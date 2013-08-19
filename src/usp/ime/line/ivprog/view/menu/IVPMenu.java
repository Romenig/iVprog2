package usp.ime.line.ivprog.view.menu;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import usp.ime.line.ivprog.view.constants.CommonNames;
import usp.ime.line.ivprog.view.editor.codeblocks.CodeMiniPanel;
import usp.ime.line.ivprog.view.utils.language.ResourceBundleIVP;

import com.l2fprod.common.swing.JTaskPaneGroup;
import com.l2fprod.common.swing.JTaskPane;

public class IVPMenu extends JPanel {

	private JTabbedPane tabbedPane;
	private JPanel ivpCodeMenu;
	private JPanel ivpFunctionsMenu;
	private JTaskPaneGroup taskPaneGroup;
	private JTaskPane codeTaskPane;
	private JTaskPane functionTaskPane;
	
	private JTaskPaneGroup commands;
	private JTaskPaneGroup comparison;
	private JTaskPaneGroup algebra;
	private JTaskPaneGroup functions;
	private JTaskPaneGroup preConstructedfunctions;

	public IVPMenu() {
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(10, 10, 0, 0));
		setPreferredSize(new Dimension(250,10));
		initTabbedPane();
		initCodeMenu();
		initCodeTaskPane();
		initFunctionMenu();
		initFunctionTaskPane();
	}

	private void initFunctionMenu() {
		ivpFunctionsMenu = new JPanel();
		tabbedPane.addTab(ResourceBundleIVP.getString("functionMenuTitle"), null, ivpFunctionsMenu, null);
		ivpFunctionsMenu.setLayout(new BorderLayout(0, 0));

	}

	private void initFunctionTaskPane() {
		functionTaskPane = new JTaskPane();
		ivpFunctionsMenu.add(functionTaskPane, BorderLayout.CENTER);
	}

	private void initTabbedPane() {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
	}

	private void initCodeMenu() {
		ivpCodeMenu = new JPanel();
		tabbedPane.addTab(ResourceBundleIVP.getString("codeBlocksMenuTitle"), null, ivpCodeMenu, null);
		ivpCodeMenu.setLayout(new BorderLayout(0, 0));

	}

	private void initCodeTaskPane() {
		codeTaskPane = new JTaskPane();
		ivpCodeMenu.add(codeTaskPane);
		initTaskPaneGroupCommands();
	}
	
	private void initTaskPaneGroupCommands(){
		commands = new JTaskPaneGroup();
		JComponent miniFor = new CodeMiniPanel(ResourceBundleIVP.getString("forMenuString"), CommonNames.FOR_MINI);
		JComponent miniWhile = new CodeMiniPanel(ResourceBundleIVP.getString("whileMenuString"), CommonNames.WHILE_MINI);
		JComponent miniIfElse = new CodeMiniPanel(ResourceBundleIVP.getString("ifElseMenuString"), CommonNames.IFELSE_MINI);
		JComponent miniPrint = new CodeMiniPanel(ResourceBundleIVP.getString("printMenuString"), CommonNames.PRINT_MINI);
		commands.add(miniFor);
		commands.add(miniWhile);
		commands.add(miniIfElse);
		commands.add(miniPrint);
		codeTaskPane.add(commands);
	}
	
	private void initTaskPaneGroupComparison(){
		
	}
	
	private void initTaskPaneGroupAlgebra(){
		
	}
	
	private void initTaskPaneGroupFunction(){
		
	}
	
	private void initTaskPaneGroupPreConstructedFunctions(){
		
	}
	
	

}
