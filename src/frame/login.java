package frame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class login extends Frame implements ActionListener , WindowListener{
    public Gpanel gp;
    public bg bg;
    public reg r;
    public Label user;
    public  Label pass;
    public TextField inuser;
    public  TextField inpass;
    public Button blg;
    public Button breg;
    public Button exit;
    public static ArrayList<String> muser = new ArrayList<String>();
    public static ArrayList<String> mpass = new ArrayList<String>();
    public login(){
        this.setTitle("Login!");
        this.setBounds(100,100,430,314);
        this.setUndecorated(true);
        this.setLayout(null);
        this.addWindowListener(this);
        user = new Label("user :");
        user.setFont(new Font("宋体",Font.PLAIN,15));
        pass = new Label("password :");
        pass.setFont(new Font("宋体",Font.PLAIN,15));
        breg = new Button("Register");
        blg = new Button("Login");
        exit = new Button("Exit");
        inuser = new TextField();
        inpass = new TextField();
        user.setBounds(100,103,40,15);
        pass.setBounds(65,133,75,15);
        this.add(user);
        this.add(pass);
        blg.setBounds(140,160,50,30);
        breg.setBounds(240,160,50,30);
        this.add(blg);
        this.add(breg);
        exit.setBounds(198,200,40,30);
        this.add(exit);
        inuser.setBounds(140,98,150,25);
        inpass.setBounds(140,128,150,25);
        this.add(inuser);
        this.add(inpass);
        blg.addActionListener(this);
        reg r =new reg();
        breg.addActionListener(e -> r.setVisible(true));
        breg.addActionListener(e -> this.setVisible(false));
        exit.addActionListener(e -> System.exit(0));
        r.blg.addActionListener(e -> this.setVisible(true));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int cuser = muser.size();
        System.out.println(muser.size());
        for (int i = 0; i < cuser; i++) {
            muser.remove(0);
            mpass.remove(0);
        }
        getMassage gm = new getMassage();
        try {
            gm.getmassage();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        int flag=0;
        for (int i = 0; i < muser.size(); i++) {
            if(inuser.getText().equals("")&&inpass.getText().equals("")){
                javax.swing.JOptionPane.showConfirmDialog(this,"用户名和密码不能为空");
                break;
            }
            else if(inuser.getText().equals("")){
                javax.swing.JOptionPane.showConfirmDialog(this,"用户名不能为空");
                break;
            }
            else if(inpass.getText().equals("")){
                javax.swing.JOptionPane.showConfirmDialog(this,"密码不能为空");
                break;
            }
            else if(inuser.getText().equals(muser.get(i))){
                javax.swing.JOptionPane.showConfirmDialog(this,"密码错误");
                break;
            }
            if(inuser.getText().equals(muser.get(i))&&inpass.getText().equals(mpass.get(i))){
                javax.swing.JOptionPane.showConfirmDialog(this,"登录成功");
                break;
            }
            else {
                for (int j = 0; j < muser.size(); j++) {
                    flag=2;
                    if (inuser.getText().equals(muser.get(j))&&inpass.getText().equals(mpass.get(j))){
                        flag = 1;
                    }
                }
                if(flag==2){
                    javax.swing.JOptionPane.showConfirmDialog(this,"用户名错误或不存在");
                }
                }


        }

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int l = javax.swing.JOptionPane.showConfirmDialog(this,"是否关闭窗口","登录系统",0);
        if(l == 0){
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    public void paint(Graphics g){
        bg b = new bg(gp);
        b.dbg(g);
        g.setFont(new Font("华文行楷",Font.BOLD,50));
        g.drawString("登录",170,80);
    }
}



