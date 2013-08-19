package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Expression;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.For;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class ForSetIncrement extends DomainAction {
	
	private IVPDomainModel model = null;
	private For f = null;
	private Expression increment = null;
	private Expression lastIncrement = null;

	public ForSetIncrement(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastIncrement = model.setForIncrement(increment, f, _currentState);
	}

	protected void undoAction() {
		model.setForIncrement(lastIncrement, f, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Expression getIncrement() {
		return increment;
	}

	public void setIncrement(Expression increment) {
		this.increment = increment;
	}

	public For getFor() {
		return f;
	}

	public void setFor(For f) {
		this.f = f;
	}

}
