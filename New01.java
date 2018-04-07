import javax.swing.*;
import java.awt.event.*;
//https://javaproglang.blogspot.com/2014/01/jtextarea-on-jpanel-implements.html#.WseGb2aZPow
// for jpassworfield https://javaproglang.blogspot.com/2014/01/jtextfield-jpasswordfield-on-jpanel.html#.WseKn2aZPow

public class New01 extends JPanel implements ActionListener
{
	JLabel lblName;
	JTextField txtName;
	JTextArea taRemarks;
	JButton btnIcon;
	//ImageIcon imgIcon;
	RestAPIClient newreq = new RestAPIClient();
	String num = newreq.number;
	String carrier = newreq.carrier;
	
	public New01()
	{
		setLayout(null);
		lblName = new JLabel("Enter number: ");
		txtName = new JTextField(15);
		taRemarks = new JTextArea(10,10);
		btnIcon = new JButton("Verify");
		btnIcon.addActionListener(this);
		
		lblName.setBounds(10,20,120,25);
		txtName.setBounds(150,20,150,25);
		btnIcon.setBounds(120,100,150,30);
		taRemarks.setBounds(30,140,330,100);
		
		//Add labels to the Panel.
		add(lblName);
		add(txtName);
		add(btnIcon);
		add(taRemarks);
	}
	public void actionPerformed(ActionEvent actEvt)
	{
		if (actEvt.getSource() == btnIcon)
		{
			String phonenum = txtName.getText();
			try {
				newreq.sendGet(phonenum);
				// set json object values
				
			} catch (Exception e) {
				System.out.println(e + " Exception thrown.");
			}
			//taRemarks.append("Carrier: " + newreq.sendGet(phonenum).Number;)
			taRemarks.append("Phonenumber verified: "+ num +"\n");
			taRemarks.append("Carrier: "+ carrier +"\n");	
		}
	}



	
	public static void main(String[] args) {
		New01 newgui = new New01();
		
		// set text on frame
		JFrame frame = new JFrame("Text Area Demo");
		frame.setContentPane(newgui);
		
		// setSize() methods is used to specify the width and height of the frame
		frame.setSize(400,300);

		// To display the Frame
		frame.setVisible(true);
		
		WindowListener listener = new WindowAdapter()
		{
			public void windowClosing(WindowEvent winEvt)
			{
				System.exit(0);
			}
		};  // End of WindowAdaptor() method

		// Window listener activates the windowClosing() method
		frame.addWindowListener(listener);
	}
		

	}


