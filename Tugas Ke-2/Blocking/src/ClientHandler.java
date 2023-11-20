import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;
    private String clientName;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            writer.println("Welcome to the chat!");

            // Minta klien untuk memasukkan nama
            writer.println("Enter your name:");
            clientName = reader.readLine();
            System.out.println("New client joined: " + clientName);
            BlockingServer.broadcastMessage(clientName + " has joined the chat.", this);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                BlockingServer.broadcastMessage(clientMessage, this);
            }
        } catch (IOException e) {
            System.out.println("Connection lost with client: " + clientName);
        } finally {
            try {
                clientSocket.close();
                BlockingServer.removeClient(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }

    public String getClientName() {
        return clientName;
    }
}
