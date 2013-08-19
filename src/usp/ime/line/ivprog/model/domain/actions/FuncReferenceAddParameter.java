package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.FunctionReference;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Reference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FuncReferenceAddParameter extends DomainAction {
	
	private IVPDomainModel model = null;
	private FunctionReference funcReference = null;
	private int parameterIndex = -1;
	private Reference parameter = null;

	public FuncReferenceAddParameter(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		 model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.addFuncReferenceParameterToIndex(parameterIndex, parameter, funcReference, _currentState);
	}

	protected void undoAction() {
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public int getParameterIndex() {
		return parameterIndex;
	}

	public void setParameterIndex(int parameterIndex) {
		this.parameterIndex = parameterIndex;
	}

	public FunctionReference getFuncReference() {
		return funcReference;
	}

	public void setFuncReference(FunctionReference funcReference) {
		this.funcReference = funcReference;
	}

}
