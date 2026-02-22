export default class BinarySearchTree<T> {
  root?: BinaryNode<T>;

  constructor() {
    this.root = undefined;
  }

  insert(v: T): void {
    const newNode = { value: v } as BinaryNode<T>;

    if (!this.root) {
      this.root = newNode;
      return;
    }

    let curr = this.root as BinaryNode<T> | null;

    while (curr != null) {
      if (v <= curr.value) {
        if (!curr.left) {
          curr.left = newNode;
          return;
        } else {
          curr = curr.left;
        }
      } else {
        if (!curr.right) {
          curr.right = newNode;
          return;
        }
        curr = curr.right;
      }
    }
  }

  search(v: T): boolean {
    return this.find(this.root || null, v);
  }

  // O(n) - skewed tree
  private find(node: BinaryNode<T> | null, v: T): boolean {
    if (!node) {
      return false;
    }

    if (node.value === v) {
      return true;
    }

    if (node.value <= v) {
      this.find(node.right, v);
    }

    return this.find(node.left, v);
  }
}

export function isBinarySearchTree(
  node: BinaryNode<number> | null,
  min: number,
  max: number,
): boolean {
  if (!node) return true;

  if (node.value <= min || node.value >= max) {
    return false;
  }

  return (
    isBinarySearchTree(node.left, min, node.value) &&
    isBinarySearchTree(node.right, node.value, max)
  );
}
