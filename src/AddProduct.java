import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
public class AddProduct extends JPanel 
{
Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
JComboBox jcbManufacturer;

JTextField txtProductName;
JTextField txtPrice;
JTextField txtCustomerPrice;
JTextField txtVat;
JTextField txtBoxQuantity;
JTextField txtBoxMrp;

JButton btnSave;
JButton btnCancel;

JLabel lblManufacturer;
JLabel lblProductName;
JLabel lblPrice;
JLabel lblCustomerPrice;
JLabel lblVat;
JLabel lblBoxQuantity;
JLabel lblBoxPrice;


 
 JPanel panel0;
JPanel panel1;

JPanel panel1_1;

JPanel panel1_2;
JPanel panel2;
JPanel panel2_1;
JPanel panel2_2;
JPanel panel2_3;
JPanel panel3;

 
public AddProduct()
{
 lblManufacturer=new JLabel("Manufacturer     ");
 jcbManufacturer =new JComboBox();
// lblBlank=new JLabel("                                      ");

 lblProductName=new JLabel("Product Name  ");
 txtProductName=new JTextField("",15);

 lblPrice=new JLabel("Product MRP       ");
 txtPrice=new JTextField("",10);
 
 lblCustomerPrice=new JLabel("Selling Price        ");
 txtCustomerPrice=new JTextField("",10);
 
lblVat=new JLabel("   Vat %    ");
 txtVat=new JTextField("",10);
 
 lblBoxPrice=new JLabel("   Box MRP    ");
 txtBoxMrp=new JTextField("",10);

 lblBoxQuantity=new JLabel(" Box Quantity        ");
 txtBoxQuantity=new JTextField("",10);
 btnSave=new JButton("Save");
 btnCancel=new JButton("Cancel");



	panel0=new JPanel();
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	panel0.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Product"));
        //panel0.setBackground(Color.lightGray);
	panel1=new JPanel();
       panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
     panel1.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Name"));
	
	
 	panel1_1 =new JPanel();
        panel1_1.setLayout(new FlowLayout(FlowLayout.LEFT));
	panel1_1.add(lblManufacturer);
    panel1_1.add(jcbManufacturer);
    //panel1_1.add(lblBlank);
	panel1_2 =new JPanel();
        panel1_2.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel1_2.add(lblProductName);
	panel1_2.add(txtProductName);
	
	panel1.add(panel1_1);
	panel1.add(panel1_2);
  
  panel2=new JPanel();
       panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
    panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Detail"));
	
      panel2_1=new JPanel();
     panel2_1.setLayout(new FlowLayout(FlowLayout.LEFT));
	panel2_1.add(lblPrice);
	panel2_1.add(txtPrice);
	
	
    panel2_2=new JPanel();
    panel2_2.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel2_2.add(lblCustomerPrice);
	panel2_2.add(txtCustomerPrice);
	//panel2_2.add(lblVat);
	//panel2_2.add(txtVat);
	
	
	
	panel2_3=new JPanel();
	panel2_3.setLayout(new FlowLayout(FlowLayout.LEFT));
    
	 panel2_3.add(lblBoxQuantity);
	panel2_3.add(txtBoxQuantity);
	panel2_3.add(lblBoxPrice);
	panel2_3.add(txtBoxMrp);
	
	
	panel2.add(panel2_1);
	panel2.add(panel2_2);
	panel2.add(panel2_3);
	
	panel3=new JPanel(); 
    panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
	panel3.add(btnSave);
        panel3.add(btnCancel);
       //  panel3.setBackground(Color.lightGray);
        panel0.add(panel1);
	panel0.add(panel2);
    panel0.add(panel3);
    
    //Container c=getContentPane();
	add(panel0);
//panel0.setPreferredSize(new Dimension(650,250));
	setSize(400,300);
	setVisible(true);
               // pack();
}
public static void main(String arg[])
{
try {

UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}
catch(Exception e)
{

} 
    AddProduct ae=new AddProduct();
}
}