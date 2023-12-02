package com.example.networkportscannerjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class NetworkPortScannerJavaFX extends Application {

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set the title of the main window
        primaryStage.setTitle("Network Port Scanner");

        // Create input components
        TextField hostField = new TextField("localhost");
        TextField startPortField = new TextField("1");
        TextField endPortField = new TextField("1024");
        TextArea resultArea = new TextArea();

        // Create a button for initiating the port scan
        Button scanButton = new Button("Scan Ports");
        // Attach an event handler to the button to perform the port scan
        scanButton.setOnAction(event -> scanPorts(hostField.getText(), startPortField.getText(), endPortField.getText(), resultArea));

        // Create layout for input components and button
        GridPane inputGrid = new GridPane();
        inputGrid.add(new Label("Target Host:"), 0, 0);
        inputGrid.add(hostField, 1, 0);
        inputGrid.add(new Label("Start Port:"), 0, 1);
        inputGrid.add(startPortField, 1, 1);
        inputGrid.add(new Label("End Port:"), 0, 2);
        inputGrid.add(endPortField, 1, 2);

        // Create the main layout for the window, containing input components, result area, and the scan button
        VBox root = new VBox(inputGrid, new ScrollPane(resultArea), scanButton);
        root.setSpacing(10); // Set spacing between components
        root.setPadding(new Insets(10)); // Set padding for the main layout

        // Allow resultArea to expand vertically
        VBox.setVgrow(resultArea, Priority.ALWAYS);
        // Avoid scanButton from expanding vertically
        VBox.setVgrow(scanButton, Priority.NEVER);
        // Center the content of the VBox vertically
        root.setAlignment(Pos.CENTER);

        // Create the scene and set it on the stage
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    // Method for scanning ports based on user input
    private void scanPorts(String host, String startPortStr, String endPortStr, TextArea resultArea) {
        try {
            // Parse input values for start and end ports
            int startPort = Integer.parseInt(startPortStr);
            int endPort = Integer.parseInt(endPortStr);

            // Display a message indicating the start of the scan
            resultArea.setText("Scanning ports on host " + host + " from " + startPort + " to " + endPort + "...\n");

            // Loop through the specified range of ports and attempt to connect to each
            for (int port = startPort; port <= endPort; port++) {
                try {
                    // Attempt to create a socket connection to the specified port
                    Socket socket = new Socket(host, port);
                    resultArea.appendText("Port " + port + " is open\n"); // If connection succeeds, the port is open
                    socket.close(); // Close the socket
                } catch (IOException e) {
                    // If an IOException occurs, the port is closed or unreachable
                }
            }
        } catch (NumberFormatException e) {
            // Handle the case where the input for start or end port is not a valid integer
            resultArea.appendText("Invalid port number(s)\n");
        }
    }
}
