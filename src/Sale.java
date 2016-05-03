import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;

public class Sale extends JInternalFrame {

JTabbedPane jtbSale;


AddSale addSale;
ViewSale viewSale;
UpdateSale updateSale;


public Sale(){
super("Sale",false,true,false,false);

addSale=new AddSale();
viewSale=new ViewSale();
updateSale=new UpdateSale();

setLayout(new BorderLayout());

jtbSale=new JTabbedPane(JTabbedPane.TOP);


jtbSale.addTab("Add Sale",addSale);
jtbSale.addTab("Update Sale",viewSale);
//jtbSale.addTab("Update Sale",updateSale);

add(jtbSale,BorderLayout.CENTER);
pack();

setVisible(true);
setLocation(250,30);


}


}