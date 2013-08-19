package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AskUser;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class AskUserSetType extends DomainAction {

	private IVPDomainModel model = null;
	private AskUser askUser = null;
	private short dataType = -1;
	private short lastDataType = 0;
	
	public AskUserSetType(String name, String description) {
		super(name, description);
	}
	
	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastDataType = model.setAskUserDataType(dataType, askUser, _currentState);
	}
	
	protected void undoAction() {
		model.setAskUserDataType(lastDataType, askUser, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public AskUser getAskUser() {
		return askUser;
	}

	public void setAskUser(AskUser askUser) {
		this.askUser = askUser;
	}

	public short getDataType() {
		return dataType;
	}

	public void setDataType(short dataType) {
		this.dataType = dataType;
	}

}
