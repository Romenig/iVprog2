package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPVector;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPVectorAddElement extends DomainAction {

	private IVPDomainModel model = null;
	private IVPVector vector = null;
	private int position = -1;
	private Variable element = null;
	private Variable lastElement = null;
	
	public IVPVectorAddElement(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastElement = model.addIVPVectorElementAtPosition(position, element, vector, _currentState);
	}

	protected void undoAction() {
		model.addIVPVectorElementAtPosition(position, lastElement, vector, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public IVPVector getVector() {
		return vector;
	}

	public void setVector(IVPVector vector) {
		this.vector = vector;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Variable getElement() {
		return element;
	}

	public void setElement(Variable element) {
		this.element = element;
	}

	public Variable getLastElement() {
		return lastElement;
	}

	public void setLastElement(Variable lastElement) {
		this.lastElement = lastElement;
	}

}
