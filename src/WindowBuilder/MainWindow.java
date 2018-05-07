package WindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import Window.ChangeStatusAction;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Label;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;

public class MainWindow {

	private JFrame frmUfXmlGenerator;
    private JPanel contentPane;
	
	private JTextField tfProductSymbol;
	private JTextField tfPrefix;
	private JTextField tfFile;
	
	private JButton btnGetFile;
	
	private JComboBox cbAction1; 
	
	private JCheckBox chbActiveA1;
	
	private JLabel lbSetAction1;
	
	public File file;
	private static String[] actionList = {"Zmiana statusu", "Wykonanie akcji", "Zmiana wartoœci pola"};
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmUfXmlGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow()  {
		frmUfXmlGenerator = new JFrame();
		frmUfXmlGenerator.setTitle("UF xml generator");
		frmUfXmlGenerator.setBounds(100, 100, 898, 546);
		frmUfXmlGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUfXmlGenerator.getContentPane().setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBounds(12, 134, 856, 127);
		frmUfXmlGenerator.getContentPane().add(contentPane_1);
		contentPane_1.setLayout(null);
		
		ChangeStatusAction action = new ChangeStatusAction();
		action.setBounds(12, 37, 832, 77);
		contentPane_1.add(action);
		action.setLayout(null);
		
		JPanel generalPanel = new JPanel();
		generalPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		generalPanel.setBounds(578, 20, 1, 1);
		contentPane_1.add(generalPanel);
		generalPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(12, 13, 856, 112);
		frmUfXmlGenerator.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 10, 191, 75);
		panel.add(panel_1);
		
		Label label = new Label("\u015Arodowisko");
		label.setBounds(55, 10, 81, 24);
		panel_1.add(label);
		
		JRadioButton radioButton = new JRadioButton("-2", true);
		radioButton.setBounds(19, 36, 41, 25);
		panel_1.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("-1");
		radioButton_1.setBounds(76, 36, 41, 25);
		panel_1.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("PROD");
		radioButton_2.setBounds(121, 36, 61, 25);
		panel_1.add(radioButton_2);
		
		JLabel label_1 = new JLabel("Symbol Produktu");
		label_1.setBounds(246, 20, 105, 24);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Prefiks wniosku");
		label_2.setBounds(506, 20, 112, 24);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(363, 21, 116, 22);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(621, 21, 116, 22);
		panel.add(textField_1);
		
		JButton button = new JButton("Wczytaj plik");
		button.setBounds(239, 60, 112, 25);
		panel.add(button);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(363, 63, 374, 22);
		panel.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(749, 10, 95, 75);
		panel.add(panel_2);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(36, 41, 25, 25);
		panel_2.add(checkBox);
		
		JLabel label_3 = new JLabel("Pomi\u0144 b\u0142\u0119dy");
		label_3.setBounds(12, 16, 71, 16);
		panel_2.add(label_3);
		
	}
}
