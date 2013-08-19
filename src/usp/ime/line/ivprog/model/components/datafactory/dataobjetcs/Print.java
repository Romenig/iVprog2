package usp.ime.line.ivprog.model.components.datafactory.dataobjetcs;

import ilm.framework.assignment.model.DomainObject;

public class Print extends CodeComponent {

	private Expression printableObject = null;

	public Print(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Return the printable object.
	 * 
	 * @return the printableObject
	 */
	public Expression getPrintableObject() {
		return printableObject;
	}

	/**
	 * Set the printable object.
	 * 
	 * @param printableObject
	 *            the printableObject to set
	 */
	public void setPrintableObject(Expression printableObject) {
		this.printableObject = printableObject;
	}

	/**
	 * Removes the printable object and return it.
	 */
	public DataObject removePrintableObject() {
		DataObject printable = printableObject;
		printableObject = null;
		return printable;
	}

	public boolean equals(DomainObject o) {
		return ((DataObject) o).getUniqueID() == this.getUniqueID();
	}

	public String toXML() {
		String str = "<dataobject class=\"print\"><id>" + getUniqueID()
				+ "</id>" + "<printable>" + printableObject.toXML()
				+ "</printable></dataobject>";
		return str;
	}

	public String toJavaString() {
		return null;
	}
}
