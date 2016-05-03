import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class ViewCustomer extends JPanel
{
JTable jtViewCustomer;
JLabel lblCustomerName;
JTextField txtCustomerName;
DefaultTableModel jtModel;
final String[] header={"id","First Name","Last Name","State","Area","Address","Contactno.","Email","Company","Pincode"};
 Object[][] data=new Object[0][10];
JScrollPane jspViewCustomer;
JPanel panel0;
JPanel panel1;
JPanel panel2;
ViewCustomer()
{
jtModel = new DefaultTableModel(data,header);

	lblCustomerName=new JLabel("Customer Name");
	txtCustomerName=new JTextField(10); 
	jtViewCustomer=new JTable(jtModel);
	jtViewCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtViewCustomer.setColumnSelectionAllowed(false);
	jtViewCustomer.setShowVerticalLines(false);
	jtViewCustomer.setShowGrid(false);
jtViewCustomer.setAutoResizeMode(0);
	jtViewCustomer.setOpaque(false);
	
	jtViewCustomer.setShowGrid(true);
	jtViewCustomer.setShowVerticalLines(true);
	jtViewCustomer.setGridColor(Color.blue);
	
	
	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jspViewCustomer=new JScrollPane(jtViewCustomer,vertical,height);
	jspViewCustomer.setPreferredSize(new Dimension(600, 400));
    
	panel0=new JPanel();
	
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	
	panel1=new JPanel();
	panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Customer",0,1,new Font("Serif", Font.BOLD,15)));
	panel1.setLayout(new BorderLayout());
	panel1.add(jspViewCustomer,BorderLayout.CENTER);
	panel0.add(panel1);
	
	panel2=new JPanel();
	panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Instant Search",0,1,new Font("Serif", Font.BOLD,15)));
	panel2.add(lblCustomerName);
	panel2.add(txtCustomerName);
	panel0.add(panel2);
	//Container c=getContentPane();
	add(panel0);
	
    setVisible(true);
    setSize(600,500);


}
public static void main(String a[])
{
try {

UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}
catch(Exception e)
{

}  
ViewCustomer vc=new ViewCustomer();
}
}