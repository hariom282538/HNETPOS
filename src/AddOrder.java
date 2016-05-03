import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class AddOrder extends JPanel
{
       JTable jtOrder;
       DefaultTableModel model;
       JLabel lblManufacturer;
       JLabel lblProductName;
	   JLabel lblDamage;
	   JComboBox jcbManufacturer;
	     JComboBox jcbProduct;
       JTextField txtSearch;
	   JLabel lblAddOrder;
		JTextField txtQuantity;
		JTextField txtDamage;
	   JButton btnUpdate;
	   JButton btnAdd;
	   JButton btnSave;
       JButton btnCancel;
JButton btnDelete;


      final String[] header={"Purchase_id","Manu_Id","Product_Id","Quantity","Amount","Order_Date","Received_Date","Status"};
      Object[][] data=new Object[0][8];

     JScrollPane jspStock;

     JPanel panel0;
     JPanel panel1;
     JPanel panel2;
	 JPanel panel2_1;
	 JPanel panel2_2;
     JPanel panel3;
	 JPanel panel4;
    
	JSpinner jsQuantity;


        AddOrder()
               {
	btnUpdate=new JButton("Update");
	btnAdd=new JButton("Add");
	btnSave=new JButton("Save");
	
	
    btnCancel=new JButton("Cancel");
	//btnCancel.setBackground(Color.green);
	btnDelete=new JButton("Delete");
	lblManufacturer =new JLabel("Manufacturer");
	lblProductName=new JLabel("Product Name");
	jcbManufacturer =new JComboBox();
	jcbProduct =new JComboBox();
	txtSearch=new JTextField(10);
	lblAddOrder=new JLabel("Quantity ");
	txtQuantity=new JTextField(10);
	lblDamage=new JLabel( "Remove",JLabel.RIGHT);
	txtDamage=new JTextField(10);

	model = new DefaultTableModel(data,header);
	
	jtOrder=new JTable(model){
      public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;   //Disallow the editing of any cell
      }
    };
	jtOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtOrder.setColumnSelectionAllowed(false);
	jtOrder.setShowVerticalLines(false);
	jtOrder.setShowGrid(false);
	jtOrder.setAutoResizeMode(0);
	//jtOrder.setBackground(Color.white);
	jtOrder.setOpaque(false);
	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jspStock=new JScrollPane(jtOrder,vertical,height);
	jspStock.setPreferredSize(new Dimension(400, 200));

	//Container c= getContentPane();
jsQuantity=new JSpinner(new SpinnerNumberModel(1,1,10000,1));

	panel0=new JPanel();
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	panel0.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Add Stock"));
               panel0.setBackground(Color.lightGray);



	panel1=new JPanel();
	panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
	panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"SelectProduct"));
	//panel1.setBackground(Color.white);
	panel1.add(jspStock);
	panel4=new JPanel();
	//panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
	//panel4.add(lblAddOrder);
	//panel4.add(txtQuantity);
	//panel4.add(lblDamage);
	//panel4.add(txtDamage);
	panel1.add(panel4);
                
	panel2=new JPanel();	
	panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

	panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Select Manufacturer"));
	panel2_1=new JPanel();
	panel2_1.setLayout(new FlowLayout(0));
	panel2_1.add(lblManufacturer);
	panel2_1.add(jcbManufacturer);
	panel2_2=new JPanel();
	panel2_2.setLayout(new FlowLayout(0));
	panel2_1.add(lblProductName);
	panel2_1.add(jcbProduct);
	//panel2_1.add(txtSearch);
	panel2_2.add(lblAddOrder);
	panel2_2.add(jsQuantity);
	//panel2_2.add(txtQuantity);
	panel2.add(panel2_1);
	panel2.add(panel2_2);
	
	//panel2.setPreferredSize(new Dimension(50, 100));
panel0.add(panel2);
 panel0.add(panel1);

panel3=new JPanel();
panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
//panel3.add(btnUpdate);
panel3.add(btnAdd);
panel3.add(btnDelete);
panel3.add(btnSave);
panel3.add(btnCancel);
panel3.setBackground(Color.lightGray);

panel0.add(panel3);
add(panel0);
add(panel0);
setSize(300,300);
setVisible(true);

//pack();
}

}