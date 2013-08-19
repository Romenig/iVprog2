package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FunctionSetReturnType extends DomainAction {

	private IVPDomainModel model = null;
	private Function function = null;
	private short returnType = -1;
	private short lastReturnType = -1;
	
	public FunctionSetReturnType(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastReturnType = model.setFunctionReturnType(returnType, function, _currentState);
	}

	protected void undoAction() {
		model.setFunctionReturnType(lastReturnType, function, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public short getReturnType() {
		return returnType;
	}

	public void setReturnType(short returnType) {
		this.returnType = returnType;
	}

}
