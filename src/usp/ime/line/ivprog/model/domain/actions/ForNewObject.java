package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.For;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class ForNewObject extends DomainAction {

	private IVPDomainModel model = null;
	private For createdFor = null;
	
	public ForNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		createdFor = model.createFor(_currentState);
	}

	protected void undoAction() {
		model.deleteFor(createdFor, _currentState);
	}
	public boolean equals(DomainAction a) {
		return false;
	}

}
