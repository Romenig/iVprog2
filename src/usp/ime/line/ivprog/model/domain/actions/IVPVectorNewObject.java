package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPVector;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPVectorNewObject extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPVector createdVector = null;

	public IVPVectorNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		createdVector = model.createIVPVector(_currentState);
	}

	protected void undoAction() {
		model.deleteIVPVector(createdVector, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
