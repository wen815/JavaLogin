package dao;
import java.sql.*;
import op.Op;

public class Dao {
   
    public static Op check(String name,String password){
        int i=0;
        Op op=new Op();
        String driverName="com.mysql.jdbc.Driver";
   String dbURL="jdbc:mysql://localhost:3306/db_library";
String USER="root";
String PASS="root";
try{
     Class.forName(driverName); 
   Connection conn=DriverManager.getConnection(dbURL,USER,PASS);
   Statement stmt=conn.createStatement();
   String sql="select *  from tb_op where name='" + name
				+ "' and password='" + password + "'and admin=1";
   ResultSet rs=stmt.executeQuery(sql);
   while(rs.next()){
       String names=rs.getString(2);
      op.setId(rs.getString("id"));
       op.setName(rs.getString("name"));
        op.setGrade(rs.getString("admin"));
         op.setPassword(rs.getString("password"));
         if(names!=null){
             i=1;
         }
   }  
}
catch(Exception e){
       e.printStackTrace();  
}
return op;
}
}