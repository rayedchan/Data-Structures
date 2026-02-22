import {
  inOrderSearch,
  postOrderSearch,
  preOrderSearch,
  bfs,
  dfs,
} from "../data_structures/BinaryTree";

export const tree: BinaryNode<number> = {
  value: 20,
  right: {
    value: 50,
    right: {
      value: 100,
      right: null,
      left: null,
    },
    left: {
      value: 30,
      right: {
        value: 45,
        right: null,
        left: null,
      },
      left: {
        value: 29,
        right: null,
        left: null,
      },
    },
  },
  left: {
    value: 10,
    right: {
      value: 15,
      right: null,
      left: null,
    },
    left: {
      value: 5,
      right: {
        value: 7,
        right: null,
        left: null,
      },
      left: null,
    },
  },
};

export const tree2: BinaryNode<number> = {
  value: 20,
  right: {
    value: 50,
    right: null,
    left: {
      value: 30,
      right: {
        value: 45,
        right: {
          value: 49,
          left: null,
          right: null,
        },
        left: null,
      },
      left: {
        value: 29,
        right: null,
        left: {
          value: 21,
          right: null,
          left: null,
        },
      },
    },
  },
  left: {
    value: 10,
    right: {
      value: 15,
      right: null,
      left: null,
    },
    left: {
      value: 5,
      right: {
        value: 7,
        right: null,
        left: null,
      },
      left: null,
    },
  },
};

describe("Tree Traversal", () => {
  it("Pre Order", () => {
    expect(preOrderSearch(tree)).toEqual([
      20, 10, 5, 7, 15, 50, 30, 29, 45, 100,
    ]);
  });
  it("In Order", () => {
    expect(inOrderSearch(tree)).toEqual([
      5, 7, 10, 15, 20, 29, 30, 45, 50, 100,
    ]);
  });
  it("Post Order", () => {
    expect(postOrderSearch(tree)).toEqual([
      7, 5, 15, 10, 29, 45, 30, 100, 50, 20,
    ]);
  });
  it("Breadth-first Search", () => {
    expect(bfs(tree, 45)).toEqual(true);
    expect(bfs(tree, 7)).toEqual(true);
    expect(bfs(tree, 69)).toEqual(false);
  });
  it("DFS on BST", function () {
    expect(dfs(tree, 45)).toEqual(true);
    expect(dfs(tree, 7)).toEqual(true);
    expect(dfs(tree, 69)).toEqual(false);
  });
});
