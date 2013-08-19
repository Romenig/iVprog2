package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class VariableNewObject extends DomainAction {

	private IVPDomainModel model = null;
	private Variable variable = null;
	
	public VariableNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		variable = model.createVariable(_currentState);
	}

	protected void undoAction() {
		model.deleteVariable(variable, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
