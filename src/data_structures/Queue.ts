// FIFO (First In, First Out) structure
// Linked List implementation

type Node<T> = {
  value: T;
  next?: Node<T>;
};

export default class Queue<T> {
  public length: number;
  private head?: Node<T>;
  private tail?: Node<T>;

  constructor() {
    this.head = undefined;
    this.tail = undefined;
    this.length = 0;
  }

  enqueue(item: T): void {
    const newNode = { value: item } as Node<T>;
    this.length++;
    if (!this.tail) {
      this.tail = this.head = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
  }

  dequeue(): T | undefined {
    if (!this.head) {
      return undefined;
    }

    this.length--;
    const removeNode = this.head;

    // unlink tail if removing last element from queue
    if (this.tail === this.head) {
      this.tail = undefined;
    }

    this.head = this.head.next;
    removeNode.next = undefined;
    return removeNode?.value;
  }

  peek(): T | undefined {
    return this.head?.value;
  }
}
