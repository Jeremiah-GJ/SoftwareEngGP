//ChatClient.java
package final_proj;

import javax.swing.SwingUtilities;

import ocsf.client.AbstractClient;

public class ChatClient extends AbstractClient {
    private LoginControl loginControl;
    private CreateAccountControl createAccountControl;

    public ChatClient() {
        super("localhost", 8300);
    }

    public void setLoginControl(LoginControl loginControl) {
        this.loginControl = loginControl;
    }

    public void setCreateAccountControl(CreateAccountControl createAccountControl) {
        this.createAccountControl = createAccountControl;
    }

    @Override
    public void handleMessageFromServer(Object arg0) {
        if (arg0 instanceof String) {
            String message = (String) arg0;

            // Debug log
            System.out.println("Received message from server: " + message);

            if (message.equals("LoginSuccessful")) {
                loginControl.loginSuccess();
            } else if (message.equals("CreateAccountSuccessful")) {
                createAccountControl.createAccountSuccess();
            } else if (message.startsWith("OPPONENT:")) {
                String opponentUsername = message.substring(9);
                System.out.println("Updating opponent label with username: " + opponentUsername);
                SwingUtilities.invokeLater(() -> {
                    GamePanel.updateOpponentLabel(opponentUsername);
                });
            } else if (message.startsWith("PONG:")) {
                // Parse the enriched PONG message
                String[] parts = message.split(":");
                String opponentUsername = parts.length > 1 ? parts[1] : "Unknown Opponent";
                String opponentDeck = parts.length > 2 ? parts[2] : "Unknown Deck";

                // Debug log
                System.out.println("Parsed PONG message - Opponent: " + opponentUsername + ", Deck: " + opponentDeck);

                // Display the information
                SwingUtilities.invokeLater(() -> {
                    GamePanel.updateOpponentLabel("Opponent: " + opponentUsername + " (Deck: " + opponentDeck + ")");
                });
            }
        } else if (arg0 instanceof Error) {
            Error error = (Error) arg0;

            if (error.getType().equals("Login")) {
                loginControl.displayError(error.getMessage());
            } else if (error.getType().equals("CreateAccount")) {
                createAccountControl.displayError(error.getMessage());
            }
        }
    }







    // Add this method to send messages to the server
    public void sendMessage(String message) {
        try {
            sendToServer(message); // AbstractClient method to send messages to the server
        } catch (Exception e) {
            System.err.println("Error sending message to server: " + e.getMessage());
        }
    }
}

