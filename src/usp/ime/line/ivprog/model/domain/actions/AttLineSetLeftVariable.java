package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AttributionLine;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Reference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class AttLineSetLeftVariable extends DomainAction {
	
	private IVPDomainModel model = null;
	private AttributionLine attLine = null;
	private Reference leftVariable = null;
	private Reference lastLeftVariable = null;
	
	public AttLineSetLeftVariable(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastLeftVariable = model.setAttributionLineLeftVariable(leftVariable, attLine, _currentState);
	}

	protected void undoAction() {
		model.setAttributionLineLeftVariable(lastLeftVariable, attLine, _currentState);
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

	public Reference getLeftVariable() {
		return leftVariable;
	}

	public void setLeftVariable(Reference leftVariable) {
		this.leftVariable = leftVariable;
	}

}
