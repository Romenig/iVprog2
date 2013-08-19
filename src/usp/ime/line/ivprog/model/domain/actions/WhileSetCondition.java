package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Operation;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.While;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class WhileSetCondition extends DomainAction {
	
	private IVPDomainModel model = null;
	private While whileObject = null;
	private Operation condition = null;
	private Operation lastCondition = null;

	public WhileSetCondition(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastCondition = model.setWhileCondition(condition, whileObject, _currentState);
	}

	protected void undoAction() {
		model.setWhileCondition(lastCondition, whileObject, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Operation getCondition() {
		return condition;
	}

	public void setCondition(Operation condition) {
		this.condition = condition;
	}

	public While getWhileObject() {
		return whileObject;
	}

	public void setWhileObject(While whileObject) {
		this.whileObject = whileObject;
	}

}
