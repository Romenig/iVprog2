package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrix;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPMatrixSetName extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPMatrix matrix = null;
	private String lastName = null;
	private String matrixName = null;

	public IVPMatrixSetName(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel) m;
	}

	protected void executeAction() {
		lastName = model.setIVPMatrixName(matrixName, matrix, _currentState);
	}

	protected void undoAction() {
		model.setIVPMatrixName(lastName, matrix, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public String getMatrixName() {
		return matrixName;
	}

	public void setMatrixName(String matrixName) {
		this.matrixName = matrixName;
	}

	public IVPMatrix getMatrix() {
		return matrix;
	}

	public void setMatrix(IVPMatrix matrix) {
		this.matrix = matrix;
	}

}
