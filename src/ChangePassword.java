import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;


class ChangePassword extends JInternalFrame
{
	
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	TitledBorder frame = new TitledBorder("General");
	JLabel lblUser;
	JTextField txtUser;
	JComboBox jcbUser;
	JPanel  innerScreen1_4;
	 JButton btnChange;
	 JButton btnCancel;
	  JPasswordField txtNewPassword1;
	  JPasswordField txtNewPassword2;
	  JPasswordField txtOldPassword;
	public ChangePassword()
	{
		super("Change Password",false,true,false,false);
		//setBounds((screen.width-400)/2,(screen.height-200)/2,400,160);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
		//-------------------------------------------Frame1------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		txtUser=new JTextField(15);
		
		lblUser=new JLabel("Username                ");
		jcbUser=new JComboBox();
		 innerScreen1_4=new JPanel();
		  innerScreen1_4.setLayout(new FlowLayout(0));
		JPanel screen1 = new JPanel();
                screen1.setLayout(new BoxLayout(screen1,BoxLayout.Y_AXIS));
                
		JPanel innerScreen1_1 = new JPanel();
		JLabel lblOldPassword = new JLabel("Existing Password  ");
               txtOldPassword = new  JPasswordField ("",15);
                //txtOldPassword.
                
                JPanel innerScreen1_2 = new JPanel();
				innerScreen1_2.setLayout(new FlowLayout(0));
                JLabel lblNewPassword1 = new JLabel("New Password        ");
               txtNewPassword1 = new  JPasswordField ("",15);
                
                JPanel innerScreen1_3 = new JPanel();
                JLabel lblNewPassword2 = new JLabel("Re-Enter Password");
                txtNewPassword2 = new  JPasswordField ("",15);
                
				//innerScreen1_1.setLayout(new BoxLayout(innerScreen1_1,BoxLayout.Y_AXIS));
			
                innerScreen1_1.add(lblOldPassword);
                innerScreen1_1.add(txtOldPassword);
                innerScreen1_2.add(lblNewPassword1);
                innerScreen1_2.add(txtNewPassword1);
                innerScreen1_3.add(lblNewPassword2);
                innerScreen1_3.add(txtNewPassword2);
                innerScreen1_4.add(lblUser);
                innerScreen1_4.add(jcbUser);
				
				screen1.add(innerScreen1_4);
                screen1.add(innerScreen1_1);
                screen1.add(innerScreen1_2);
                screen1.add(innerScreen1_3);
                
                JPanel screen2 = new JPanel();
                screen2.setLayout(new GridLayout(1,1));
                
                JPanel innerScreen2_1 = new JPanel();
             btnChange = new JButton("Change Password");
		//btnChange.setActionCommand("ChangePassword");
        //        btnChange.addActionListener(this);
		 btnCancel = new JButton("   Cancel   ");
		//btnCancel.setActionCommand("Cancel");
		//btnCancel.addActionListener(this);
                
                innerScreen2_1.add(btnChange);
                innerScreen2_1.add(btnCancel);
                screen2.add(innerScreen2_1);
                
	
		
		getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
		//getContentPane().add(innerScreen1_1,BorderLayout.NORTH);
		getContentPane().add(screen1);
                getContentPane().add(screen2);
		setVisible(true);
		pack();
		setLocation(350,30);
		
	}
	
	
	
}
