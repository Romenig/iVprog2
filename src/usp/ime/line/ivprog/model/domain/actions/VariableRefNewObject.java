package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.VariableReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class VariableRefNewObject extends DomainAction {
	
	private IVPDomainModel model = null;
	private VariableReference varRef = null;

	public VariableRefNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		varRef = model.createVariableReference(_currentState);
	}

	protected void undoAction() {
		model.deleteVariableReference(varRef, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
