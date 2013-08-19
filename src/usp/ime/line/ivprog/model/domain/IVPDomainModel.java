package usp.ime.line.ivprog.model.domain;

import java.awt.Point;

import usp.ime.line.ivprog.model.components.datafactory.DataFactory;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AskUser;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.AttributionLine;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComponent;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.CodeComposite;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Comment;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Expression;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.For;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Function;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.FunctionReference;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrix;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPMatrixReference;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPVector;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IVPVectorReference;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.IfElse;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Operation;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Print;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Reference;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.ReturnStatement;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.Variable;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.VariableReference;
import usp.ime.line.ivprog.model.components.datafactory.dataobjetcs.While;
import usp.ime.line.ivprog.view.utils.language.ResourceBundleIVP;
import ilm.framework.assignment.model.AssignmentState;
import ilm.framework.domain.DomainModel;

public class IVPDomainModel extends DomainModel {

	private DataFactory factory = null;
	
	public IVPDomainModel(){
		factory = new DataFactory();
	}
	
	//new actions
	public void dropCodeComponent(CodeComponent dropComponent, CodeComposite dropTarget, int index, AssignmentState state){
		dropTarget.addChildToIndex(dropComponent, index);
		state.setStateChanged(dropTarget);
	}
	
	public void removeCodeComponent(CodeComposite dropTarget, int index,
			AssignmentState _currentState) {
	}
	
	//########################## AskUser methods ##########################
	public AskUser createAskUser(AssignmentState state){
		AskUser askUser = (AskUser) factory.createAskUser();
		state.add(askUser);
		return askUser;
	}
	
	public void deleteAskUser(AskUser askUser, AssignmentState state){
		state.remove(askUser);
	}
	
	public void restoreAskUser(AskUser askUser, AssignmentState state){
		state.add(askUser);
	}
	
	public String setAskUserMessage(String message, AskUser askUser, AssignmentState state){
		String lastMessage = askUser.getMessage();
		askUser.setMessage(message);
		state.setStateChanged(askUser);
		return lastMessage;
	}
	
	public short setAskUserDataType(short dataType, AskUser askUser, AssignmentState state){
		short lastType = askUser.getDataType();
		askUser.setDataType(dataType);
		state.setStateChanged(askUser);
		return lastType;
	}
	
	//########################## AttributionLine methods ##########################
	
	public AttributionLine createAttributionLine(AssignmentState state){
		AttributionLine attLine = (AttributionLine) factory.createAttributionLine();
		state.add(attLine);
		return attLine;
	}
	
	public void deleteAttributionLine(AttributionLine attLine, AssignmentState state){
		state.remove(attLine);
	}
	
	public void restoreAttributionLine(AttributionLine attLine, AssignmentState state){
		state.add(attLine);
	}
	
	public short setAttributionLineType(short type, AttributionLine attLine, AssignmentState state){
		short lastType = attLine.getLeftVariableType();
		attLine.setLeftVariableType(type);
		state.setStateChanged(attLine);
		return lastType;
	}
	
	public Reference setAttributionLineLeftVariable(Reference leftVariable, AttributionLine attLine, AssignmentState state){
		Reference lastLeftVar = attLine.getLeftVariable();
		attLine.setLeftVariable(leftVariable);
		state.setStateChanged(attLine);
		return lastLeftVar;
	}
	
	public Expression setAttributionLineRightExpression(Expression expression, AttributionLine attLine, AssignmentState state){
		Expression lastExpression = attLine.getRightExpression();
		attLine.setRightExpression(expression);
		state.setStateChanged(attLine);
		return lastExpression;
	}
	
	//########################## Comment methods ##########################
	
	public Comment createComment(AssignmentState state){
		Comment createdComment = (Comment) factory.createComment();
		state.add(createdComment);
		return createdComment;
	}
	
	public void deleteComment(Comment comment, AssignmentState state){
		state.remove(comment);
	}
	
	public void restoreComment(Comment comment, AssignmentState state){
		state.add(comment);
	}
	
