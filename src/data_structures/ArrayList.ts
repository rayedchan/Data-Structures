// Just practice array list operations
// skip out on capacity growth

export default class ArrayList<T> {
  public length: number;
  private items: T[];
  private capacity: number;

  constructor(capacity: number) {
    this.length = 0;
    this.capacity = capacity;
    this.items = Array(capacity).fill(null);
  }

  add(item: T): void {
    this.items[this.length] = item;
    this.length++;
  }

  addAt(index: number, item: T): void {
    if (index >= this.length) {
      this.add(item);
      return;
    }

    // shift over elements
    for (let i = this.length; i > index; i--) {
      this.items[i] = this.items[i - 1];
    }

    // replace new value at index
    this.items[index] = item;
    this.length++;
  }

  remove(item: T): number {
    let index = -1;

    for (let i = 0; i < this.length; i++) {
      if (this.items[i] === item) {
        index = i;
        break;
      }
    }

    // shift elements
    if (index !== -1) {
      for (let j = index; j < this.length - 1; j++) {
        this.items[j] = this.items[j + 1];
      }

      this.items[this.length - 1] = null as any;
      this.length--;
    }

    return index;
  }

  toArray(): T[] {
    return this.items;
  }
}
