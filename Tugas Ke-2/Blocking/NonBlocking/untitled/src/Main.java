import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Port server
            System.out.println("Server is running. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Cek apakah alamat IP client diizinkan atau diblokir
                if (isBlocked(clientSocket.getInetAddress().getHostAddress())) {
                    System.out.println("Blocking access for: " + clientSocket.getInetAddress());
                    clientSocket.close(); // Tutup koneksi untuk client yang diblokir
                } else {
                    // Lakukan apa yang perlu dilakukan jika client diizinkan
                    // Misalnya, buat thread baru untuk menangani komunikasi dengan client
                    // Thread clientThread = new Thread(new ClientHandler(clientSocket));
                    // clientThread.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isBlocked(String ipAddress) {
        // Implementasi logika pemblokiran di sini
        // Contoh sederhana, blokir akses dari alamat IP tertentu
        return ipAddress.equals("192.168.0.2");
    }
}
