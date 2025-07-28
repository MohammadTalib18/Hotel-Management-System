
package hotel.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;  

public class conn {
    Connection c;
    Statement s;
    
    conn(){
    
        
        
     try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:MYSQL://localhost:3306/hotelmanagementsystem","root","mohd@password"); 
            
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            e.printStackTrace();
        }  
    
    }
    
}
