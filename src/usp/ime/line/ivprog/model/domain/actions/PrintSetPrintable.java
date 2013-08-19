package usp.ime.line.ivprog.model.domain.actions;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Expression;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Print;
import usp.ime.line.ivprog.model.domain.IVPDomainModel;
import ilm.framework.assignment.model.DomainAction;
import ilm.framework.domain.DomainModel;

public class PrintSetPrintable extends DomainAction {

	private IVPDomainModel model = null;
	private Print print = null;
	private Expression printable = null;
	private Expression lastPrintable = null;
	
	public PrintSetPrintable(String name, String description) {
		super(name, description);
	}

	public void setDomainModel(DomainModel m) {
		model = (IVPDomainModel)model;
	}

	protected void executeAction() {
		lastPrintable = model.setPrintPrintable(printable, print,_currentState);
	}

	protected void undoAction() {
		model.setPrintPrintable(lastPrintable, print, _currentState);
	}

	public boolean equals(DomainAction a) {
		return false;
	}

	public Expression getPrintable() {
		return printable;
	}

	public void setPrintable(Expression printable) {
		this.printable = printable;
	}

	public Print getPrint() {
		return print;
	}

	public void setPrint(Print print) {
		this.print = print;
	}

}
