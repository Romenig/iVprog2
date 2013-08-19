/*
 * (non-Javadoc)
 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
 * Classe que observa o AssignmentState e � Observada pela GUI. 
 */

package usp.ime.line.ivprog.model.domain;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import usp.ime.line.ivprog.controller.IVPEventController;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComponent;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComposite;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.DataObject;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.domain.actions.ForNewObject;

public class IVPProgram extends Observable implements Observer {

	private HashMap functionList;
	private HashMap preDefinedFunctionList;
	private HashMap actionList;

	public IVPProgram() {
		IVPEventController.setIVPProgam(this);
		functionList = new HashMap();
		preDefinedFunctionList = new HashMap();
	}

	// ####################### DOMAIN ACTIONS ##########################
	public void createNewFor() {
		ForNewObject fNO = (ForNewObject) actionList.get("fornewobject");
		fNO.execute();
	}

	public void addChild(DataObject dropComponent, DataObject dropTarget,
			int index) {
		CodeComponent cComponent = null;
		CodeComposite cComposite = null;
		if (dropTarget instanceof CodeComposite
				&& dropComponent instanceof CodeComponent) { // accepts drop
			cComposite = (CodeComposite) dropTarget;
			cComponent = (CodeComponent) dropComponent;
			// cComposite.addChildToIndex(cComponent, index); have to be made
			// with DomainAction!
			actionList.get("dropComponent");
		} else {
			// launch exception
		}
	}

	// ####################### PROCESSING DROP EVENT ##########################
	private boolean isHolding = false;
	private CodeComponent holdingComponent = null;
	private int dropIndex = -1;

	// ####################### ##########################
	public void update(Observable assignmentState, Object domainObject) {
		if (domainObject instanceof Function) {
			Function f = (Function) domainObject;
			if (!functionList.containsKey(f.getFunctionName())) {
				functionList.put(f.getFunctionName(), f);
			}
			setChanged();
			notifyObservers(domainObject);
		} else if (domainObject instanceof CodeComponent) {
			CodeComponent component = (CodeComponent) domainObject;
			setChanged();
			notifyObservers(component);
		}
	}

	// ####################### ALL GETTERS/SETTERS ##########################
	public HashMap getFunctionList() {
		return functionList;
	}

	public void setFunctionList(HashMap functionList) {
		this.functionList = functionList;
	}

	public HashMap getPreDefinedFunctionList() {
		return preDefinedFunctionList;
	}

	public void setPreDefinedFunctionList(HashMap preDefinedFunctionList) {
		this.preDefinedFunctionList = preDefinedFunctionList;
	}

	public boolean isHolding() {
		return isHolding;
	}

	public void setHolding(boolean isHolding) {
		this.isHolding = isHolding;
	}

	public CodeComponent getHoldingComponent() {
		return holdingComponent;
	}

	public void setHoldingComponent(CodeComponent holdingComponent) {
		this.holdingComponent = holdingComponent;
	}

	public int getDropIndex() {
		return dropIndex;
	}

	public void setDropIndex(int dropIndex) {
		this.dropIndex = dropIndex;
	}

	public HashMap getActionList() {
		return actionList;
	}

	public void setActionList(HashMap actionList) {
		this.actionList = actionList;
	}

}
