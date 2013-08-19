package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Comment;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class CommentSetText extends DomainAction {

	private IVPDomainModel model = null;
	private Comment comment = null;
	private String commentText = null;
	private String lastCommentText = null;
	
	public CommentSetText(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastCommentText = model.setCommentText(commentText, comment, _currentState);
	}

	protected void undoAction() {
		model.setCommentText(lastCommentText, comment, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

}
