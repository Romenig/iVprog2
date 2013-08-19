package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Expression;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.ReturnStatement;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class ReturnSetExpression extends DomainAction {

	private IVPDomainModel model = null;
	private ReturnStatement rStatement = null;
	private Expression returnedExpression = null;
	private Expression lastReturned = null;
	
	public ReturnSetExpression(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)model;
	}

	protected void executeAction() {
		lastReturned = model.setReturnExpression(returnedExpression, rStatement, _currentState);
	}

	protected void undoAction() {
		model.setReturnExpression(lastReturned, rStatement, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public ReturnStatement getReturnStatement() {
		return rStatement;
	}

	public void setReturnStatement(ReturnStatement rStatement) {
		this.rStatement = rStatement;
	}

	public Expression getReturnedExpression() {
		return returnedExpression;
	}

	public void setReturnedExpression(Expression returnedExpression) {
		this.returnedExpression = returnedExpression;
	}

}
