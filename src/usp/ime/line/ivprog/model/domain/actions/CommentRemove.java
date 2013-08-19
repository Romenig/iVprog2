package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Comment;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class CommentRemove extends DomainAction {

	private IVPDomainModel model = null;
	private Comment removedComment = null;
	
	public CommentRemove(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		model.deleteComment(removedComment, _currentState);
	}

	protected void undoAction() {
		model.restoreComment(removedComment, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Comment getRemovedComment() {
		return removedComment;
	}

	public void setRemovedComment(Comment comment) {
		this.removedComment = comment;
	}

}
