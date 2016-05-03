import java.sql.*;


class TableCreator{

Connection con;
Statement stmt;
ResultSet rs;
String strQuery;

ConnectionnN connect;
Connectionn connect2;
public TableCreator(){

connect=new ConnectionnN();
connect2=new Connectionn();
 try{
 
 connect.startConnection();
 
 
 
 strQuery="create user usr identified by usr Default Tablespace   USERS  Temporary Tablespace TEMP Quota UNLIMITED ON USERS ";
 connect.executeQuery("update",strQuery);
strQuery="GRANT CONNECT,RESOURCE TO usr ";
 connect.executeQuery("update",strQuery);
  connect.closeConnection();
 
connect2.startConnection();
 
 strQuery="create table login(username varchar2(20),password varchar2(20))";
 connect2.executeQuery("update",strQuery);
	
  strQuery="insert into login values('1','1')";
 connect2.executeQuery("update",strQuery);
 
  strQuery="create table instance(value number)";
 connect2.executeQuery("update",strQuery);
 
  strQuery="insert into instance values(0)";
 connect2.executeQuery("update",strQuery);
 
connect2.closeConnection();

}

catch(Exception e1){
System.out.print(e1);
}



}

public static void main(String[] args){
TableCreator t=new TableCreator();

}

}