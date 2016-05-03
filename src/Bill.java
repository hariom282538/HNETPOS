import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;
import javax.swing.JComboBox.*;

public class Bill extends JInternalFrame {

JPanel panel0;
JPanel panel1;
JPanel panel2;
JPanel panel2_1;
JPanel panel2_2;
JPanel panel3;
JPanel panel4;
//JPanel panel5;
JPanel panel5;
JPanel panel6;
JPanel panel7;
JPanel panel8;
JPanel panel9;
JPanel panel10;

ButtonGroup bgroup;
Border border;
JLabel lblFirstName;
JLabel lblLastName;
JLabel lblCompany;

JComboBox jcbFirstName;
JComboBox jcbLastName;
JComboBox jcbCompany;
JComboBox jcbSaleId;
JComboBox jcbProductName;

JLabel lblStatus;


JLabel lblPending; 
JLabel lblDate;
JLabel lblCurrentDate;
JLabel lblOrderId;
JLabel lblProductName;


JButton btnGenerate;

JButton btnCancel;

JLabel lblComplaint;
JTextArea txtaDescription;
JScrollPane jspDescription;


JRadioButton jrbOrder;
JRadioButton jrbProduct;




public Bill(){
super("Bill",false,true,false,false);


panel0=new JPanel();
panel1=new JPanel();
panel2=new JPanel();
panel2_1=new JPanel();
panel2_2=new JPanel();
panel3=new JPanel();
panel4=new JPanel();
panel5=new JPanel();
//panel5=new JPanel();
panel6=new JPanel();
panel7=new JPanel();
panel8=new JPanel();
panel9=new JPanel();
panel10=new JPanel();

btnGenerate=new JButton("Generate");

btnCancel=new JButton("Cancel");

    
	jrbOrder=new JRadioButton("Sale");
	jrbProduct=new JRadioButton("Product");
	bgroup=new ButtonGroup();
	bgroup.add(jrbOrder);
	bgroup.add(jrbProduct);
	jrbOrder.setSelected(true);
	
	jcbSaleId=new JComboBox();
	jcbProductName=new JComboBox();
	//jcbSaleId.addItem("Select");
//	jcbProductName.addItem("Select");
	//jcbSaleId.setEnabled(false);
	jcbProductName.setEnabled(false);
	
	//panel2_1.add(jrbOrder);
	//panel2_1.add(jrbProduct);
	
	jcbFirstName=new JComboBox();
    jcbLastName=new JComboBox();
    jcbCompany=new JComboBox();
	
	jcbFirstName.addItem("Select");
		jcbLastName.addItem("Select");
			jcbCompany.addItem("Select");
	lblPending =new JLabel("Pending");
	border= LineBorder.createGrayLineBorder();
	lblPending.setBorder(border);

	jcbSaleId.addItem("Select");
	
lblOrderId =new JLabel("Sale Id");
lblProductName =new JLabel("             Product Name");
panel2_2.add(lblOrderId);
panel2_2.add(jcbSaleId);
//panel2_2.add(lblProductName);
//panel2_2.add(jcbProductName);

panel2.add(panel2_1);
panel2.add(panel2_2);


	txtaDescription=new JTextArea(3,20);
		jspDescription=new JScrollPane(txtaDescription,22,30);
	lblCurrentDate=new JLabel("D");
lblCurrentDate.setBorder(border);

panel0.setLayout(new BoxLayout(panel0,BoxLayout.Y_AXIS));
panel1.setLayout(new FlowLayout(0));
panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
panel10.setLayout(new BoxLayout(panel10,BoxLayout.Y_AXIS));
panel2_1.setLayout(new FlowLayout(0));
panel2_2.setLayout(new FlowLayout());
panel3.setLayout(new GridLayout(2,1));
panel4.setLayout(new FlowLayout(0));
panel9.setLayout(new FlowLayout(0));
panel5.setLayout(new FlowLayout(0));
//panel5.setLayout(new GridLayout(2,1));
panel6.setLayout(new FlowLayout(0));
panel7.setLayout(new FlowLayout(0));
panel8.setLayout(new FlowLayout(4));

lblFirstName=new JLabel("                      First Name :");
lblLastName=new JLabel("Last Name :");

lblCompany=new JLabel("Company :  ");
lblComplaint=new JLabel("Complaint");
lblStatus=new JLabel("Status:");
lblDate=new JLabel("                   Date:");


panel1.add(lblCompany);
panel1.add(jcbCompany);

panel1.add(lblFirstName);
panel1.add(jcbFirstName);

panel9.add(lblLastName);
panel9.add(jcbLastName);
panel10.add(panel1);
panel10.add(panel9);
//panel1.setPreferredSize(new Dimension(900,500));

panel4.add(lblComplaint);
panel4.add(jspDescription);
panel5.add(lblStatus);
panel5.add(lblPending);
panel5.add(lblDate);
panel5.add(lblCurrentDate);
//panel5.setSize(100,100);
panel8.add(btnGenerate);

panel8.add(btnCancel);


panel0.setBorder(new TitledBorder(new LineBorder(Color.blue,2),"Bill ",0,1,new Font("Serif", Font.BOLD,15)));
//panel1.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Name ",0,1,new Font("Serif", Font.BOLD,15)));
panel10.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Name ",0,1,new Font("Serif", Font.BOLD,15)));
panel3.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Details ",0,1,new Font("Serif", Font.BOLD,15)));
panel2.setBorder(new TitledBorder(new LineBorder(Color.blue,1),"Select Sale Id",0,1,new Font("Serif", Font.BOLD,15)));

panel0.add(panel10);
panel0.add(panel2);

panel3.add(panel4);
panel3.add(panel5);
//panel0.add(panel3);
panel0.add(panel8);


//Container c=getContentPane();
add(panel0);





setVisible(true);
setSize(500,300);
setLocation(350,30);
//pack();
}


}