package frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Input {
    public static String user;
    public static String pass;
    public void input() throws SQLException{
        Connection con = new conn().getCon();
        String sql = "insert into up values (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        System.out.println(user);
        ps.setString(1,user);
        ps.setString(2,pass);
        try{
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("添加成功");
            }
            else{
                System.out.println("添加失败");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            ps.close();
            con.close();
        }
    }

}
