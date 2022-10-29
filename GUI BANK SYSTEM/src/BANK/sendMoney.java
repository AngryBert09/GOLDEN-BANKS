package BANK;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class sendMoney extends JFrame {

	private JPanel contentPane;
	private JTextField accountTextfield;
	private JTextField amountTextfield;
	private JButton sendMoney;
	private JLabel exitIcon , facebookLabel, tittleLabel, BG,accountLabel,amountLabel;
	private String ownaccountnum , name;
	private Double bal;
	private ResultSet rs;
	private Connection con;
	private Statement state;
	private JFrame homepage;
	
	Main main =  new Main();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sendMoney frame = new sendMoney();			
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sendMoney() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel accountLabel = new JLabel("Account #  :");
		accountLabel.setForeground(Color.WHITE);
		accountLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		accountLabel.setBounds(116, 88, 95, 14);
		contentPane.add(accountLabel);
		
		JLabel amountLabel = new JLabel("Amount  :");
		amountLabel.setForeground(Color.WHITE);
		amountLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		amountLabel.setBounds(116, 124, 80, 14);
		contentPane.add(amountLabel);
		
		accountTextfield = new JTextField();
		accountTextfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				accountTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				
	            if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					
                    accountTextfield.setEditable(true);
					
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
					
					accountTextfield.setEditable(true);
					
				}else {
					
					accountTextfield.setEditable(false);
					
				}
				
			}
			}});
		accountTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		accountTextfield.setBounds(202, 87, 121, 20);
		contentPane.add(accountTextfield);
		accountTextfield.setColumns(10);
		accountTextfield.setDocument(new Limiter(9));
		
		amountTextfield = new JTextField();
		amountTextfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
	                if(e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
					
                    amountTextfield.setEditable(true);
					
				}else {
					if(e.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE || e.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
					
					amountTextfield.setEditable(true);
					
				}else {
					
					amountTextfield.setEditable(false);
					
				}
			}
			}});
		amountTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		amountTextfield.setBounds(185, 123, 138, 20);
		contentPane.add(amountTextfield);
		amountTextfield.setColumns(10);
		amountTextfield.setDocument(new Limiter(6));
		
		
	    exitIcon = new JLabel("");
		exitIcon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
		     dispose();
				
			}
		});
		exitIcon.setBounds(10, 11, 31, 29);
		contentPane.add(exitIcon);
		ImageIcon img2  = new ImageIcon(getClass().getResource("back.png"));
		Image image2 = (img2).getImage().getScaledInstance(	exitIcon.getWidth(), 	exitIcon.getHeight(), Image.SCALE_SMOOTH);
		img2 = new ImageIcon(image2);
	    exitIcon.setIcon(img2);
	
	    sendMoney = new JButton("SEND");
	    sendMoney.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Homepage home = new Homepage();
	    
	    		
	    		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase","GoldenBank","tuto123");
			        String accountnum = accountTextfield.getText();
			        String amount  = amountTextfield.getText();
			        
			        String send = "update userinfos set balance = ( balance + ? ) where AccountNumber=?";
			        String sql = "select * from userinfos where AccountNumber='"+ownaccountnum+"'";
			        PreparedStatement ps = con.prepareStatement(send);
			        state = con.createStatement();
			        rs = state.executeQuery(sql);
			        home.setAccountnum(ownaccountnum);
			
			       if(rs.next()) {
			    	   
			    	   // CHECK THE IF THE AMOUNT IS GREATER THAN BALANCE
			    	   if(Double.parseDouble(amount) > rs.getDouble(11)) {
			    		   
			    		   JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE","NOTICE!", JOptionPane.WARNING_MESSAGE);
			    		   amountTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
			    		   
			    	   }if(amountTextfield.getText().isEmpty()) {
			    			   amountTextfield.setBorder(new MatteBorder(1, 1, 1, 1, (Color)new Color (255,0,0)));
			    			   
			    		   
	  
			    	   } else {
			    		   
			    		   /* check if the input account number
			    		    * are the same with the own account number
			    		    */
			    		   
			    		   if(ownaccountnum.equals(accountnum))
			    		   {
			    			   
			    			   JOptionPane.showMessageDialog(null, "INVALID ACCOUNT NUMBER","WARNING",JOptionPane.WARNING_MESSAGE);
			    			   getFrame().dispose();
			    			   new sendMoney().dispose();
			    			   
			    			   
			    			   
			    		   }else if(accountnum != rs.getString("AccountNumber")) {
			    			   
			    			   // Check if the input account number is valid
			    				int count = 0;
				    			count++;
				    			
				    			if(count > 1) {
				    				getFrame().dispose();
				    			}
			    			   
			    			JOptionPane.showMessageDialog(null, "INVALID ACCOUNTNUMBER");
			    		
			    		   
			    
			    		   }else {
			    		   
			    		   // IF NOT THE PROGRAM WILL SEND THE MONEY TO THE RECIPIENT
			    		   ps.setString(1, amount);
			    		   ps.setString(2, accountnum);
			    		   ps.executeUpdate();
			    		   
			    		   // THEN THE PROGRAM WILL DEDUCT THE AMOUNT TO THE BALANCE
			    		   PreparedStatement pes = con.prepareStatement("Update userinfos set balance= (balance - ?) where AccountNumber='"+ownaccountnum+"'");
			    		   pes.setString(1, amount);
			    		   pes.executeUpdate();
			    		   
			    		   ps.close();
			    		   pes.close();
			    		   con.close();
			    		   rs.close();
			    		   
			    	      JOptionPane.showMessageDialog(null, "SEND SUCCESSFULLY");
			    	      new sendMoney().dispose();
			    	    

			    		   } }}else {
			    		   
			    		   accountTextfield.setBorder(new MatteBorder(1,1,1,1, (Color) new Color(255,0,0)));
			   
			    	   }
			    	   
			    	   
			    	   
			       
			     	
			        		
					
					
	    	} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		 
		
	    		
	    		
	    	}
	        
            
	    });
		sendMoney.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sendMoney.setContentAreaFilled(true);
				sendMoney.setText("");
				sendMoney.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\blacksent.png"));
				sendMoney.setBackground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sendMoney.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\sendmoney.png"));
				sendMoney.setContentAreaFilled(false);
				sendMoney.setText("SEND");
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				Homepage home = new Homepage();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				
			    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase","GoldenBank","tuto123");
			    state = con.createStatement();
			    rs = state.executeQuery("Select * from userinfos where AccountNumber='"+ownaccountnum+"'");
				home.setAccountnum(ownaccountnum);
			    
				
				
			 if(rs.next()) {
				 name = rs.getString(1);
				 bal = rs.getDouble(11);
				
				 getFrame().dispose();
				 home.getFrame().setVisible(true);
				 home.getFrame().setLocationRelativeTo(null);
				 home.setFirst(name);
				 home.setBal(bal);
				
			
		
				
			 }	} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				
			 }
			}});
		sendMoney.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sendMoney.setIcon(new ImageIcon("D:\\Github Repositories\\PERSONAL-DEVS\\Icons\\Icons\\sendmoney.png"));
		sendMoney.setForeground(Color.WHITE);
		sendMoney.setContentAreaFilled(false);
		sendMoney.setFocusPainted(false);
		sendMoney.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		sendMoney.setFont(new Font("SansSerif", Font.PLAIN, 13));
		sendMoney.setBounds(153, 149, 149, 38);
		contentPane.add(sendMoney);

	
		
	    facebookLabel = new JLabel("www.facebook.com/albrtsuperduper");
		facebookLabel.setForeground(Color.WHITE);
		facebookLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
		facebookLabel.setBounds(10, 275, 186, 14);
		contentPane.add(facebookLabel);
		
	    tittleLabel = new JLabel("Express Money");
		tittleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		tittleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tittleLabel.setForeground(Color.WHITE);
		tittleLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		tittleLabel.setBounds(153, 24, 138, 29);
		contentPane.add(tittleLabel);
		
		BG = new JLabel("");
		BG.setBounds(0, 0, 450, 300);
		contentPane.add(BG);
		ImageIcon img1  = new ImageIcon(getClass().getResource("another.jpg"));
		Image image1 = (img1).getImage().getScaledInstance(	BG.getWidth(), 	BG.getHeight(), Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image1);
		BG.setIcon(img1);
	}
	
	public void setAccountnum(String accountnum) {
		
		this.ownaccountnum = accountnum;
	}
	public void setBal(Double bal) {
		
		this.bal = bal;

	
	} public Double getBal() {
		return bal;
	}
	public String getAccountnum() {
		
		return ownaccountnum;
	} 
	public void setFrame(JFrame homepage) {
		
		this.homepage = homepage;
	}
	public JFrame getFrame() {
		return homepage;
		
	}

		
	}
	
	
