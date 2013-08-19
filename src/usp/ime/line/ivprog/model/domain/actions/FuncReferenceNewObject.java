package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.FunctionReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class FuncReferenceNewObject extends DomainAction {

	private IVPDomainModel model = null;
	private FunctionReference createdObject = null;
	
	public FuncReferenceNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		createdObject = model.createFuncReference(_currentState);
	}

	protected void undoAction() {
		model.deleteFuncReference(createdObject, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
