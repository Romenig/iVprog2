package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPVectorReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPVectorRefNewObject extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPVectorReference createdVecRef = null;

	public IVPVectorRefNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		createdVecRef = model.createIVPVectorReference(_currentState);
	}

	protected void undoAction() {
		model.deleteIVPVectorReference(createdVecRef, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