	public String setCommentText(String text, Comment comment, AssignmentState state){
		String lastCommentText = comment.getComment();
		comment.setComment(text);
		state.setStateChanged(comment);
		return lastCommentText;
	}
	
	//########################## For methods ##########################
	
	public For createFor(AssignmentState state){
		For createdFor = (For) factory.createFor();
		state.add(createdFor);
		return createdFor;
	}
	
	public void deleteFor(For f, AssignmentState state){
		state.remove(f);
	}
	
	public void restoreFor(For f, AssignmentState state){
		state.add(f);
	}
	
	public Expression setForIndexInitialValue(Expression initialValue, For f, AssignmentState state){
		Expression lastInitValue = f.getIndexInitialValue();
		f.setIndexInitialValue(initialValue);
		state.setStateChanged(f);
		return lastInitValue;
	}
	
	public Expression setForUpperBound(Expression upperBound, For f, AssignmentState state){
		Expression lastUpperBound = f.getUpperBound();
		f.setUpperBound(upperBound);
		state.setStateChanged(f);
		return lastUpperBound;
	}
	
	public Expression setForIncrement(Expression increment, For f, AssignmentState state){
		Expression lastIncrement = f.getIncrement();
		f.setIncrement(increment);
		state.setStateChanged(f);
		return lastIncrement;
	}
	
	public void addForChildToIndex(CodeComponent child, int index, For f, AssignmentState state){
		f.addChildToIndex(child, index);
		state.setStateChanged(f);
	}
	
	public CodeComponent removeForChildFromIndex(int index, For f, AssignmentState state){
		CodeComponent removedChild = (CodeComponent) f.removeChildFromIndex(index);
		state.setStateChanged(f);
		return removedChild;
	}
	
	//########################## Function methods ##########################
	
	public Function createFunction(AssignmentState state){
		Function createdFunction = (Function) factory.createFunction();
		state.add(createdFunction);
		return createdFunction;
	}
	
	public Function createMainFunction(AssignmentState state){
		Function mainFunction = (Function) factory.createFunction();
		mainFunction.setFunctionName(ResourceBundleIVP.getString("mainFunctionName"));
		state.add(mainFunction);
		return mainFunction;
	}
	
	public void deleteFunction(Function function, AssignmentState state){
		state.remove(function);
	}
	
	public void restoreFunction(Function function, AssignmentState state){
		state.add(function);
	}
	
	public String setFunctionName(String name, Function function, AssignmentState state){
		String lastName = function.getFunctionName();
		function.setFunctionName(name);
		state.setStateChanged(function);
		return lastName;
	}
	
	public short setFunctionReturnType(short type, Function function, AssignmentState state){
		short lastType = function.getReturnType();
		function.setReturnType(type);
		state.setStateChanged(function);
		return lastType;
	}
	
	public void addFunctionParameterAtIndex(int index, Variable parameter, Function function, AssignmentState state){
		function.addParameter(parameter);
		state.setStateChanged(function);
	}
	
	public Variable removeFunctionParameterFromIndex(int index, Function function, AssignmentState state){
		Variable removedParameter = (Variable) function.removeParameterAtIndex(index);
		state.setStateChanged(function);
		return removedParameter;
	}
	
	public int getFunctionParameterIndex(String parameterName, Function function){
		return function.getIndexForParameterWithName(parameterName);
	}
	
	public void addFunctionLocalVariableAtIndex(int index, Variable localVariable, Function function, AssignmentState state){
		function.addLocalVariable(localVariable);
		state.setStateChanged(function);
	}
	
	public Variable removeFunctionLocalVariableFromIndex(int index, Function function, AssignmentState state){
		Variable removedVariable = (Variable) function.removeLocalVariableFromIndex(index);
		state.setStateChanged(function);
		return removedVariable;
	}
	
	public int getFunctionVariableIndex(String variableName, Function function){
		return function.getIndexForVariableWithName(variableName);
	}
	
	public void addReferenceToTheList(FunctionReference reference, Function function, AssignmentState state){
		function.addReferenceToTheList(reference);
		state.setStateChanged(function);
	}
	
