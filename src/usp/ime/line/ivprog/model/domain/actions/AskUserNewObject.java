package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AskUser;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class AskUserNewObject extends DomainAction {

	private IVPDomainModel model = null;
	private AskUser createdAskUser = null;

	public AskUserNewObject(String name, String description) {
		super(name, description);
	}
	
	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		createdAskUser = model.createAskUser(_currentState);	
	}

	protected void undoAction() {
		model.deleteAskUser(createdAskUser, _currentState); 
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
