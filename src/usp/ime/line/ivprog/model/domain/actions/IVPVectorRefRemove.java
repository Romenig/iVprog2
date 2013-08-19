package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPVectorReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPVectorRefRemove extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPVectorReference vecRef = null;

	public IVPVectorRefRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		model.deleteIVPVectorReference(vecRef, _currentState);
	}

	protected void undoAction() {
		model.restoreIVPVectorReference(vecRef, _currentState);
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

}
