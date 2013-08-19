package usp.ime.line.ivprog.model.domain.actions;

import java.awt.Point;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrix;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPMatrixSetDimensions extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPMatrix matrix = null;
	private Point lastMatrixSize = null;
	private Point matrixSize = null;

	public IVPMatrixSetDimensions(String name, String description) {
		super(name, description);

	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastMatrixSize = model.setIVPMatrixDimensions(matrix, matrixSize, _currentState);
	}

	protected void undoAction() {
		model.setIVPMatrixDimensions(matrix, lastMatrixSize, _currentState);
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

	public Point getLastMatrixSize() {
		return lastMatrixSize;
	}

	public void setLastMatrixSize(Point lastMatrixSize) {
		this.lastMatrixSize = lastMatrixSize;
	}

	public Point getMatrixSize() {
		return matrixSize;
	}

	public void setMatrixSize(Point matrixSize) {
		this.matrixSize = matrixSize;
	}

}
