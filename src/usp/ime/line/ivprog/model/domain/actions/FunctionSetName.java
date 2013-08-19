package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FunctionSetName extends DomainAction {
	
	private IVPDomainModel model = null;
	private Function function = null;
	private String name = null;
	private String lastName = null;

	public FunctionSetName(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastName = model.setFunctionName(name, function, _currentState);
	}

	protected void undoAction() {
		model.setFunctionName(lastName, function, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public String getFunctionName() {
		return name;
	}

	public void setFunctionName(String name) {
		this.name = name;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

}
