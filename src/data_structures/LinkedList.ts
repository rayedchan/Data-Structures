export default class LinkedList<T> {
  private head: Node<T> | null = null;
  private length: number = 0;

  prepend(value: T): void {
    const newNode = new Node(value);

    if (this.head === null) {
      this.head = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
    this.length++;
  }

  insertAt(value: T, index: number): void {
    if (index === 0) {
      this.prepend(value);
      return;
    }

    let ptr = this.head;
    let prev = null;
    let position = 0;
    while (position < index && ptr !== null) {
      prev = ptr;
      ptr = ptr.next;
      position++;
    }

    const newNode = new Node(value);

    if (prev) {
      newNode.next = prev.next;
      prev.next = newNode;
    }
  }

  removeAt(index: number): Node<T> | null {
    if (index === 0) {
      if (this.head) {
        const remove = this.head;
        this.head = this.head.next;
        return remove;
      } else {
        return null;
      }
    }

    let ptr = this.head;
    let prev = null;
    let position = 0;

    while (ptr != null) {
      if (index == position && prev) {
        prev.next = ptr.next;
        ptr.next = null;
        return ptr;
      }

      position++;
      prev = ptr;
      ptr = ptr.next;
    }

    return null;
  }

  printList(): string {
    let ptr: Node<T> | null = this.head;
    let str: string = "";

    while (ptr != null) {
      str = str + ptr.value + "->";
      ptr = ptr.next;
    }
    return str;
  }
}

class Node<T> {
  value: T;
  next: Node<T> | null = null;

  constructor(value: T) {
    this.value = value;
  }
}
