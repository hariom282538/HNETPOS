import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
//import java.sql.*;


class About extends JInternalFrame 
{
	
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	TitledBorder frame = new TitledBorder("General");
	JButton cmdOk;
	public About()
	{
		super("About",false,true,false,false);
		setBounds((screen.width-400)/2,(screen.height-315)/2,500,275);
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
		//-------------------------------------------Frame1------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		JPanel screen1 = new JPanel();
                screen1.setBackground(Color.WHITE);
				screen1.setLayout(new BoxLayout(screen1, BoxLayout.Y_AXIS));
		JPanel innerScreen1_1 = new JPanel();
		innerScreen1_1.setBackground(Color.WHITE);
		ImageIcon icon = new ImageIcon("i/seeranabout2.jpg");
		JLabel label = new JLabel(icon);
		innerScreen1_1.add(label);
		JPanel innerScreen1_2 = new JPanel();
                innerScreen1_2.setBackground(Color.WHITE);
		innerScreen1_2.setLayout(new GridLayout(4,1));
		JLabel lbl1_ = new JLabel("Management System by N&N Inc.",JLabel.CENTER);
		lbl1_.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lbl2_ = new JLabel("Version  1.0",JLabel.CENTER);
		lbl2_.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel lbl5_ = new JLabel("HNET POS",JLabel.CENTER);
		lbl5_.setFont(new Font("Serif", Font.BOLD, 18));
		JLabel lbl4_ = new JLabel("      Warning: Unauthorized reproduction or distribution of this software is illegal      ",JLabel.CENTER);
		lbl4_.setFont(new Font("Serif", Font.BOLD, 15));
		JLabel lbl3_ = new JLabel("--------------------------------------------------------------------------------",JLabel.CENTER);
		JLabel lbl6_ = new JLabel("--------------------------------------------------------------------------------",JLabel.CENTER);
		cmdOk = new JButton("   Ok   ");
		Dimension dim=new Dimension(100,30);
		cmdOk.setPreferredSize(dim);
		//cmdOk.setActionCommand("Ok");
		//cmdOk.addActionListener(this);
	
		lbl1_.setBackground(Color.white);
		lbl2_.setBackground(Color.white);
		lbl3_.setBackground(Color.white);
		lbl4_.setBackground(Color.white);
		//innerScreen1_2.add(lbl1_);
		innerScreen1_2.add(lbl5_);
		//innerScreen1_2.add(lbl6_);
		innerScreen1_2.add(lbl2_);
		innerScreen1_2.add(lbl3_);
		innerScreen1_2.add(lbl4_);
	
                JPanel innerScreen1_4 = new JPanel();
				
		innerScreen1_4.add(cmdOk);
		screen1.setBackground(Color.white);
		innerScreen1_4.setBackground(Color.white);
		screen1.add(innerScreen1_2);
		screen1.add(innerScreen1_4);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		getContentPane().add(innerScreen1_1);
		getContentPane().add(screen1);
		//getContentPane().add(cmdOk);
		getRootPane().setDefaultButton(cmdOk);
		setVisible(true);
		pack();
		setLocation(350,30);

	}
	
	
	
}
