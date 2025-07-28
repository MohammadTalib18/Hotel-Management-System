
    package hotel.management.system;
    import java.awt.*;
    import java.awt.event.*;
    import java.sql.*;	
    import javax.swing.*;
    public class UpdateCheck extends JFrame implements ActionListener {
        Choice ccustomer;
        JTextField tfroom,tfname,tfcheckin,tfpaid,tfpending;
        JButton update,check,back;
        UpdateCheck(){
              getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setTitle("Update Check");
    
        JLabel text= new JLabel ("Update Status");
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



        JLabel lblname= new JLabel ("Name");
        lblname.setBounds(20,140,100,20);
         lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblname);


        tfname=new JTextField();
        tfname.setBounds(150,140,120,20);
         tfname.setFont(new Font("Tahoma", Font.PLAIN, 14));
                add(tfname);


        JLabel lblcheckin= new JLabel ("Checkin Time");
        lblcheckin.setBounds(20,180,100,20);
        lblcheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblcheckin);


        tfcheckin =new JTextField();
        tfcheckin.setBounds(150,180,120,20);
        tfcheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfcheckin);


        JLabel lblpaid= new JLabel ("Amount Paid");
        lblpaid.setBounds(20,220,100,20);
        lblpaid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblpaid);


        tfpaid=new JTextField();
        tfpaid.setBounds(150,220,120,20);
        tfpaid.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfpaid);



        JLabel lblpending= new JLabel ("Amount Pending");
        lblpending.setBounds(20,260,120,20);
        lblpending.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblpending);
    

        tfpending=new JTextField();
        tfpending.setBounds(150,260,120,20);
        tfpending.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfpending);

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

        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
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
           tfname.setText(rs.getString("name"));
           tfcheckin.setText(rs.getString("checkintime"));
           tfpaid.setText(rs.getString("deposit"));
  
           }
           
           ResultSet rs2= conn.s.executeQuery("select * from room01 where roomnumber='"+tfroom.getText()+"'");
           
           while(rs2.next()){
           
           String price= rs2.getString("price");
           
           int amountPaid = Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
           tfpending.setText(""+amountPaid);
           }
           }catch(Exception e){
           e.printStackTrace();
           }
           
     }else if(ae.getSource()==update){
         
         String number =ccustomer.getSelectedItem();
         String room= tfroom.getText();
          String name= tfname.getText(); 
          String checkin= tfcheckin.getText();
           String deposit= tfpaid.getText();
           try{
           
               conn conn=new conn ();
               conn.s.executeUpdate("update customer02 set room ='"+room+"',name='"+name+"',checkintime='"+checkin+"',deposit='"+deposit+"' where number='"+number+"'");
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

        new UpdateCheck();
        }

    }
