import { linearSearch } from "../search";

describe("linearSearch", () => {
  it("should return true when element is found", () => {
    const haystack = [1, 3, 5, 7, 9];
    expect(linearSearch(haystack, 5)).toBe(true);
  });

  it("should return false when element is not found", () => {
    const haystack = [1, 3, 5, 7, 9];
    expect(linearSearch(haystack, 4)).toBe(false);
  });

  it("should return false for empty array", () => {
    const haystack: number[] = [];
    expect(linearSearch(haystack, 5)).toBe(false);
  });
});
