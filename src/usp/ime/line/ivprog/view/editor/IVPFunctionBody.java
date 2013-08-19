package usp.ime.line.ivprog.view.editor;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

import usp.ime.line.ivprog.IVProg2;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.DataObject;
import usp.ime.line.ivprog.view.editor.codeblocks.ForBlock;
import usp.ime.line.ivprog.view.interfaces.CatchableObject;
import usp.ime.line.ivprog.view.interfaces.ViewDomainObject;

public class IVPFunctionBody extends JPanel implements ViewDomainObject{
	
	private JScrollPane scrollPane;
	private IVPCanvas canvas;
	private JPanel variablePanelContainer;
	private String functionName = null;
	private DataObject functionData = null;

	public IVPFunctionBody() {
		setLayout(new BorderLayout(0, 0));
		initScroll();
		initCanvas();
		initVariableContainer();
		addMouseListener(IVProg2.getMouseListener());
	}

	private void initVariableContainer() {
		variablePanelContainer = new JPanel();
		add(variablePanelContainer, BorderLayout.NORTH);
	}

	private void initCanvas() {
		canvas = new IVPCanvas(false, this);
		scrollPane.setViewportView(canvas);
	}

	private void initScroll() {
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
	}
	
	public void addToCanvas(ViewDomainObject component){
		canvas.addComponentToCanvas((CatchableObject) component);
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public DataObject getDataObject() {
		return functionData;
	}

	public void setDataObject(DataObject o) {
		functionData = o;
	}

}
