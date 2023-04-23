package frame;

import javax.swing.*;
import java.awt.*;

public class bg {
    public int bx;
    public int by;
    public  int bw;
    public  int bh;
    public Panel nowp;
    public Image imgbg;
    public bg(Panel p){
        bx= 0;
        by= 0;
        nowp = p;
        imgbg =new ImageIcon("bg.png").getImage();
        bw = imgbg.getHeight(nowp);
        bh = imgbg.getHeight(nowp);

    }
    public void dbg(Graphics g){
        g.drawImage(imgbg,bx,by,nowp);
    }
}
