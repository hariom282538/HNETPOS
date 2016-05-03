import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class PanelBg extends JPanel{


GetImage getI;
JPanel panelBgImg;
public PanelBg(){

getI=new GetImage();
     ImageIcon imh = new ImageIcon(getI.getImage("i/p2.jpg"));
      //  setSize(imh.getIconWidth(), imh.getIconHeight());
         // setSize(400,400);
        panelBgImg = new JPanel()
        {
            public void paintComponent(Graphics g) 
            {
                Image img = new ImageIcon(getI.getImage("i/p2.jpg")).getImage();
               		   //Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
			   Dimension size = new Dimension(1366,750);
                setPreferredSize(size);
                setMinimumSize(size);
                setMaximumSize(size);
                setSize(size);
                setLayout(new FlowLayout());
               g.drawImage(img, 0, 0,1366,750,null);
            } 
        };

}



}