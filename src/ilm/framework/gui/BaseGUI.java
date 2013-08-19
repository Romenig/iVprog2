package ilm.framework.gui;

import ilm.framework.SystemFactory;
import ilm.framework.assignment.IAssignment;
import ilm.framework.config.SystemConfig;
import ilm.framework.modules.AssignmentModule;
import ilm.framework.modules.IlmModule;
import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import usp.ime.line.ivprog.view.utils.IconButtonUI;

import com.l2fprod.common.swing.plaf.LookAndFeelAddons;
import com.l2fprod.common.swing.plaf.windows.WindowsLookAndFeelAddons;

public abstract class BaseGUI extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	protected SystemConfig _config;
	protected SystemFactory _factory;
	protected Vector _domainGUIList;
	protected Vector _authoringGUIList;
	protected IAssignment _assignments;
	protected int _activeAssignment;

	public void setComponents(SystemConfig config, IAssignment commands,
			SystemFactory factory) {
		_config = config;
		_config.addObserver(this);
		_factory = factory;
		_domainGUIList = new Vector();
		_authoringGUIList = new Vector();
		_assignments = commands;
		_activeAssignment = 0;
	}

	public void initGUI() {
		initAssignments();
		initFrameworkButtons(_assignments.getIlmModuleList().values());
	}

	protected abstract void initAssignments();

	protected abstract void initFrameworkButtons(Collection moduleList);

	public void startDesktop() {
	    JFrame frame = new JFrame();
	    frame.getContentPane().add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024, 700);
		//frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	protected void updateAssignmentIndex(int index) {
		_activeAssignment = index;
		Iterator moduleIterator = _assignments.getIlmModuleList().values()
				.iterator();
		while (moduleIterator.hasNext()) {
			IlmModule module = (IlmModule) moduleIterator.next();
			module.setAssignmentIndex(index);
			if (module instanceof AssignmentModule) {
				AssignmentModule m = (AssignmentModule) module;
				if (m.getObserverType() != AssignmentModule.ACTION_OBSERVER) {
					m.update(_assignments.getCurrentState(index), null);
				}
			}
		}
	}

	protected abstract void initAuthoringButton();

	protected abstract void initNewAssignmentButton();

	protected abstract void initCloseAssignmentButton();

	protected abstract void initOpenAssignmentButton();

	protected abstract void initSaveAssignmentButton();

	protected abstract void startAuthoring();

	protected abstract void addNewAssignment();

	protected abstract void closeAssignment(int index);

	protected abstract void openAssignmentFile(String fileName);

	protected abstract void saveAssignmentFile(String fileName);

	protected JButton makeButton(String imageName, String actionCommand,String toolTipText, String altText) {
		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		try {
			button.setIcon(new ImageIcon(BaseGUI.class.getResource("/usp/ime/line/resources/" + imageName + ".png"), altText));
		} catch (Exception e) {
			System.err.println("Error: image './usp/ime/line/resources/"+ imageName	+ ".png' is missing: ilm/framework/gui/BaseGUI.java");
		}
		button.setUI(new IconButtonUI());
		return button;
	}
}
