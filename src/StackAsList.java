
public class StackAsList implements Stack{
	public Node first;
	
	public StackAsList() {}
	public StackAsList(Node n) {
		first = n;
	}
	
	@Override
	public void push(String elem) {
	}
	
	private class Node{
		Object data;
		Node next;
		public Node (Object object) {
			data = object;
		}
		public Node (Object object, Node next) {
			data = object;
			this.next = next;
		}
		
		
	}

}
