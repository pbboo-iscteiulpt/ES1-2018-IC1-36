package BDA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class InterfaceGeral {

	private JFrame frame;
	private JTextField SearchField;
	

	public InterfaceGeral() {
		InterfaceGeral geral = this;
		System.out.println("geral...");
		frame = new JFrame("DBA");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(130, 130, 390, 390);
		frame.setLayout(null);
		
		SearchField = new JTextField();
		SearchField.setBounds(37, 27, 174, 38);
		frame.add(SearchField);
		SearchField.setColumns(10);
		
		JLabel FacebookLabel = new JLabel("");
		FacebookLabel.setBounds(254, 94, 46, 31);
		frame.add(FacebookLabel);
		
		JLabel TwitterLabel = new JLabel("");
		TwitterLabel.setBounds(254, 142, 46, 31);
		frame.add(TwitterLabel);
		
		JLabel EmailLabel = new JLabel("");
		EmailLabel.setBounds(254, 196, 46, 31);
		frame.add(EmailLabel);
		
		JButton SearchButton = new JButton("Pesquisar");
		SearchButton.setBounds(234, 35, 89, 23);
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FacebookAPI f = new FacebookAPI();
				f.setSearchword(SearchField.getText());
				f.connect();
				FacebookLabel.setText(Integer.toString(f.getNregistos()));
				
				TwitterApi t = new TwitterApi();
				TwitterLabel.setText(Integer.toString(t.getNregistos()));
				
				
			}
		});
		frame.add(SearchButton);
		
		JButton FacebookButton = new JButton("Facebook");
		FacebookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				FacebookAPI a = new FacebookAPI();
				a.startInterface(geral);
				
			}
		});
		FacebookButton.setBounds(38, 88, 173, 43);
		frame.add(FacebookButton);
		
		JButton TwitterButton = new JButton("Twitter");
		TwitterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				TwitterApi t = new TwitterApi();
				t.startInterface(geral);
				
			}
		});
		TwitterButton.setBounds(38, 142, 173, 43);
		frame.add(TwitterButton);
		
		JButton EmailButton = new JButton("Email");
		EmailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				EmailAPI t = new EmailAPI();
				t.startInterface(geral);
				
			}
		});
		EmailButton.setBounds(38, 196, 173, 43);
		frame.add(EmailButton);
		
	}
	
	public void openagain() {
		frame.setVisible(true);
	}
}
