import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class ViewProduct extends JPanel
{
JTable jtViewProduct;
JLabel lblProductName;
JTextField txtProductName;
DefaultTableModel jtModel;
final String[] header={"product id","Manufacturer id","Product Name","MRP","Customer Price","Unit_Quantity","Unit_Purchase_Price","Unit_Selling_Price"};
 Object[][] data=new Object[0][8];
JScrollPane jspViewProduct;
JPanel panel0;
JPanel panel1;
JPanel panel2;
ViewProduct()
{
jtModel = new DefaultTableModel(data,header);
     
	 lblProductName=new JLabel("Product Name");
	txtProductName=new JTextField(10); 
	
	jtViewProduct=new JTable(jtModel);
	jtViewProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtViewProduct.setColumnSelectionAllowed(false);
	jtViewProduct.setShowVerticalLines(false);
	jtViewProduct.setShowGrid(false);
jtViewProduct.setAutoResizeMode(0);
	jtViewProduct.setOpaque(false);
	
	jtViewProduct.setShowGrid(true);
	jtViewProduct.setShowVerticalLines(true);
	jtViewProduct.setGridColor(Color.blue);
	
	
	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jspViewProduct=new JScrollPane(jtViewProduct,vertical,height);
	jspViewProduct.setPreferredSize(new Dimension(600, 400));
    
	panel0=new JPanel();
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	
	panel1=new JPanel();
	panel1.setLayout(new BorderLayout());
	panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Customer",0,1,new Font("Serif", Font.BOLD,15)));
	panel1.add(jspViewProduct,BorderLayout.CENTER);
	panel0.add(panel1);
	
	
	panel2=new JPanel();
	panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Instant Search",0,1,new Font("Serif", Font.BOLD,15)));
	panel2.add(lblProductName);
	panel2.add(txtProductName);
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
ViewProduct vm=new ViewProduct();
}
}