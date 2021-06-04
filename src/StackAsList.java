import java.util.NoSuchElementException;

public class StackAsList {
	public Node first;
	public int totalNumberOfNodes = 0;
	
	public void addFirstNode(Object object) {
		Node last = new Node(object, first);
		first = last;
		totalNumberOfNodes ++;
	}
	public void printAllNodes() {
		Node currentNode = first;		
		while (currentNode.next != null)
		{
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
		if (currentNode.next == null) {
			System.out.println(currentNode.data);
		}
	}
	public Object removeFirst() {
		if(first == null) { throw new NoSuchElementException();}
		Object object = first.data;
		first = first.next;
		return object;
	}
	public StackAsList() {
		first = null;
	}
	public StackListIterator listIterator() {
		return new StackListIterator();
	}
	
	private class Node{
		Object data;
		Node next;
		private Node() {
		}
		private Node(Object object) {
			data = object;
		}
		private Node(Object object, Node nextNode) {
			data = object;
			next = nextNode;
		}
	}
	class StackListIterator {
		private Node position;
		private Node previous;
		private boolean isAfterNext;
		
		public StackListIterator() {
			position = null;
			previous = null;
			isAfterNext = false;
		}
		public Object next() {
			if (!hasNext()) { throw new NoSuchElementException();}
			previous = position;
			isAfterNext = true;
			
			if (position == null){
				position = first; 
			}
			else {
				position = position.next;
			}
			return position.data;
		}
		public boolean hasNext() {
			if (position == null) {
				return first != null;
			}
			else {
				return position.next != null;
			}
		}
		public void add(Object object) {
			if (position == null) {
				addFirstNode(object);
				position = first;
			}
			else {
				Node newNode = new Node(object, position.next);
				position.next = newNode;
				position = newNode;
			}
			totalNumberOfNodes ++;
			isAfterNext = false;
		}
		public void remove() {
			if(!isAfterNext) { throw new IllegalStateException();}
			if(position == first) {
				removeFirst();
			}
			else {
				previous.next = position.next;
			}
			position = previous;
			totalNumberOfNodes --;
			isAfterNext = false;
		}
		public void set(Object object) {
			if(!isAfterNext) { throw new IllegalStateException();}
			position.data = object;
		}
	}
	

}
