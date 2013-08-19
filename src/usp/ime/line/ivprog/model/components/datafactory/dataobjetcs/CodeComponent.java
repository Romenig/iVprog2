package usp.ime.line.ivprog.model.components.datafactory.dataobjetcs;

public abstract class CodeComponent extends DataObject {
	
	private Function escope;
	
	public CodeComponent(String name, String description) {
		super(name, description);
	}
	
	public Function getEscope(){
		return escope;
	}
	
	public void setEscope(Function e){
		escope = e;
	}
	
}
