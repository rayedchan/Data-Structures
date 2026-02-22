export default class MinHeap {
  public length: number;
  private data: number[];

  constructor() {
    this.data = [];
    this.length = 0;
  }

  insert(value: number): void {
    this.data[this.length] = value;
    this.heapifyUp(this.length);
    this.length++;
  }

  delete(): number {
    if (this.length === 0) {
      return -1;
    }

    const out = this.data[0];

    if (this.length === 1) {
      this.length--;
      this.data = [];
      return out;
    }

    this.length--;
    this.data[0] = this.data[this.length];
    this.heapifyDown(0);
    return out;
  }

  private heapifyDown(idx: number): void {
    const lIdx = this.leftChild(idx);
    const rIdx = this.rightChild(idx);

    if (idx >= this.length || lIdx >= this.length || rIdx >= this.length) {
      return;
    }

    const lV = this.data[lIdx];
    const rV = this.data[rIdx];
    const v = this.data[idx];

    if (lV >= rV && v > rV) {
      this.data[idx] = rV;
      this.data[rIdx] = v;
      this.heapifyDown(rIdx);
    } else if (rV >= lV && v > lV) {
      this.data[idx] = lV;
      this.data[lIdx] = v;
      this.heapifyDown(lIdx);
    }
  }

  private heapifyUp(idx: number) {
    // recursive
    // if (idx === 0) {
    //   return;
    // }

    // const pIndex = this.parent(idx);
    // const pValue = this.data[pIndex];
    // const v = this.data[idx];

    // if (v < pValue) {
    //   this.data[idx] = pValue;
    //   this.data[pIndex] = v;
    //   this.heapifyUp(pIndex);
    // }

    let currentIndex = idx;
    let currentValue = this.data[idx];

    while (currentIndex != 0) {
      let parentIndex = this.parent(currentIndex);
      let parentValue = this.data[parentIndex];

      if (parentValue <= currentValue) {
        break;
      }

      this.data[parentIndex] = currentValue;
      this.data[currentIndex] = parentValue;
      currentIndex = parentIndex;
    }
  }

  private parent(idx: number): number {
    return Math.floor((idx - 1) / 2);
  }

  private leftChild(idx: number): number {
    return 2 * idx + 1;
  }

  private rightChild(idx: number): number {
    return 2 * idx + 2;
  }
}
