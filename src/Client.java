import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            Socket socket = new Socket("127.0.0.1",1978);
            ObjectOutputStream outputStream =
                    new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream =
                    new ObjectInputStream(socket.getInputStream());
            System.out.println("Insert name");
            String name = in.next();
            while (true){
                String message = in.next();
                MessageData md = new MessageData(name,message, new Date());
                outputStream.writeObject(md);
                if((md = (MessageData) inputStream.readObject())!=null){
                    System.out.println(md.toString());
                    if(md.getNames()!=null){
                        ArrayList<String> names = md.getNames();
                        for (int i =0;i<names.size();i++){
                            System.out.println(names.get(i));
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}