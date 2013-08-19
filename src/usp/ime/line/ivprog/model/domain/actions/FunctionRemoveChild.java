package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComponent;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FunctionRemoveChild extends DomainAction {
	
	private IVPDomainModel model = null;
	private Function function = null;
	private CodeComponent removedChild = null;
	private int removedChildIndex = -1;
	
	public FunctionRemoveChild(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		removedChild = model.removeFunctionAChildFromIndex(removedChildIndex, function, _currentState);
	}

	protected void undoAction() {
		model.addFunctionAChildAtIndex(removedChildIndex, removedChild, function, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public int getRemovedChildIndex() {
		return removedChildIndex;
	}

	public void setRemovedChildIndex(int removedChildIndex) {
		this.removedChildIndex = removedChildIndex;
	}

}
