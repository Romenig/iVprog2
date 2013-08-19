package usp.ime.line.ivprog.model.domain.actions;

import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Expression;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrixReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;

public class IVPMatrixRefSetColumnExpression extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPMatrixReference matrixRef = null;
	private Expression columnExpression = null;
	private Expression lastColumnExpression = null;

	public IVPMatrixRefSetColumnExpression(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastColumnExpression = model.setIVPMatrixReferenceColumnExpression(columnExpression, matrixRef, _currentState);
	}

	protected void undoAction() {
		model.setIVPMatrixReferenceColumnExpression(lastColumnExpression, matrixRef, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Expression getColumnExpression() {
		return columnExpression;
	}

	public void setColumnExpression(Expression lineExpression) {
		this.columnExpression = lineExpression;
	}

	public IVPMatrixReference getMatrixRef() {
		return matrixRef;
	}

	public void setMatrixRef(IVPMatrixReference matrixRef) {
		this.matrixRef = matrixRef;
	}
}