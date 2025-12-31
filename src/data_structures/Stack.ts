// LIFO (Last In First Out) structure
// Linked List implementation

type Node<T> = {
  value: T;
  next?: Node<T>;
};

export default class Stack<T> {
  public length: number;
  private head?: Node<T>;

  constructor() {
    this.length = 0;
    this.head = undefined;
  }

  push(item: T): void {
    const newNode = { value: item } as Node<T>;
    this.length++;
    newNode.next = this.head;
    this.head = newNode;
  }

  pop(): T | undefined {
    if (!this.head) {
      return undefined;
    }

    const removeNode = this.head;
    this.head = this.head.next;
    this.length--;
    return removeNode.value;
  }

  peek(): T | undefined {
    if (!this.head) {
      return undefined;
    }
    return this.head.value;
  }
}
