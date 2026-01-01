import ArrayList from "../data_structures/ArrayList";

describe("ArrayList", () => {
  it("should add elements to the end of the array list", () => {
    const arrayList = new ArrayList<number>(3);
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    expect(arrayList.length).toBe(3);
    expect(arrayList.toArray()).toEqual([1, 2, 3]);
  });

  it("should add elements anywhere in the array list", () => {
    const arrayList = new ArrayList<number>(7);
    arrayList.addAt(0, 1);
    arrayList.addAt(0, 2);
    arrayList.addAt(0, 9);
    arrayList.addAt(1, 8);
    arrayList.addAt(2, 3);
    arrayList.addAt(2, 5);
    expect(arrayList.length).toBe(6);
    expect(arrayList.toArray()).toEqual([9, 8, 5, 3, 2, 1, null]);
  });

  it("should remove from the array list", () => {
    const arrayList = new ArrayList<number>(10);
    arrayList.add(1);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(4);
    arrayList.add(5);
    expect(arrayList.length).toBe(5);
    expect(arrayList.remove(2)).toBe(1);
    expect(arrayList.length).toBe(4);
    expect(arrayList.remove(5)).toBe(3);
    arrayList.remove(3);
    arrayList.remove(1);
    arrayList.remove(4);
    expect(arrayList.length).toBe(0);
  });
});
