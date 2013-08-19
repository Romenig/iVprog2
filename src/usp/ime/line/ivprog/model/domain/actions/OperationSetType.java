package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Operation;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class OperationSetType extends DomainAction {
	
	private IVPDomainModel model = null;
	private Operation operation = null;
	private short operationType = -1;
	private short lastType = -1;

	public OperationSetType(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastType = model.setOperationType(operationType, operation, _currentState);
	}

	protected void undoAction() {
		model.setOperationType(lastType, operation, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public short getOperationType() {
		return operationType;
	}

	public void setOperationType(short operationType) {
		this.operationType = operationType;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}
