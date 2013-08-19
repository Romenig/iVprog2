package usp.ime.line.ivprog.controller;

import java.awt.event.MouseEvent;
import java.util.Vector;

import usp.ime.line.ivprog.model.domain.IVPProgram;
import usp.ime.line.ivprog.view.IVPDomainGUI;
import usp.ime.line.ivprog.view.constants.CommonNames;
import usp.ime.line.ivprog.view.editor.IVPCanvas;
import usp.ime.line.ivprog.view.editor.codeblocks.CodeMiniPanel;
import usp.ime.line.ivprog.view.interfaces.CatchableObject;

public abstract class IVPEventController {

	private static IVPDomainGUI domainGUI = null;
	private static IVPProgram program = null;

	public static void setDomainGUI(IVPDomainGUI dGUI) {
		domainGUI = dGUI;
	}

	public static void setIVPProgam(IVPProgram prog) {
		program = prog;
	}

}
