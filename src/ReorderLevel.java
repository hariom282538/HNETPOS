import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;
import javax.swing.JComboBox.*;

public class ReorderLevel extends JInternalFrame {

JPanel panel0;
JPanel panel1;
JPanel panel2;
JPanel panel3;
JPanel panel4;


ButtonGroup bgroup;
Border border;
JLabel lblManufacturer;
JLabel lblLastName;
JLabel lblProduct;

JComboBox jcbManufacturer;
JComboBox jcbProduct;
JComboBox jcbCompany;
JComboBox jcbSaleId;
JComboBox jcbProductName;

JLabel lblQuantity;


JLabel lblPending; 
JLabel lblDate;
JLabel lblCurrentDate;
JLabel lblOrderId;
JLabel lblProductName;


JButton btnSet;

JButton btnClose;



JSpinner jsQuantity;


public ReorderLevel(){
super("ReorderLevel",false,true,false,false);


panel0=new JPanel();
panel1=new JPanel();
panel2=new JPanel();

panel3=new JPanel();
panel4=new JPanel();



jsQuantity=new JSpinner(new SpinnerNumberModel(1,1,1000,50));

btnSet=new JButton("Set     ");

btnClose=new JButton("Close  ");

    
	lblQuantity=new JLabel("Quantity");


	
	jcbManufacturer=new JComboBox();
    jcbProduct=new JComboBox();

	
	jcbManufacturer.addItem("Select");
		jcbProduct.addItem("Select");
			
	
	











panel0.setLayout(new BoxLayout(panel0,BoxLayout.Y_AXIS));
panel1.setLayout(new FlowLayout(0));
panel2.setLayout(new FlowLayout());



panel3.setLayout(new BoxLayout(panel3,BoxLayout.Y_AXIS));
panel4.setLayout(new FlowLayout());



lblManufacturer=new JLabel("Manufacturer :");


lblProduct=new JLabel("          Product :  ");


panel1.add(lblManufacturer);
panel1.add(jcbManufacturer);
panel1.add(lblProduct);
panel1.add(jcbProduct);



panel2.add(lblQuantity);
panel2.add(jsQuantity);
panel3.add(panel1);
panel3.add(panel2);


panel4.add(btnSet);
panel4.add(btnClose);





panel0.setBorder(new TitledBorder(new LineBorder(Color.blue,2),"ReorderLevel ",0,1,new Font("Serif", Font.BOLD,15)));

panel3.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Select Product ",0,1,new Font("Serif", Font.BOLD,15)));


panel0.add(panel3);
panel0.add(panel4);

add(panel0);

setVisible(true);
setSize(400,300);
setLocation(350,30);

}


}