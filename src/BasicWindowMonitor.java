import java.awt.event.*;
import java.awt.Window;


public class BasicWindowMonitor extends WindowAdapter {
Connectionn connect;
public void windowClosing(WindowEvent e) {
Window w = e.getWindow();
w.setVisible(false);
connect=new Connectionn();
try{
connect.startConnection();

String strQuery="Delete from instance";
connect.executeQuery("update",strQuery);

strQuery="insert into instance values('0')";

connect.executeQuery("update",strQuery);
strQuery="delete from modifyf";
connect.executeQuery("update",strQuery);
strQuery="insert into modifyf values(0,0,0,0)";

connect.executeQuery("update",strQuery);
connect.closeConnection();
}

catch(Exception e1){
System.out.print(e1);
}


w.dispose();
//System.out.println("let d hackin begin");
System.exit(0);
}
}