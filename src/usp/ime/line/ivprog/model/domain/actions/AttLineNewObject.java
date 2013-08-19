package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AttributionLine;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class AttLineNewObject extends DomainAction {
	
	private IVPDomainModel model = null;
	private AttributionLine createdAttLine = null;

	public AttLineNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		createdAttLine = model.createAttributionLine(_currentState);
	}

	protected void undoAction() {
		model.deleteAttributionLine(createdAttLine, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
