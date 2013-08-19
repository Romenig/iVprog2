package usp.ime.line.ivprog.model.domain.actions;

import java.awt.Point;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrix;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPMatrixAddElement extends DomainAction {

	private IVPDomainModel model = null;
	private IVPMatrix matrix = null;
	private Point position = null;
	private Variable variable = null;
	private Variable lastVariable = null;
	
	public IVPMatrixAddElement(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastVariable = model.addElementToMatrixPosition(matrix, position, variable, _currentState);
	}

	protected void undoAction() {
		model.addElementToMatrixPosition(matrix, position, lastVariable, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public IVPMatrix getMatrix() {
		return matrix;
	}

	public void setMatrix(IVPMatrix matrix) {
		this.matrix = matrix;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Variable getVariable() {
		return variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

}
