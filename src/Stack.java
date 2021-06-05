public interface Stack<T> {
	
	abstract void addFirstNode(T elem); //fügt neues Objekt ins Stack
	
	abstract void printAllNodes(); //Druckt gesamten Stack aus
	
	abstract T removeFirst(); //nimmt erstes Objekt des Stacks und entfernt es //Object??
	
	abstract String toString(); //druckt Stack aus
	
	abstract Object next(); //bewegt Iterator zur nächsten Stelle
	//StackListIterator evtl hinzufügen ^ v
	abstract boolean hasNext(); //prüft, ob ausgewählte Objekt nachfolgendes hat
	
	abstract void add(); //fügt Objekt an der ausgewählten Stelle hinzu
	
	abstract void remove(); //entfernt Objekt an der ausgewählten Stelle
	
	abstract void set(); //verändert Objekt an der ausgewählten Stelle
	
}
