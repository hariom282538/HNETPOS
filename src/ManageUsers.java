import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class ManageUsers extends JInternalFrame {

JTabbedPane jtbManageUsers;


AddUser addUser;
DeleteUser  deleteUser;


public ManageUsers(){
super("ManageUsers",false,true,false,false);

addUser=new AddUser();
deleteUser=new DeleteUser();




setLayout(new BorderLayout());

jtbManageUsers=new JTabbedPane(JTabbedPane.TOP);


jtbManageUsers.addTab(" Add User",addUser);
jtbManageUsers.addTab("Delete User",deleteUser);


add(jtbManageUsers,BorderLayout.CENTER);
pack();

setVisible(true);
setLocation(350,30);

}

}