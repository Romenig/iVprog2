package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.ReturnStatement;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class ReturnNewObject extends DomainAction {
	
	private IVPDomainModel model = null;
	private ReturnStatement rStatement = null;

	public ReturnNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		rStatement = model.createReturnStatement(_currentState);
	}

	protected void undoAction() {
		model.deleteReturnStatement(rStatement, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
