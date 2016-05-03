import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class View extends JInternalFrame {

JTabbedPane jtbView;

ViewCustomer viewCust;
ViewManufacturer viewManu;
ViewStock viewStock;
ViewProduct viewProd;




public View(){
super("Search",false,true,false,false);

viewCust=new ViewCustomer();
viewManu=new ViewManufacturer();
viewStock=new ViewStock();
viewProd=new ViewProduct();

setLayout(new BorderLayout());

jtbView=new JTabbedPane(JTabbedPane.TOP);

jtbView.addTab("Search Manufacturer",viewManu);
jtbView.addTab("Search Product",viewProd);
jtbView.addTab("Search Customer",viewCust);
jtbView.addTab("Search Stock",viewStock);


add(jtbView,BorderLayout.CENTER);
pack();
//getRootPane().setDefaultButton(addManu.btnCancel);
setVisible(true);
setLocation(350,30);

}


}