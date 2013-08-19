package ilm.framework.assignment.model;

import java.util.Observable;
import java.util.Vector;

public final class AssignmentState extends Observable {

	private Vector _objectList;

	public AssignmentState() {
		_objectList = new Vector();
	}

	public final void add(DomainObject object) {
		_objectList.add(object);
		setChanged();
		notifyObservers(object);
	}

	public final boolean remove(DomainObject object) {
		boolean isRemoved = _objectList.remove(object);
		setChanged();
		notifyObservers(object);
		return isRemoved;
	}

	public final DomainObject remove(int index) {
		DomainObject removedObject = (DomainObject) _objectList.remove(index);
		setChanged();
		notifyObservers(removedObject);
		return removedObject;
	}

	public final DomainObject get(int index) {
		return (DomainObject) _objectList.get(index);
	}

	public final DomainObject getFromName(String name) {
		for (int i = 0; i < _objectList.size(); i++) {
			DomainObject obj = (DomainObject) _objectList.get(i);
			if (obj.getName().equals(name)) {
				return obj;
			}
		}
		return null;
	}

	public final DomainObject getFromDescription(String description) {
		for (int i = 0; i < _objectList.size(); i++) {
			DomainObject obj = (DomainObject) _objectList.get(i);
			if (obj.getDescription().equals(description)) {
				return obj;
			}
		}
		return null;
	}

	public final Vector getList() {
		return _objectList;
	}

	public final void setList(Vector list) {
		_objectList = list;
	}

	public final boolean equals(AssignmentState state) {
		if (_objectList.size() != state.getList().size()) {
			return false;
		}
		for (int i = 0; i < _objectList.size(); i++) {
			if (!_objectList.get(i).equals(state.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public void setStateChanged(DomainObject o){
		setChanged();
		notifyObservers(o);
	}
	
}
