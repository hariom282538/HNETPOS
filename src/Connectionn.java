import java.sql.*;
import java.io.*;

class Connectionn{

Connection con;
Statement st;
ResultSet rs;
ResultSetMetaData rsmd;


void startConnection(){
try{

Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","");

st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
System.out.println("Connected");
}
catch(SQLException e)
{System.out.println("C 3:"+e);

}

catch(Exception e)
{System.out.println("C :"+e);

}
}


void executeQuery(String type,String query){
try{

if(type=="update")
	st.executeUpdate(query);
else
	rs=st.executeQuery(query);
	
	}
	
catch(Exception e)
{System.out.println("C :"+e);
}
}


void  closeConnection(){
try{

st.close();
con.close();
System.out.println("DISConnected");
}

catch(Exception e)
{System.out.println("D :"+e);}
}


}