package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IfElse;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IfElseRemove extends DomainAction {
	
	private IVPDomainModel model = null;
	private IfElse ifElse = null;

	public IfElseRemove(String name, String description) {
		super(name, description);
		
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.deleteIfElse(ifElse, _currentState);
	}

	protected void undoAction() {
		model.restoreIfElse(ifElse, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public IfElse getIfElse() {
		return ifElse;
	}

	public void setIfElse(IfElse ifElse) {
		this.ifElse = ifElse;
	}

}
