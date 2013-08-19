package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Expression;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.For;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class ForSetIndexInitValue extends DomainAction {

	private IVPDomainModel model = null;
	private For f = null;
	private Expression lastInitValue = null;
	private Expression initValue = null;
	
	public ForSetIndexInitValue(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastInitValue = model.setForIndexInitialValue(initValue, f, _currentState);
	}

	protected void undoAction() {
		model.setForIndexInitialValue(lastInitValue, f, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Expression getInitValue() {
		return initValue;
	}

	public void setInitValue(Expression initValue) {
		this.initValue = initValue;
	}

	public For getFor() {
		return f;
	}

	public void setFor(For f) {
		this.f = f;
	}

}
