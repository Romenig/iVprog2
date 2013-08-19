package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class VariableSetType extends DomainAction {

	private IVPDomainModel model = null;
	private Variable variable = null;
	private short type = -1;
	private short lastType = -1;
	
	public VariableSetType(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastType = model.setVariableType(type, variable, _currentState);
	}

	protected void undoAction() {
		model.setVariableType(lastType, variable, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Variable getVariable() {
		return variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

}
