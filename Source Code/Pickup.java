package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;



public class Pickup extends JFrame implements ActionListener{
    
   JTable table;
   JButton back,submit;
   Choice typeofcar;
      JCheckBox available ,occupied;
    Pickup(){
   getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
 setTitle("Pickup Services"); 

JLabel text= new JLabel ("Pickup Services");
text.setBounds(310,10,200,20);
 text.setFont(new Font("Tahoma", Font.PLAIN, 25));
add(text);


JLabel lblbed= new JLabel ("Types of Car");
 lblbed.setFont(new Font("Tahoma", Font.PLAIN, 17));
lblbed.setBounds(50,60,100,20);
add(lblbed);

typeofcar = new Choice();
typeofcar.setBounds(160,60,150,20);
 typeofcar.setFont(new Font("Tahoma", Font.PLAIN, 14));
 typeofcar.setBackground(Color.WHITE);
add(typeofcar);

try{

conn conn= new conn();
ResultSet rs=conn.s.executeQuery("select * from driver");


while(rs.next()){

typeofcar.add(rs.getString("model"));
}
}
catch(Exception e)  {
                e.printStackTrace();
            }
            




            JLabel j1=new JLabel("Name");
            j1.setBounds(50,110,100,30);
            add(j1);
        
 
             JLabel j2=new JLabel("Age");
            j2.setBounds(150,110,100,30);
            add(j2);
            

            
             JLabel j3=new JLabel("Gender");
            j3.setBounds(250,110,100,30);
            add(j3);
            
      
            
              JLabel j4=new JLabel(" Company");
            j4.setBounds(350,110,100,30);
            add(j4);
            
            
            
              JLabel j5=new JLabel(" Model");
            j5.setBounds(450,110,100,30);
            add(j5);
            
//
//              JLabel j6=new JLabel(" Avaiable");
//            j4.setBounds(600,110,100,30);
//            add(j6);
//            
//            
//              JLabel j7=new JLabel(" Location");
//            j4.setBounds(650,110,100,30);
//            add(j7);
//            
            
            
          
            
            
           
             table = new JTable();
            table.setBounds(50,150,700,250);
            add(table);
             try{
            conn c = new conn ();
            ResultSet rs= c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e)  {
                e.printStackTrace();
            }
            
             
         submit = new JButton("Submit");
        submit.addActionListener(this);
	submit.setBounds(400, 400, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
	add(submit);
    
        
        
        back = new JButton("Back");
        back.addActionListener(this);
	back.setBounds(200, 400, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
	add(back);
    
        
        
        
             
         
    setBounds(240,170,800,500);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==submit){
        
            try{
                String query1="select * from driver where model ='"+typeofcar.getSelectedItem()+"'";
             
//                
                conn conn= new conn();
                ResultSet rs;
               
                rs=conn.s.executeQuery(query1);
             
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
                
            }
            
        
        }else{       
        setVisible(false);
            new Reception();
        }
          
    }
    
    
    public static void main(String []args){
    new Pickup();
    
    }
}
