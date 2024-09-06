import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchStudent {
    private JLabel head;
    private JLabel name;
    private JLabel Department;
    private JLabel CGPA;
    private JLabel Age;
    private JLabel RollNo;
    private JTextField nameTextField;
    private JTextField DepartmenttextField;
    private JTextField CGPAtextField;
    private JTextField AgetextField;
    private JTextField RollNotextField;
    private JButton Search;
    private JPanel Main;

    public SearchStudent()
    {
        JFrame frame=new JFrame("Specific student detail");
        frame.setContentPane(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query ="select name,department,CGPA,age from Students where RollNo = ?";
                try
                {
                    int no=Integer.parseInt(RollNotextField.getText());
                    Connection con=GetConnection.getCon();
                    PreparedStatement ps=con.prepareStatement(query);
                    ps.setInt(1,no);
                    ResultSet rs=ps.executeQuery();
                    if(rs.next())
                    {
                        nameTextField.setText(rs.getString(1));
                        DepartmenttextField.setText(rs.getString(2));
                        CGPAtextField.setText(String.valueOf(rs.getInt(3)));
                        AgetextField.setText(String.valueOf(rs.getInt(4)));
                        JOptionPane.showMessageDialog(null,"found out!!!");
                        RollNotextField.setText("");
                    }
                    else
                    {
                        nameTextField.setText("");
                        DepartmenttextField.setText("");
                        CGPAtextField.setText("");
                        AgetextField.setText("");
                        JOptionPane.showMessageDialog(null,"invalid RollNo!!!!!");
                    }
                }
                catch (SQLException e2)
                {
                    e2.printStackTrace();
                }
            }
        });
    }

//    public static void main(String[] args) {
//        new SearchStudent();
//    }

}
