import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class UpdateOrder extends JPanel
{
       JTable jtOrder;
       DefaultTableModel model;
       JLabel lblManufacturer;
       JLabel lblProductName;
	   JLabel lblDamage;
	   JLabel lblDate;
	    JLabel lblCurrentDate;
	   JComboBox jcbManufacturer;
       JTextField txtSearch;
	   JLabel lblAddStock;
		JTextField txtAddStock;
		JTextField txtDamage;
	   JButton btnUpdate;
       JButton btnCancel;
JButton btnDelete;

      final String[] header={"Stock Id","Product Names","Stock"};
      Object[][] data=new Object[0][3];

     JScrollPane jspStock;

     JPanel panel0;
     JPanel panel1;
     JPanel panel2;
	 JPanel panel2_1;
	 JPanel panel2_2;
     JPanel panel3;
	 JPanel panel4;
    String calendar;
	Calendar cal;
Border border;

        UpdateOrder()
               {
	btnUpdate=new JButton("Update");
	
    btnCancel=new JButton("Cancel");
	btnDelete=new JButton("Delete");
	
	//btnCancel.setBackground(Color.green);
	lblManufacturer =new JLabel("Manufacturer");
	lblProductName=new JLabel("Product Name");
	jcbManufacturer =new JComboBox();
	txtSearch=new JTextField(10);
	lblAddStock=new JLabel("Add");
	txtAddStock=new JTextField(10);
	lblDamage=new JLabel( "Remove",JLabel.RIGHT);
	txtDamage=new JTextField(10);

	model = new DefaultTableModel(data,header);
	
	jtOrder=new JTable(model);
	jtOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtOrder.setColumnSelectionAllowed(false);
	jtOrder.setShowVerticalLines(false);
	jtOrder.setShowGrid(false);
	//jtOrder.setBackground(Color.white);
	jtOrder.setOpaque(false);
	jtOrder.setAutoResizeMode(0);
	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jspStock=new JScrollPane(jtOrder,vertical,height);
	jspStock.setPreferredSize(new Dimension(400, 200));

	//Container c= getContentPane();
lblDate=new JLabel("Date :");
lblCurrentDate=new JLabel();

cal=new GregorianCalendar();
int day=cal.get(Calendar.DAY_OF_MONTH);
int month=cal.get(Calendar.MONTH);
int year=cal.get(Calendar.YEAR);
month=month+1;
String strMonth="";
if(month==1) strMonth="Jan";
if(month==2) strMonth="Feb";
if(month==3) strMonth="Mar";
if(month==4) strMonth="Apr";
if(month==5) strMonth="May";
if(month==6) strMonth="Jun";
if(month==7) strMonth="Jul";
if(month==8) strMonth="Aug";
if(month==9) strMonth="Sep";
if(month==10) strMonth="Oct";
if(month==11) strMonth="Nov";
if(month==12) strMonth="Dec";
calendar=Integer.toString(day)+"-"+strMonth+"-"+Integer.toString(year);
border= LineBorder.createGrayLineBorder();
lblCurrentDate.setBorder(border);
lblCurrentDate.setText(calendar);


	panel0=new JPanel();
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	panel0.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Update Stock"));
               panel0.setBackground(Color.lightGray);



	panel1=new JPanel();
	panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
	panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"SelectProduct"));
	//panel1.setBackground(Color.white);
	panel1.add(jspStock);
	panel4=new JPanel();
	panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
	panel4.add(lblDate);
	panel4.add(lblCurrentDate);
	//panel4.add(lblAddStock);
	//panel4.add(txtAddStock);
	//panel4.add(lblDamage);
	//panel4.add(txtDamage);
	panel1.add(panel4);
                
	panel2=new JPanel();	
	panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
	panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Select Manufacturer"));
	panel2_1=new JPanel();
	panel2_1.add(lblManufacturer);
	panel2_1.add(jcbManufacturer);
	panel2_2=new JPanel();
	panel2_2.add(lblProductName);
	panel2_2.add(txtSearch);
	
	panel2.add(panel2_1);
	panel2.add(panel2_2);
	
	//panel2.setPreferredSize(new Dimension(50, 100));
//panel0.add(panel2);
 panel0.add(panel1);

panel3=new JPanel();
panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
panel3.add(btnUpdate);
panel3.add(btnDelete);
panel3.add(btnCancel);
panel3.setBackground(Color.lightGray);

panel0.add(panel3);
add(panel0);
add(panel0);
setSize(300,300);
setVisible(true);

//pack();
}
public static void main(String a[])
{
try {

UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}
catch(Exception e)
{

}  
UpdateOrder us=new UpdateOrder();
}
}