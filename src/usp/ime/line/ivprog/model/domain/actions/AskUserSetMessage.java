package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AskUser;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class AskUserSetMessage extends DomainAction {

	private IVPDomainModel model = null;
	private AskUser askUser = null;
	private String message = null;
	private String lastMessage = null;
	
	public AskUserSetMessage(String name, String description) {
		super(name, description);
	}
	
	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastMessage = model.setAskUserMessage(message, askUser, _currentState);
	}

	protected void undoAction() {
		model.setAskUserMessage(lastMessage, askUser, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AskUser getAskUser() {
		return askUser;
	}

	public void setAskUser(AskUser askUser) {
		this.askUser = askUser;
	}

}
