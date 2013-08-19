package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.While;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class WhileRemove extends DomainAction {
	
	private IVPDomainModel model = null;
	private While whileObject = null;

	public WhileRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.deleteWhile(whileObject, _currentState);
	}

	protected void undoAction() {
		model.restoreWhile(whileObject, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public While getWhileObject() {
		return whileObject;
	}

	public void setWhileObject(While whileObject) {
		this.whileObject = whileObject;
	}

}
