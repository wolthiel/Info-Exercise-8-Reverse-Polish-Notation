public interface Stack<T> {
	
	abstract void push(T elem); //fügt neues Objekt ins Stack
	
	abstract T pop(); //nimmt erstes Objekt des Stacks und entfernt es
	
	abstract T peek(); //schaut auf das oberste Objekt des Stacks
	
	abstract String toString(); //druckt Stack aus
}