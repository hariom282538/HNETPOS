import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.awt.Dimension;

import javax.swing.table.DefaultTableModel.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class EditEmployee extends JPanel
{
       JTable jtEmployee;
       DefaultTableModel model;
       JComboBox jcbSearch;
       JTextField txtSearch;
       JButton btnModify;
       JButton btnDelete;
       JButton btnCancel;
	   JLabel lblEmployee;

      final String[] header={"id","Names","Branch"};
      Object[][] data=new Object[0][3];

     JScrollPane jsp;

     JPanel panel0;
     JPanel panel1;
     JPanel panel2;
     JPanel panel3;
    


        EditEmployee()
               {
			   
			   lblEmployee=new JLabel("Name");
	btnModify=new JButton("Modify");
	//btnModify.setBackground(Color.orange);
                btnDelete=new JButton("Delete");
	btnCancel=new JButton("Cancel");
	//btnCancel.setBackground(Color.green);
	txtSearch=new JTextField(15);
	//lblSearch=new JLabel("Name");
    jcbSearch=new JComboBox();
	jcbSearch.addItem("Emplyee Name");
	jcbSearch.addItem("Branch Name");
	model = new DefaultTableModel(data,header);
	
	jtEmployee=new JTable(model);
	jtEmployee.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtEmployee.setColumnSelectionAllowed(false);
	jtEmployee.setShowVerticalLines(false);
	jtEmployee.setShowGrid(false);
	//jtEmployee.setBackground(Color.white);
	jtEmployee.setOpaque(false);
	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jsp=new JScrollPane(jtEmployee,vertical,height);
	jsp.setPreferredSize(new Dimension(630, 210));

	//Container c= getContentPane();


	panel0=new JPanel();
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	panel0.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Delete/Modify"));
              //   panel0.setBackground(Color.lightGray);



	panel1=new JPanel();
	panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Select Employee"));
	//panel1.setBackground(Color.white);
	panel1.add(jsp);
	
                 panel0.add(panel1);

	panel2=new JPanel();	
	panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 1),"Search"));
	//panel2.add(jcbSearch);
	panel2.add(lblEmployee);
	
	panel2.add(txtSearch);
	panel2.setPreferredSize(new Dimension(50, 80));
panel0.add(panel2);
panel3=new JPanel();
panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
panel3.add(btnModify);
panel3.add(btnDelete);
panel3.add(btnCancel);
//panel3.setBackground(Color.lightGray);

panel0.add(panel3);
add(panel0);
add(panel0);
panel1.setPreferredSize(new Dimension(650,250));
//panel1.setPreferredSize(new Dimension(700,300));
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
EditEmployee de=new EditEmployee();
}
}