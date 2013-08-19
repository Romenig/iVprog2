package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Expression;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Operation;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class OperationSetExpA extends DomainAction {
	
	private IVPDomainModel model = null;
	private Operation operation = null;
	private Expression expA = null;
	private Expression lastExpA = null;
		
	public OperationSetExpA(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastExpA = model.setOperationExpressionA(expA, operation, _currentState);
	}

	protected void undoAction() {
		model.setOperationExpressionA(lastExpA, operation, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Expression getExpA() {
		return expA;
	}

	public void setExpA(Expression expA) {
		this.expA = expA;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}
