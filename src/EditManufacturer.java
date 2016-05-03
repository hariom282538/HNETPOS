import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class EditManufacturer extends JPanel
{
       JTable jtManufacturer;
       DefaultTableModel jtModel;
       JLabel lblSearch;
       JTextField txtSearch;
       JButton btnModify;
       JButton btnDelete;
       JButton btnCancel;

		JScrollPane jsp;

     JPanel panel0;
     JPanel panel1;
     JPanel panel2;
     JPanel panel3;
	 
	 	Cursor cursor;
    
      final String[] header={"Manufacturer Id","Name"};
      Object[][] data=new Object[0][2];

        EditManufacturer()
               {
	btnModify=new JButton("Modify");
	
    btnDelete=new JButton("Delete");
	btnCancel=new JButton("Cancel");

	txtSearch=new JTextField(15);
	lblSearch=new JLabel("Name");

	jtModel = new DefaultTableModel(data,header);
	
	jtManufacturer=new JTable(jtModel);
	jtManufacturer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtManufacturer.setColumnSelectionAllowed(false);
	jtManufacturer.setShowVerticalLines(false);
	jtManufacturer.setShowGrid(false);

	jtManufacturer.setOpaque(false);
	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jsp=new JScrollPane(jtManufacturer,vertical,height);
	jsp.setPreferredSize(new Dimension(400, 200));

cursor=new Cursor(12);
jtManufacturer.setCursor(cursor);


	panel0=new JPanel();
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	
             
	panel1=new JPanel();
	
	panel1.add(jsp);
	
    panel0.add(panel1);

	panel2=new JPanel();	
	//panel2.setLayout(new FlowLayout(0));
	panel0.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Delete / Modify",0,1,new Font("Serif", Font.BOLD,15)));
	panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Select Manufacturer",0,1,new Font("Serif", Font.BOLD,15)));
	panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Instant Search",0,1,new Font("Serif", Font.BOLD,15)));
	panel2.add(lblSearch);
	
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


}

}