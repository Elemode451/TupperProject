package main;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JToolBar;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class MainGUI {
	private JFrame frmTupperCalculator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frmTupperCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTupperCalculator = new JFrame();
		frmTupperCalculator.setTitle("Tupper Calculator");
		frmTupperCalculator.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\danie\\OneDrive\\Desktop\\NMICK.png"));
		frmTupperCalculator.setAlwaysOnTop(true);
		frmTupperCalculator.setBounds(100, 100, 772, 537);
		frmTupperCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BigInteger emptyKValue = new BigInteger("0");
		JLabel lblWelcomeToThe = new JLabel("Welcome to Tupper's Self Referential Equation! ");
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setFont(new Font("Myanmar Text", Font.PLAIN, 15));
		JTextArea txtKValue = new JTextArea();
		txtKValue.setBackground(Color.GRAY);
		txtKValue.setLineWrap(true);
		
		JButton btnUploadImage = new JButton("Upload Image");
		btnUploadImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser("C:/Users/danie/Onedrive/Desktop");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "png");
				fileChooser.setFileFilter(filter);
				int option = fileChooser.showOpenDialog(frmTupperCalculator);
				if(option == JFileChooser.APPROVE_OPTION){
					File file = fileChooser.getSelectedFile();
					btnUploadImage.setText("File Selected:" + file.getName());
					try {
						String bin = ImageProcessor.processImage(file.getPath());
						BigInteger kValue = ImageProcessor.returnKValue(bin);
						txtKValue.setText("K Value: " + kValue);
					} catch (IOException e1) {
						txtKValue.setText("K Value Calculation failed.");
						e1.printStackTrace();
					}
					
					
					
				} else {
					
					btnUploadImage.setText("Invalid file - Upload again.");
				}
			}
		});
		
		JButton btnNewButton = new JButton("Render");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmTupperCalculator.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnUploadImage, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
								.addComponent(txtKValue, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
							.addGap(39)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
							.addGap(28))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblWelcomeToThe)
							.addContainerGap(429, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomeToThe)
					.addGap(7)
					.addComponent(txtKValue, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUploadImage, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		frmTupperCalculator.getContentPane().setLayout(groupLayout);
		
		
		
	}
}
