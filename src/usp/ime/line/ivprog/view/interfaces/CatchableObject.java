package usp.ime.line.ivprog.view.interfaces;

import javax.swing.JComponent;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.DataObject;
import usp.ime.line.ivprog.view.editor.IVPFunctionBody;

public interface CatchableObject extends ViewDomainObject {
	
	public JComponent getIVPContainer();
	public void setIVPConainer(JComponent container);
	public IVPFunctionBody getEscope();
	public void setEscope(IVPFunctionBody function);
	public void setIndexAtContainer(int index);
	public int getIndexOnContainer();
	
}
