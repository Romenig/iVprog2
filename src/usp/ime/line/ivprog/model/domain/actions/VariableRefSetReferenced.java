package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.VariableReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class VariableRefSetReferenced extends DomainAction {

	private IVPDomainModel model = null;
	private VariableReference varRef = null;
	private Variable referencedVar = null;
	private Variable lastReferenced = null;
	
	public VariableRefSetReferenced(String name, String description) {
		super(name, description);
	}
	
	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastReferenced = model.setVariableReferenceReferenced(varRef, referencedVar, _currentState);
	}

	protected void undoAction() {
		model.setVariableReferenceReferenced(varRef, lastReferenced, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public VariableReference getVarRef() {
		return varRef;
	}

	public void setVarRef(VariableReference varRef) {
		this.varRef = varRef;
	}

	public Variable getReferencedVar() {
		return referencedVar;
	}

	public void setReferencedVar(Variable referencedVar) {
		this.referencedVar = referencedVar;
	}

}
