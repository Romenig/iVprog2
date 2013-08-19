package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.While;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class WhileNewObject extends DomainAction {
	
	private IVPDomainModel model = null;
	private While whileObject = null;

	public WhileNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		whileObject = model.createWhile(_currentState);
	}

	protected void undoAction() {
		model.deleteWhile(whileObject, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
