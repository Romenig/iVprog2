package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Print;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class PrintNewObject extends DomainAction {

	private IVPDomainModel model = null;
	private Print createdPrint = null;
	
	public PrintNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		createdPrint = model.createPrint(_currentState);
	}

	protected void undoAction() {
		model.deletePrint(createdPrint, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
