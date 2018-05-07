package Window;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Metods.PartXmlGenerator;

public class CallAction extends JPanel implements PartXmlGenerator {

	private JPanel panelCallAction;
	private JLabel lbActionName;
	private JTextField tfActionName;
	
	public CallAction() {
		super();
		panelCallAction = new JPanel();
		panelCallAction.setBounds(12, 42, 832, 73);
		panelCallAction.setLayout(null);
		add(panelCallAction);
		
		lbActionName = new JLabel("Symbol akcji do wykonania");
		lbActionName.setBounds(12, 13, 180, 16);
		add(lbActionName);
		
		tfActionName = new JTextField();
		tfActionName.setBounds(300, 10, 228, 22);
		add(tfActionName);
		tfActionName.setColumns(10);
		
	}

	@Override
	public String GeneratePart() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
