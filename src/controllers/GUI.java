package controllers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import models.Person;
import utils.FileIO;

import javax.swing.DefaultListModel;
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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class GUI {

	protected static final String FileName = null;
	private JFrame frmFamilyTree;
	DefaultListModel<String>  PList;
	JLabel amountOfPeople;
	Person person;
	

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
		frmFamilyTree.setBounds(300, 200, 450, 300);
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
						if(FileIO.allPeople.size() == 0){
							JOptionPane.showMessageDialog(null, "File was empty or corrupt");

						}
						
						else{
							for(String key : FileIO.allPeople.keySet()) {
								System.out.println(key);
								PList.addElement(key);
							}
							
							
							amountOfPeople.setText("Total People = " +  PList.size());
							
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "File was empty or corrupt");

						e1.printStackTrace();
					}
				}


				
				// fileChooser to select file
			}
		});
		menuBar.add(btnOpen);
		
		
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
		
		
		// a person's first name
		JTextArea fName = new JTextArea();
		fName.setSize(new Dimension(100, 200));
		fName.setBounds(554, 142, 152, 22);
		frmFamilyTree.getContentPane().add(fName);
		
		// a person's year of birth
		JTextArea birthYear = new JTextArea();
		birthYear.setSize(new Dimension(100, 200));
		birthYear.setBounds(554, 186, 80, 22);
		frmFamilyTree.getContentPane().add(birthYear);
		
		
		//person's gender
		JTextArea gender = new JTextArea();
		gender.setSize(new Dimension(100, 200));
		gender.setBounds(554, 228, 80, 22);
		frmFamilyTree.getContentPane().add(gender);
		
		
		//person's mother's name
  		JTextArea motherName = new JTextArea();
		motherName.setSize(new Dimension(100, 200));
		motherName.setBounds(554, 273, 152, 22);
		frmFamilyTree.getContentPane().add(motherName);
		
		//person's father's name
		JTextArea fatherName = new JTextArea();
		fatherName.setSize(new Dimension(100, 200));
		fatherName.setBounds(554, 318, 152, 22);
		frmFamilyTree.getContentPane().add(fatherName);
		
		
		PList = new DefaultListModel<String>();

		JList allPeople = new JList(PList);		
	
		
		
				allPeople.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						// look up allPeople with name of selected person
						String  index = (String) allPeople.getSelectedValue();
					//	System.out.println(index);
					Person PS = FileIO.allPeople.get(index);
					
					fName.setText(PS.getName());
					birthYear.setText(Integer.toString(PS.getBirthYear()));
					gender.setText(PS.getGender());
					if (PS.getMother()!= null){
						motherName.setText(PS.getMother().getName());
					}
					else{
						motherName.setText("Unknown");
					}
					
					
					if (PS.getFather()!= null){
						fatherName.setText(PS.getFather().getName());
					}else{
						fatherName.setText("Unknown");
					}
					
					
					

					// to get grandparents call:
					// grandMotherName = PS.getMother().getMother().getName()
					// grandFatherName = PS.getFather().getFather().getName()
					}
				});
				allPeople.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				
		JScrollPane scrollPane = new JScrollPane(allPeople);
		scrollPane.setPreferredSize(new Dimension(50, 150));
		scrollPane.setBounds(0, 0, 170, 540);
		frmFamilyTree.getContentPane().add(scrollPane);
		
		
		amountOfPeople= new JLabel("Total People = " +  PList.size());
		amountOfPeople.setBounds(271, 378, 435, 14);
		frmFamilyTree.getContentPane().add(amountOfPeople);
	}
	
}
