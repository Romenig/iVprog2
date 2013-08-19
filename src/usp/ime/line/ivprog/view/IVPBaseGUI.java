package usp.ime.line.ivprog.view;

import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import java.util.Vector;

import ilm.framework.IlmProtocol;
import ilm.framework.assignment.Assignment;
import ilm.framework.assignment.model.AssignmentState;
import ilm.framework.domain.DomainGUI;
import ilm.framework.gui.AuthoringGUI;
import ilm.framework.gui.BaseGUI;
import ilm.framework.modules.IlmModule;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import usp.ime.line.ivprog.view.constants.CommonNames;
import usp.ime.line.ivprog.view.editor.IVPCanvas;
import usp.ime.line.ivprog.view.editor.codeblocks.CodeMiniPanel;
import usp.ime.line.ivprog.view.utils.IVPMouseListener;
import usp.ime.line.ivprog.view.utils.IconButtonUI;
import usp.ime.line.ivprog.view.utils.RoundedJPanel;
import usp.ime.line.ivprog.view.utils.language.ResourceBundleIVP;

import com.l2fprod.common.swing.JLinkButton;
import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.JTaskPaneGroup;
import com.l2fprod.common.swing.PercentLayout;
import com.l2fprod.common.swing.plaf.windows.WindowsLinkButtonUI;
import com.l2fprod.common.swing.plaf.windows.WindowsTaskPaneGroupUI;
import com.l2fprod.common.swing.plaf.windows.WindowsTaskPaneUI;

import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

public class IVPBaseGUI extends BaseGUI {

	private JPanel footer;
	private JPanel content;
	private JPanel header;
	private JPanel frameworkMenuPanel;
	private JTabbedPane tabbedPane;
	private int tabCount = 0;
	private JButton authoringBtn;
	private JButton newAssBtn;
	private JButton closeAssBtn;
	private JButton openAssBtn;
	private JButton saveAssBtn;
	private JButton historyBtn;
	private JButton undoBtn;
	private JButton redoBtn;
	private JButton evaluationBtn;
	private JButton objectBtn;
	private IVPDomainGUI currentGUI;

	public IVPBaseGUI() {
		setLayout(new BorderLayout(0, 0));
		initHeader();
		initTabbedPane();
		initFooter();
		initContent();
		initFrameworkMenu();
	}
	
	private void initFrameworkMenu() {
		initFrameworkMenuGroup();
		initIVPCodeBlocksMenu();
	}

