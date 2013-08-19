package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FunctionAddParameter extends DomainAction {
	
	private IVPDomainModel model = null;
	private Function function = null;
	private Variable parameter = null;
	private int parameterIndex = -1;

	public FunctionAddParameter(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.addFunctionParameterAtIndex(parameterIndex, parameter, function, _currentState);
	}

	protected void undoAction() {
		model.removeFunctionParameterFromIndex(parameterIndex, function, _currentState);
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

	public Variable getParameter() {
		return parameter;
	}

	public void setParameter(Variable parameter) {
		this.parameter = parameter;
	}

	public int getParameterIndex() {
		return parameterIndex;
	}

	public void setParameterIndex(int parameterIndex) {
		this.parameterIndex = parameterIndex;
	}

}
