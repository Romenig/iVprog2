package usp.ime.line.ivprog.view;

import java.util.Vector;

import javax.swing.JComponent;

import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AttributionLine;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComponent;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.For;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IfElse;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Print;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.While;
import usp.ime.line.ivprog.view.editor.IVPFunctionBody;
import usp.ime.line.ivprog.view.editor.codeblocks.ForBlock;

public class GUIRenderer {
	
	public IVPFunctionBody buildFunction(Function f){
		IVPFunctionBody newFunction = new IVPFunctionBody();
		newFunction.setDataObject(f);
		Vector children = f.getChildrenList();
		for(int i = 0; i < children.size(); i++){
			JComponent component = parseChildren(((CodeComponent)children.get(i)));
			newFunction.addToCanvas(component);
		}
		newFunction.setFunctionName(f.getFunctionName());
		return newFunction;
	}
	
	public ForBlock buildFor(CodeComponent forObject){
		For forData = (For) forObject;
		ForBlock newFor = new ForBlock();
		newFor.setDataObject(forData);
		return newFor;
	}
	
	private JComponent parseChildren(CodeComponent c){
		if(c instanceof For){
			return buildFor(c);
		} else if (c instanceof While){
			
		} else if (c instanceof IfElse){
			
		} else if (c instanceof Print){
			
		} else if (c instanceof AttributionLine){
			
		}
		return null;
	}

}
