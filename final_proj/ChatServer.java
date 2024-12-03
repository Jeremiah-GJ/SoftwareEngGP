// ChatServer.java
package final_proj;

import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class ChatServer extends AbstractServer {
    private JTextArea log;
    private JLabel status;
    private boolean running = false;
    private Database database;

    // Track player deck selections using client IDs
    private HashMap<Long, String> playerDecks = new HashMap<>();

    // Track client usernames using client IDs
    private HashMap<Long, String> clientUsernames = new HashMap<>();

    public ChatServer() {
        super(12345);
        this.setTimeout(500);
    }

    public boolean isRunning() {
        return running;
    }

    public void setLog(JTextArea log) {
        this.log = log;
    }

    public void setStatus(JLabel status) {
        this.status = status;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public void serverStarted() {
        running = true;
        status.setText("Listening");
        status.setForeground(Color.GREEN);
        if (log != null) {
            log.append("Server started\n");
        }
    }

    @Override
    public void serverStopped() {
        status.setText("Stopped");
        status.setForeground(Color.RED);
        if (log != null) {
            log.append("Server stopped accepting new clients - press Listen to start accepting new clients\n");
        }
    }

    @Override
    public void serverClosed() {
        running = false;
        status.setText("Close");
        status.setForeground(Color.RED);
        if (log != null) {
            log.append("Server and all current clients are closed - press Listen to restart\n");
        }
    }

    @Override
    public void clientConnected(ConnectionToClient client) {
        if (log != null) {
            log.append("Client " + client.getId() + " connected\n");
        }
    }

    @Override
    public void handleMessageFromClient(Object msg, ConnectionToClient client) {
        if (msg instanceof String) {
            String message = (String) msg;

            // Handle deck selection
            if (message.startsWith("DeckSelected:")) {
                String selectedDeck = message.substring(13); // Extract the deck name
                playerDecks.put(client.getId(), selectedDeck);
                System.out.println("Deck assigned to client ID " + client.getId() + ": " + selectedDeck);

                // Debug log for playerDecks map
                System.out.println("Current playerDecks map: " + playerDecks);

                // Log the deck selection to the JTextArea
                if (log != null) {
                    SwingUtilities.invokeLater(() -> {
                        log.append("Client " + client.getId() + " selected deck: " + selectedDeck + "\n");
                    });
                }
            }
            // Handle opponent username propagation
            else if (message.startsWith("LOGIN:")) {
                String username = message.substring(6);
                clientUsernames.put(client.getId(), username);
                System.out.println("Stored username for client ID " + client.getId() + ": " + username);

                // Debug log for clientUsernames map
                System.out.println("Current clientUsernames map: " + clientUsernames);

                // Notify all other clients about this user
                for (Thread clientThread : getClientConnections()) {
                    ConnectionToClient otherClient = (ConnectionToClient) clientThread;
                    if (!otherClient.equals(client)) {
                        try {
                            System.out.println("Sending username to opponent client " + otherClient.getId());
                            otherClient.sendToClient("OPPONENT:" + username);

                            String otherUsername = clientUsernames.getOrDefault(otherClient.getId(), "Unknown User");
                            System.out.println("Sending opponent username to client " + client.getId() + ": " + otherUsername);
                            client.sendToClient("OPPONENT:" + otherUsername);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            // Handle PING-PONG interaction
            else if (message.equals("PING")) {
                for (Thread clientThread : getClientConnections()) {
                    ConnectionToClient otherClient = (ConnectionToClient) clientThread;
                    if (!otherClient.equals(client)) {
                        try {
                            // Retrieve opponent's username and deck using client IDs
                            String opponentUsername = clientUsernames.getOrDefault(otherClient.getId(), "Unknown User");
                            String opponentDeck = playerDecks.getOrDefault(otherClient.getId(), "Unknown Deck");

                            // Debug logs
                            System.out.println("PING Handling - Opponent Username: " + opponentUsername);
                            System.out.println("PING Handling - Opponent Deck: " + opponentDeck);

                            String pongMessage = "PONG:" + opponentUsername + ":" + opponentDeck;
                            System.out.println("Sending PONG to client " + client.getId() + ": " + pongMessage);
                            client.sendToClient(pongMessage);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break; // Only handle the first opponent found
                    }
                }
            }
        }

        else if (msg instanceof LoginData) {
            LoginData data = (LoginData) msg;
            Object result;
            if (database.verifyAccount(data.getUsername(), data.getPassword())) {
                result = "LoginSuccessful";
                if (log != null) {
                    log.append("Client " + client.getId() + " successfully logged in as " + data.getUsername() + "\n");
                }
            } else {
                result = new Error("The username and password are incorrect.", "Login");
                if (log != null) {
                    log.append("Client " + client.getId() + " failed to log in\n");
                }
            }
            try {
                client.sendToClient(result);
            } catch (IOException e) {
                return;
            }
        }

        else if (msg instanceof CreateAccountData) {
            CreateAccountData data = (CreateAccountData) msg;
            Object result;
            if (database.createNewAccount(data.getUsername(), data.getPassword())) {
                result = "CreateAccountSuccessful";
                if (log != null) {
                    log.append("Client " + client.getId() + " created a new account called " + data.getUsername() + "\n");
                }
            } else {
                result = new Error("The username is already in use.", "CreateAccount");
                if (log != null) {
                    log.append("Client " + client.getId() + " failed to create a new account\n");
                }
            }
            try {
                client.sendToClient(result);
            } catch (IOException e) {
                return;
            }
        }
    }

    public void testLogMessage(String message) {
        if (log != null) {
            SwingUtilities.invokeLater(() -> {
                log.append(message + "\n");
            });
        } else {
            System.out.println("Log is null in testLogMessage.");
        }
    }

    @Override
    public void listeningException(Throwable exception) {
        running = false;
        status.setText("Exception occurred while listening");
        status.setForeground(Color.RED);
        if (log != null) {
            log.append("Listening exception: " + exception.getMessage() + "\n");
            log.append("Press Listen to restart server\n");
        }
    }

    private void sendStartGameMessage() {
        for (Long clientId : playerDecks.keySet()) {
            String selectedDeck = playerDecks.get(clientId);
            for (Thread clientThread : getClientConnections()) {
                ConnectionToClient client = (ConnectionToClient) clientThread;
                if (client.getId() == clientId) {
                    try {
                        client.sendToClient("StartGame:" + selectedDeck);
                        if (log != null) {
                            log.append("Sent StartGame message to client " + client.getId() + " with deck: " + selectedDeck + "\n");
                        }
                    } catch (IOException e) {
                        if (log != null) {
                            log.append("Error sending StartGame message to client " + client.getId() + ": " + e.getMessage() + "\n");
                        }
                    }
                    break;
                }
            }
        }
        playerDecks.clear();
    }
}
