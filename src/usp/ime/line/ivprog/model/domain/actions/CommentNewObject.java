package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Comment;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class CommentNewObject extends DomainAction {
	
	private IVPDomainModel model = null;
	private Comment createdComment = null;
	
	public CommentNewObject(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		createdComment = model.createComment(_currentState);
	}

	protected void undoAction() {
		model.deleteComment(createdComment, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

}
