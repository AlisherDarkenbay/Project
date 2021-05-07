import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    private Socket socket;
    private Socket[] sockets;
    private int index;

    public ClientHandler(Socket socket, Socket[] sockets, int index) {
        this.socket = socket;
        this.sockets = sockets;
        this.index = index;
    }
    public void run() {

        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData data = null;
            while ((data = (PackageData) inputStream.readObject()) != null) {
                System.out.println(data);
                if(data.getOperationType().equals("ADD_STUDENT")){
                    if(connect()){
                        addUser(data.getStudent());
                    }
                }else if(data.getOperationType().equals("LIST_STUDENTS")){
                    PackageData response = new PackageData();
                    ArrayList<Students> students = new ArrayList<>();
                    if(connect()){
                        students = getStudents();
                        System.out.println("GetAllStudents ");
                        response.setStudents(students);
                        outputStream.writeObject(response);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addUser(Students student) {
    }

    private ArrayList<Students> getStudents() {
        return getStudents();
    }

    public static boolean connect() {
        boolean check = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
            System.out.println("Connected");
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check;
    }
}