	public void removeFunctionReferenceFromTheList(FunctionReference functionReference, Function function, AssignmentState state){
		function.removeFunctionReference(functionReference);
		state.setStateChanged(function);
	}
	
	public void addFunctionAChildAtIndex(int index, CodeComponent aChild, Function function, AssignmentState state){
		function.addChildToIndex(aChild, index);
		state.setStateChanged(function);
	}
	
	public CodeComponent removeFunctionAChildFromIndex(int index, Function function, AssignmentState state){
		CodeComponent child = function.removeChildFromIndex(index);
		state.setStateChanged(function);
		return child;
	}
	
	//########################## FunctionReference methods ##########################
	
	public FunctionReference createFuncReference(AssignmentState state){
		FunctionReference functionReference = (FunctionReference) factory.createFunctionReference();
		state.add(functionReference);
		return functionReference;
	}
	
	public void deleteFuncReference(FunctionReference functionReference, AssignmentState state){
		state.remove(functionReference);
	}
	
	public void restoreFuncReference(FunctionReference functionReference, AssignmentState state){
		state.add(functionReference);
	}
	
	public void setFuncReferenceReferencedFunction(FunctionReference functionReference, Function function){
		functionReference.setReferencedFunction(function);
	}
	
	public void addFuncReferenceParameterToIndex(int index, Reference parameter, FunctionReference functionReference, AssignmentState state){
		functionReference.addParameterToTheListAtIndex(index, parameter);
		state.setStateChanged(functionReference);
	}
	
	public Reference removeFuncReferenceParameterFromTheIndex(int index, FunctionReference functionReference, AssignmentState state){
		Reference parameter = functionReference.removeParameterFromTheIndex(index);
		state.setStateChanged(functionReference);
		return parameter;
	}
	
	//########################## If/Else methods ##########################
	
	public IfElse createIfElse(AssignmentState state){
		IfElse createdIfElse = (IfElse) factory.createIfElse();
		state.add(createdIfElse);
		return createdIfElse;
	}
	
	public void deleteIfElse(IfElse ifElse, AssignmentState state){
		state.remove(ifElse);
	}
	
	public void restoreIfElse(IfElse ifElse, AssignmentState state){
		state.add(ifElse);
	}
	
	public Operation setOperationOfComparison(Operation comparison, IfElse ifElse, AssignmentState state){
		Operation lastComparison = ifElse.getComparison();
		ifElse.setComparison(comparison);
		state.setStateChanged(ifElse);
		return lastComparison;
	}
	
	public void addIfChildAtIndex(int index, CodeComponent removedChild, IfElse ifElse, AssignmentState state){
		ifElse.addChildToIndex(removedChild, index);
		state.setStateChanged(ifElse);
	}
	
	public CodeComponent removeIfChildFromIndex(int index, IfElse ifElse, AssignmentState state){
		CodeComponent removedChild = ifElse.removeChildFromIndex(index);
		state.setStateChanged(ifElse);
		return removedChild;
	}
	
	public void addElseChildAtIndex(int index, CodeComponent child, IfElse ifElse, AssignmentState state){
		ifElse.addElseChildToIndex(child, index);
		state.setStateChanged(ifElse);
	}
	
	public CodeComponent removeElseChildFromIndex(int index, IfElse ifElse, AssignmentState state){
		CodeComponent removedChild = ifElse.removeElseChildFromIndex(index);
		state.setStateChanged(ifElse);
		return removedChild;
	}
	
	//########################## IVPMatrix methods ##########################
	
	public IVPMatrix createMatrix(AssignmentState state){
		IVPMatrix createdMatrix = (IVPMatrix) factory.createIVPMatrix();
		state.add(createdMatrix);
		return createdMatrix;
	}
	
	public void deleteIVPMatrix(IVPMatrix matrix, AssignmentState state){
		state.remove(matrix);
	}
	
	public void restoreIVPMatrix(IVPMatrix matrix, AssignmentState state){
		state.add(matrix);
	}
	
