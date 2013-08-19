package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrix;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPMatrixNewObject extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPMatrix createdMatrix = null;

	public IVPMatrixNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;		
	}

	protected void executeAction() {
		createdMatrix = model.createMatrix(_currentState);
	}

	protected void undoAction() {
		model.deleteIVPMatrix(createdMatrix, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
