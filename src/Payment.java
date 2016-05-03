import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class Payment extends JInternalFrame
{

JPanel panel0;
JPanel panel1;
JPanel panel2;
JPanel panel3;
JPanel panel4;
JPanel panel5;
JPanel panel6;
JPanel panel7;
JPanel panel8;


JLabel lblFirstName;
JLabel lblLastName;
JLabel lblCompany;

JComboBox jcbFirstName;
JComboBox jcbLastName;
JComboBox jcbCompany;

JRadioButton jrbCheque,jrbCash;
ButtonGroup bgroup;
JLabel lblCheque;
JTextField txtCheque;
JLabel lblChequeStatus;
JComboBox jcbChequeStatus;

JLabel lblPayment;
JTextField txtPayment;

JButton btnUpdate,btnModify,btnDelete,btnCancel;

JTable jtViewPayment;
DefaultTableModel jtModel;
final String[] header={"Payment id","Order id","First Name","LastName","Company","Total Amount","Paid","Balance","Payment Type","Cheque no","Cheque Status"};
 Object[][] data=new Object[0][11];
JScrollPane jspViewPayment;
Payment()
{
super("Payment",false,true,false,false);


jtModel = new DefaultTableModel(data,header);
jtViewPayment=new JTable(jtModel);
	jtViewPayment.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jtViewPayment.setColumnSelectionAllowed(false);
	jtViewPayment.setShowVerticalLines(false);
	jtViewPayment.setShowGrid(false);
jtViewPayment.setAutoResizeMode(3);
	jtViewPayment.setOpaque(false);
	int vertical=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	int height=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
	jspViewPayment=new JScrollPane(jtViewPayment,vertical,height);
	jspViewPayment.setPreferredSize(new Dimension(100, 200));
	
	jcbCompany=new JComboBox();
	jcbCompany.addItem("All");
	jcbFirstName=new JComboBox();
    jcbFirstName.addItem("Select");
	jcbLastName=new JComboBox();
    jcbLastName.addItem("Select");
	
	jrbCheque=new JRadioButton("Cheque");
	jrbCash=new JRadioButton("Cash");
	jrbCash.setSelected(true);
	bgroup=new ButtonGroup();
	bgroup.add(jrbCash);
	
	bgroup.add(jrbCheque);
	lblCheque=new JLabel("Cheque no");
    txtCheque=new JTextField(15); 
	lblChequeStatus=new JLabel("Status");
	jcbChequeStatus=new JComboBox();
	jcbChequeStatus.addItem("Pending");
	jcbChequeStatus.addItem("Complete");
	
lblFirstName=new JLabel("First Name :");
lblLastName=new JLabel("Last Name :");

lblCompany=new JLabel("Company :");
	lblPayment=new JLabel("Amount");
	txtPayment=new JTextField(10);
	btnUpdate=new JButton("Update");
	btnModify=new JButton("Modify");

	btnCancel=new JButton("Cancel");
	panel0=new JPanel();
	
	panel0.setLayout(new BoxLayout(panel0, BoxLayout.Y_AXIS));
	
	panel1=new JPanel();
	panel1.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Customer",0,1,new Font("Serif", Font.BOLD,15)));
	panel1.setLayout(new FlowLayout());
	
     panel1.add(lblCompany);
     panel1.add(jcbCompany);

     panel1.add(lblFirstName);
     panel1.add(jcbFirstName);

     panel1.add(lblLastName);
     panel1.add(jcbLastName);
	// panel0.add(panel1);
	
	panel2=new JPanel();
	panel2.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Payment Detail",0,1,new Font("Serif", Font.BOLD,15)));
	panel2.setLayout(new BorderLayout());
	panel2.add(jspViewPayment,BorderLayout.CENTER);
	panel0.add(panel2);
	
	panel3=new JPanel();
	panel3.setBorder(new TitledBorder (new LineBorder (Color.blue, 2),"Payment Mode",0,1,new Font("Serif", Font.BOLD,15)));
	//panel3.setLayout(new GridLayout(2,1));
	
	panel4=new JPanel();
	panel4.add(jrbCash);
	panel4.add(jrbCheque);
	panel5=new JPanel();
	panel5.add(lblCheque);
	panel5.add(txtCheque);
    panel5.add(lblChequeStatus);
    panel5.add(jcbChequeStatus);	
	
	//panel3.add(panel4);
	//panel3.add(panel5);
	//panel0.add(panel3);
	panel6=new JPanel();
	panel6.add(lblPayment);
	panel6.add(txtPayment);
	//panel0.add(panel6);
	panel7=new JPanel();
	panel7.setLayout(new FlowLayout(4));
	panel7.add(btnUpdate);
	//panel7.add(btnModify);
	panel7.add(btnCancel);
	panel0.add(panel7);
	Container c=getContentPane();
	c.add(panel0);
	setVisible(true);
	setLocation(350,30);
	setSize(400,400);
	}

public static void main(String a[])
{
Payment p=new Payment();

}


}