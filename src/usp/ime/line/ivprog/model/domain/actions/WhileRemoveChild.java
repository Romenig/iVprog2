package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComponent;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComposite;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.While;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class WhileRemoveChild extends DomainAction {

	private IVPDomainModel model = null;
	private While whileObject = null;
	private CodeComposite child = null;
	private int childIndex = -1;

	public WhileRemoveChild(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.removeWhileChildFromIndex(childIndex, whileObject, _currentState);
	}

	protected void undoAction() {
		model.addWhileChildToIndex(child, childIndex, whileObject, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public While getWhileObject() {
		return whileObject;
	}

	public void setWhileObject(While whileObject) {
		this.whileObject = whileObject;
	}

	public CodeComposite getChild() {
		return child;
	}

	public void setChild(CodeComposite child) {
		this.child = child;
	}

	public int getChildIndex() {
		return childIndex;
	}

	public void setChildIndex(int childIndex) {
		this.childIndex = childIndex;
	}
}
