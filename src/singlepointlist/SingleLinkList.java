package singlepointlist;

import java.util.HashSet;
import java.util.Set;

//先进后出的栈式结构
public class SingleLinkList {
	
	class Element {
		public Object value = null;
		public Element nextNode = null;
	}

	class Value {
		public String code;
		public String name;

		public Value() {
		}

		public Value(String code, String name) {
			this.code = code;
			this.name = name;
		}

		@Override
		public String toString() {
			return code + "-" + name;
		}

	}

	private Element header = null;

	public static void main(String[] args) {
		SingleLinkList list = new SingleLinkList();
		Value value1 = list.new Value("1", "java");
		Value value2 = list.new Value("2", "c++");
		Value value3 = list.new Value("3", "c#");
		Value value4 = list.new Value("4", "vb");
		list.add(value1);
		list.add(value2);
		list.add(value3);
		list.add(value4);

		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
		// System.out.println("remove vb ?" + list.remove(value4));
		// System.out.println("have c++ ?" + list.contains(value2));
		// System.out.println("have vb ?" + list.contains(value4));
		// System.out.println("list is emptry ? " + list.isEmpty());
		// System.out.println(list);
		// list.clear();
		// System.out.println("list is emptry ? " + list.isEmpty());
	}

	static int size = 0;

	public void add(Object node) {
		if (header == null) {
			header = new Element();
			header.value = null;
			header.nextNode = null;
		}
		Element element = new Element();
		element.value = node;

		// 我如果只是给header.nextNode 设置为element 则无法给这个结构给串起来 。这里面Head 相当于一个游标
		// 每次都是往后移动。形成一个栈的结构
		element.nextNode = header.nextNode;
		header.nextNode = element;
		size++;
	}

	public void clear() {
		header = null;
	}

	public boolean contains(Object o) {
		if (header == null)
			return false;
		Element eqEl = header.nextNode;
		while (eqEl != null) {
			if (eqEl.value == o) {
				return true;
			}
			eqEl = eqEl.nextNode;
		}
		return false;
	}

	public String toString() {
		int size = this.size();
		String print = "";
		if (size == 0)
			return print;
		for (int i = 0; i < size; i++) {
			print = "," + this.get(i) + print;
		}
		print = "[" + print.substring(1) + "]";
		return print;
	}

	public Object get(int index) {
		if (header == null)
			return null;
		int size = this.size();
		if (index > (size - 1) || index < 0) {
			return null;
		}
		Element temp = header.nextNode;
		int i = 0;
		while (temp != null) {
			if (index == i) {
				return temp.value;
			}
			i++;
			temp = temp.nextNode;
		}
		return null;
	}

	private Element getElement(int index) {
		if (header == null)
			return null;
		int size = this.size();
		if (index > (size - 1) || index < 0) {
			return null;
		}
		Element temp = header.nextNode;
		int i = 0;
		while (temp != null) {
			if (index == i) {
				return temp;
			}
			i++;
			temp = temp.nextNode;
		}
		return null;
	}

	public boolean isEmpty() {
		if (header == null)
			return true;
		else
			return false;
	}

	public boolean remove(Object o) {
		if (header == null)
			return false;
		Element eqPreEl = header;
		Element eqEl = header.nextNode;
		while (eqEl != null) {
			if (eqEl.value == o) {
				eqPreEl.nextNode = eqEl.nextNode;
				return true;
			}
			eqPreEl = eqEl;
			eqEl = eqEl.nextNode;
		}
		return false;
	}

	public int size() {
		if (header == null)
			return 0;
		Element temp = header.nextNode;
		int i = 0;
		while (temp != null) {
			i++;
			temp = temp.nextNode;
		}
		return i;
	}

	/**
	 * 检查环状单链表
	 * 
	 * @return
	 */
	public boolean checkLoop() {
		if (header == null)
			return false;
		int size = this.size();
		if (size == 0)
			return false;
		Set<Element> set = new HashSet<Element>();
		for (int i = 0; i < size; i++) {
			Element el = getElement(i);
			if (!set.contains(el)) {
				set.add(el);
			}
			if (set.contains(el.nextNode)) {
				return true;
			}
		}
		return false;
	}
}