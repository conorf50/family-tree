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
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	protected static final String FileName = null;
	private JFrame frmFamilyTree;
	DefaultListModel<String>  PList;
	JLabel amountOfPeople;
	Person person;
	
	// for a new Person (hidden by default)
	private JFrame addNewPerson;
	private JTextField NfirstName;
	private JTextField NyearOfBirth;
	private JTextField NnameOfMother;
	private JTextField NnameOfFather;
	private JTextField NnameOfGrandMother;
	private JTextField NnameOfGrandFather;
	
	//data used to create a new Person
		// 'N' denotes a field associated with a new Person
		private String Nname;
		private String Ngender;
		private Integer NbirthYear;
		private String NmotherName;
		private String NfatherName;
		private String NgrandMotherName;
		private String NgrandFatherName;

	

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
					window.addNewPerson.setVisible(false);
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
		
		// Form used to add a new Person
		addNewPerson = new JFrame();
		addNewPerson.setTitle("Add Person");
		addNewPerson.setResizable(false);
		addNewPerson.setSize(new Dimension(400, 450));
		addNewPerson.getContentPane().setMinimumSize(new Dimension(400, 400));
		addNewPerson.getContentPane().setSize(new Dimension(400, 4000));
		addNewPerson.getContentPane().setPreferredSize(new Dimension(400, 400));
		addNewPerson.setPreferredSize(new Dimension(400, 451));
		addNewPerson.getContentPane().setLayout(null);
		
		
		
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
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// add a new Person using provided data
				addNewPerson.setVisible(true);
				//call add method with all parameters
				
					// We must check what the user entered
				 if (NfirstName.getText().matches("\\w+")
						    && (Ngender.equals("M") || Ngender.equals("F"))    // 
						    &&(NyearOfBirth.getText().matches("\\d+"))        // "\\d+ will match only numbers
						 	|| (NnameOfFather.getText().matches("\\w+")) 
						 	|| (NnameOfMother.getText().matches("\\w+"))
						    || (NnameOfGrandMother.getText().matches("\\w+")) 
						    || (NnameOfGrandFather.getText().matches("\\w+"))) // "\\w+" matches only letters
						 {
						 	// create new person with all  this info
					 	Nname = NfirstName.getText();	
					 	NbirthYear = Integer.parseInt(NyearOfBirth.getText());
					 	NmotherName = NnameOfMother.getText();	
					 	NfatherName = NnameOfFather.getText();	
					 	NgrandMotherName = NnameOfGrandMother.getText();	
					 	NgrandFatherName = NnameOfGrandFather.getText();	 	
					 
					 
					 System.out.println(Nname + NbirthYear + Ngender + NmotherName + NfatherName + NgrandMotherName + NgrandFatherName);
					 //Person p = new Person(name, gender, birthYear, (Person) mother, (Person) father)
						 }
						 else {
							 JOptionPane.showMessageDialog(null, "Please check you've provided the correct information \n Names shoud only contain letters\n "
							 		+ "Birth Year should be an integer");
							 NfirstName.setText("");			 
							 NyearOfBirth.setText("");
						 	NnameOfMother.setText("");
					     	NnameOfFather.setText("");
							NnameOfGrandMother.setText("");
							NnameOfGrandFather.setText("");
							 }
						

				
				
				
			
				
				
				
			}
		});
		menuBar.add(btnAdd);
		menuBar.add(btnExit);
		frmFamilyTree.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(271, 144, 80, 21);
		frmFamilyTree.getContentPane().add(lblName);
		
		JLabel lblBirthYear = new JLabel("Birth Year");
		lblBirthYear.setBounds(271, 188, 80, 21);
		frmFamilyTree.getContentPane().add(lblBirthYear);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(266, 233, 80, 21);
		frmFamilyTree.getContentPane().add(lblGender);
		
		JLabel lblMotherName = new JLabel("Name of mother");
		lblMotherName.setBounds(269, 275, 106, 21);
		frmFamilyTree.getContentPane().add(lblMotherName);
		
		JLabel lblFatherName = new JLabel("Name of father");
		lblFatherName.setBounds(269, 320, 106, 21);
		frmFamilyTree.getContentPane().add(lblFatherName);
		
		
		// labels for the add new person dialog
		
		JLabel lblAddANew = new JLabel("Add a new person using the fields below. ");
		lblAddANew.setBounds(97, 11, 287, 14);
		addNewPerson.getContentPane().add(lblAddANew);

		JLabel NlblName = new JLabel("Name *");
		NlblName.setBounds(10, 63, 85, 14);
		addNewPerson.getContentPane().add(NlblName);

		JLabel NlblYearOfBirth = new JLabel("Year of Birth *");
		NlblYearOfBirth.setBounds(10, 107, 125, 14);
		addNewPerson.getContentPane().add(NlblYearOfBirth);

		JLabel NlblNameOfMother = new JLabel("Name of mother");
		NlblNameOfMother.setBounds(10, 193, 182, 14);
		addNewPerson.getContentPane().add(NlblNameOfMother);

		JLabel NlblNameOfFather = new JLabel("Name of father");
		NlblNameOfFather.setBounds(10, 236, 182, 14);
		addNewPerson.getContentPane().add(NlblNameOfFather);

		JLabel NlblNameOfGrandfather = new JLabel("Name of grandfather");
		NlblNameOfGrandfather.setBounds(10, 322, 182, 14);
		addNewPerson.getContentPane().add(NlblNameOfGrandfather);

		JLabel NlblNameOfGrandmother = new JLabel("Name of grandmother");
		NlblNameOfGrandmother.setBounds(10, 278, 182, 14);
		addNewPerson.getContentPane().add(NlblNameOfGrandmother);

		JLabel NlblNewLabel = new JLabel("Mandatory fields are marked with ' * '");
		NlblNewLabel.setBounds(97, 27, 287, 14);
		addNewPerson.getContentPane().add(NlblNewLabel);
		
		
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
		
		
		// new person dialog
		NfirstName = new JTextField();
		NfirstName.setBounds(202, 60, 160, 20);
		addNewPerson.getContentPane().add(NfirstName);

		
		NfirstName.setColumns(10);

		NyearOfBirth = new JTextField();
		NyearOfBirth.setColumns(10);
		NyearOfBirth.setBounds(202, 104, 160, 20);
		addNewPerson.getContentPane().add(NyearOfBirth);

		
		NnameOfMother = new JTextField();
		NnameOfMother.setColumns(10);
		NnameOfMother.setBounds(202, 190, 160, 20);
		addNewPerson.getContentPane().add(NnameOfMother);

		 
		
		
		NnameOfFather = new JTextField();
		NnameOfFather.setColumns(10);
		NnameOfFather.setBounds(202, 233, 160, 20);
		addNewPerson.getContentPane().add(NnameOfFather);

		

		NnameOfGrandMother = new JTextField();
		NnameOfGrandMother.setColumns(10);
		NnameOfGrandMother.setBounds(202, 275, 160, 20);
		addNewPerson.getContentPane().add(NnameOfGrandMother);

		 

		NnameOfGrandFather = new JTextField();
		NnameOfGrandFather.setColumns(10);
		NnameOfGrandFather.setBounds(202, 319, 160, 20);
		addNewPerson.getContentPane().add(NnameOfGrandFather);

		JRadioButton genderM = new JRadioButton("Male");
		genderM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//set gender string to be "M"
				Ngender = "M";
			}
		});
		genderM.setBounds(202, 144, 71, 23);
		addNewPerson.getContentPane().add(genderM);

		JRadioButton genderF = new JRadioButton("Female");
		genderF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// set gender string to "F";
				Ngender = "F";
			}
		});

		genderF.setBounds(275, 144, 109, 23);
		addNewPerson.getContentPane().add(genderF);
		
		ButtonGroup genders = new ButtonGroup();
		genders.add(genderM);
		genders.add(genderF);

		JLabel NlblGender = new JLabel("Gender *");
		lblGender.setBounds(10, 148, 85, 14);
		addNewPerson.getContentPane().add(NlblGender);

		JButton NbtnAdd = new JButton("Add");
		
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
