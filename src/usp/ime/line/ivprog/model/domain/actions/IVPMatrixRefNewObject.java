package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrixReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPMatrixRefNewObject extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPMatrixReference createdMRef = null;

	public IVPMatrixRefNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		createdMRef = model.createIVPMatrixReference(_currentState);
	}

	protected void undoAction() {
		model.deleteIVPMatrixReference(createdMRef, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
