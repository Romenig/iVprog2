package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AttributionLine;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Expression;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class AttLineSetExpression extends DomainAction {
	
	private IVPDomainModel model = null;
	private AttributionLine attLine = null;
	private Expression rightExpression = null;
	private Expression lastRightExpression = null;
	
	public AttLineSetExpression(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastRightExpression = model.setAttributionLineRightExpression(rightExpression, attLine, _currentState);
	}

	protected void undoAction() {
		model.setAttributionLineRightExpression(lastRightExpression, attLine, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public AttributionLine getAttLine() {
		return attLine;
	}

	public void setAttLine(AttributionLine attLine) {
		this.attLine = attLine;
	}

	public Expression getRightExpression() {
		return rightExpression;
	}

	public void setRightExpression(Expression rightExpression) {
		this.rightExpression = rightExpression;
	}

}
