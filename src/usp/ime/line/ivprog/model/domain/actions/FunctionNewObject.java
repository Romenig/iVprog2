package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FunctionNewObject extends DomainAction {

	private IVPDomainModel model = null;
	private Function createdFunction = null;
	
	public FunctionNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.createFunction(_currentState);
	}

	protected void undoAction() {
		model.deleteFunction(createdFunction, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
