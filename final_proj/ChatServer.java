// ChatServer.java
package final_proj;

import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.util.*;


import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class ChatServer extends AbstractServer {
    private JTextArea log;
    private JLabel status;
    private boolean running = false;
    private Database database;

    // Track player deck selections
    private HashMap<ConnectionToClient, String> playerDecks = new HashMap<>();
    
    private Set<ConnectionToClient> clients = new HashSet<>();

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
    	 clients.add(client);
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
                playerDecks.put(client, selectedDeck);

                // Log the deck selection to the JTextArea
                if (log != null) {
                    SwingUtilities.invokeLater(() -> {
                        log.append("Client " + client.getId() + " selected deck: " + selectedDeck + "\n");
                    });
                } else {
                    System.out.println("Log is null when processing deck selection.");
                }

                // Check if both players are ready
                if (playerDecks.size() == 2) {
                    sendStartGameMessage();
                }
            }
            if (message.startsWith("+")) {
            	sendCall(client);
            }
        }

        // Existing login logic
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

        // Existing account creation logic
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

    // Notify both players to start the game
    private void sendStartGameMessage() {
        for (ConnectionToClient client : playerDecks.keySet()) {
            String selectedDeck = playerDecks.get(client);
            try {
                client.sendToClient("StartGame:" + selectedDeck); // Notify the client to start the game
                if (log != null) {
                    log.append("Sent StartGame message to client " + client.getId() + " with deck: " + selectedDeck + "\n");
                }
            } catch (IOException e) {
                if (log != null) {
                    log.append("Error sending StartGame message to client " + client.getId() + ": " + e.getMessage() + "\n");
                }
            }
        }

        // Reset the deck selections for future games
        playerDecks.clear();
    }
    
    private void sendCall(ConnectionToClient client) {
    	for (ConnectionToClient otherClient : clients) {
            if (otherClient != client) {
                // Get the deck selection of the current client
                String selectedDeck = playerDecks.get(client);
                int clientId = (int) client.getId();

                // Construct the message
                String message = "Opponent ID:" + clientId + ". Opponent Deck selected:" + selectedDeck;

                // Send the message to the other client
                try {
                    otherClient.sendToClient(message);
                    if (log != null) {
                        log.append("Sent ID and Deck to client " + otherClient.getId() + ": " + selectedDeck + "\n");
                    }
                } catch (IOException e) {
                    if (log != null) {
                        log.append("Error sending ID and Deck message to client " + otherClient.getId() + ": " + e.getMessage() + "\n");
                    }
                }
            }
        }
    }
}
