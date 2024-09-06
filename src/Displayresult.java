import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;

public class Displayresult {
    private  JTable table1;
    private JLabel head;
    private JScrollPane table;
    private JPanel Main;

    public  void display()
    {
        JFrame frame=new JFrame("ALL RECORDS :");
        frame.setContentPane(Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        try{
            Connection con=GetConnection.getCon();
            Statement stmt=con.createStatement();
            String query=" select * from Students;";
            ResultSet rs=stmt.executeQuery(query);
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        Displayresult d=new Displayresult();
//        d.display();
//    }
}
