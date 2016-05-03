import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;

public class Customer extends JInternalFrame {

JTabbedPane jtbCustomer;
JTabbedPane jtbManufacturer;

AddCustomer addCust;
EditCustomer editCust;

public Customer(){
super("Customer",false,true,false,false);

addCust=new AddCustomer();
editCust=new EditCustomer();

setLayout(new BorderLayout());

jtbCustomer=new JTabbedPane(JTabbedPane.TOP);

jtbCustomer.addTab("Edit Customer",editCust);
jtbCustomer.addTab("Add Customer",addCust);


add(jtbCustomer,BorderLayout.CENTER);
pack();

setVisible(true);
setLocation(350,30);


}


}