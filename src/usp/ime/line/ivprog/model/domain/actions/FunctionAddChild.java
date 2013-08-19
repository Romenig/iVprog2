package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComponent;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FunctionAddChild extends DomainAction {
	
	private IVPDomainModel model = null;
	private Function function = null;
	private CodeComponent child = null;
	private int index = -1;

	public FunctionAddChild(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		model.addFunctionAChildAtIndex(index, child, function, _currentState);
	}

	protected void undoAction() {
		model.removeFunctionAChildFromIndex(index, function, _currentState);
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

	public CodeComponent getChild() {
		return child;
	}

	public void setChild(CodeComponent child) {
		this.child = child;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
