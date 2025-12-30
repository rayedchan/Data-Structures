// O(n)
export function linearSearch(haystack: number[], needle: number): boolean {
  for (let i = 0; i < haystack.length; i++) {
    if (haystack[i] === needle) {
      return true;
    }
  }
  return false;
}

// O(log n)
// Array must be sorted
export function binarySearch(sortedArray: number[], target: number): boolean {
  let left = 0;
  let right = sortedArray.length - 1;

  while (left <= right) {
    let midpoint = Math.floor((left + right) / 2);

    if (sortedArray[midpoint] === target) {
      return true;
    } else if (target > sortedArray[midpoint]) {
      left = midpoint + 1;
    } else {
      right = midpoint - 1;
    }
  }

  return false;
}

// O(sqrt(N))
// array is sorted with booleans
export function twoCrystalBalls(breaks: boolean[]): number {
  const jump: number = Math.floor(Math.sqrt(breaks.length));
  let firstBreakpoint = null;

  // jump by squareroot of n
  for (let i = jump; i < breaks.length; i = i + jump) {
    if (breaks[i] === true) {
      firstBreakpoint = i;
      break;
    }
  }

  let start = firstBreakpoint ? firstBreakpoint - jump : breaks.length - jump;
  let end = firstBreakpoint ? firstBreakpoint + 1 : breaks.length;

  // linear search on subset
  for (let j = start; j < end; j++) {
    if (breaks[j] === true) {
      return j;
    }
  }

  return -1;
}
