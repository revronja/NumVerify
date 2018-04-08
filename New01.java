import javax.swing.*;
import java.awt.event.*;

// test number is 14158586273

public class New01 extends JPanel implements ActionListener
{
	JLabel lblName;
	JTextField txtName;
	JTextArea taRemarks;
	JButton btnIcon;
	//ImageIcon imgIcon;
	Test_RestAPIClient newreq = new Test_RestAPIClient();
	private JScrollPane scrollPane;

	public New01()
	{
		setLayout(null);
		lblName = new JLabel("Enter number: ");
		txtName = new JTextField(15);
		btnIcon = new JButton("Verify");
		btnIcon.addActionListener(this);
		
		lblName.setBounds(10,20,120,25);
		txtName.setBounds(150,20,150,25);
		btnIcon.setBounds(120,100,150,30);
		
		//Add labels to the Panel.
		add(lblName);
		add(txtName);
		add(btnIcon);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 140, 330, 100);
		add(scrollPane);
		taRemarks = new JTextArea(10,10);
		scrollPane.setViewportView(taRemarks);
	
		
		
	}
	public void actionPerformed(ActionEvent actEvt)
	{
		if (actEvt.getSource() == btnIcon)
		{
			String phonenum = txtName.getText();
			try {
				newreq.sendGet(phonenum);
				taRemarks.append("Phone number valid: " + newreq.valid + "\n");
				taRemarks.append("Local format: " + newreq.localformat + "\n");
				taRemarks.append("International format: " + newreq.intformat + "\n");
				taRemarks.append("Location: " + newreq.location + "\n");
				taRemarks.append("Carrier: " + newreq.carrier + "\n");
				taRemarks.append("Countrycode: " + newreq.countrycode + "\n");
				taRemarks.append("Linetype: " + newreq.linetype + "\n");
				
				
			} catch (Exception e) {
				System.out.println(e + " Exception thrown.");
			}
			// output can go here ?
			//taRemarks.append("Carrier: " + newreq.sendGet(phonenum).Number;)
			
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


