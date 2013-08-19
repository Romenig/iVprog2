package usp.ime.line.ivprog.model.components.datafactory.dataobjetcs;

import ilm.framework.assignment.model.DomainObject;

public abstract class DataObject extends DomainObject {

	private int uniqueID = 0;

	public DataObject(String name, String description) {
		super(name, description);
	}

	/**
	 * This method returns the uniqueID of a DomainObject.
	 * 
	 * @return uniqueID
	 */
	public int getUniqueID() {
		return uniqueID;
	}

	/**
	 * This method sets the uniqueID of a DomainObject. This id must be set a
	 * single time during object creation.
	 * 
	 * @param id
	 */
	public void setUniqueID(int id) {
		uniqueID = id;
	}

	/**
	 * This method returns a String containing the XML notation for a Data
	 * Object.
	 * 
	 * @return
	 */
	public abstract String toXML();

	/**
	 * This method returns a String containing the Java notation for a Data
	 * Object.
	 * 
	 * @return
	 */
	public abstract String toJavaString();

}
