package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Expression;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPVectorReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPVectorReferenceSetPosition extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPVectorReference vecRef = null;
	private Expression position = null;
	private Expression lastPosition = null;
	
	public IVPVectorReferenceSetPosition(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastPosition = model.setIVPVectorReferencePosition(position, vecRef, _currentState);
	}

	protected void undoAction() {
		model.setIVPVectorReferencePosition(lastPosition, vecRef, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public IVPVectorReference getVecRef() {
		return vecRef;
	}

	public void setVecRef(IVPVectorReference vecRef) {
		this.vecRef = vecRef;
	}

	public Expression getPosition() {
		return position;
	}

	public void setPosition(Expression position) {
		this.position = position;
	}

	public Expression getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Expression lastPosition) {
		this.lastPosition = lastPosition;
	}

}
