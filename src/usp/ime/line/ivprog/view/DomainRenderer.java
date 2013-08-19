package usp.ime.line.ivprog.view;

import java.util.Vector;

import javax.swing.JComponent;

import usp.ime.line.ivprog.IVProg2;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AttributionLine;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComponent;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.DataObject;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.For;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IfElse;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Print;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.While;
import usp.ime.line.ivprog.view.editor.IVPFunctionBody;
import usp.ime.line.ivprog.view.editor.codeblocks.ForBlock;
import usp.ime.line.ivprog.view.interfaces.ViewDomainObject;

public class DomainRenderer {
	
	public IVPFunctionBody buildFunction(Function f){
		IVPFunctionBody newFunction = new IVPFunctionBody();
		newFunction.setDataObject(f);
		Vector children = f.getChildrenList();
		for(int i = 0; i < children.size(); i++){
			ViewDomainObject component = parseChildren(((CodeComponent)children.get(i)));
			newFunction.addToCanvas(component);
		}
		newFunction.setFunctionName(f.getFunctionName());
		return newFunction;
	}
	
	public ForBlock buildFor(DataObject domainObject){
		For forData = (For) domainObject;
		ForBlock newFor = new ForBlock();
		newFor.setDataObject(forData);
		return newFor;
	}
	
	private ViewDomainObject parseChildren(DataObject domainObject){
		if(domainObject instanceof For){
			return buildFor(domainObject);
		} else if (domainObject instanceof While){
			
		} else if (domainObject instanceof IfElse){
			
		} else if (domainObject instanceof Print){
			
		} else if (domainObject instanceof AttributionLine){
			
		}
		return null;
	}

	public void buildNewComponent(DataObject domainObject) {
		ViewDomainObject holdingComponent = parseChildren(domainObject);
		IVProg2.getMouseListener().setHoldingComponent(holdingComponent);
	}

	public void rebuildComponent(DataObject domainObject) {
		
	}

}
