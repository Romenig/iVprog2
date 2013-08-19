package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.FunctionReference;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Reference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FuncReferenceRemoveParam extends DomainAction{

	private IVPDomainModel model = null;
	private FunctionReference funcReference = null;
	private int removedIndex = -1;
	private Reference removedParameter = null;
	
	public FuncReferenceRemoveParam(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		removedParameter = model.removeFuncReferenceParameterFromTheIndex(removedIndex, funcReference, _currentState);
	}

	protected void undoAction() {
		model.addFuncReferenceParameterToIndex(removedIndex, removedParameter, funcReference, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public int getRemovedIndex() {
		return removedIndex;
	}

	public void setRemovedIndex(int removedIndex) {
		this.removedIndex = removedIndex;
	}

	public FunctionReference getFuncReference() {
		return funcReference;
	}

	public void setFuncReference(FunctionReference funcReference) {
		this.funcReference = funcReference;
	}

}
