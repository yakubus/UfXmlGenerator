package Window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateValue extends JPanel{
	
	private JPanel panelUpdateValue;
	
	private JLabel lbFieldSymbol;
	private JTextField tfFieldSymbol;
	
	private JLabel lbFieldNewValue;
	private JTextField tfFieldNewValue;
	
	public UpdateValue() {
		
		panelUpdateValue = new JPanel();
		panelUpdateValue.setBounds(12, 42, 832, 80);
		panelUpdateValue.setLayout(null);
		add(panelUpdateValue);
		
		lbFieldSymbol = new JLabel("Symbol pola");
		lbFieldSymbol.setBounds(12, 13, 100, 16);
		add(lbFieldSymbol);
		
		tfFieldSymbol  = new JTextField();
		tfFieldSymbol.setBounds(120, 10, 200, 22);
		add(tfFieldSymbol);
		tfFieldSymbol.setColumns(10);
		
		lbFieldNewValue = new JLabel("Nowa wartoœæ");
		lbFieldNewValue.setBounds(390, 13, 100, 16);
		add(lbFieldNewValue);
		
		tfFieldNewValue  = new JTextField();
		tfFieldNewValue.setBounds(500, 10, 228, 22);
		add(tfFieldNewValue);
		tfFieldNewValue.setColumns(10);
	}
	

}
