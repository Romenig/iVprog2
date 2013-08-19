package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FunctionRemove extends DomainAction {
	
	private IVPDomainModel model = null;
	private Function removedFunction = null;

	public FunctionRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.deleteFunction(removedFunction, _currentState);
	}

	protected void undoAction() {
		model.restoreFunction(removedFunction, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Function getRemovedFunction() {
		return removedFunction;
	}

	public void setRemovedFunction(Function removedFunction) {
		this.removedFunction = removedFunction;
	}

}
