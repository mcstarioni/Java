package Test.Applet;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by mcstarioni on 28.04.2017.
 */
public class MyApplet extends Applet
{
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.green);
        g.fillRect(0,0,200,200);
        g.setColor(Color.black);
        g.drawString("Hello, world!!!!", 100,100);
    }
}