	private void initTabbedPane() {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				setActiveAssignment();
			}
		});
		tabCount = 0;
	}

	private void initFrameworkMenuGroup() {
		header.setLayout(new BorderLayout(0, 0));
		frameworkMenuPanel = new JPanel();
		frameworkMenuPanel.setOpaque(false);
		FlowLayout fl_frameworkMenuPanel = new FlowLayout();
		fl_frameworkMenuPanel.setVgap(0);
		fl_frameworkMenuPanel.setHgap(10);
		fl_frameworkMenuPanel.setAlignment(FlowLayout.LEFT);
		frameworkMenuPanel.setLayout(fl_frameworkMenuPanel);
		header.add(frameworkMenuPanel, BorderLayout.CENTER);
	}

	private void initHeader() {
		header = new JPanel();
		header.setBorder(new EmptyBorder(10,0,0,0));
		add(header, BorderLayout.NORTH);
	}

	private void initContent() {
		content = new JPanel();
		add(content, BorderLayout.CENTER);
		content.setLayout(new BorderLayout(0, 0));

	}

	private void initFooter() {
		footer = new JPanel();
		add(footer, BorderLayout.SOUTH);
	}

	// #################### BEGIN framework methods ####################
	public void update(Observable arg0, Object arg1) {
	}

	protected void initAssignments() {
		if (_assignments.getNumberOfAssignments() == 1) {
			tabbedPane.setVisible(false);
			_domainGUIList.add(_factory.createDomainGUI(_config,_factory.getDomainModel(_config)));
			int index = _domainGUIList.size() - 1;
			((DomainGUI) _domainGUIList.get(index)).setAssignment(_assignments.getProposition(0), _assignments.getCurrentState(0),_assignments.getIlmModuleList().values());
			content.add((Component) _domainGUIList.get(index),BorderLayout.CENTER);
			_authoringGUIList.add(_factory.createAuthoringGUI((DomainGUI) _domainGUIList.get(index),_assignments.getProposition(0),_assignments.getInitialState(0),	_assignments.getCurrentState(0),_assignments.getExpectedAnswer(0),_assignments.getConfig(0), _assignments.getMetadata(0)));
			setActiveAssignment();
		} else {
			content.add(tabbedPane, BorderLayout.CENTER);
			for (int i = 0; i < _assignments.getNumberOfAssignments(); i++) {
				tabbedPane.setVisible(true);
				initAssignment(_assignments.getCurrentState(i));
			}
		}
	}

	private void initAssignment(AssignmentState curState) {
		_domainGUIList.add(_factory.createDomainGUI(_config,_factory.getDomainModel(_config)));
		int index = _domainGUIList.size() - 1;
		((DomainGUI) _domainGUIList.get(index)).setAssignment(_assignments.getProposition(index), curState, _assignments.getIlmModuleList().values());
		tabbedPane.addTab("assign" + (tabCount++),(Component) _domainGUIList.get(index));
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		setActiveAssignment();
		_authoringGUIList.add(_factory.createAuthoringGUI((DomainGUI) _domainGUIList.get(index),_assignments.getProposition(index),_assignments.getInitialState(index),_assignments.getCurrentState(index),_assignments.getExpectedAnswer(index),_assignments.getConfig(index),_assignments.getMetadata(index)));
	}

	protected void setActiveAssignment() {
		int index = tabbedPane.getSelectedIndex();
		if (index == -1) {
			updateAssignmentIndex(0);
			currentGUI = (IVPDomainGUI) _domainGUIList.get(0);
		} else {
			updateAssignmentIndex(index);
			currentGUI = (IVPDomainGUI) _domainGUIList.get(index);
		}
	}

	protected void initFrameworkButtons(Collection moduleList) {
		initAuthoringButton();
		initNewAssignmentButton();
		initCloseAssignmentButton();
		initOpenAssignmentButton();
		initSaveAssignmentButton();
		Vector buttonsVector = new Vector();
		Object[] modules = (Object[]) moduleList.toArray();
		for (int i = 0; i < modules.length; i++) {
			Component[] components = ((IlmModule) modules[i]).getGUI()
					.getComponents();
			for (int j = 0; j < components.length; j++) {
				buttonsVector.add(components[j]);
			}
		}
		recoverButtonsFromModules(buttonsVector);
		initFrameworkMenuPanelLayout();

	}

	

	protected void initAuthoringButton() {
		authoringBtn = makeButton("authoring", "ASSIGNMENT AUTHORING",
				ResourceBundleIVP.getString("authoringBtn.Tip"),
				ResourceBundleIVP.getString("authoringBtn.AltText"));
		authoringBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startAuthoring();
			}
		});
	}

	protected void initNewAssignmentButton() {
		newAssBtn = makeButton("newassignment", "NEW ASSIGNMENT",
				ResourceBundleIVP.getString("newAssBtn.Tip"),
				ResourceBundleIVP.getString("newAssBtn.AltText"));
		newAssBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewAssignment();
			}
		});
	}

	protected void initCloseAssignmentButton() {
		closeAssBtn = makeButton("closeassignment", "CLOSE ASSIGNMENT",
				ResourceBundleIVP.getString("closeAssBtn.Tip"),
				ResourceBundleIVP.getString("closeAssBtn.AltText"));
		closeAssBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeAssignment(tabbedPane.getSelectedIndex());
			}
		});
		updateCloseButton();
	}

	protected void initOpenAssignmentButton() {
		openAssBtn = makeButton("openassignment", "OPEN ASSIGNMENT FILE",
				ResourceBundleIVP.getString("openAssBtn.Tip"),
				ResourceBundleIVP.getString("openAssBtn.AltText"));
		openAssBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openAssignmentFile(getFileNameFromWindow("Choose file"));
			}
		});
	}

	protected void initSaveAssignmentButton() {
		saveAssBtn = makeButton("save", "SAVE ASSIGNMENT FILE",
				ResourceBundleIVP.getString("saveAssBtn.Tip"),
				ResourceBundleIVP.getString("saveAss.AltText"));
		saveAssBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAssignmentFile(getFileNameFromWindow("Choose filename"));
			}
		});
	}

	protected void startAuthoring() {
		((JFrame) _authoringGUIList.get(_activeAssignment)).setVisible(true);
	}

	protected void addNewAssignment() {
		if (_assignments.getNumberOfAssignments() == 1) {
			content.removeAll();
			content.add(tabbedPane, BorderLayout.CENTER);
			tabbedPane.setVisible(true);
			tabbedPane.addTab("assign" + (tabCount++),(Component) _domainGUIList.get(0));
			AssignmentState state = _assignments.newAssignment();
			initAssignment(state);
		} else {
			initAssignment(_assignments.newAssignment());
		}
		updateCloseButton();
	}

	protected void closeAssignment(int index) {
		if (_assignments.getNumberOfAssignments() == 1) {
		} else if (_assignments.getNumberOfAssignments() == 2) {
			closeActiveAssignment();
			content.removeAll();
			content.add((Component) _domainGUIList.get(0), BorderLayout.CENTER);
			((JComponent) _domainGUIList.get(0)).setVisible(true);
			updateCloseButton();
		} else {
			closeActiveAssignment();
		}
	}

	protected void openAssignmentFile(String fileName) {
		if (fileName == null) {
			return;
		}
		int initialIndex = _assignments.openAssignmentPackage(fileName);
		for (int i = initialIndex; i < _assignments.getNumberOfAssignments(); i++) {
			if (_domainGUIList.size() == 1) {
				content.removeAll();
				content.add(tabbedPane, BorderLayout.CENTER);
				tabbedPane.setVisible(true);
				tabbedPane.addTab("assign" + (tabCount++),
						(Component) _domainGUIList.get(0));
			}
			initAssignment(_assignments.getCurrentState(i));
		}
		updateCloseButton();
	}

	protected void saveAssignmentFile(String fileName) {
		if (fileName == null) {
			return;
		}
		Vector list = new Vector();
		for (int i = 0; i < _assignments.getNumberOfAssignments(); i++) {
			if (((AuthoringGUI) _authoringGUIList.get(i)).getProposition()
					.length() > 1) {
				list.add(((AuthoringGUI) _authoringGUIList.get(i))
						.getAssignment());
			} else {
				Assignment a = new Assignment(_assignments.getProposition(i),
						_assignments.getInitialState(i),
						_assignments.getCurrentState(i),
						_assignments.getExpectedAnswer(i));
				if (tabbedPane.getTabCount() == 0) {
					a.setName(IlmProtocol.ASSIGNMENT_FILE_NODE + tabCount);
				} else {
					a.setName(tabbedPane.getTitleAt(i));
				}
				a.setConfig(_assignments.getConfig(i));
				a.setMetadata(_assignments.getMetadata(i));
				list.add(a);
			}
		}
		_assignments.saveAssignmentPackage(list, fileName);
	}

	// #################### END framework methods ####################
	
	// #################### BEGIN Support methods (Framework and Romenig's) ####################
	
	private void initFrameworkMenuPanelLayout() {
		addButtonToFrameworkMenu(0, 0, openAssBtn);
		addButtonToFrameworkMenu(1, 0, closeAssBtn);
		addButtonToFrameworkMenu(2, 0, newAssBtn);
		addButtonToFrameworkMenu(3, 0, authoringBtn);
		addButtonToFrameworkMenu(4, 0, saveAssBtn);
		addButtonToFrameworkMenu(0, 1, undoBtn);
		addButtonToFrameworkMenu(1, 1, redoBtn);
		addButtonToFrameworkMenu(2, 1, objectBtn);
		addButtonToFrameworkMenu(3, 1, historyBtn);
		addButtonToFrameworkMenu(4, 1, evaluationBtn);
	}

	private void addButtonToFrameworkMenu(int line, int column, JButton button) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = line;
		gbc.gridy = column;
		gbc.insets = new Insets(5, 5, 5, 5);
		frameworkMenuPanel.add(button);
	}

	private void recoverButtonsFromModules(Vector buttonsVector) {
		// HARDCODED > Sorry!
		// Vector positions are occupied by:
		// historyBtn; undoBtn; redoBtn; evaluationBtn; objectBtn.
		historyBtn = (JButton) buttonsVector.get(0);
		undoBtn = (JButton) buttonsVector.get(1);
		redoBtn = (JButton) buttonsVector.get(2);
		evaluationBtn = (JButton) buttonsVector.get(3);
		objectBtn = (JButton) buttonsVector.get(4);
	} 
	
	private String getFileNameFromWindow(String option) {
		JFileChooser fc = new JFileChooser();
		int returnval = fc.showDialog(this, option);
		if (returnval == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile().getAbsolutePath();
		} else if (returnval == JFileChooser.ERROR_OPTION) {
			JOptionPane.showMessageDialog(this, "Error while choosing file.",
					"Error file", JOptionPane.OK_OPTION);
		}
		return null;
	}

	private void updateCloseButton() {
		if (_assignments.getNumberOfAssignments() == 1) {
			closeAssBtn.setEnabled(false);
		} else {
			closeAssBtn.setEnabled(true);
		}
	}

	private void closeActiveAssignment() {
		int index = _activeAssignment;
		_assignments.closeAssignment(index);
		tabbedPane.remove(index);
		_domainGUIList.remove(index);
		_authoringGUIList.remove(index);
		setActiveAssignment();
	}

	private void initIVPCodeBlocksMenu() {
	}
	
}
