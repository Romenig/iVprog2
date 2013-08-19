package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class VariableSetName extends DomainAction {
	
	private IVPDomainModel model = null;
	private Variable variable = null;
	private String name = null;
	private String lastName = null;

	public VariableSetName(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastName = model.setVariableName(name, variable, _currentState);
	}

	protected void undoAction() {
		model.setVariableName(lastName, variable, _currentState);
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

	public void setVariableName(String name) {
		this.name = name;
	}
	
	public String getVariableName(){
		return name;
	}

}
