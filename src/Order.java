import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class Order extends JInternalFrame {

JTabbedPane jtbOrder;


UpdateOrder upOrder;
AddOrder adOrder;


public Order(){
super("Order",false,true,false,false);

upOrder=new UpdateOrder();
adOrder=new AddOrder();




setLayout(new BorderLayout());

jtbOrder=new JTabbedPane(JTabbedPane.TOP);


jtbOrder.addTab("Order Product",adOrder);
jtbOrder.addTab("Update Order",upOrder);
//jtbOrder.addTab("Delete Order",deleteCust);

add(jtbOrder,BorderLayout.CENTER);
pack();

setVisible(true);
setLocation(350,30);

}


}