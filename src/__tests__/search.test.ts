import { binarySearch, linearSearch, twoCrystalBalls } from "../search";

describe("linearSearch", () => {
  it("should return true when element is found", () => {
    const haystack: number[] = [1, 3, 5, 7, 9];
    expect(linearSearch(haystack, 5)).toBe(true);
  });

  it("should return false when element is not found", () => {
    const haystack: number[] = [1, 3, 5, 7, 9];
    expect(linearSearch(haystack, 4)).toBe(false);
  });

  it("should return false for empty array", () => {
    const haystack: number[] = [];
    expect(linearSearch(haystack, 5)).toBe(false);
  });
});

describe("binary search", () => {
  it("should return true when element is found", () => {
    const sortedArray: number[] = [1, 2, 3, 4, 5];
    expect(binarySearch(sortedArray, 5)).toBe(true);
  });

  it("should return false when element is not found", () => {
    const haystack: number[] = [10, 30, 50, 70, 90];
    expect(binarySearch(haystack, 5)).toBe(false);
  });

  it("should return false for empty array", () => {
    const haystack: number[] = [];
    expect(binarySearch(haystack, 5)).toBe(false);
  });
});

describe("two crystal balls", () => {
  it("given multiple true values should return the specific index where crystal begins to break", () => {
    const breaks: boolean[] = [
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
      true,
    ];
    expect(twoCrystalBalls(breaks)).toBe(20);
  });
  it("given one true value should return the specific index where crystal begins to break", () => {
    const breaks: boolean[] = [
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      true,
    ];
    expect(twoCrystalBalls(breaks)).toBe(9);
  });
  it("should return -1 for an indestructible crystal", () => {
    const breaks: boolean[] = [
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
      false,
    ];
    expect(twoCrystalBalls(breaks)).toBe(-1);
  });
});
