package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class VariableSetValue extends DomainAction {
	
	private IVPDomainModel model = null;
	private Variable variable = null;
	private String value = null;
	private String lastValue = null;

	public VariableSetValue(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastValue = model.setVariableValue(value, variable, _currentState);
	}

	protected void undoAction() {
		 model.setVariableValue(lastValue, variable, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Variable getVariable() {
		return variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

}
