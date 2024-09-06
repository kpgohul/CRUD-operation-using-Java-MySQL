import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddRecord {
    private JLabel Name;
    private JLabel Department;
    private JLabel CGPA;
    private JLabel Age;
    private JTextField NametextField;
    private JTextField DepartmenttextField;
    private JTextField CGPAtextField;
    private JTextField AgeTextField;
    private JButton Add;
    private JLabel Head;
    private JPanel Main;

    public AddRecord() {
        JFrame frame=new JFrame("Add Student Record :");
        frame.setContentPane(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Add.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query ="insert into Students (name,department,cgpa,age) values(?,?,?,?)";
                try
                {
                    String n=NametextField.getText();
                    String d=DepartmenttextField.getText();
                    int c=Integer.parseInt(CGPAtextField.getText());
                    int a=Integer.parseInt(AgeTextField.getText());
                    Connection con=GetConnection.getCon();
                    PreparedStatement ps=con.prepareStatement(query);
                    ps.setString(1,n);
                    ps.setString(2,d);
                    ps.setInt(3,c);
                    ps.setInt(4,a);
                    int t=ps.executeUpdate();
                    if(t==0) throw new SQLException();
                    else   JOptionPane.showMessageDialog(null,"Succesfully added");
            }
                catch(SQLException e2)
                {
                    e2.printStackTrace();
                }
            }
        });
    }

//    public static void main(String[] args) {
//        new AddRecord();
//    }
}
