import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
        public static void main(String[] args) {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
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

    public static void addStudents(Students st) {
    }
}


