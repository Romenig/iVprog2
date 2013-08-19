package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrix;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPMatrixRemove extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPMatrix deletedMatrix = null;
	
	public IVPMatrixRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.deleteIVPMatrix(deletedMatrix, _currentState);
	}

	protected void undoAction() {
		model.restoreIVPMatrix(deletedMatrix, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public IVPMatrix getDeletedMatrix() {
		return deletedMatrix;
	}

	public void setDeletedMatrix(IVPMatrix deletedMatrix) {
		this.deletedMatrix = deletedMatrix;
	}

}
