import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class ViewManufacturer extends JPanel
{
JTable jtViewManufacturer;
JLabel lblManufacturerName;
JTextField txtManufacturerName;
DefaultTableModel jtModel;
final String[] header={"id","Manufacturer","State","Area","Address","Contactno.","Email","Pincode","Vat"};
 Object[][] data=new Object[0][9];
JScrollPane jspViewManufacturer;
JPanel panel0;
JPanel panel1;
JPanel panel2;
ViewManufacturer()
{
jtModel = new DefaultTableModel(data,header);
    
	lblManufacturerName=new JLabel("Manufacturer Name");
	txtManufacturerName=new JTextField(10); 
	
	jtViewManufacturer=new JTable(jtModel);
	jtViewManufacturer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtViewManufacturer.setColumnSelectionAllowed(false);
	jtViewManufacturer.setShowVerticalLines(false);
	jtViewManufacturer.setShowGrid(false);
jtViewManufacturer.setAutoResizeMode(0);
	jtViewManufacturer.setOpaque(false);
	
	jtViewManufacturer.setShowGrid(true);
	jtViewManufacturer.setShowVerticalLines(true);
	jtViewManufacturer.setGridColor(Color.blue);
	
	
	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jspViewManufacturer=new JScrollPane(jtViewManufacturer,vertical,height);
	jspViewManufacturer.setPreferredSize(new Dimension(600, 400));
    
	panel0=new JPanel();
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	
	panel1=new JPanel();
	panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Manufacturer",0,1,new Font("Serif", Font.BOLD,15)));
	panel1.setLayout(new BorderLayout());
	panel1.add(jspViewManufacturer,BorderLayout.CENTER);
	panel0.add(panel1);
	
	panel2=new JPanel();
	panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Instant Search",0,1,new Font("Serif", Font.BOLD,15)));
	panel2.add(lblManufacturerName);
	panel2.add(txtManufacturerName);
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
ViewManufacturer vm=new ViewManufacturer();
}
}