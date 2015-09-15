package org.cx.util.executeorder;

/**
 * 单向链表
 * @author grass
 * @create date 2011-5-10
 */
public class Linked {
	private Node root;

	class Node {
		private String name;

		private Node next;

		public Node(String name) {
			this.name = name;
		}

		public void addNode(Node node) {
			if (this.next == null) {
				this.next = node;
			} else {
				this.next.addNode(node);
			}
		}

		public void printNode() {
			System.out.print(this.name + "-->");
			if (this.next != null) {
				this.next.printNode();
			}
		}

		public boolean searchNode(String name) {
			if (this.name.equals(name)) {
				return true;
			} else {
				if (this.next != null) {
					return this.next.searchNode(name);
				} else {
					return false;
				}
			}
		}

		public void deleteNode(Node node, String name) {
			if (this.name.equals(name)) {
				node.next = this.next;
			} else {
				this.next.deleteNode(this, name);
			}
		}
	};

	public void print() {
		this.root.printNode();
	}

	public void add(String name) {
		if (this.root == null) {
			this.root = new Node(name);
		} else {
			this.root.addNode(new Node(name));
		}
	}

	public boolean search(String name) {
		return this.root.searchNode(name);
	}

	public void delete(String name) {
		if (search(name)) {
			this.root.next.deleteNode(root, name);
		}
	}
	
	public static void main(String[] args) {
		Linked link = new Linked() ;
		link.add("root") ;
		link.add("1") ;
		link.add("2") ;
		link.add("3") ;
		link.print() ;
		System.out.println(link.search("5"));
		link.delete("2");
		link.print() ;
	}
}
