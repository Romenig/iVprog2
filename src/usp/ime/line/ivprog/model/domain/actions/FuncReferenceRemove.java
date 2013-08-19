package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.FunctionReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FuncReferenceRemove extends DomainAction {

	private IVPDomainModel model = null;
	private FunctionReference removedFunctionReference = null;
	
	public FuncReferenceRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		model.deleteFuncReference(removedFunctionReference, _currentState);
	}

	protected void undoAction() {
		model.restoreFuncReference(removedFunctionReference, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public FunctionReference getRemovedFunctionReference() {
		return removedFunctionReference;
	}

	public void setRemovedFunctionReference(FunctionReference removedFunctionReference) {
		this.removedFunctionReference = removedFunctionReference;
	}

}
