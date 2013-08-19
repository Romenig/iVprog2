package usp.ime.line.ivprog.controller;

import java.awt.event.MouseEvent;
import java.util.Vector;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComponent;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComposite;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.DataObject;
import usp.ime.line.ivprog.model.domain.IVPProgram;
import usp.ime.line.ivprog.view.IVPDomainGUI;
import usp.ime.line.ivprog.view.constants.CommonNames;
import usp.ime.line.ivprog.view.editor.IVPCanvas;
import usp.ime.line.ivprog.view.editor.codeblocks.CodeMiniPanel;
import usp.ime.line.ivprog.view.interfaces.CatchableObject;
import usp.ime.line.ivprog.view.interfaces.ViewDomainObject;

public abstract class IVPEventController {

	private static IVPDomainGUI domainGUI = null;
	private static IVPProgram program = null;

	public static void setDomainGUI(IVPDomainGUI dGUI) {
		domainGUI = dGUI;
	}

	public static void setIVPProgam(IVPProgram prog) {
		program = prog;
	}
	
	public static void dropOnCanvas(DataObject dropComponent, DataObject dropTarget, int index){
		program.addChild(dropComponent,dropTarget,index);
	}

	public static void createNewFor() {
		program.createNewFor();
	}

}
