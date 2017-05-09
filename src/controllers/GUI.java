package controllers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class GUI {

	private JFrame frmFamilyTree;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frmFamilyTree.setTitle("Family Tree");
		frmFamilyTree.setBounds(100, 100, 450, 300);
		frmFamilyTree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFamilyTree.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(186, 26, 238, 20);
		frmFamilyTree.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(185, 11, 46, 14);
		frmFamilyTree.getContentPane().add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 73, 86, 20);
		frmFamilyTree.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBirthYeae = new JLabel("Birth Year");
		lblBirthYeae.setBounds(186, 57, 85, 14);
		frmFamilyTree.getContentPane().add(lblBirthYeae);
		
		textField_2 = new JTextField();
		textField_2.setBounds(338, 73, 86, 20);
		frmFamilyTree.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setBounds(338, 57, 86, 15);
		frmFamilyTree.getContentPane().add(lblNewLabel);
		
		JLabel lblMothersName = new JLabel("Mother's Name");
		lblMothersName.setBounds(186, 124, 85, 14);
		frmFamilyTree.getContentPane().add(lblMothersName);
		
		textField_3 = new JTextField();
		textField_3.setBounds(185, 149, 239, 20);
		frmFamilyTree.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(186, 207, 238, 20);
		frmFamilyTree.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Father's Name");
		lblNewLabel_1.setBounds(186, 180, 85, 14);
		frmFamilyTree.getContentPane().add(lblNewLabel_1);
		
		JList list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		list.setForeground(Color.LIGHT_GRAY);
		list.setValueIsAdjusting(true);
		list.setVisibleRowCount(12);
		list.setSelectedIndices(new int[] {10});
		list.setSelectedIndex(9);
		list.setBounds(10, 246, 136, -234);
		frmFamilyTree.getContentPane().add(list);
	}
}
