import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends JPanel {
    private MainFrame parent;

    private JLabel label;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox FacultyBox;
    private JButton add;
    private JButton back;

    public AddStudent(MainFrame parent) {

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("NAME");
        label.setSize(300,30);
        label.setLocation(30,100);
        add(label);

        label1 = new JLabel("SURNAME");
        label1.setSize(300,30);
        label1.setLocation(30,150);
        add(label1);

        label2 = new JLabel("AGE");
        label2.setSize(300,30);
        label2.setLocation(30,200);
        add(label2);


        textField = new JTextField("");
        textField.setSize(300,30);
        textField.setLocation(100,100);
        add(textField);

        textField1 = new JTextField("");
        textField1.setSize(300,30);
        textField1.setLocation(100,150);
        add(textField1);

        textField2 = new JTextField("");
        textField2.setSize(300,30);
        textField2.setLocation(100,200);
        add(textField2);


        add = new JButton("ADD");
        add.setSize(100,30);
        add.setLocation(50,350);
        add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = label.getText();
                String surname = label1.getText();
                int age = Integer.parseInt(label2.getText());
                Students st = new Students(null,name,surname,age);
                Main.addStudents(st);
                label.setText("");
                label1.setText("");
                label2.setText("0");
            }

        });

        back = new JButton("BACK");
        back.setSize(100,30);
        back.setLocation(250,350);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getFirstPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }
}