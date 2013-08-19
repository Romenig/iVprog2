package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Expression;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrixReference;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class IVPMatrixRefSetLineExpression extends DomainAction {
	
	private IVPDomainModel model = null;
	private IVPMatrixReference matrixRef = null;
	private Expression lineExpression = null;
	private Expression lastLineExpression = null;

	public IVPMatrixRefSetLineExpression(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		lastLineExpression = model.setIVPMatrixReferenceLineExpression(lineExpression, matrixRef, _currentState);
	}

	protected void undoAction() {
		model.setIVPMatrixReferenceLineExpression(lastLineExpression, matrixRef, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Expression getLineExpression() {
		return lineExpression;
	}

	public void setLineExpression(Expression lineExpression) {
		this.lineExpression = lineExpression;
	}

	public IVPMatrixReference getMatrixRef() {
		return matrixRef;
	}

	public void setMatrixRef(IVPMatrixReference matrixRef) {
		this.matrixRef = matrixRef;
	}

}
