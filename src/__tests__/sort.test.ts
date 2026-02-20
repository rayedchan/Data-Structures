import { bubbleSort, quickSort } from "../algorithms/sort";

describe("bubble sort", () => {
  it("should sort the array", () => {
    const array = [9, 6, 3, 4, 1, 7, 2, 5, 8];
    bubbleSort(array);
    expect(array).toEqual([1, 2, 3, 4, 5, 6, 7, 8, 9]);
  });
  it("one element", () => {
    const array = [9];
    bubbleSort(array);
    expect(array).toEqual([9]);
  });
  it("empty array", () => {
    const array: number[] = [];
    bubbleSort(array);
    expect(array).toEqual([]);
  });
});

describe("Quicksort", () => {
  it("should sort the array", () => {
    const array = [9, 3, 7, 4, 69, 420, 42];
    quickSort(array, 0, array.length - 1);
    expect(array).toEqual([3, 4, 7, 9, 42, 69, 420]);
  });
});
