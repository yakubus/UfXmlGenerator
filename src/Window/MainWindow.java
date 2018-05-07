package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Metods.FileGenerator;
import Metods.PartXmlGenerator;
import WindowBuilder.GeneralProperties;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JComboBox;

public class MainWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private JTextField tfProductSymbol;
	private JTextField tfPrefix;
	private JTextField tfFile;
	
	private JButton btnGetFile;
	private JButton btnGenerateXml;
	
	private JComboBox cbAction1; 
	
	private JCheckBox chbActiveA1;
	private JCheckBox chbSkipError;
	
	private JLabel lbSetAction1;
	
	private JPanel panelAction1;
	
	private ChangeStatusAction changeStatusAction;
	private UpdateValue updateValue;
	private CallAction callAction;
	
	public File file;
	private static String[] actionList = {"---wybierz---", "Zmiana statusu", "Wykonanie akcji", "Zmiana wartoœci pola"};
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("UF xml generator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel generalPanel = new JPanel();
		generalPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		generalPanel.setBounds(12, 13, 856, 99);
		contentPane.add(generalPanel);
		generalPanel.setLayout(null);
		
		
		JPanel panelEnvironment = new JPanel();
		panelEnvironment.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelEnvironment.setBounds(12, 10, 191, 75);
		generalPanel.add(panelEnvironment);
		panelEnvironment.setLayout(null);
		
		Label lbEnvironment = new Label("\u015Arodowisko");
		lbEnvironment.setBounds(55, 10, 81, 24);
		panelEnvironment.add(lbEnvironment);
		
		JRadioButton rbE2 = new JRadioButton("-2", true);
		rbE2.setBounds(19, 36, 41, 25);
		panelEnvironment.add(rbE2);
		
		JRadioButton rbE1 = new JRadioButton("-1");
		rbE1.setBounds(76, 36, 41, 25);
		panelEnvironment.add(rbE1);
		
		JRadioButton rbEProd = new JRadioButton("PROD");
		rbEProd.setBounds(121, 36, 61, 25);
		panelEnvironment.add(rbEProd);
		
		ButtonGroup bGroupEnvironment = new ButtonGroup();
		bGroupEnvironment.add(rbE1);
		bGroupEnvironment.add(rbE2);
		bGroupEnvironment.add(rbEProd);
		
		JLabel lbProductSymbol = new JLabel("Symbol Produktu");
		lbProductSymbol.setBounds(246, 20, 105, 24);
		generalPanel.add(lbProductSymbol);
		
		JLabel lbPrefix = new JLabel("Prefiks wniosku");
		lbPrefix.setBounds(506, 20, 112, 24);
		generalPanel.add(lbPrefix);
		
		tfProductSymbol = new JTextField();
		tfProductSymbol.setBounds(363, 21, 116, 22);
		generalPanel.add(tfProductSymbol);
		tfProductSymbol.setColumns(10);
		
		tfPrefix = new JTextField();
		tfPrefix.setBounds(621, 21, 116, 22);
		generalPanel.add(tfPrefix);
		tfPrefix.setColumns(10);
		
		btnGetFile = new JButton("Wczytaj plik");
		btnGetFile.setBounds(239, 60, 112, 25);
		generalPanel.add(btnGetFile);
		btnGetFile.addActionListener(this);
		
		tfFile = new JTextField();
		tfFile.setBounds(363, 63, 374, 22);
		generalPanel.add(tfFile);
		tfFile.setColumns(10);
		
		JPanel panelSkipError = new JPanel();
		panelSkipError.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSkipError.setBounds(749, 10, 95, 75);
		generalPanel.add(panelSkipError);
		panelSkipError.setLayout(null);
		
		chbSkipError = new JCheckBox("");
		chbSkipError.setBounds(36, 41, 25, 25);
		panelSkipError.add(chbSkipError);
		
		JLabel lbSkipError = new JLabel("Pomi\u0144 b\u0142\u0119dy");
		lbSkipError.setBounds(12, 16, 71, 16);
		panelSkipError.add(lbSkipError);
		
		panelAction1 = new JPanel();
		panelAction1.setToolTipText("");
		panelAction1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAction1.setBounds(12, 125, 856, 115);
		contentPane.add(panelAction1);
		panelAction1.setLayout(null);		
		
		
		cbAction1 = new JComboBox(actionList);
		cbAction1.setBounds(105, 9, 220, 22);
		panelAction1.add(cbAction1);
		cbAction1.addActionListener(this);
		cbAction1.setVisible(false);
		
		
		lbSetAction1 = new JLabel("Wybierz akcj\u0119");
		lbSetAction1.setBounds(12, 9, 98, 22);
		panelAction1.add(lbSetAction1);
		
		chbActiveA1 = new JCheckBox("Active");
		chbActiveA1.setBounds(777, 8, 71, 25);
		panelAction1.add(chbActiveA1);
		chbActiveA1.addActionListener(this);
		
		changeStatusAction = new ChangeStatusAction();
		changeStatusAction.setLayout(null);
		changeStatusAction.setBounds(12, 44, 832, 56);
		panelAction1.add(changeStatusAction);
		changeStatusAction.setVisible(false);
		
		updateValue = new UpdateValue();
		updateValue.setLayout(null);
		updateValue.setBounds(12, 44, 832, 56);
		panelAction1.add(updateValue);
		updateValue.setVisible(false);
		
		callAction = new CallAction();
		callAction.setLayout(null);
		callAction.setBounds(12, 44, 832, 56);
		panelAction1.add(callAction);
		
		btnGenerateXml = new JButton("Generuj XML");
		btnGenerateXml.setBounds(727, 443, 125, 43);
		contentPane.add(btnGenerateXml);
		callAction.setVisible(false);
		btnGenerateXml.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == btnGetFile) {
			JFileChooser fc = new JFileChooser();
			if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
				tfFile.setText(file.getAbsolutePath());
			}				

		}
		else if(source == chbActiveA1) {
			if (chbActiveA1.isSelected()) {
				cbAction1.setVisible(true);
			} else {
				cbAction1.setVisible(false);
			}
		}else if (source == cbAction1) {
			String tmp = (String)cbAction1.getSelectedItem();
			if (tmp.equals("Zmiana statusu")){
					changeStatusAction.setVisible(true);
					updateValue.setVisible(false);
					callAction.setVisible(false);
			}else if (tmp.equals("Zmiana wartoœci pola")){
				updateValue.setVisible(true);
				changeStatusAction.setVisible(false);
				callAction.setVisible(false);
			}else if (tmp.equals("Wykonanie akcji")){
				callAction.setVisible(true);
				changeStatusAction.setVisible(false);
				updateValue.setVisible(false);
			}else {
				callAction.setVisible(false);
				changeStatusAction.setVisible(false);
				updateValue.setVisible(false);
			}
		}else if (source == btnGenerateXml) {
			try {
				GenerateXmlBtnAction();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private void GenerateXmlBtnAction() throws FileNotFoundException {
	
	//do dorobienia licznik akcji
	PartXmlGenerator[] PXG = new PartXmlGenerator[1];
	GeneralProperties properties = new GeneralProperties(tfPrefix.getText(), "O", "PROD", tfProductSymbol.getText(), chbSkipError.isSelected());
	
	
	
	//stworzenie listy akcji
	String tmp = (String)cbAction1.getSelectedItem();
	if (tmp.equals("Zmiana statusu")){
		PXG[0]= (PartXmlGenerator) changeStatusAction;
	}else if (tmp.equals("Zmiana wartoœci pola")){
		PXG[0]= (PartXmlGenerator) updateValue;
	}else if (tmp.equals("Wykonanie akcji")){
		PXG[0]= (PartXmlGenerator) callAction;
	}else {
		
	}
	FileGenerator fileGenerator = new FileGenerator(file, "C:\\UfXmlGenerator", chbSkipError.isSelected(), PXG, properties);
	
	fileGenerator.CallGenerate();
	}
}
