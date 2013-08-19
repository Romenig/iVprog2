package usp.ime.line.ivprog.view.utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import usp.ime.line.ivprog.controller.IVPEventController;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.For;
import usp.ime.line.ivprog.view.IVPDomainGUI;
import usp.ime.line.ivprog.view.constants.CommonNames;
import usp.ime.line.ivprog.view.editor.IVPCanvas;
import usp.ime.line.ivprog.view.editor.codeblocks.CodeMiniPanel;
import usp.ime.line.ivprog.view.editor.codeblocks.ForBlock;
import usp.ime.line.ivprog.view.interfaces.CatchableObject;

public class IVPMouseListener implements MouseListener {
	
	private boolean isHolding = false;
	private JComponent holdingComponent = null;
	
	//################################## MOUSE LISTENER METHODS ########################
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		if(!isHolding){
			getHoldingComponent(e);
		} else {
			dropComponent(e);
		}
	}

	//############################### AUX METHODS ########################
	private void dropComponent(MouseEvent e) {
		if(e.getSource() instanceof IVPCanvas)
			processClickOnCanvas(e);
	}
	private void getHoldingComponent(MouseEvent e) {
		if(e.getSource() instanceof CodeMiniPanel){
			processClickOnMiniPanel(e);
		}
	}

	
	//############################### MiniPanel ##########################
		private void processClickOnMiniPanel(MouseEvent e){
			CodeMiniPanel cMP= (CodeMiniPanel) e.getSource();
			if(cMP.getClassName().equals(CommonNames.FOR_MINI)){
				IVPEventController.createNewFor();
				isHolding = true;
			} else if(cMP.getClassName().equals(CommonNames.WHILE_MINI)){
				isHolding = true;
			} else if(cMP.getClassName().equals(CommonNames.IFELSE_MINI)){
				isHolding = true;
			} else if(cMP.getClassName().equals(CommonNames.PRINT_MINI)){
				isHolding = true;
			}
		}
		
		//############################### Drop on canvas #################
		private static void processClickOnCanvas(MouseEvent e){
			System.out.println("Canvas > ");
			IVPCanvas canvas = (IVPCanvas) e.getSource();
			
		}
		
		public JComponent getHoldingComponent() {
			return holdingComponent;
		}
		public void setHoldingComponent(JComponent holdingComponent) {
			this.holdingComponent = holdingComponent;
		}

}
