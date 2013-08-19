package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrixReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPMatrixRefRemove extends DomainAction{
	
	private IVPDomainModel model = null;
	private IVPMatrixReference matrixRef = null;

	public IVPMatrixRefRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		model.deleteIVPMatrixReference(matrixRef, _currentState);
	}

	protected void undoAction() {
		model.restoreIVPMatrixReference(matrixRef, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public IVPMatrixReference getMatrixRef() {
		return matrixRef;
	}

	public void setMatrixRef(IVPMatrixReference matrixRef) {
		this.matrixRef = matrixRef;
	}

}
