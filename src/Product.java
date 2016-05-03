import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;

public class Product extends JInternalFrame {

JTabbedPane jtBorder;


AddProduct addProduct;
EditProduct editProduct;


public Product(){
super("Product",false,true,false,false);

addProduct=new AddProduct();
editProduct=new EditProduct();

setLayout(new BorderLayout());

jtBorder=new JTabbedPane(JTabbedPane.TOP);

jtBorder.addTab("Edit Product",editProduct);
jtBorder.addTab("Add Product",addProduct);


add(jtBorder,BorderLayout.CENTER);
pack();
//setSize(500,500);
setVisible(true);
setLocation(350,30);

}


}