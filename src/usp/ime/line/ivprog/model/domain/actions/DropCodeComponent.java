package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComponent;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComposite;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class DropCodeComponent extends DomainAction {

	private IVPDomainModel model = null;
	int index;
	private CodeComponent dropComponent;
	private CodeComposite dropTarget;
	
	public DropCodeComponent(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.dropCodeComponent(dropComponent, dropTarget, index, _currentState);
	}

	protected void undoAction() {
		model.removeCodeComponent(dropTarget, index, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
