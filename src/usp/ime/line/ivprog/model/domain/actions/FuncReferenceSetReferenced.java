package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.FunctionReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FuncReferenceSetReferenced extends DomainAction {

	private IVPDomainModel model = null;
	private FunctionReference functionReference = null;
	private Function function = null;
	
	public FuncReferenceSetReferenced(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.setFuncReferenceReferencedFunction(functionReference, function);
	}

	protected void undoAction() {
		model.setFuncReferenceReferencedFunction(null, function);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public FunctionReference getFunctionReference() {
		return functionReference;
	}

	public void setFunctionReference(FunctionReference functionReference) {
		this.functionReference = functionReference;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

}
