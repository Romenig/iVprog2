package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.For;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class ForRemove extends DomainAction {

	private IVPDomainModel model = null;
	private For deletedFor = null;
	
	public ForRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		model.deleteFor(deletedFor, _currentState);
	}

	protected void undoAction() {
		model.restoreFor(deletedFor, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public For getDeletedFor() {
		return deletedFor;
	}

	public void setDeletedFor(For deletedFor) {
		this.deletedFor = deletedFor;
	}

}
