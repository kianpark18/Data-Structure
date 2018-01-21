import java.util.*;

public class SinglyLinkedList {	
	Node head;
	Node tail;
	int size;
	
	public SinglyLinkedList() {
		this.size = 0;
		
	}
	
	public <T> void add(T data) { // add to the end of the list. 
		if(size == 0) {
			head = new Node(data);
			size++;
		}else {
			head = _addToEnd(data, head);
			size++;
		}
		
	}
	
	private <T> Node _addToEnd(T data, Node node) { //add node to the end of the list recursively
		if(node == null) {
			return new Node(data);
		}
		
		Node newNode = _addToEnd(data, node.next);
		node.next = newNode;
		
		return node;
	}
	
	public <T> void addFirst(T data) {
			Node newNode =  new Node(data);
			newNode.next = head;
			head = newNode;
			size++;
	}
	
	
	
	public void reverse() {
		head = _reverse(head);
	}
	
	private Node _reverse(Node node) {
		if(node.next == null) {
			return node;
		}
		
		Node h = _reverse(node.next);
		Node qNode = node.next;
		qNode.next = node;
		node.next = null;
		return h;
		
	}
	
	
	public void print() {
		print(head);
	}
	
	private void print(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.println(node.toString());
		print(node.next);
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		LinkedList list1 = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		list.addFirst(99);
		list.addFirst(99);
		list.addFirst(99);
		list.addFirst(99);

		
		

	}

}

class Node<T>{
	T data;
	Node next;
	
	public Node(T data) {
		this.data = data;
	}
	
	public String toString() {
		return data.toString() +" ";
	}
}



