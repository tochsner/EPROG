
public class LinkedList2 {

	Node first;
	Node last;
	int size;
	
	public LinkedList() {
		first = null;
		last = null;
		size = 0;
	}
	
	public void addFirst(int value) {
		Node newNode = new Node(value, null, first);
		
		if (size > 0) {
			first.previous = newNode;
			first = newNode;
		} else {			
			first = newNode;
			last = newNode;
		}
		
		size++;
	}
	
	public void addLast(int value) {
		Node newNode = new Node(value, last, null);
		
		if (size > 0) {
			last.next = newNode;
			last = newNode;
		} else {
			first = newNode;
			last = newNode;
		}
		
		size++;
	}
	
	public int removeFirst() {
		int value = first.value;
		
		if (size > 1) {
			first = first.next;
			first.previous = null;
		} else if (size == 1) {
			first = null;
			last = null;
		} else if (size == 0) {
			System.out.println("Fehler");
		}
		
		size--;
		return value;
	}
	
	public int[] toArray() {
		int[] result = new int[size];
		
		int i = 0;
		for (Node current = first; current != null; current = current.next) {
			result[i] = current.value;
			i++;
		}
		
		return result;
	}
	
}


class Node {
	Node next;
	Node previous;
	int value;
	
	public Node(int value, Node previous, Node next) {
		this.value = value;
		this.previous = previous;
		this.next = next;
	}
}