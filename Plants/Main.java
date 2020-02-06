import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Chatter implements Runnable {
    ServerSocket serverSocket;

    public Chatter(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            Socket socket = serverSocket.accept();
            System.out.println("Server (" + Thread.currentThread().getId() + ") accepted a new client!");
            Scanner scanner = new Scanner(socket.getInputStream());
            String message = "";
            while (!message.equals("Bye")) {
                if (scanner.hasNext()) {
                    message = scanner.next();
                    System.out.println("Server (" + Thread.currentThread().getId() + ") received: " + message);
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8765);
        List<Thread> chatters = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Thread chatter = new Thread(new Chatter(serverSocket));
            chatters.add(chatter);
        }

        for (Thread chatter : chatters) {
            chatter.start();
        }

    }
}