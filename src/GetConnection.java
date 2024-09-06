import java.sql.*;

public class  GetConnection{
    public static  Connection getCon()
    {
     Connection con = null;
        try {
            String url ="jdbc:mysql://localhost:3306/StudentInfo";
            con = DriverManager.getConnection(url,"root","kprahul143");
            System.out.println("Success");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
