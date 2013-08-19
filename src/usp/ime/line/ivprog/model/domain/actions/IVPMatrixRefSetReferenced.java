package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrix;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrixReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPMatrixRefSetReferenced extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPMatrixReference matrixRef = null;
	private IVPMatrix referenced = null;
	private IVPMatrix lastReferenced = null;

	public IVPMatrixRefSetReferenced(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastReferenced = model.setIVPMatrixReferenceReferencedMatrix(referenced, matrixRef, _currentState);
	}

	protected void undoAction() {
		model.setIVPMatrixReferenceReferencedMatrix(lastReferenced, matrixRef, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public IVPMatrix getReferenced() {
		return referenced;
	}

	public void setReferenced(IVPMatrix referenced) {
		this.referenced = referenced;
	}

	public IVPMatrixReference getMatrixRef() {
		return matrixRef;
	}

	public void setMatrixRef(IVPMatrixReference matrixRef) {
		this.matrixRef = matrixRef;
	}

}
