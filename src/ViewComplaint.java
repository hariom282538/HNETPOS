import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class ViewComplaint extends JPanel
{
JTable jtViewComplaint;
JButton btnClear;
JButton btnDelete;
JButton btnCancel;

DefaultTableModel jtModel;
final String[] header={"Complaint id","First Name","LastName","Company","Description","Status","Complaint Date"};
 Object[][] data=new Object[0][7];
JScrollPane jspViewComplaint;
JPanel panel0;
JPanel panel1;
JPanel panel2;
ViewComplaint()
{
jtModel = new DefaultTableModel(data,header);

	

	jtViewComplaint=new JTable(jtModel);
	jtViewComplaint.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtViewComplaint.setColumnSelectionAllowed(false);
	jtViewComplaint.setShowVerticalLines(false);
	jtViewComplaint.setShowGrid(false);
jtViewComplaint.setAutoResizeMode(0);
	jtViewComplaint.setOpaque(false);
	
	jtViewComplaint.setShowGrid(true);
	jtViewComplaint.setShowVerticalLines(true);
	jtViewComplaint.setGridColor(Color.blue);
	
	

	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jspViewComplaint=new JScrollPane(jtViewComplaint,vertical,height);
	jspViewComplaint.setPreferredSize(new Dimension(400, 300));
    
	
	btnClear =new JButton("Clear");
	btnDelete=new JButton("Delete");
	btnCancel=new JButton("Cancel");
	
	panel0=new JPanel();
	
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	
	panel1=new JPanel();
	panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Complaint",0,1,new Font("Serif", Font.BOLD,15)));
	panel1.setLayout(new BorderLayout());
	panel1.add(jspViewComplaint,BorderLayout.CENTER);
	panel0.add(panel1);
	
	panel2=new JPanel();
	panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
	panel2.add(btnClear);
	panel2.add(btnDelete);
	panel2.add(btnCancel);
	panel0.add(panel2);
	//Container c=getContentPane();
	add(panel0);
	
    setVisible(true);
    setSize(600,500);
   // pack();

}
public static void main(String a[])
{
try {

UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}
catch(Exception e)
{

}  
ViewComplaint vcp=new ViewComplaint();
}
}