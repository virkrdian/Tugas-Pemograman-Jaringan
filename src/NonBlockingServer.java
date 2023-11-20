import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NonBlockingServer {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        NonBlockingServer server = new NonBlockingServer();
        server.startServer();
    }

    public void startServer() {
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open();
             Selector selector = Selector.open()) {

            serverChannel.bind(new InetSocketAddress(PORT));
            serverChannel.configureBlocking(false);
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            System.out.println("Server sedang mendengarkan port " + PORT);

            while (true) {
                int channelSiap = selector.select();

                if (channelSiap == 0) {
                    continue;
                }

                Set<SelectionKey> kunciTerpilih = selector.selectedKeys();
                Iterator<SelectionKey> iteratorKunci = kunciTerpilih.iterator();

                while (iteratorKunci.hasNext()) {
                    SelectionKey kunci = iteratorKunci.next();

                    if (kunci.isAcceptable()) {
                        tanganiTerima(kunci, selector);
                    } else if (kunci.isReadable()) {
                        tanganiBaca(kunci, selector);
                    }

                    iteratorKunci.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void tanganiTerima(SelectionKey kunci, Selector selector) throws IOException {
        ServerSocketChannel saluranServer = (ServerSocketChannel) kunci.channel();
        SocketChannel saluranClient = saluranServer.accept();
        saluranClient.configureBlocking(false);
        saluranClient.register(selector, SelectionKey.OP_READ);

        System.out.println("Client baru terhubung: " + saluranClient.getRemoteAddress());
    }

    private void tanganiBaca(SelectionKey kunci, Selector selector) throws IOException {
        SocketChannel saluranClient = (SocketChannel) kunci.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int byteDibaca = saluranClient.read(buffer);

        if (byteDibaca == -1) {
            kunci.cancel();
            saluranClient.close();
            System.out.println("Client terputus: " + saluranClient.getRemoteAddress());
            return;
        }

        buffer.flip();
        byte[] data = new byte[buffer.remaining()];
        buffer.get(data);
        String pesan = new String(data).trim();

        System.out.println("Diterima dari " + saluranClient.getRemoteAddress() + ": " + pesan);

        sebarPesan(pesan, selector, saluranClient);
    }

    private void sebarPesan(String pesan, Selector selector, SocketChannel saluranPengirim) throws IOException {
        for (SelectionKey kunci : selector.keys()) {
            if (kunci.isValid() && kunci.channel() instanceof SocketChannel && kunci.channel() != saluranPengirim) {
                SocketChannel saluran = (SocketChannel) kunci.channel();
                saluran.write(ByteBuffer.wrap(pesan.getBytes()));
            }
        }
    }
}
