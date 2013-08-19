package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.ReturnStatement;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class ReturnSetType extends DomainAction {
	
	private IVPDomainModel model = null;
	private ReturnStatement rStatement = null;
	private short rStatementType = -1;
	private short lastType = -1;

	public ReturnSetType(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastType = model.setReturnStatementType(rStatementType, rStatement, _currentState);
	}

	protected void undoAction() {
		model.setReturnStatementType(lastType, rStatement, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public ReturnStatement getrStatement() {
		return rStatement;
	}

	public void setReturnStatement(ReturnStatement rStatement) {
		this.rStatement = rStatement;
	}

	public short getReturnStatementType() {
		return rStatementType;
	}

	public void setrStatementType(short rStatementType) {
		this.rStatementType = rStatementType;
	}

}
