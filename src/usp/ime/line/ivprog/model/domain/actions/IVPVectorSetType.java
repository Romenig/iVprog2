package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPVector;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPVectorSetType extends DomainAction {

	private IVPDomainModel model = null;
	private IVPVector vector = null;
	private short vectorType = -1;
	private short lastType = -1;
	
	public IVPVectorSetType(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastType = model.setIVPVectorType(vectorType, vector, _currentState);
	}

	protected void undoAction() {
		model.setIVPVectorType(lastType, vector, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public IVPVector getVector() {
		return vector;
	}

	public void setVector(IVPVector vector) {
		this.vector = vector;
	}

	public short getVectorType() {
		return vectorType;
	}

	public void setVectorType(short vectorType) {
		this.vectorType = vectorType;
	}

}
