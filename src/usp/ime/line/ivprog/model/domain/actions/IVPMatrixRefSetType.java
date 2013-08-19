package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrixReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPMatrixRefSetType extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPMatrixReference matrixRef = null;
	private short refType = -1;
	private short lastType = -1;

	public IVPMatrixRefSetType(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastType = model.setIVPMatrixReferenceType(refType, matrixRef, _currentState);
	}

	protected void undoAction() {
		model.setIVPMatrixReferenceType(lastType, matrixRef, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public short getLastType() {
		return lastType;
	}

	public void setLastType(short lastType) {
		this.lastType = lastType;
	}

	public short getRefType() {
		return refType;
	}

	public void setRefType(short refType) {
		this.refType = refType;
	}

	public IVPMatrixReference getMatrixRef() {
		return matrixRef;
	}

	public void setMatrixRef(IVPMatrixReference matrixRef) {
		this.matrixRef = matrixRef;
	}

}