	public String setIVPMatrixName(String name, IVPMatrix matrix, AssignmentState state){
		String lastName = matrix.getCollectionName();
		matrix.setCollectionName(name);
		state.setStateChanged(matrix);
		return lastName;
	}
	
	public short setIVPMatrixType(short matrixType, IVPMatrix matrix, AssignmentState state){
		short lastType = matrix.getCollectionType();
		matrix.setCollectionType(matrixType);
		state.setStateChanged(matrix);
		return lastType;
	}
	
	public Point setIVPMatrixDimensions(IVPMatrix matrix, Point newDimension, AssignmentState state){
		Point lastDimension = matrix.getDimension();
		matrix.setMatrixDimension(newDimension);
		state.setStateChanged(matrix);
		return lastDimension;
	}
	
	public Variable addElementToMatrixPosition(IVPMatrix matrix, Point position, Variable element, AssignmentState state){
		Variable lastVariable = matrix.getElementFromIndex(position);
		matrix.addToIndexes(position, element);
		state.setStateChanged(matrix);
		return lastVariable;
	}
	
	//########################## IVPMatrixReference methods ##########################
	
	public IVPMatrixReference createIVPMatrixReference(AssignmentState state){
		IVPMatrixReference createdMRef = (IVPMatrixReference) factory.createIVPMatrixReference(); 
		state.add(createdMRef);
		return createdMRef;
	}
	
	public void deleteIVPMatrixReference(IVPMatrixReference matrixRef, AssignmentState state){
		state.remove(matrixRef);
	}
	
	public void restoreIVPMatrixReference(IVPMatrixReference matrixRef, AssignmentState state){
		state.add(matrixRef);
	}
	
	public short setIVPMatrixReferenceType(short refType, IVPMatrixReference matrixRef, AssignmentState state){
		short lastType = matrixRef.getReferenceType();
		matrixRef.setReferenceType(refType);
		state.setStateChanged(matrixRef);
		return lastType;
	}
	
	public IVPMatrix setIVPMatrixReferenceReferencedMatrix(IVPMatrix referenced, IVPMatrixReference matrixRef, AssignmentState state){
		IVPMatrix lastMatrix = matrixRef.getReferencedMatrix();
		matrixRef.setReferencedMatrix(referenced);
		state.setStateChanged(matrixRef);
		return lastMatrix;
	}
	
	public Expression setIVPMatrixReferenceLineExpression(Expression line, IVPMatrixReference matrixRef, AssignmentState state){
		Expression lastLineExpression = matrixRef.getLineExpression();
		matrixRef.setLineExpression(line);
		state.setStateChanged(matrixRef);
		return lastLineExpression;
	}
	
	public Expression setIVPMatrixReferenceColumnExpression(Expression column, IVPMatrixReference matrixRef, AssignmentState state){
		Expression lastColumnExpression = matrixRef.getColumnExpression();
		matrixRef.setColumnExpression(column);
		state.setStateChanged(matrixRef);
		return lastColumnExpression;
	}
	
	//########################## IVPVector methods ##########################
	
	public IVPVector createIVPVector(AssignmentState state){
		IVPVector createdVector = (IVPVector) factory.createIVPVector();
		state.add(createdVector);
		return createdVector;
	}
	
	public void deleteIVPVector(IVPVector vector, AssignmentState state){
		state.remove(vector);
	}
	
	public void restoreIVPVector(IVPVector vector, AssignmentState state){
		state.add(vector);
	}

	public String setIVPVectorName(String name, IVPVector vector, AssignmentState state){
		String lastName = vector.getCollectionName();
		vector.setCollectionName(name);
		state.setStateChanged(vector);
		return lastName;
	}
	
	public short setIVPVectorType(short vectorType, IVPVector vector, AssignmentState state){
		short lastType = vector.getCollectionType();
		vector.setCollectionType(vectorType);
		state.setStateChanged(vector);
		return lastType;
	}
	
	public int setIVPVectorSize(int size, IVPVector vector, AssignmentState state){
		int lastSize = vector.getVectorSize();
		vector.setVectorSize(size);
		state.setStateChanged(vector);
		return lastSize;
	}
	
