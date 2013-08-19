package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Operation;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class OperationNewObject extends DomainAction {
	
	private IVPDomainModel model = null;
	private Operation createdOperation = null;

	public OperationNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		createdOperation = model.createOperation(_currentState);
	}

	protected void undoAction() {
		model.deleteOperation(createdOperation, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
