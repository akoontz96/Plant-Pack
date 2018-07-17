package main;

class Node {
	private Plant item;
	private Node next;

	public Node(Plant item, Node next) {
		this.item = item;
		this.next = next;
	}

	public Plant getItem() {
		return item;
	}

	public void setItem(Plant item) {
		this.item = item;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
