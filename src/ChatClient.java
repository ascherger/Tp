import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ChatClient{
	private JTextArea output;
	private JTextField input;
	private JButton sendButton;
	private JButton quitButton;
	
	public ChatClient(){
		output = new JTextArea(10,50);
		input = new JTextField(50);
		sendButton = new JButton("Send");
		quitButton = new JButton("Quit");
		
		//agrego los receptores de eventos
		sendButton.addActionListener(new SendHandler());
		quitButton.addActionListener(new QuitHandler());
	}
	
	public void launchFrame(){
		JFrame frame = new JFrame("Chat Room");
		
		frame.setLayout(new BorderLayout());
		
		frame.add(output,BorderLayout.WEST);
		frame.add(input,BorderLayout.SOUTH);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2,1));
		p1.add(sendButton);
		p1.add(quitButton);
		
		frame.add(p1, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private class SendHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			String text = input.getText();
			output.setText(output.getText()+ text + "\n");
			input.setText("");
		}
	}
	
	private class QuitHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
}