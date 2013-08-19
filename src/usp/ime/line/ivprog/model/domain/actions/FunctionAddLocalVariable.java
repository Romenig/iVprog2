package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FunctionAddLocalVariable extends DomainAction {

	private IVPDomainModel model = null;
	private Function function = null;
	private Variable localVariable = null;
	private int localVariableIndex = -1;
	
	public FunctionAddLocalVariable(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.addFunctionLocalVariableAtIndex(localVariableIndex, localVariable, function, _currentState);
	}

	protected void undoAction() {
		model.removeFunctionLocalVariableFromIndex(localVariableIndex, function, _currentState);
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

	public Variable getLocalVariable() {
		return localVariable;
	}

	public void setLocalVariable(Variable localVariable) {
		this.localVariable = localVariable;
	}

	public int getLocalVariableIndex() {
		return localVariableIndex;
	}

	public void setLocalVariableIndex(int index) {
		this.localVariableIndex = index;
	}

}
