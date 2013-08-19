package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IfElse;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IfElseNewObject extends DomainAction {

	private IVPDomainModel model = null;
	private IfElse createdIfElse = null;
	
	public IfElseNewObject(String name, String description) {
		super(name, description);

	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		createdIfElse = model.createIfElse(_currentState);
	}
	
	protected void undoAction() {
		model.deleteIfElse(createdIfElse, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
