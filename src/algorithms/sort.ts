// O(N^2)
// Compares adjacent elements and swap if they are out of order
// Moves the larget element to the end of the array in each outer iteration
export function bubbleSort(arr: number[]): void {
  for (let i = 0; i < arr.length - 1; i++) {
    for (let j = 0; j < arr.length - 1 - i; j++) {
      const current = arr[j];
      const next = arr[j + 1];
      if (current > next) {
        // swap
        [arr[j], arr[j + 1]] = [arr[j + 1], arr[j]];
      }
    }
  }
}

// O(N^2) worst case
// O(n log n) average case
// Choose last element as pivot, move elements lower than pivot beginning of the low index
// using another pointer to track the end of the lower partition, swap pivot with element one spot right to the pointer
function partition(arr: number[], lo: number, hi: number): number {
  const pivot = arr[hi];
  let idx = lo - 1;

  for (let i = lo; i < hi; i++) {
    if (arr[i] <= pivot) {
      idx++;
      // swap
      // const tmp = arr[i];
      // arr[i] = arr[idx];
      // arr[idx] = tmp;
      [arr[i], arr[idx]] = [arr[idx], arr[i]];
    }
  }

  idx++;
  // swap pivot
  // arr[hi] = arr[idx];
  // arr[idx] = pivot;
  [arr[hi], arr[idx]] = [arr[idx], arr[hi]];

  return idx;
}

export function quickSort(arr: number[], lo: number, hi: number): void {
  if (lo >= hi) {
    return;
  }

  const pivotIdx = partition(arr, lo, hi);

  quickSort(arr, lo, pivotIdx - 1);
  quickSort(arr, pivotIdx + 1, hi);
}
