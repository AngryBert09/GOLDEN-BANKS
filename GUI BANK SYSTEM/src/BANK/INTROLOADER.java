package BANK;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;
import java.awt.Label;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class INTROLOADER extends JFrame {

	private JPanel contentPane;
	private JProgressBar LOADER;
	private JLabel whileLoadingLabel;
	private JLabel lblNewLabel;
	private JLabel BG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					INTROLOADER frame = new INTROLOADER();
			    
					frame.setLocationRelativeTo(null);
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
	public INTROLOADER() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel logoIcon = new JLabel();
		logoIcon.setBounds(186, 123, 75, 71);
		contentPane.add(logoIcon);
		ImageIcon img3  = new ImageIcon(getClass().getResource("logo.png"));
		Image image3 = (img3).getImage().getScaledInstance(	logoIcon.getWidth(), 	logoIcon.getHeight(), Image.SCALE_SMOOTH);
		img3 = new ImageIcon(image3);
		logoIcon.setIcon(img3);
		
		JLabel tittleLabel = new JLabel("GOLDEN BANK");
		tittleLabel.setForeground(Color.WHITE);
		tittleLabel.setFont(new Font("SansSerif", Font.PLAIN, 25));
		tittleLabel.setBounds(259, 123, 189, 71);
		contentPane.add(tittleLabel);
		
	    whileLoadingLabel = new JLabel();
	    whileLoadingLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
	    whileLoadingLabel.setForeground(Color.WHITE);
		whileLoadingLabel.setBounds(10, 304, 182, 14);
		contentPane.add(whileLoadingLabel);

	    LOADER = new JProgressBar();
	    LOADER.setBorderPainted(false);
	    LOADER.setEnabled(false);
	    LOADER.setBackground(Color.LIGHT_GRAY);
	    LOADER.setFont(new Font("SansSerif", Font.PLAIN, 11));
	    LOADER.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	    LOADER.setForeground(Color.ORANGE);
		LOADER.setBounds(10, 329, 621, 24);
		

		  Thread t = new Thread(){
		        public void run(){
		            for(int i = 0 ; i <= 100 ; i = i+1){
		           
		                final int percent = i;
		               
		                switch(i) {
		                case 15:
		                	whileLoadingLabel.setText("PREPARING APPLICATION ...");
		                    break;                
		                case 30:
		                	whileLoadingLabel.setText("CONNECTING TO THE DATABASE ...");
		                    break;
		                case 50:
		                	whileLoadingLabel.setText("CONNECTION SUCCESSFUL ...");
		                	break;
		                case 70:
		                	whileLoadingLabel.setText("LAUNCHING APPLICATION ...");
		                	break;
		                case 92:
		                	whileLoadingLabel.setText("LAUNCH SUCCESSFULLY ...");
		                	break;
		                case 98:
		                	whileLoadingLabel.setText("OPENING UI ...");
		                  break;
		                case 100:
		                    Main main = new Main();
		                    main.setLocationRelativeTo(null);
		                    main.setVisible(true);  
		                    dispose();
		                }
		                
		                SwingUtilities.invokeLater(new Runnable() {
		                    public void run() {
		                        LOADER.setValue(percent);
		                    }
		                  });

		                try {
		                    Thread.sleep(20);
		                } catch (InterruptedException e) {}
		            }
		        }
		    };
		    
		    
		contentPane.add(LOADER);
		
		lblNewLabel = new JLabel("BETA version 1.0.0.0");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 202, 24);
		contentPane.add(lblNewLabel);
		
		BG = new JLabel("");
		BG.setBounds(0, 0, 641, 384);
		contentPane.add(BG);
		ImageIcon img1  = new ImageIcon(getClass().getResource("another.jpg"));
		Image image1 = (img1).getImage().getScaledInstance(	BG.getWidth(), 	BG.getHeight(), Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image1);
		BG.setIcon(img1);

		t.start();
		
	
	}
}
