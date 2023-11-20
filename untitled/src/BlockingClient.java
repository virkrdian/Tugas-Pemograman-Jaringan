import java.io.*;
import java.net.Socket;

public class BlockingClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Menerima pesan dari server
            new Thread(() -> {
                String serverResponse;
                try {
                    while ((serverResponse = reader.readLine()) != null) {
                        System.out.println("Server: " + serverResponse);
                    }
                } catch (IOException e) {
                    System.out.println("Connection to server lost.");
                    System.exit(0);
                }
            }).start();

            // Mengirim pesan ke server
            String message;
            while (true) {
                System.out.print("Enter your message: ");
                message = userInput.readLine();
                writer.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
