import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class AddSale extends JPanel
{


JLabel lblFirstName;
JLabel lblLastName;
JLabel lblCompany;
JLabel  lblSaleDate1;
JLabel  lblShipmentDate;
JLabel lblManufacturerName;
JLabel lblProductName;
JLabel lblQuantity;  
JLabel lblTotal1;
JLabel lblTotal2;
JTable jtProductList,jtAddProduct;
DefaultTableModel jtModel1,jtModel2;

JComboBox jcbFirstName;

JComboBox jcbLastName;
JComboBox jcbCompany;
JTextField  txtSaleDate;
JLabel lblSaleDate2;
JComboBox jcbShipmentDateDay;
JComboBox jcbShipmentDateMonth;
JComboBox jcbShipmentDateYear;
JComboBox jcbManufacturer;
JTextField  txtSearch;
JTextField txtQuantity; 
JTextField txtTotal;
  JButton btnAdd;
 JButton btnRemove;
 
 JButton btnSave;
 JButton btnCancel;

 	JScrollPane jspAddProduct,jspProductList;
	int j;
	String temp;

      final String[] header1={"Product Name","MRP","Box_Price","Stock"};
      Object[][] data1=new Object[0][5];

       final String[] header2={"Product Name","Box_Price","Quantity","Amount"};
      Object[][] data2=new Object[0][4];






JPanel panel0;
JPanel panel1;

JPanel panel1_1;

JPanel panel1_2;
JPanel panel2;
JPanel panel2_1;
JPanel panel2_2;
JPanel panel2_3;
JPanel panel3;
JPanel panel3_1;
JPanel panel3_2;
JPanel panel3_3;
JPanel panel4;
JPanel panel4_1;


JPanel panel5;
JPanel panel5_1;
JPanel panel5_2;

JPanel panel6;
JPanel panel7;
JPanel panel7_1;
JPanel panel7_2;
JPanel panel8;

Border border;

AddSale()
{
border= LineBorder.createGrayLineBorder();

lblFirstName=new JLabel("First Name");
lblLastName=new JLabel("Last Name");
lblCompany=new JLabel("Company");
lblSaleDate1=new JLabel("Sale Date");
lblShipmentDate=new JLabel("Shipment Date");
lblManufacturerName=new JLabel("Manufacturer");
lblProductName=new JLabel("Product Name");
lblQuantity=new JLabel("Quantity");
lblTotal1=new JLabel("Total");
lblTotal2=new JLabel("");
lblSaleDate2=new JLabel("");
lblSaleDate2.setBorder(border);
lblTotal2.setBorder(border);
border= LineBorder.createGrayLineBorder();

jtModel1 = new DefaultTableModel(data1,header1);
jtModel2 = new DefaultTableModel(data2,header2);

jtProductList=new JTable(jtModel1);
jtProductList.setAutoResizeMode(0);
jtAddProduct=new JTable(jtModel2);
jtAddProduct.setAutoResizeMode(0);
    jtProductList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtProductList.setColumnSelectionAllowed(false);
	jtProductList.setShowVerticalLines(false);
	jtProductList.setShowGrid(false);

	jtProductList.setOpaque(false);
	int vertical1=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height1=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
jspProductList=new JScrollPane(jtProductList,vertical1,height1);

	jspProductList.setPreferredSize(new Dimension(320, 150));

	
	jtAddProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtAddProduct.setColumnSelectionAllowed(false);
	jtAddProduct.setShowVerticalLines(false);
	jtAddProduct.setShowGrid(false);
	jtAddProduct.setOpaque(false);
	int vertical2=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int height2=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jspAddProduct=new JScrollPane(jtAddProduct,vertical2,height2);

	jspAddProduct.setPreferredSize(new Dimension(320, 150));

	jtProductList.setShowGrid(true);
	jtProductList.setShowVerticalLines(true);
	jtProductList.setGridColor(Color.blue);
	
	
	
	

jcbFirstName=new JComboBox();
jcbLastName=new JComboBox();
jcbCompany=new JComboBox();
txtSaleDate=new JTextField(10);
jcbShipmentDateDay=new JComboBox();
jcbShipmentDateMonth=new JComboBox();
jcbShipmentDateYear=new JComboBox();
jcbManufacturer=new JComboBox();
txtSearch=new JTextField(10);
txtQuantity=new JTextField(10);
txtTotal =new JTextField(10);



  jcbShipmentDateYear.addItem("Select");
  jcbShipmentDateMonth.addItem("Select");
  jcbShipmentDateDay.addItem("Select");
  
  //jcbShipmentDateYear.addItem("2011");
for( j =2011;j<2031;j++)
                {
                     temp = Integer.toString(j);
                    jcbShipmentDateYear.addItem(temp);
                }
/*for( j =1;j<13;j++)
                {
                     temp = Integer.toString(j);
                    jcbShipmentDateMonth.addItem(temp);
                }*/
				
				jcbShipmentDateMonth.addItem("Jan");
		jcbShipmentDateMonth.addItem("Feb");
		jcbShipmentDateMonth.addItem("Mar");
		jcbShipmentDateMonth.addItem("Apr");
		jcbShipmentDateMonth.addItem("May");
		jcbShipmentDateMonth.addItem("Jun");
		jcbShipmentDateMonth.addItem("Jul");
		jcbShipmentDateMonth.addItem("Aug");
		jcbShipmentDateMonth.addItem("Sep");
		jcbShipmentDateMonth.addItem("Oct");
		jcbShipmentDateMonth.addItem("Nov");
		jcbShipmentDateMonth.addItem("Dec");
				for( j =1;j<32;j++)
                {
                     temp = Integer.toString(j);
                    jcbShipmentDateDay.addItem(temp);
                }
				
btnAdd=new JButton(">");
btnRemove=new JButton("<");
btnSave=new JButton("Save");
btnCancel=new JButton("Cancel");

panel0=new JPanel();
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	panel0.setBorder(new TitledBorder (new LineBorder(Color.blue, 2),"Sale"));
    panel0.setBackground(Color.lightGray);
	
	 panel1=new JPanel();
       panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
	  panel1.setBorder(new TitledBorder (new LineBorder(Color.blue, 1),"Customer"));
	
	panel1_1 =new JPanel();
	panel1_1.add(lblCompany);
	panel1_1.add(jcbCompany);
	panel1_1.add(lblFirstName);
	panel1_1.add(jcbFirstName);
	panel1_1.add(lblLastName);
	panel1_1.add(jcbLastName);
	
	panel1.add(panel1_1);
	
	panel2=new JPanel();
    panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
	panel2.setBorder(new TitledBorder (new LineBorder(Color.blue, 1),"Date"));

	panel2_1 =new JPanel();
	panel2_1.add(lblSaleDate1);
	//panel2_1.add(txtSaleDate);
	panel2_1.add(lblSaleDate2);
	//panel2_1.add(lblShipmentDate);
	//panel2_1.add(jcbShipmentDateDay);
	//panel2_1.add(jcbShipmentDateMonth);
	//panel2_1.add(jcbShipmentDateYear);
	panel2.add(panel2_1);
	
	panel3=new JPanel();
	panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
	panel3.setBorder(new TitledBorder (new LineBorder(Color.blue, 2),"Product"));
    panel3.setBackground(Color.lightGray);
	
	
	panel3_1 =new JPanel();
	panel3_1.add(lblManufacturerName);
	panel3_1.add(jcbManufacturer);
	panel3_1.add(lblProductName);
	panel3_1.add(txtSearch);

	panel3.add(panel3_1);
	  
	  
	  panel4=new JPanel();
       panel4.setLayout(new BoxLayout(panel4,BoxLayout.X_AXIS));
       panel4.setBorder(new TitledBorder (new LineBorder(Color.blue, 1),"Place Sale"));
	   
	   panel5=new JPanel();
       panel5.setLayout(new BoxLayout(panel5,BoxLayout.Y_AXIS));
       panel5.setBorder(new TitledBorder (new LineBorder(Color.blue, 1),"Product List"));
	   
	  panel5_1=new JPanel();
       panel5_1.setLayout(new BoxLayout(panel5_1,BoxLayout.Y_AXIS));
       
	panel5_1.add(jspProductList);
    panel5_2=new JPanel(); 
	panel5_2.add(lblQuantity);
    	panel5_2.add(txtQuantity);
		panel5.add(panel5_1);
		panel5.add(panel5_2);
	panel6=new JPanel();
       panel6.setLayout(new BoxLayout(panel6,BoxLayout.Y_AXIS));
     
	 panel6.add(btnAdd);
	 panel6.add(btnRemove);
	 
	 panel7=new JPanel();
       panel7.setLayout(new BoxLayout(panel7,BoxLayout.Y_AXIS));
       panel7.setBorder(new TitledBorder (new LineBorder(Color.blue, 1),"Add Sale"));
	   
	   panel7_1=new JPanel();
	   panel7_1.add(jspAddProduct);
	   panel7.add(panel7_1);
	   panel7_2=new JPanel();
	   panel7_2.add(lblTotal1);
       panel7_2.add(lblTotal2);	 
       panel7.add(panel7_2);	 
	 panel4.add(panel5);
	 panel4.add(panel6);
	 panel4.add(panel7);
	 
	 
	 panel8=new JPanel();
     panel8.setLayout(new FlowLayout(FlowLayout.RIGHT));
     panel8.add(btnSave);
     panel8.add(btnCancel);	 
		
	// Container c=getContentPane();
     
     panel0.add(panel1);
     panel0.add(panel2);
     panel0.add(panel3);
     panel0.add(panel4);
	 panel0.add(panel8);
	 
	//c.add(panel0);
	add(panel0);
	  setSize(500,800);
	 setVisible(true);
       //  pack();
     	 
	   
	
	
	
	}
public static void main(String a[])
{
try {

UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}
catch(Exception e)
{

}  
AddSale ao=new  AddSale();
}
}
