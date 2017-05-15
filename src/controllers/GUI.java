package controllers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

import utils.FileIO;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GUI {

	protected static final String FileName = null;
	private JFrame frmFamilyTree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FileIO imports = new FileIO();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmFamilyTree.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFamilyTree = new JFrame();
		frmFamilyTree.setMinimumSize(new Dimension(800, 600));
		frmFamilyTree.setName("frame");
		frmFamilyTree.setResizable(false);
		frmFamilyTree.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmFamilyTree.setSize(new Dimension(800, 600));
		frmFamilyTree.setPreferredSize(new Dimension(800, 600));
		frmFamilyTree.setTitle("Family Tree v1.0");
		frmFamilyTree.setBounds(100, 100, 450, 300);
		frmFamilyTree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmFamilyTree.setJMenuBar(menuBar);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent openFile) {
				JFileChooser Fc = new JFileChooser();
				Fc.setCurrentDirectory(new java.io.File("C:/Users/"));
				Fc.setDialogTitle("Choose File");
				Fc.setFileSelectionMode(JFileChooser.FILES_ONLY);


				Fc.showOpenDialog(null);
				if (Fc.getSelectedFile() != null) {
					

					//encFileName = encFile.getAbsolutePath();

					JTextArea FileNameText = new JTextArea();
					FileNameText.setBounds(143, 35, 281, 22);
					File usersFile = Fc.getSelectedFile();

					FileNameText.setText(FileName);
					try {
						FileIO.importer(usersFile);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			
				// fileChooser to select file
			}
		});
		menuBar.add(btnOpen);
		
		JButton btnAbout = new JButton("About");
		menuBar.add(btnAbout);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(btnExit);
		frmFamilyTree.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(271, 144, 80, 21);
		frmFamilyTree.getContentPane().add(lblName);
		
		JLabel lblBirthYear = new JLabel("Birth Year");
		lblBirthYear.setBounds(271, 188, 80, 21);
		frmFamilyTree.getContentPane().add(lblBirthYear);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(271, 230, 80, 21);
		frmFamilyTree.getContentPane().add(lblGender);
		
		JLabel lblMotherName = new JLabel("Name of mother");
		lblMotherName.setBounds(269, 275, 106, 21);
		frmFamilyTree.getContentPane().add(lblMotherName);
		
		JLabel lblFatherName = new JLabel("Name of father");
		lblFatherName.setBounds(269, 320, 106, 21);
		frmFamilyTree.getContentPane().add(lblFatherName);
		
		JTextArea fName = new JTextArea();
		fName.setSize(new Dimension(100, 200));
		fName.setBounds(554, 142, 152, 22);
		frmFamilyTree.getContentPane().add(fName);
		
		JTextArea birthYear = new JTextArea();
		birthYear.setSize(new Dimension(100, 200));
		birthYear.setBounds(554, 186, 80, 22);
		frmFamilyTree.getContentPane().add(birthYear);
		
		JTextArea gender = new JTextArea();
		gender.setSize(new Dimension(100, 200));
		gender.setBounds(554, 228, 80, 22);
		frmFamilyTree.getContentPane().add(gender);
		
		JTextArea motherName = new JTextArea();
		motherName.setSize(new Dimension(100, 200));
		motherName.setBounds(554, 273, 152, 22);
		frmFamilyTree.getContentPane().add(motherName);
		
		JTextArea fatherName = new JTextArea();
		fatherName.setSize(new Dimension(100, 200));
		fatherName.setBounds(554, 318, 152, 22);
		frmFamilyTree.getContentPane().add(fatherName);
		
		JLabel personNum = new JLabel("Person " + "personNum"  + "of " +  "people.size()");
		personNum.setBounds(271, 378, 435, 14);
		frmFamilyTree.getContentPane().add(personNum);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(50, 150));
		scrollPane.setBounds(20, 520, 177, -495);
		frmFamilyTree.getContentPane().add(scrollPane);
		
		JList allPeople = new JList();
		allPeople.setPreferredSize(new Dimension(50, 180));
		allPeople.setBounds(30, 520, 177, 477);
		frmFamilyTree.getContentPane().add(allPeople);
	}
}
