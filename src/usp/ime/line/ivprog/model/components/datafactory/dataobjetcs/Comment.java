package usp.ime.line.ivprog.model.components.datafactory.dataobjetcs;

import ilm.framework.assignment.model.DomainObject;

public class Comment extends CodeComponent {

	private String comment = "";

	public Comment(String name, String description) {
		super(name, description);
	}

	/**
	 * Return the string containing the comment.
	 * 
	 * @return
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Set the comment text of this object.
	 * 
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean equals(DomainObject o) {
		return ((DataObject) o).getUniqueID() == this.getUniqueID();
	}

	public String toXML() {
		String str = "<dataobject class=\"comment\">" + "<id>" + getUniqueID()
				+ "</id>" + "<comment>" + comment + "</comment>"
				+ "</dataobject>";
		return str;
	}

	public String toJavaString() {
		return null;
	}
}
