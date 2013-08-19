package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Expression;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.For;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class ForSetUpperBound extends DomainAction {

	private IVPDomainModel model = null;
	private For f = null;
	private Expression upperBound = null;
	private Expression lastUpperBound = null;
	
	public ForSetUpperBound(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastUpperBound = model.setForUpperBound(upperBound, f, _currentState);
	}

	protected void undoAction() {
		model.setForUpperBound(lastUpperBound, f, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Expression getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(Expression upperBound) {
		this.upperBound = upperBound;
	}

	public For getFor() {
		return f;
	}

	public void setFor(For f) {
		this.f = f;
	}

}
