import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NonBlockingClient {
    private static final String ALAMAT_SERVER = "localhost";
    private static final int PORT_SERVER = 12345;

    public static void main(String[] args) {
        NonBlockingClient client = new NonBlockingClient();
        client.mulaiClient();
    }

    public void mulaiClient() {
        try (SocketChannel saluranSocket = SocketChannel.open()) {
            saluranSocket.connect(new InetSocketAddress(ALAMAT_SERVER, PORT_SERVER));

            new Thread(() -> {
                try {
                    terimaPesan(saluranSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            kirimPesan(saluranSocket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void kirimPesan(SocketChannel saluranSocket) throws IOException {
        try (BufferedReader masukanConsole = new BufferedReader(new InputStreamReader(System.in))) {
            String inputPengguna;
            while ((inputPengguna = masukanConsole.readLine()) != null) {
                saluranSocket.write(ByteBuffer.wrap(inputPengguna.getBytes()));
            }
        }
    }

    private void terimaPesan(SocketChannel saluranSocket) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (true) {
            int byteDibaca = saluranSocket.read(buffer);

            if (byteDibaca == -1) {
                System.out.println("Server telah menutup koneksi.");
                break;
            }

            if (buffer.position() > 0) {
                buffer.flip();
                byte[] data = new byte[buffer.remaining()];
                buffer.get(data);
                String pesan = new String(data).trim();
                System.out.println("Diterima dari server: " + pesan);
                buffer.clear();
            }
        }
    }
}
