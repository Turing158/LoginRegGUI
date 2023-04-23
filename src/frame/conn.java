package frame;
import java.sql.*;
public class conn {
    Connection con;

    public Connection getCon()throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库加载成功");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lr?characterEncoding=UTF-8","root","ice13672682@");
            System.out.println("数据连接成功");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}
