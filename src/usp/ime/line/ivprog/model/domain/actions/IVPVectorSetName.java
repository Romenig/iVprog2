package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPVector;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPVectorSetName extends DomainAction {

	private IVPDomainModel model = null;
	private IVPVector vector = null;
	private String lastName = null;
	private String vectorName = null;
	
	public IVPVectorSetName(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastName = model.setIVPVectorName(vectorName, vector, _currentState);
	}

	protected void undoAction() {
		model.setIVPVectorName(lastName, vector, _currentState);
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

	public String getVectorName() {
		return vectorName;
	}

	public void setVectorName(String vectorName) {
		this.vectorName = vectorName;
	}

}
