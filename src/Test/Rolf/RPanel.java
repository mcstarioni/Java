package Test.Rolf;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mcstarioni on 21.11.2016.
 */
public class RPanel extends JPanel{
    JTextField loxName;
    public RPanel()
    {
        super();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JLabel label = new JLabel("NOW WHO IS A TRUE LOX?????");
        label.setFont(new Font(null,Font.BOLD,40));
        Box box = Box.createHorizontalBox();
        loxName = new JTextField(10);
        JButton accept = new JButton("ENTER");
        box.add(loxName);
        box.add(accept);
        Icon nikita = new ImageIcon("C:\\Users\\Макс\\Documents\\Programming" +
                "\\3 semester\\Java\\src\\Test\\Rolf\\NikitaCanvas.png");
        JButton loxAccept  = new JButton(nikita);
        loxAccept.setSize(new Dimension(50,50));
        add(label);
        add(box);
        add(loxAccept);
    }
}