	public Variable addIVPVectorElementAtPosition(int position, Variable element, IVPVector vector, AssignmentState state){
		Variable lastVariable = vector.getElementAtIndex(position);
		vector.addElementToIndex(position, element);
		state.setStateChanged(vector);
		return lastVariable;
	}
	
	//########################## IVPVectorReference methods ##########################
	
	public IVPVectorReference createIVPVectorReference(AssignmentState state){
		IVPVectorReference createdRef = (IVPVectorReference) factory.createIVPVectorReference();
		state.add(createdRef);
		return createdRef;
	}

	public void deleteIVPVectorReference(IVPVectorReference vecRef, AssignmentState state){
		state.remove(vecRef);
	}
	
	public void restoreIVPVectorReference(IVPVectorReference vecRef, AssignmentState state){
		state.add(vecRef);
	}
	
	public short setIVPVectorReferenceType(short type, IVPVectorReference vecRef, AssignmentState state){
		short lastType = vecRef.getReferenceType();
		vecRef.setReferenceType(type);
		state.setStateChanged(vecRef);
		return lastType;
	}
	
	public IVPVector setIVPVectorReferencedVector(IVPVector referenced, IVPVectorReference vecRef, AssignmentState state){
		IVPVector lastReferenced = vecRef.getReferencedVector();
		vecRef.setReferencedVector(referenced);
		state.setStateChanged(vecRef);
		return lastReferenced;
	}
	
	public Expression setIVPVectorReferencePosition(Expression position, IVPVectorReference vecRef, AssignmentState state){
		Expression lastPosition = vecRef.getPosition();
		vecRef.setPosition(position);
		state.setStateChanged(vecRef);
		return lastPosition;
	}
	
	//########################## Operation methods ##########################

	public Operation createOperation(AssignmentState state){
		Operation createdOperation = (Operation) factory.createOperation();
		state.add(createdOperation);
		return createdOperation;
	}
	
	public void deleteOperation(Operation operation, AssignmentState state){
		state.remove(operation);
	}
	
	public void restoreOperation(Operation operation, AssignmentState state){
		state.add(operation);
	}
	
	public short setOperationType(short operationType, Operation operation, AssignmentState state){
		short lastType = operation.getOperationType();
		operation.setOperationType(operationType);
		state.setStateChanged(operation);
		return lastType;
	}
	
	public Expression setOperationExpressionA(Expression expA, Operation operation, AssignmentState state){
		Expression lastExpA = operation.getExpressionA();
		operation.setExpressionA(expA);
		state.setStateChanged(operation);
		return lastExpA;
	}
	
	public Expression setOperationExpressionB(Expression expB, Operation operation, AssignmentState state){
		Expression lastExpB = operation.getExpressionB();
		operation.setExpressionA(expB);
		state.setStateChanged(operation);
		return lastExpB;
	}
	
	//########################## Print methods ##########################
	
	public Print createPrint(AssignmentState state){
		Print createdPrint = (Print) factory.createPrint();
		state.add(createdPrint);
		return createdPrint;
	}
	
	public void deletePrint(Print print, AssignmentState state){
		state.remove(print);
	}
	
	public void restorePrint(Print print, AssignmentState state){
		state.add(print);
	}
	
	public Expression setPrintPrintable(Expression printable, Print print, AssignmentState state){
		Expression lastPrintable = print.getPrintableObject();
		print.setPrintableObject(printable);
		return lastPrintable;
	}
	
	//########################## ReturnStatement methods ##########################
	
	public ReturnStatement createReturnStatement(AssignmentState state){
		ReturnStatement createdReturn = (ReturnStatement) factory.createReturnStatement();
		state.add(createdReturn);
		return createdReturn;
	}
	
	public void deleteReturnStatement(ReturnStatement rStatement, AssignmentState state){
		state.remove(rStatement);
	}
	
	public void restoreReturnStatement(ReturnStatement rStatement, AssignmentState state){
		state.add(rStatement);
	}
	
