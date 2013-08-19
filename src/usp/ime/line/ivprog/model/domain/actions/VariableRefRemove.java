package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.VariableReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class VariableRefRemove extends DomainAction {

	private IVPDomainModel model = null;
	private VariableReference varRef = null;
	
	public VariableRefRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.deleteVariableReference(varRef, _currentState);
	}

	protected void undoAction() {
		model.restoreVariableReference(varRef, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public VariableReference getVarRef() {
		return varRef;
	}

	public void setVarRef(VariableReference varRef) {
		this.varRef = varRef;
	}

}
