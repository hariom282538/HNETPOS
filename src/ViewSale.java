import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class ViewSale extends JPanel
{
JLabel lblFirstName;
JLabel lblLastName;
JLabel lblCompany;
JButton btnSearch;
JButton btnComplete;
JButton btnDelete;
JButton btnCancel;

JComboBox jcbFirstName;

JComboBox jcbLastName;
JComboBox jcbCompany;

JTable jtViewSale;
DefaultTableModel jtModel;
JScrollPane jspViewSale;
	
JPanel panel0;
JPanel panel1;
JPanel panel1_1;
JPanel panel1_2;
JPanel panel2;
JPanel panel2_1;
JPanel panel3;
	
	
      final String[] header={"Order Id1","Order Id2","Customer Id","Product Id","Quantity"};
      Object[][] data=new Object[0][5];
ViewSale()
 {
    
    lblFirstName=new JLabel("First Name");
    lblLastName=new JLabel("Last Name");
    lblCompany=new JLabel("Company");
    JLabel lblBlank=new JLabel("        ");  
    btnSearch=new JButton("Search");
	jcbFirstName=new JComboBox();
    jcbLastName=new JComboBox();
    jcbCompany=new JComboBox();
	   btnComplete=new JButton("Complete");
	      btnDelete=new JButton("Delete");
		     btnCancel=new JButton("Cancel");
	
	
	jtModel = new DefaultTableModel(data,header);
    jtViewSale=new JTable(jtModel);
jtViewSale.setAutoResizeMode(0);

    jtViewSale.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtViewSale.setColumnSelectionAllowed(false);
	jtViewSale.setShowVerticalLines(false);
	jtViewSale.setShowGrid(false);

	jtViewSale.setOpaque(false);
	
	jtViewSale.setShowGrid(true);
	jtViewSale.setShowVerticalLines(true);
	jtViewSale.setGridColor(Color.blue);
	
	
	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jspViewSale=new JScrollPane(jtViewSale,vertical,height);
	jspViewSale.setPreferredSize(new Dimension(400, 200));

	
	jtViewSale.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtViewSale.setColumnSelectionAllowed(false);
	jtViewSale.setShowVerticalLines(false);
	jtViewSale.setShowGrid(false);
	jtViewSale.setOpaque(false);
	int vertical2=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height2=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jspViewSale=new JScrollPane(jtViewSale,vertical2,height2);
	jspViewSale.setPreferredSize(new Dimension(430, 200));

    panel0=new JPanel();
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	panel0.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Order"));
    panel0.setBackground(Color.lightGray);
	
	 panel1=new JPanel();
       panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
	  panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Customer"));
	
	panel1_1 =new JPanel();
	panel1_1.add(lblCompany);
	panel1_1.add(jcbCompany);
	panel1_1.add(lblFirstName);
	panel1_1.add(jcbFirstName);
	panel1_1.add(lblLastName);
	panel1_1.add(jcbLastName);
	
	panel1_1.add(lblBlank);
	panel1_1.add(btnSearch);
	panel1.add(panel1_1);
	
    panel2=new JPanel();
    panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
	panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Date"));
  
    panel2_1=new JPanel();
       panel2_1.setLayout(new BoxLayout(panel2_1,BoxLayout.Y_AXIS));
       
	panel2_1.add(jspViewSale);
	 panel2.add(panel2_1);
	 panel3=new JPanel();
     panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
     panel3.add(btnComplete);
     panel3.add(btnDelete);
     panel3.add(btnCancel);	 
  
   // panel0.add(panel1);
	panel0.add(panel2);
	panel0.add(panel3);
	
	//Container c=getContentPane();
	add(panel0);
  
    setSize(500,800);
	 setVisible(true);
    //     pack();
     	 
  
  }

public static void main(String a[])
{
try {

UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}
catch(Exception e)
{

}  
ViewSale ao=new  ViewSale();
}
}