package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.VariableReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class VariableRemoveReference extends DomainAction {

	private IVPDomainModel model = null;
	private Variable variable = null;
	private VariableReference reference = null;

	public VariableRemoveReference(String name, String description) {
		super(name, description);
	}
	
	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.removeVariableReference(reference, variable, _currentState);
	}

	protected void undoAction() {
		model.addVariableReference(reference, variable, _currentState);
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

	public VariableReference getReference() {
		return reference;
	}

	public void setReference(VariableReference reference) {
		this.reference = reference;
	}

}
