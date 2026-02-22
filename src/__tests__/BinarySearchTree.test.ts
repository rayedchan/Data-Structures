import { inOrderSearch } from "../data_structures/BinaryTree";
import BinarySearchTree, {
  isBinarySearchTree,
} from "../data_structures/BinarySearchTree";

describe("Binary Search Tree", () => {
  it("tests", () => {
    const bst = new BinarySearchTree<number>();
    bst.insert(10);
    bst.insert(5);
    bst.insert(15);
    bst.insert(1);
    bst.insert(7);
    bst.insert(8);
    bst.insert(21);
    const root = bst.root as BinaryNode<number>;
    expect(isBinarySearchTree(root, -Infinity, Infinity)).toBe(true);
    expect(inOrderSearch(root)).toEqual([1, 5, 7, 8, 10, 15, 21]);
  });
});
