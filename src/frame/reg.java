package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class reg extends Frame implements ActionListener{
    public Gpanel gp;
    public login lg;
    public Label user;
    public  Label pass;
    public TextField inuser;
    public TextField inpass;
    public Button blg;
    public Button breg;
    public reg(){
        this.setTitle("Register!");
        this.setBounds(100,100,430,314);
        this.setUndecorated(true);
        this.setLayout(null);
        Gpanel gp = new Gpanel();
        user = new Label("user :");
        user.setFont(new Font("宋体",Font.PLAIN,15));
        pass = new Label("password :");
        pass.setFont(new Font("宋体",Font.PLAIN,15));
        breg = new Button("Register");
        blg = new Button(" Back Login");
        inuser = new TextField();
        inpass = new TextField();
        user.setBounds(100,103,40,15);
        pass.setBounds(65,133,75,15);
        this.add(user);
        this.add(pass);
        breg.setBounds(140,160,50,30);
        blg.setBounds(210,160,80,30);
        this.add(blg);
        this.add(breg);
        inuser.setBounds(140,98,150,25);
        inpass.setBounds(140,128,150,25);
        this.add(inuser);
        this.add(inpass);
        breg.addActionListener(this);
        blg.addActionListener(e -> this.setVisible(false));
    }

    @Override
    public void actionPerformed(ActionEvent e){
        getMassage gm = new getMassage();
        try {
            gm.getmassage();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        Input.user = inuser.getText();
        Input.pass = inpass.getText();
        boolean flag = false;
        for (int i = 0; i < login.muser.size(); i++) {
            if(inuser.getText().equals("")&&inpass.getText().equals("")){
                javax.swing.JOptionPane.showConfirmDialog(this,"用户名和密码不能为空");
                flag = true;
                break;
            }
            else if(inuser.getText().equals("")){
                javax.swing.JOptionPane.showConfirmDialog(this,"用户名不能为空");
                flag = true;
                break;
            }
            else if(inpass.getText().equals("")){
                javax.swing.JOptionPane.showConfirmDialog(this,"密码不能为空");
                flag = true;
                break;
            }
            else if(login.muser.get(i).equals(inuser.getText())){
                javax.swing.JOptionPane.showConfirmDialog(this,"注册失败,用户名被注册");
                flag = true;
                break;
            }
        }
        if(flag==false){

            Input ip = new Input();
            try {
                ip.input();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            javax.swing.JOptionPane.showConfirmDialog(this,"注册成功");
        }

    }
    public void paint(Graphics g){
        bg b = new bg(gp);
        b.dbg(g);
        g.setFont(new Font("华文行楷",Font.BOLD,50));
        g.drawString("注册",170,80);
    }
}
