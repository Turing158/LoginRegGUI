package frame;

import java.sql.*;

public class getMassage {
    public void getmassage()throws SQLException{
        Connection con = new conn().getCon();
        String user = "select user from up";
        String pass = "select password from up";
        PreparedStatement psuser = con.prepareStatement(user);
        PreparedStatement pspass = con.prepareStatement(pass);
        ResultSet rsuser = psuser.executeQuery(user);
        ResultSet rspass = pspass.executeQuery(pass);
        while(rsuser.next()){
            login.muser.add(rsuser.getString("user"));
        }
        while(rspass.next()){
            login.mpass.add(rspass.getString("password"));
        }
        psuser.close();
        pspass.close();
        con.close();
    }
}
