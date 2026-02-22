function walkPre(curr: BinaryNode<number> | null, path: number[]): number[] {
  if (!curr) {
    return path;
  }

  // recurse
  // pre
  path.push(curr.value);

  // recurse
  walkPre(curr.left, path);
  walkPre(curr.right, path);

  // post
  return path;
}

export function preOrderSearch(root: BinaryNode<number>): number[] {
  return walkPre(root, []);
}

function walkIn(curr: BinaryNode<number> | null, path: number[]): number[] {
  if (!curr) {
    return path;
  }

  // recurse
  // pre

  // recurse
  walkIn(curr.left, path);
  path.push(curr.value);
  walkIn(curr.right, path);

  // post
  return path;
}

export function inOrderSearch(root: BinaryNode<number>): number[] {
  return walkIn(root, []);
}

function walkPost(curr: BinaryNode<number> | null, path: number[]): number[] {
  if (!curr) {
    return path;
  }

  // recurse
  // pre

  // recurse
  walkPost(curr.left, path);
  walkPost(curr.right, path);

  // post
  path.push(curr.value);
  return path;
}

export function postOrderSearch(root: BinaryNode<number>): number[] {
  return walkPost(root, []);
}

// Breadth-first search using queue
// level by level traversal
export function bfs(head: BinaryNode<number>, needle: number): boolean {
  const q = [head];

  while (q.length) {
    const curr = q.shift() as BinaryNode<number>;

    if (curr.value === needle) {
      return true;
    }

    if (curr.left) {
      q.push(curr.left);
    }

    if (curr.right) {
      q.push(curr.right);
    }
  }

  return false;
}

export function compareTwoBinaryTrees(
  a: BinaryNode<number> | null,
  b: BinaryNode<number> | null,
): boolean {
  if (a === null && b === null) {
    return true;
  }

  if (a === null || b === null) {
    return false;
  }

  if (a.value !== b.value) {
    return false;
  }

  return (
    compareTwoBinaryTrees(a.left, b.left) &&
    compareTwoBinaryTrees(a.right, b.right)
  );
}

export function dfs(head: BinaryNode<number> | null, needle: number): boolean {
  if (!head) {
    return false;
  }

  if (head.value === needle) {
    return true;
  }

  if (head.value < needle) {
    return dfs(head.right, needle);
  }

  return dfs(head.left, needle);
}
