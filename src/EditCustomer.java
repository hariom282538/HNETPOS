import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class EditCustomer extends JPanel 
{
       JTable jtCustomer;
       DefaultTableModel jtModel;
       JComboBox jcbSearch;
       JTextField txtSearch;
	   
       JButton btnModify;
       JButton btnDelete;
       JButton btnCancel;
	   
	Cursor cursor;
     
	   JScrollPane jsp;

     JPanel panel0;
     JPanel panel1;
     JPanel panel2;
     JPanel panel3;
    
 final String[] header={"Customer Id","Name","Last Name","Company"};
      Object[][] data=new Object[0][0] ;

	  

   public  EditCustomer() {
   

	btnModify=new JButton("Modify");
	btnDelete=new JButton("Delete");
	btnCancel=new JButton("Cancel");
	
	txtSearch=new JTextField(15);
	
	jcbSearch=new JComboBox();
	jcbSearch.addItem("Company");
	jcbSearch.addItem("Customer");

	jtModel = new DefaultTableModel(data,header);

	
	jtCustomer=new JTable(jtModel);
	jtCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtCustomer.setColumnSelectionAllowed(false);
	jtCustomer.setShowVerticalLines(false);
	jtCustomer.setShowGrid(false);

	jtCustomer.setOpaque(false);
	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jsp=new JScrollPane(jtCustomer,vertical,height);
	jsp.setPreferredSize(new Dimension(400, 200));

   cursor=new Cursor(12);
   jtCustomer.setCursor(cursor);

	panel0=new JPanel();
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	
    panel1=new JPanel();
	
	panel1.add(jsp);
	
	panel0.add(panel1);

	panel2=new JPanel();	
	
	panel0.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Delete / Modify",0,1,new Font("Serif", Font.BOLD,15)));
	panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Select Customer",0,1,new Font("Serif", Font.BOLD,15)));
	panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Instant Search",0,1,new Font("Serif", Font.BOLD,15)));
	panel2.add(jcbSearch);
	
	panel2.add(txtSearch);
	panel2.setPreferredSize(new Dimension(50, 100));
	panel0.add(panel2);
	panel3=new JPanel();
	panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
	panel3.add(btnModify);
	panel3.add(btnDelete);
	panel3.add(btnCancel);


	panel0.add(panel3);
	add(panel0);

	setVisible(true);

}/*
public void actionPerformed(ActionEvent ae){
if(ae.getActionCommand().equals("cust.deleteCust.btnDelete")){

jtModel.removeRow();
}}*/
}