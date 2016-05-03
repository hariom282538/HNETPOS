import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class EditProduct extends JPanel
{
       JTable jtProduct;
       DefaultTableModel jtModel;
       JComboBox jcbManufacturer;
       JTextField txtSearch;
       JButton btnModify;
       JButton btnDelete;
       JButton btnCancel;

		JScrollPane jspProduct;

     JPanel panel0;
     JPanel panel1;
     JPanel panel2;
     JPanel panel3;
    
      final String[] header={"Product Id","Product Name","Manufacturer Name"};
      Object[][] data=new Object[0][2];

        EditProduct()
               {
	btnModify=new JButton("Modify");
	
    btnDelete=new JButton("Delete");
	btnCancel=new JButton("Cancel");

	txtSearch=new JTextField(15);
	jcbManufacturer=new JComboBox();

	jtModel = new DefaultTableModel(data,header);
	
	jtProduct=new JTable(jtModel);
	jtProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtProduct.setColumnSelectionAllowed(false);
	jtProduct.setShowVerticalLines(false);
	jtProduct.setShowGrid(false);

	jtProduct.setOpaque(false);
	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jspProduct=new JScrollPane(jtProduct,vertical,height);
	jspProduct.setPreferredSize(new Dimension(470, 160));




	panel0=new JPanel();
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	
             
	panel1=new JPanel();
	
	panel1.add(jspProduct);
	
    panel0.add(panel1);
    panel0.setPreferredSize(new Dimension(500, 350));
	panel2=new JPanel();	
	//panel2.setLayout(new FlowLayout(0));
	panel0.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Delete / Modify",0,1,new Font("Serif", Font.BOLD,15)));
	panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Select Product",0,1,new Font("Serif", Font.BOLD,15)));
	panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Instant Search",0,1,new Font("Serif", Font.BOLD,15)));
	panel2.add(jcbManufacturer);
	
	panel2.add(txtSearch);
	//panel2.setPreferredSize(new Dimension(50, 80));
	panel0.add(panel2);
	panel3=new JPanel();
	panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
	panel3.add(btnModify);
	panel3.add(btnDelete);
	panel3.add(btnCancel);


	panel0.add(panel3);
   // Container c=getContentPane();
	add(panel0);

	setVisible(true);
   // setSize(300,300);

}
public static void main(String a[])
{
EditProduct dp=new EditProduct();
}
}