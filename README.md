# Network Port Scanner using JavaFX <br>

This Java application provides a comprehensive graphical user interface for scanning open ports on a target system within a network. Developed using JavaFX, the application simplifies the process of configuring, initiating, and viewing results of port scans.

## Features: <br>

### 1. Target Host Input <br>
Enter the target host, which can be an IP address or a domain name. This is the system you want to scan for open ports.

### 2. Port Range Configuration<br>
Specify the range of ports to scan by entering the start and end port numbers. This flexibility allows users to narrow down or broaden the scope of the scan.

### 3. Scan Initiation<br>
Initiate the port scanning process by clicking the "Scan" button. The application will systematically check each port in the specified range for openness.

### 4. Real-time Results Display<br>
View the scan results in real-time within the graphical interface. Open ports are highlighted, providing instant feedback on the status of each port.

### 5. User-friendly Interface<br>
The JavaFX graphical user interface enhances the user experience, making it intuitive to configure and initiate port scans.


### Prerequisites<br>

- **Java Development Kit (JDK):** Ensure that you have the Java Development Kit installed on your system.

### Usage

1. **Launch the Application:**
   - Execute the compiled Java program, which launches the JavaFX application.

2. **Configure Scan Parameters:**
   - Enter the target host, start port, and end port in their respective text fields.

3. **Initiate Port Scan:**
   - Click the "Scan" button to start the scanning process.

4. **View Results:**
   - Results will be displayed in the text area, providing information about open ports.
  
### Additional Information:<br>
🠮 Verify Open Ports using CMD<br>
🠮 Open the Command Prompt.<br>
🠮 Type netstat -aon and hit enter.<br>
🠮 Look for the port numbers in the Listening state.<br>

### Filters for CMD Verification:<br>
🠮 netstat -ano | find "LISTENING" | sort        - To sort by "LISTENING" ports<br>
🠮 netstat -ano | find "ESTABLISHED" | sort      - To sort by "ESTABLISHED" ports<br>
🠮 netstat -ano | find "TIME_WAIT" | sort        - To sort by "TIME_WAIT" ports<br>

## Contributing

Contributions are welcome! If you have suggestions for improvements, feature requests, or would like to report issues, feel free to [create an issue](https://github.com/Pranav-Amin-10/NetworkPortScannerGUI/issues) or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