	public short setReturnStatementType(short type, ReturnStatement rStatement, AssignmentState state){
		short lastType = rStatement.getType();
		rStatement.setType(type);
		state.setStateChanged(rStatement);
		return lastType;
	}
	
	public Expression setReturnExpression(Expression expression, ReturnStatement rStatement, AssignmentState state){
		Expression lastReturned = rStatement.getExpressionToBeReturned();
		rStatement.setExpressionToBeReturned(expression);
		state.setStateChanged(rStatement);
		return lastReturned;
	}
	
	//########################## Variable methods ##########################
	
	public Variable createVariable(AssignmentState state){
		Variable createdVariable = (Variable) factory.createVariable();
		state.add(createdVariable);
		return createdVariable;
	}
	
	public void deleteVariable(Variable variable, AssignmentState state){
		state.remove(variable);
	}
	
	public void restoreVariable(Variable variable, AssignmentState state){
		state.add(variable);
	}
	
	public short setVariableType(short type,  Variable variable, AssignmentState state){
		short lastType = variable.getVariableType();
		variable.setVariableType(type);
		state.setStateChanged(variable);
		return lastType;
	}
	
	public String setVariableName(String name, Variable variable, AssignmentState state){
		String lastName = variable.getVariableName();
		variable.setVariableName(name);
		state.setStateChanged(variable);
		return lastName;
	}
	
	public String setVariableValue(String value, Variable variable, AssignmentState state){
		String lastValue = variable.getVariableValue();
		variable.setVariableValue(value);
		state.setStateChanged(variable);
		return lastValue;
	}
	
	public void addVariableReference(VariableReference reference, Variable variable, AssignmentState state){
		variable.addVariableReference(reference);
		state.setStateChanged(variable);
	}
	
	public void removeVariableReference(VariableReference reference, Variable variable, AssignmentState state){
		variable.removeVariableReference(reference);
		state.setStateChanged(variable);
	}
	
	//########################## VariableReference methods ##########################
	
	public VariableReference createVariableReference(AssignmentState state){
		VariableReference createdVarRef = (VariableReference) factory.createVarReference();
		state.add(createdVarRef);
		return createdVarRef;
	}
	
	public void deleteVariableReference(VariableReference createdVarRef, AssignmentState state){
		state.remove(createdVarRef);
	}
	
	public void restoreVariableReference(VariableReference createdVarRef, AssignmentState state){
		state.add(createdVarRef);
	}
	
	public Variable setVariableReferenceReferenced(VariableReference reference, Variable variable, AssignmentState state){
		Variable lastReferenced = reference.getReferencedVariable();
		reference.setReferencedVariable(variable);
		state.setStateChanged(reference);
		return lastReferenced;
	}
	
	//########################## While methods ##########################
	
	public While createWhile(AssignmentState state){
		While createdWhile = (While) factory.createWhile();
		state.add(createdWhile);
		return createdWhile;
	}
	
	public void deleteWhile(While whileObject, AssignmentState state){
		state.remove(whileObject);
	}
	
	public void restoreWhile(While whileObject, AssignmentState state){
		state.add(whileObject);
	}
	
	public Operation setWhileCondition(Operation condition, While whileObject, AssignmentState state){
		Operation lastCondition = whileObject.getCondition();
		whileObject.setCondition(condition);
		state.setStateChanged(whileObject);
		return lastCondition;
	}
	
	public void addWhileChildToIndex(CodeComponent child, int index, While whileObject, AssignmentState state){
		whileObject.addChildToIndex(child, index);
		state.setStateChanged(whileObject);
	}
	
	public CodeComponent removeWhileChildFromIndex(int index, While whileObject, AssignmentState state){
		CodeComponent removedChild = (CodeComponent) whileObject.removeChildFromIndex(index);
		state.setStateChanged(whileObject);
		return removedChild;
	}
	
	//########################## Framework methods ##########################
	
	public AssignmentState getNewAssignmentState() {
		return new AssignmentState();
	}

	public float AutomaticChecking(AssignmentState studentAnswer,
			AssignmentState expectedAnswer) {
		return 0;
	}



}
