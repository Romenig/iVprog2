package usp.ime.line.ivprog.model.domain.actions;

import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPVectorRefSetReferenced extends DomainAction {

	public IVPVectorRefSetReferenced(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel model) {
	}

	protected void executeAction() {
	}

	protected void undoAction() {
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
