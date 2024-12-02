//ServerGUI.java


package final_proj;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

public class ServerGUI extends JFrame {
    private JLabel status;
    private String[] labels = {"Port #", "Timeout"};
    private JTextField[] textFields = new JTextField[labels.length];
    private JTextArea log;
    private JButton listen;
    private JButton close;
    private JButton stop;
    private JButton quit;
    private JButton testLog; // New button for testing log functionality
    private ChatServer server;

    public ServerGUI() {
        JPanel north = new JPanel();
        JPanel center = new JPanel(new BorderLayout());
        JPanel south = new JPanel();
        EventHandler handler = new EventHandler();
        int i = 0;

        this.setTitle("Chat Server");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel statusText = new JLabel("Status:");
        north.add(statusText);
        status = new JLabel("Not Connected");
        status.setForeground(Color.RED);
        north.add(status);

        JPanel centerNorth = new JPanel(new GridLayout(labels.length, 2, 5, 5));
        for (i = 0; i < textFields.length; i++) {
            JLabel label = new JLabel(labels[i], JLabel.RIGHT);
            centerNorth.add(label);
            textFields[i] = new JTextField(10);
            centerNorth.add(textFields[i]);
        }

        textFields[0].setText("8300");
        textFields[1].setText("500");

        JPanel centerNorthBuffer = new JPanel();
        centerNorthBuffer.add(centerNorth);
        center.add(centerNorthBuffer, BorderLayout.NORTH);

        JPanel serverLogPanel = new JPanel(new BorderLayout());
        JLabel serverLabel = new JLabel("Server Log", JLabel.CENTER);
        JPanel serverLabelBuffer = new JPanel();
        serverLabelBuffer.add(serverLabel);
        serverLogPanel.add(serverLabelBuffer, BorderLayout.NORTH);
        log = new JTextArea(10, 35);
        log.setEditable(false);
        JScrollPane serverLogPane = new JScrollPane(log);
        JPanel serverLogPaneBuffer = new JPanel();
        serverLogPaneBuffer.add(serverLogPane);
        serverLogPanel.add(serverLogPaneBuffer, BorderLayout.SOUTH);

        JPanel centerSouth = new JPanel();
        centerSouth.add(serverLogPanel);
        center.add(centerSouth, BorderLayout.SOUTH);

        listen = new JButton("Listen");
        listen.addActionListener(handler);
        south.add(listen);
        close = new JButton("Close");
        close.addActionListener(handler);
        south.add(close);
        stop = new JButton("Stop");
        stop.addActionListener(handler);
        south.add(stop);
        quit = new JButton("Quit");
        quit.addActionListener(handler);
        south.add(quit);

        // Add a new button for testing the log
        testLog = new JButton("Test Log");
        testLog.addActionListener(e -> {
            if (log != null) {
                log.append("Test log message: The JTextArea is functioning correctly.");
            } else {
                System.out.println("Log JTextArea is null!");
            }
        });
        south.add(testLog); // Add test button to GUI

        this.add(north, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);

        this.setSize(450, 450);
        this.setVisible(true);

        server = new ChatServer();
        server.setLog(log); // Set the log correctly
        System.out.println("Log set in server: " + (log != null ? "Yes" : "No"));
        server.setStatus(status);

        try {
            Database database = new Database();
            server.setDatabase(database);
            log.append("Database connection established.");
        } catch (SQLException e) {
            log.append("Database connection failed: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        new ServerGUI();
    }

    public JTextField getTextFieldAt(int index) {
        return textFields[index];
    }

    public JLabel getStatus() {
        return status;
    }

    public JTextArea getLog() {
        return log;
    }

    class EventHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object buttonClicked = e.getSource();

            if (buttonClicked == listen) {
                if (textFields[0].getText().equals("") || textFields[1].getText().equals("")) {
                    log.append("Port number or timeout not entered before pressing Listen");
                } else {
                    server.setPort(Integer.parseInt(textFields[0].getText()));
                    server.setTimeout(Integer.parseInt(textFields[1].getText()));
                    try {
                        server.listen();
                    } catch (IOException e1) {
                        log.append("An exception occurred: " + e1.getMessage() + "");
                    }
                }
            } else if (buttonClicked == close) {
                if (!server.isRunning()) {
                    log.append("Server not currently started");
                } else {
                    try {
                        server.close();
                    } catch (IOException e1) {
                        log.append("An exception occurred: " + e1.getMessage() + "");
                    }
                }
            } else if (buttonClicked == stop) {
                if (!server.isListening()) {
                    log.append("Server not currently listening");
                } else {
                    server.stopListening();
                }
            } else if (buttonClicked == quit) {
                System.exit(0);
            }
        }
    }
}

