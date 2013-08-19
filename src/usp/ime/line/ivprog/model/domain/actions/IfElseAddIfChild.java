package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComponent;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComposite;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IfElse;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IfElseAddIfChild extends DomainAction {

	private IVPDomainModel model = null;
	private IfElse ifElse = null;
	private CodeComposite aChild = null;
	private int childIndex = -1;
	
	public IfElseAddIfChild(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.addIfChildAtIndex(childIndex, aChild, ifElse, _currentState);
	}

	protected void undoAction() {
		model.removeIfChildFromIndex(childIndex, ifElse, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public IfElse getIfElse() {
		return ifElse;
	}

	public void setIfElse(IfElse ifElse) {
		this.ifElse = ifElse;
	}

	public int getChildIndex() {
		return childIndex;
	}

	public void setChildIndex(int childIndex) {
		this.childIndex = childIndex;
	}

	public CodeComposite getaChild() {
		return aChild;
	}

	public void setaChild(CodeComposite aChild) {
		this.aChild = aChild;
	}

}
