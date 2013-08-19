package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Operation;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class OperationRemove extends DomainAction {
	
	private IVPDomainModel model = null;
	private Operation operation = null;

	public OperationRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.deleteOperation(operation, _currentState);
	}

	protected void undoAction() {
		model.restoreOperation(operation, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}
