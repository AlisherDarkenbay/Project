import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListStudents extends JPanel {

    private MainFrame parent;

    private JLabel label;
    private JButton back;
    private JTextArea area;
    private  JTable table;

    public ListStudents(MainFrame parent) {

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        label = new JLabel("SECOND PAGE");
        label.setSize(300,30);
        label.setLocation(100,100);
        add(label);

        String[] header = {null,"Name","Surname","Age"};
        JTable table;
        JScrollPane scrollPane;

        back = new JButton("Back");
        back.setSize(300,30);
        back.setLocation(100,250);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getSecondPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });

        area = new JTextArea();
        area.setSize(300,100);
        area.setLocation(100,300);
        add(area);
    }
    public void actionPerformed(ActionEvent e){
        area.append(label+" ");
    }
    public void generateTable(Students[] students){
        Object data[][] = new Object[students.length][3];

        for(int i =0;i<students.length;i++){
            data[i][0] = students[i].getName();
            data[i][1] = students[i].getSurname();
            data[i][2] = students[i].getAge();
        }

        int header=0;
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);

    }
}

