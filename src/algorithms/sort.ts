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
