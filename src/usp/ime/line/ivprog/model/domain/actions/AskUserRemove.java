package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AskUser;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class AskUserRemove extends DomainAction {

	private IVPDomainModel model = null;
	private AskUser removedAskUser = null;
	
	public AskUserRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		model.deleteAskUser(removedAskUser, _currentState);
	}

	protected void undoAction() {
		model.restoreAskUser(removedAskUser, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public AskUser getRemovedAskUser() {
		return removedAskUser;
	}

	public void setRemovedAskUser(AskUser removedAskUser) {
		this.removedAskUser = removedAskUser;
	}

}
