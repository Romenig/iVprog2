package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FunctionRemoveParameter extends DomainAction {

	private IVPDomainModel model = null;
	private Function function = null;
	private Variable removedParameter = null;
	private int parameterIndex = -1;
	private String removedParameterName = null;
	
	public FunctionRemoveParameter(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		parameterIndex = model.getFunctionParameterIndex(removedParameterName, function);
		removedParameter = model.removeFunctionParameterFromIndex(parameterIndex, function, _currentState);
	}

	protected void undoAction() {
		model.addFunctionParameterAtIndex(parameterIndex, removedParameter, function, _currentState);
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

	public String getRemovedParameter() {
		return removedParameterName;
	}

	public void setRemovedParameter(String removedParameter) {
		this.removedParameterName = removedParameter;
	}

}
