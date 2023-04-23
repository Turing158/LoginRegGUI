import frame.*;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)throws SQLException {
        getMassage gm = new getMassage();
        gm.getmassage();
       login lg = new login();
        reg rg = new reg();
        lg.setVisible(true);

    }
}