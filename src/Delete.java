import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    private JTextField RollNotextField;
    private JPanel Main;
    private JLabel Head;
    private JLabel RollNo;
    private JButton Del;

    public Delete() {
        JFrame frame=new JFrame("Delete a record :");
        frame.setContentPane(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                int no =Integer.parseInt(RollNotextField.getText());
                String query ="delete from Students where rollNo = ?;";
                Connection con=GetConnection.getCon();
                PreparedStatement ps=con.prepareStatement(query);
                    ps.setInt(1,no);
                    int  t=ps.executeUpdate();
                    if(t!=0)
                    {
                        RollNotextField.setText("");
                        JOptionPane.showMessageDialog(null,"Succesfully Deleted");
                    }
                    else {
                        RollNotextField.setText("");
                        JOptionPane.showMessageDialog(null,"Invalid roll No.!!!!!!!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
