package smtp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame {

	static JFrame jf;
	static JPanel jp;
	static	JPanel jp1;
	static	JPanel contentPanel;
	static	JLabel jl;
	static	JLabel subjectLabel;
	static	JTextField jtf;
	static	JTextField subjectTextField;
	static	JTextArea contentArea;
	static	JScrollPane jsp;
	static	JButton sendButton;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jf = new JFrame();
		jp = new JPanel();
		jp1 = new JPanel();
		contentPanel = new JPanel();
		jl = new JLabel("E-mail address :");
		subjectLabel = new JLabel("Subject               :");
		jtf = new JTextField();
		subjectTextField = new JTextField();
		contentArea = new JTextArea();
		jsp = new JScrollPane(contentArea);
		sendButton = new JButton("Send");

		jtf.setColumns(20);

		jp.setLayout(new FlowLayout());
		jp.add(jl);
		jp.add(jtf);

		jp1.setLayout(new FlowLayout());
		jp1.add(subjectLabel);
		jp1.add(subjectTextField);
		subjectTextField.setColumns(20);

		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(jp1, BorderLayout.NORTH);
		contentPanel.add(jsp, BorderLayout.CENTER);

		sendButton.addActionListener(new Send());
		
		jf.setLayout(new BorderLayout());
		jf.setSize(400, 400);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setTitle("Sending Email!");
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.add(jp, BorderLayout.NORTH);
		jf.add(contentPanel, BorderLayout.CENTER);
		jf.add(sendButton, BorderLayout.SOUTH);

	}

	static class Send implements ActionListener {

		String address, subject, content;
		SendEmail se = new SendEmail();

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				
				address = jtf.getText();
				subject = subjectTextField.getText();
				content = contentArea.getText();
				
				se.sendMail(address,subject,content);
				
				jtf.setText("");
				subjectTextField.setText("");
				contentArea.setText("");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
}
