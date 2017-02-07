import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class A1client {
  final static boolean shouldFill = true;
  final static boolean shouldWeightX = true;
  final static boolean RIGHT_TO_LEFT = false;
  static Socket Socket1 = null;
  static PrintWriter out = null;
  static BufferedReader in = null;
  public static void createInputFrame() {
    JFrame frame = new JFrame();
    Object result = JOptionPane.showInputDialog(frame, "Enter printer name:");
    System.out.println(result);

  }

  public static void createGUI() {
    // create frame
    JFrame frame = new JFrame("A1Client");
    frame.setSize(500,700);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //set pane
    Container pane = frame.getContentPane();
    pane.setLayout(new GridBagLayout());

    GridBagConstraints c = new GridBagConstraints();
    // if (shouldFill) {
    //   c.fill = GridBagConstraints.HORIZONTAL;
    // }

    JLabel IPLabel = new JLabel("IP Address:");
    if (shouldWeightX) {
      c.weightx = 0.5;
    }
    c.fill = GridBagConstraints.NONE;
    c.gridwidth = 1;
    c.insets = new Insets(5,0,0,0);
    c.gridx = 0;
    c.gridy = 0;
    pane.add(IPLabel, c);

    JTextField IPTextField = new JTextField(32);
    if (shouldWeightX) {
      c.weightx = 0.5;
    }
    // c.fill = GridBagConstraints.HORIZONTAL;
    c.gridwidth = 2;
    c.gridx = 1;
    c.gridy = 0;
    pane.add(IPTextField, c);

    JLabel portLabel = new JLabel("Port:");
    if (shouldWeightX) {
      c.weightx = 0.5;
    }
    // c.fill = GridBagConstraints.HORIZONTAL;
    c.gridwidth = 1;
    c.gridx = 0;
    c.gridy = 1;
    pane.add(portLabel, c);

    JTextField portTextField = new JTextField(16);
    if (shouldWeightX) {
      c.weightx = 0.5;
    }
    // c.fill = GridBagConstraints.HORIZONTAL;
    c.gridwidth = 1;
    c.gridx = 1;
    c.gridy = 1;
    pane.add(portTextField, c);

    JButton connectButton = new JButton("Connect");
    if (shouldWeightX) {
      c.weightx = 0.5;
    }
    c.fill = GridBagConstraints.NONE;
    c.gridwidth = 1;
    c.gridx = 1;
    c.gridy = 2;
    c.gridwidth = 1;
    pane.add(connectButton, c);

    JButton disconnectButton = new JButton("Disconnect");
    if (shouldWeightX) {
      c.weightx = 0.5;
    }
    // c.fill = GridBagConstraints.HORIZONTAL;
    c.gridwidth = 1;
    c.gridx = 2;
    c.gridy = 2;
    c.gridwidth = 1;
    pane.add(disconnectButton, c);

    JTextArea postArea = new JTextArea(10,20);
    if (shouldWeightX) {
      c.weightx = 0;
    }
    c.fill = GridBagConstraints.HORIZONTAL;
    // c.gridwidth = 3;
    c.gridx = 0;
    c.gridy = 3;
    pane.add(postArea, c);

    JButton postButton = new JButton("Post");
    if (shouldWeightX) {
      c.weightx = 0.5;
    }
    // c.fill = GridBagConstraints.HORIZONTAL;
    c.fill = GridBagConstraints.NONE;
    c.gridwidth = 1;
    c.gridx = 1;
    c.gridy = 4;
    pane.add(postButton, c);

    JButton getButton = new JButton("Get");
    if (shouldWeightX) {
      // c.fill = GridBagConstraints.HORIZONTAL;
      c.gridwidth = 1;
      c.gridx = 2;
      c.gridy = 4;
      pane.add(getButton, c);
    }

    JTextArea outputArea = new JTextArea(10,20);
    if (shouldWeightX) {
      c.weightx = 0.5;
      outputArea.setLineWrap(true);
      outputArea.setWrapStyleWord(true);
      outputArea.setEditable(false);
    }
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 5;
    pane.add(outputArea, c);

    //display the window
    frame.pack();
    frame.setVisible(true);

    //action listeners
    connectButton.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            // Create a method named "createFrame()", and set up an new frame there
            // Call createFrame()
        	String serverIp = IPTextField.getText();
        	int serverPort = Integer.parseInt(portTextField.getText());
        	try {
        		Socket1 = new Socket(serverIp, serverPort);
                out = new PrintWriter(Socket1.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(Socket1.getInputStream()));
            } catch (UnknownHostException e1) {
                System.err.println("cant connect");
                System.exit(1);
            } catch (IOException e1) {
                System.err.println("cant connect");
                System.exit(1);
            }
        	
        }
    });

    disconnectButton.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            // Create a method named "createFrame()", and set up an new frame there
            // Call createFrame()
        	try {
				Socket1.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    });

    postButton.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            // Create a method named "createFrame()", and set up an new frame there
            // Call createFrame()
        	String clientPost = postArea.getText();
        	out.println(clientPost);
        	try{
        		String answer = in.readLine();
        		outputArea.setText(answer);
        	} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
        	}
        }
    });

    getButton.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
        	String clientPost = postArea.getText();
        	out.println(clientPost);
        	try{
        		String answer = in.readLine();
        		outputArea.setText(answer);
        	} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
        	}
        }
    });
  }


  public static void main(String argv[]) {
    javax.swing.SwingUtilities.invokeLater(new Runnable () {
      public void run() {
        createGUI();
      }
    });
  }

}
