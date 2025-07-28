
    package hotel.management.system;
    import java.awt.*;
    import java.awt.event.*;
    import java.sql.*;	
    import javax.swing.*;
    public class UpdateRoom extends JFrame implements ActionListener {
        Choice ccustomer;
        JTextField tfroom,tfavailabie,tfstatus,tfpaid,tfpending;
        JButton update,check,back;
        UpdateRoom(){
              getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setTitle("Update Room");
    
        JLabel text= new JLabel ("Update Room Status");
        text.setBounds(110,10,200,20);
         text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        JLabel lblid= new JLabel ("Customer id");
        lblid.setBounds(20,60,100,20);
         lblid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblid);



        ccustomer= new Choice();
        ccustomer.setBounds(150,60,130,25);
        ccustomer.setBackground(Color.WHITE);
        add(ccustomer);

        try{
    
            conn conn= new conn();
            ResultSet rs= conn.s.executeQuery("select * from customer02");
            while(rs.next()){
            ccustomer.add(rs.getString("number"));
            }

    
        }catch(Exception e){
            e.printStackTrace();

        }



        JLabel lblroom= new JLabel ("Room");
        lblroom.setBounds(20,100,100,20);
         lblroom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblroom);


        tfroom=new JTextField();
        tfroom.setBounds(150,100,120,20);
         tfroom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfroom);



        JLabel lblname= new JLabel ("Availability");
        lblname.setBounds(20,140,100,20);
         lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblname);


        tfavailabie=new JTextField();
        tfavailabie.setBounds(150,140,120,20);
         tfavailabie.setFont(new Font("Tahoma", Font.PLAIN, 14));
                add(tfavailabie);


        JLabel lblcheckin= new JLabel ("Cleaning Status");
        lblcheckin.setBounds(20,180,100,20);
        lblcheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblcheckin);


        tfstatus =new JTextField();
        tfstatus.setBounds(150,180,120,20);
        tfstatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfstatus);


        update = new JButton("Update");	
	update.setBounds(100, 320, 130, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
	add(update);

        
          check = new JButton("Check");	
	check.setBounds(300, 320, 130, 30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
	add(check);


          back = new JButton("Back");	
	back.setBounds(500, 320, 130, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
	add(back);

        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
         Image i2=i1.getImage().getScaledInstance(350,260, Image.SCALE_DEFAULT);
         ImageIcon i3= new ImageIcon(i2);
            JLabel image= new JLabel(i3);
             image.setBounds(380,30,350,260);
                add(image);
        
           setBounds(250,100,800,500);
              setVisible(true);
           
        
        
    }
     public void actionPerformed(ActionEvent ae){
     if(ae.getSource()==check){
           String id= ccustomer.getSelectedItem();
           String query= "select * from customer02 where number='"+id+"'";
           try{
           conn conn =new conn();
           
           ResultSet rs= conn.s.executeQuery(query);
           while(rs.next()){
           
           tfroom.setText(rs.getString("room"));
         
           }
           
           ResultSet rs2= conn.s.executeQuery("select * from room01 where roomnumber='"+tfroom.getText()+"'");
           
           while(rs2.next()){
           tfavailabie.setText(rs2.getString("availability"));
                 tfstatus.setText(rs2.getString("cleaning_status"));
            }
           }catch(Exception e){
           e.printStackTrace();
           }
           
     }else if(ae.getSource()==update){
         
         String number =ccustomer.getSelectedItem();
         String room= tfroom.getText();
          String available= tfavailabie.getText(); 
          String status= tfstatus.getText();
           String deposit= tfpaid.getText();
           try{
           
               conn conn=new conn ();
               conn.s.executeUpdate("update room01 set availability ='"+available+"',cleaning_status='"+status+"', where roomnumber='"+room+"'");
               JOptionPane.showMessageDialog(null, "  Data Updated  Successfully");
           }catch(Exception e){
                 e.printStackTrace();
           }
          
     }else if(ae.getSource()==back) {
         setVisible(false);
         new Reception();
     
     
     }
  
     
         
         
     }
    
        public static void main (String []args){

        new UpdateRoom();
        }

    }
