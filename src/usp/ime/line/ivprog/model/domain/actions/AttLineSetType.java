package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AttributionLine;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class AttLineSetType extends DomainAction {

	private IVPDomainModel model = null;
	private AttributionLine attLine = null;
	private short dataType = -1;
	private short lastDataType = 0;
	
	public AttLineSetType(String name, String description) {
		super(name, description);
	}
	
	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastDataType = model.setAttributionLineType(dataType, attLine, _currentState);
	}
	
	protected void undoAction() {
		model.setAttributionLineType(lastDataType, attLine, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public AttributionLine getAttributionLine() {
		return attLine;
	}

	public void setAttributionLine(AttributionLine askUser) {
		this.attLine = askUser;
	}

	public short getDataType() {
		return dataType;
	}

	public void setDataType(short dataType) {
		this.dataType = dataType;
	}

}
