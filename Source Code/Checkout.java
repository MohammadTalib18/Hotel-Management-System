
package hotel.management.system;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.util.Date;
   import java.awt.event.*;
public class Checkout extends JFrame  implements ActionListener {
    Choice ccustomer;
    JLabel lblrm,lbltime,lbltimeout;
    JButton checkout,back;
    Checkout(){
    getContentPane().setBackground(Color.WHITE);
        setLayout(null);
    
        
         setTitle("Checkout"); 
          JLabel text= new JLabel ("Checkout");
        text.setBounds(110,10,200,20);
         text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        JLabel lblid= new JLabel ("Customer id");
        lblid.setBounds(40,60,100,20);
         lblid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblid);
        
        ccustomer= new Choice();
        ccustomer.setBounds(150,60,130,25);
        ccustomer.setBackground(Color.WHITE);
        add(ccustomer);

  
        
        
           JLabel lblroom= new JLabel ("Room Number");
        lblroom.setBounds(40,100,100,20);
         lblroom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblroom);
        
         lblrm= new JLabel ();
        lblrm.setBounds(200,100,100,20);
         lblrm.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblrm);
        
        
        
        
        JLabel lblcheckin= new JLabel ("Check in time");
        lblcheckin.setBounds(40,140,100,20);
         lblcheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblcheckin);
        
         lbltime= new JLabel ();
        lbltime.setBounds(150,140,100,20);
         lbltime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lbltime);
        
        
        
        JLabel lblcheckout= new JLabel ("Check out time");
        lblcheckout.setBounds(40,180,100,20);
         lblcheckout.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblcheckout);
        
        
        Date date= new Date();
         lbltimeout= new JLabel (" "+date);
        lbltimeout.setBounds(150,180,120,25);
         lbltimeout.setFont(new Font("Tahoma", Font.BOLD, 11));
        add(lbltimeout);
        
        
        
        checkout = new JButton("Checkout");	
	checkout.setBounds(40, 270, 130, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
	add(checkout);

        
          back = new JButton("Back");	
	back.setBounds(200, 270, 130, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
	add(back);
        
              try{
    
            conn conn= new conn();
            ResultSet rs= conn.s.executeQuery("select * from customer02");
            while(rs.next()){
            ccustomer.add(rs.getString("number"));
            lblrm.setText(rs.getString("room"));
            lbltime.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){
            e.printStackTrace();

        }
        
        
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
            Image i3 = i1.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i3);
            JLabel image = new JLabel(i2);
            image.setBounds(350,55,400,300);
            add(image);
        
        
        
        
          setBounds(250,100,750,450);
              setVisible(true);
           
            
    }
    
     public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==checkout){
     
         String query1=" delete from customer02 where number='"+ccustomer.getSelectedItem()+"'";
         String query2= "update room01 availability='Available' where roomnumber='"+lblrm+"'";
         try{
         conn conn= new conn();
         conn.s.executeUpdate(query1);
         conn.s.executeUpdate(query2);
         JOptionPane.showMessageDialog(null, "  Checkout done");
              
         setVisible(false);
     new Reception();
         
         }catch(Exception e){
         e.printStackTrace();
         
         }
         
     
     }else{
     
     setVisible(false);
     new Reception();
     }
     
     
     
     }
    
    public static void main(String[]args){
    new Checkout();
    
    }
    
}
