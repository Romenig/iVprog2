package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Print;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class PrintRemove extends DomainAction {
	
	private IVPDomainModel model = null;
	private Print print = null;
	
	public PrintRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)model;
	}

	protected void executeAction() {
		model.deletePrint(print, _currentState);
	}

	protected void undoAction() {
		model.restorePrint(print, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
