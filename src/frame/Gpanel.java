package frame;

import java.awt.*;

public class Gpanel extends Panel{
    public login lg;
    public  bg bg;
    public Gpanel(){
        bg = new bg(this);
    }
    public void paint(Graphics g){
        bg.dbg(g);
    }

}
