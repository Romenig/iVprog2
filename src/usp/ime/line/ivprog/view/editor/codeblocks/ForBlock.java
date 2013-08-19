package usp.ime.line.ivprog.view.editor.codeblocks;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.DataObject;
import usp.ime.line.ivprog.view.editor.IVPCanvas;
import usp.ime.line.ivprog.view.editor.IVPFunctionBody;
import usp.ime.line.ivprog.view.interfaces.CatchableObject;
import usp.ime.line.ivprog.view.interfaces.ViewDomainObject;

import javax.swing.BoxLayout;

public class ForBlock extends CodeBaseGUI implements CatchableObject, ViewDomainObject {

	private JPanel headerConainer;
	private JPanel canvasContainer;
	private DataObject forData;

	public ForBlock() {
		initHeaderContainer();
		initContractionBtn();
		initHeaderContent();
		initCanvasContainer();
		initCanvas();
	}

	private void initCanvas() {
		IVPCanvas canvas = new IVPCanvas(true, this);
		canvasContainer.add(canvas);
	}

	private void initCanvasContainer() {
		canvasContainer = new JPanel();
		compositePanel.add(canvasContainer, BorderLayout.CENTER);
		canvasContainer.setLayout(new BoxLayout(canvasContainer, BoxLayout.X_AXIS));
	}

	private void initHeaderContent() {
		JLabel forLbl = new JLabel("Para");
		headerConainer.add(forLbl);
		
		//ExpressionDropTarget dropTarget = new ExpressionDropTarget();
		//headerConainer.add(dropTarget);
		
		JLabel timesDoLbl = new JLabel("vezes. Fa\u00E7a:");
		headerConainer.add(timesDoLbl);
	}

	private void initContractionBtn() {
		JButton contractionBtn = new JButton("");
		headerConainer.add(contractionBtn);
	}

	private void initHeaderContainer() {
		headerConainer = new JPanel();
		FlowLayout fl_headerConainer = (FlowLayout) headerConainer.getLayout();
		fl_headerConainer.setAlignment(FlowLayout.LEFT);
		compositePanel.add(headerConainer, BorderLayout.NORTH);
	}

	public CatchableObject getCatchable() {
		return this;
	}

	public JComponent getIVPContainer() {
		return ivpContainer;
	}

	public void setIVPConainer(JComponent container) {
		ivpContainer = container;
	}

	public IVPFunctionBody getEscope() {
		return escope;
	}

	public void setEscope(IVPFunctionBody function) {
		escope = function;
	}

	public void setIndexAtContainer(int index) {
		indexAtContainer = index;
	}

	public int getIndexOnContainer() {
		return indexAtContainer;
	}

	public DataObject getDataObject() {
		return forData;
	}

	public void setDataObject(DataObject forDataObject) {
		forData = forDataObject;
	}

}
