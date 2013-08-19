package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FunctionRemoveLocalVariable extends DomainAction{
	
	private IVPDomainModel model = null;
	private Function function = null;
	private Variable removedLocalVariable = null;
	private String removedLocalVariableName = null;
	private int removedLocalVariableIndex = -1;

	public FunctionRemoveLocalVariable(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		removedLocalVariableIndex = model.getFunctionVariableIndex(removedLocalVariableName, function);
		removedLocalVariable = model.removeFunctionLocalVariableFromIndex(removedLocalVariableIndex, function, _currentState);
	}

	protected void undoAction() {
		model.addFunctionLocalVariableAtIndex(removedLocalVariableIndex, removedLocalVariable, function, _currentState);
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

	public String getRemovedLocalVariableName() {
		return removedLocalVariableName;
	}

	public void setRemovedLocalVariableName(String removedLocalVariableName) {
		this.removedLocalVariableName = removedLocalVariableName;
	}

}
