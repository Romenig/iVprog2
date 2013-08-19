package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Expression;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Operation;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class OperationSetExpB extends DomainAction {

	private IVPDomainModel model = null;
	private Operation operation = null;
	private Expression expB = null;
	private Expression lastExpB = null;
		
	public OperationSetExpB(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastExpB = model.setOperationExpressionB(expB, operation, _currentState);
	}

	protected void undoAction() {
		model.setOperationExpressionB(lastExpB, operation, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Expression getExpB() {
		return expB;
	}

	public void setExpB(Expression expB) {
		this.expB = expB;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}


}
