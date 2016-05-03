import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;

public class Manufacturer extends JInternalFrame {


JTabbedPane jtbCustomer;
JTabbedPane jtbManufacturer;

AddManufacturer addManu;
EditManufacturer editManu;

public Manufacturer(){
super("Manufacturer",false,true,false,false);
//super("MANUFACTURER",false,true,false,false);
addManu=new AddManufacturer();
editManu=new EditManufacturer();
setLayout(new BorderLayout());

jtbCustomer=new JTabbedPane(JTabbedPane.TOP);
jtbManufacturer=new JTabbedPane(JTabbedPane.TOP);

jtbManufacturer.addTab("Edit Manufacturer",editManu);
jtbManufacturer.addTab("Add Manufacturer",addManu);


add(jtbManufacturer,BorderLayout.CENTER);
pack();
getRootPane().setDefaultButton(editManu.btnCancel);
//setOpaque(false);
setVisible(true);
setLocation(350,30);

}
    public static void main(String[] args) {
        Frame f=new Frame();
        
        Manufacturer m=new Manufacturer();
        f.setVisible(true);
        f.setLayout(new FlowLayout());
        f.setSize(500, 900);
        f.add(m);
    }

}