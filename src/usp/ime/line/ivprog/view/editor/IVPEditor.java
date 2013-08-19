package usp.ime.line.ivprog.view.editor;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTabbedPane;

import com.l2fprod.common.swing.JTaskPane;

import usp.ime.line.ivprog.view.constants.CommonColors;

public class IVPEditor extends JTaskPane {
	
	private JTabbedPane tabbedPane;

	public IVPEditor() {
		setLayout(new BorderLayout(0, 0));
		initTabbedPane();
	}

	private void initTabbedPane() {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
	}
	
	public void addTab(String tabName, JComponent c){
		tabbedPane.add(tabName, c);
	}
	
	public void removeTabAtIndex(int index){
		tabbedPane.remove(index);
	}
	
	public void updateFunction(IVPFunctionBody function){
		if(tabbedPane.getTabCount() == 0){
			tabbedPane.add(function, function.getFunctionName());
			return;
		}
		for(int i = 0; i < tabbedPane.getTabCount(); i++){
			if(tabbedPane.getTitleAt(i).equals(function.getFunctionName())){
				tabbedPane.remove(i);
				tabbedPane.add(function, i);
			}
		}
	}

}
