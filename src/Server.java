import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        try{
            ServerSocket server = new ServerSocket(1978);
            System.out.println("Waiting for client");
            Socket socket = server.accept();
            System.out.println("Client connected");
            ObjectInputStream inputStream =
                    new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream =
                    new ObjectOutputStream(socket.getOutputStream());
            MessageData md = null;


            } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        }

}

 