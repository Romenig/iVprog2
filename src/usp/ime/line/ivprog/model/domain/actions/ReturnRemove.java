package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.ReturnStatement;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class ReturnRemove extends DomainAction {

	private IVPDomainModel model = null;
	private ReturnStatement rStatement = null;
	
	public ReturnRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.deleteReturnStatement(rStatement, _currentState);
	}

	protected void undoAction() {
		model.restoreReturnStatement(rStatement, _currentState);
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

}
