public interface Stack {
	
	abstract void push(String elem);
	
	default String pop() {
		return "Hallo";
	}
	
}