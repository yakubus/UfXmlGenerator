package Window;


import java.awt.HeadlessException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ChangeStatusAction extends JPanel{
	
	private JPanel panelChangeState;
	private JLabel lbTargetStatus;
	private JTextField tfTargetStatus;
		
	

	public ChangeStatusAction() throws HeadlessException {
		super();
		
		panelChangeState = new JPanel();
		panelChangeState.setBounds(12, 42, 832, 73);
		panelChangeState.setLayout(null);
		add(panelChangeState);
		
		
		lbTargetStatus = new JLabel("Symbol statusu docelowego");
		lbTargetStatus.setBounds(12, 13, 180, 16);
		add(lbTargetStatus);
		
		tfTargetStatus = new JTextField();
		tfTargetStatus.setBounds(300, 10, 228, 22);
		add(tfTargetStatus);
		tfTargetStatus.setColumns(10);
	}
}
