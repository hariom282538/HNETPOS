import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import javax.swing.border.*;
import javax.swing.UIManager.*;

public class MyMenu extends JFrame {

JPanel panel0;
JPanel panel1;
JPanel panel2;
JPanel panel3;
PanelBg bg;


JButton btnCustomer;
JButton btnEmployee;
JButton btnManufacturer;
JButton btnSale;
JButton btnPayment;
JButton btnComplaint;
JButton btnProduct;
JButton btnStock;
JButton btnOrder;
JButton btnSearch;
JButton btnView;
JButton btnReport;

JLabel lblBlank;
JLabel lblUser;
JLabel lblUserName;
JLabel lblTimeField;


JMenuBar menubar;

JMenu mnuFile;
JMenu mnuOptions;
JMenu mnuSettings;
JMenu mnuHelp;
JMenu mnuUser;
JMenu mnuAdmin;


JMenu mnuLookAndFeel;



Dimension Dim;

Cursor cursor;
GetImage getI;
Dimension screen;

JMenuItem itemExit;
JMenuItem itemAbout;
JMenuItem itemMetal;
JMenuItem itemMotif;
JMenuItem itemWindows;
JMenuItem itemNimbus;
JMenuItem itemLiquid;
JMenuItem itemSystem;
JMenuItem itemChangePassword;
JMenuItem itemChangePassword2;
JMenuItem itemManageUsers;
JMenuItem itemBill;
JMenuItem itemReorder;
JMenuItem itemLogout;
JMenuItem itemLogout2;

JTextField _timeField; 
JLabel lblLoginTime; 
JLabel lblTime; 

public MyMenu(){
 setTitle("HNET POS HOME ");

screen = Toolkit.getDefaultToolkit().getScreenSize();

getI=new GetImage();
Dim=new Dimension(160,35);
cursor=new Cursor(12);


lblBlank=new JLabel("Blank");
lblUser=new JLabel(" 		                                     	 User :");
lblUserName=new JLabel("");
lblTimeField=new JLabel("    					    		                                     	 Clock: ");
lblTimeField.setFont(new java.awt.Font("Sans-Serif", Font.BOLD, 20));

lblTime=new JLabel("Login Time :");
lblTime.setFont(new java.awt.Font("Sans-Serif", Font.BOLD, 20));
lblLoginTime=new JLabel("");
lblLoginTime.setFont(new java.awt.Font("Sans-Serif", Font.BOLD, 20));

btnCustomer =new JButton("Customer");
btnEmployee =new JButton("Employee");
btnManufacturer =new JButton("Manufacturer");
btnSale =new JButton("Sale");
btnPayment =new JButton("Payment");
btnComplaint =new JButton("Complaint");
btnProduct =new JButton("Product ");
btnStock =new JButton("Stock");
btnOrder=new JButton("Order");
btnSearch =new JButton("Search");
btnView =new JButton("Search ");
btnReport =new JButton("Report");

menubar=new JMenuBar();

mnuFile =new JMenu("File");
mnuOptions=new JMenu("Options");
mnuSettings=new JMenu("Settings");
mnuHelp=new JMenu("Help");
mnuUser=new JMenu("User");
mnuAdmin=new JMenu("Admin");


mnuLookAndFeel=new JMenu("LookAndFeel");



itemExit=new JMenuItem("Exit");
itemExit.setActionCommand("itemExit");
itemAbout=new JMenuItem("About");
itemMetal=new JMenuItem("Metal");
itemMotif=new JMenuItem("Motif");
itemWindows=new JMenuItem("Windows");
itemNimbus=new JMenuItem("Nimbus");
itemLiquid=new JMenuItem("Liquid");
itemSystem=new JMenuItem("System");
itemChangePassword=new JMenuItem("Change Password");
itemChangePassword2=new JMenuItem("Change Password");
itemManageUsers=new JMenuItem("Manage Users");
itemBill=new JMenuItem("Bill");
//itemBill.setArmed(true);
itemBill.setEnabled(true);

itemReorder=new JMenuItem("Reorder Level");
//itemBill.setArmed(true);
itemReorder.setEnabled(true);

//JSeparator separator=new JSeparator(); 
itemLogout=new JMenuItem("Logout");
itemLogout2=new JMenuItem("Logout");

mnuFile.add(itemExit);
mnuHelp.add(itemAbout);
mnuLookAndFeel.add(itemLiquid);
mnuLookAndFeel.addSeparator();
mnuLookAndFeel.add(itemMetal);
mnuLookAndFeel.addSeparator();
mnuLookAndFeel.add(itemMotif);
mnuLookAndFeel.addSeparator();
mnuLookAndFeel.add(itemNimbus);
mnuLookAndFeel.addSeparator();
mnuLookAndFeel.add(itemSystem);
mnuLookAndFeel.addSeparator();
mnuLookAndFeel.add(itemWindows);
//mnuOptions.add(itemChangePassword);
//mnuOptions.add(new JSeparator());
//mnuOptions.add(itemManageUsers);
//mnuOptions.add(new JSeparator());
mnuOptions.add(itemBill);
mnuOptions.add(new JSeparator());
mnuOptions.add(itemReorder);


//mnuHelp.setEnabled(false);
//mnuLookAndFeel.addSeparator();

mnuSettings.add(mnuLookAndFeel);

//mnuHelp.add(item);

mnuAdmin.add(itemChangePassword);
mnuAdmin.add(new JSeparator());
mnuAdmin.add(itemManageUsers);
mnuAdmin.add(new JSeparator());
mnuAdmin.add(itemLogout);

mnuUser.add(itemChangePassword2);
mnuUser.add(new JSeparator());
mnuUser.add(itemLogout2);

menubar.add(mnuFile);
//menubar.addSeparator();
menubar.add(mnuOptions);
menubar.add(mnuSettings);
menubar.add(mnuUser);
menubar.add(mnuAdmin);


menubar.add(mnuHelp);

panel0=new JPanel();
panel1=new JPanel();
panel2=new JPanel();
panel3=new JPanel();

//------------------------------------------------
_timeField = new JTextField(5);
_timeField.setEditable(false);
 _timeField.setFont(new Font("sansserif", Font.PLAIN, 20));
 _timeField.setBackground(new Color(0,153,204));

//------------------------------------------------

setLayout(new BorderLayout());

panel0.setBorder(new TitledBorder(new EtchedBorder(),"MAIN ",2,2,new Font("Serif", Font.BOLD,20),Color.cyan));
panel2.setBorder(new TitledBorder(new EtchedBorder(),"panel 2 ",2,2,new Font("Serif", Font.BOLD,20),Color.black));

panel0.setPreferredSize(new Dimension(200,900));
panel0.setLayout(new FlowLayout(0,0,5));
panel0.setBackground(new Color(0,153,204));
panel1.setBackground(new Color(0,153,204));
panel1.setBorder(new EtchedBorder());

Border border= LineBorder.createGrayLineBorder();
lblUserName.setBorder(border);
lblLoginTime.setBorder(border);
panel1.setLayout(new FlowLayout(0));

panel1.add(lblTime);
panel1.add(lblLoginTime);
panel1.add(lblUser);
panel1.add(lblUserName);
panel1.add(lblTimeField);
panel1.add(_timeField);


btnCustomer.setRolloverIcon(new ImageIcon(getI.getImage("i/btn.bmp")));
panel1.setPreferredSize(new Dimension(130,70));

btnCustomer.setPreferredSize(Dim);
btnEmployee.setPreferredSize(Dim);
btnManufacturer.setPreferredSize(Dim);
btnSale.setPreferredSize(Dim);
btnPayment.setPreferredSize(Dim);
btnComplaint.setPreferredSize(Dim);
btnProduct.setPreferredSize(Dim);
btnStock.setPreferredSize(Dim);
btnOrder.setPreferredSize(Dim);
btnSearch.setPreferredSize(Dim);
btnView.setPreferredSize(Dim);
btnReport.setPreferredSize(Dim);

btnCustomer.setCursor(cursor);
btnEmployee.setCursor(cursor);
btnManufacturer.setCursor(cursor);
btnSale.setCursor(cursor);
btnPayment.setCursor(cursor);
btnComplaint.setCursor(cursor);
btnProduct.setCursor(cursor);
btnStock.setCursor(cursor);
btnOrder.setCursor(cursor);
btnSearch.setCursor(cursor);
btnView.setCursor(cursor);
btnReport.setCursor(cursor);

panel0.add(lblBlank);

panel0.add(btnManufacturer);
panel0.add(btnProduct);
panel0.add(btnCustomer);
panel0.add(btnEmployee);
panel0.add(btnOrder);
panel0.add(btnStock);
panel0.add(btnSale);
panel0.add(btnPayment);
panel0.add(btnComplaint);
panel0.add(btnView);
//panel0.add(btnSearch);
panel0.add(btnReport);
//panel0.add(_timeField);

bg=new PanelBg();

setJMenuBar(menubar);

lblBlank.setVisible(false);

add(panel0,BorderLayout.WEST);
add(panel1,BorderLayout.SOUTH);
//bg.panelBgImg.setBorder(new TitledBorder(new EtchedBorder(),"panel BG ",2,2,new Font("Serif", Font.BOLD,20),Color.black));

add(bg.panelBgImg,BorderLayout.CENTER);
addWindowListener(new BasicWindowMonitor());

//setIconImage(new ImageIcon(getI.getImage("i/k.jpg")).getImage());
setIconImage(new ImageIcon(getI.getImage("i/icone.jpg")).getImage());
setSize(screen.width,screen.height);
getLayeredPane().setOpaque(true);

setVisible(true);
}

    public static void main(String[] args) {
        new MyMenu();
    }

}