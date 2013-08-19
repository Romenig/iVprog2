package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComposite;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.For;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class ForRemoveChild extends DomainAction {

	private IVPDomainModel model = null;
	private For forObject = null;
	private CodeComposite child = null;
	private int childIndex = -1;

	public ForRemoveChild(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)m;
	}

	protected void executeAction() {
		model.removeForChildFromIndex(childIndex, forObject, _currentState);
	}

	protected void undoAction() {
		model.addForChildToIndex(child, childIndex, forObject, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public For getForObject() {
		return forObject;
	}

	public void setForObject(For forObject) {
		this.forObject = forObject;
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
