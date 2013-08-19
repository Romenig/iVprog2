package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrix;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPMatrixSetType extends DomainAction {

	private IVPDomainModel model = null;
	private IVPMatrix matrix = null;
	private short matrixType = -1;
	private short lastType = -1;
	
	
	public IVPMatrixSetType(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastType = model.setIVPMatrixType(matrixType, matrix, _currentState);
	}

	protected void undoAction() {
		model.setIVPMatrixType(lastType, matrix, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public short getMatrixType() {
		return matrixType;
	}

	public void setMatrixType(short matrixType) {
		this.matrixType = matrixType;
	}

	public IVPMatrix getMatrix() {
		return matrix;
	}

	public void setMatrix(IVPMatrix matrix) {
		this.matrix = matrix;
	}

}
