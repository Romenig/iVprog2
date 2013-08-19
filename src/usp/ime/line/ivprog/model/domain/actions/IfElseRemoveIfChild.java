package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComponent;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComposite;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IfElse;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IfElseRemoveIfChild extends DomainAction{

	private IVPDomainModel model = null;
	private IfElse ifElse = null;
	private CodeComponent removedChild = null;
	private int removedIndex = -1;

	public IfElseRemoveIfChild(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction(){
		removedChild = model.removeIfChildFromIndex(removedIndex, ifElse, _currentState);
	}

	protected void undoAction() {
		model.addIfChildAtIndex(removedIndex, removedChild, ifElse, _currentState);
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

	public int getRemovedIndex() {
		return removedIndex;
	}

	public void setRemovedIndex(int removedIndex) {
		this.removedIndex = removedIndex;
	}

}
