import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class GetImage extends JFrame {


public GetImage(){
}

public Image getImage(String pathName)
     {
         URL url = getClass().getResource(pathName); 
        Image image = Toolkit.getDefaultToolkit().getImage(url);
        return image;    
     }


}