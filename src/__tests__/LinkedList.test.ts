import LinkedList from "../data_structures/LinkedList";

describe("Linked List", () => {
  it("should create a linked list with prepend", () => {
    const linkedList = new LinkedList<number>();
    linkedList.prepend(1);
    linkedList.prepend(2);
    linkedList.prepend(3);
    expect(linkedList.printList()).toBe("3->2->1->");
  });

  it("should create a linked list with insertAt", () => {
    const linkedList = new LinkedList<number>();
    linkedList.insertAt(1, 0);
    linkedList.insertAt(2, 1);
    linkedList.insertAt(3, 2);
    linkedList.insertAt(4, 3);
    linkedList.insertAt(5, 1);
    linkedList.insertAt(6, 4);
    linkedList.insertAt(7, 300);
    linkedList.insertAt(8, 5);
    expect(linkedList.printList()).toBe("1->5->2->3->6->8->4->7->");
  });

  it("should delete from linked list", () => {
    const linkedList = new LinkedList<number>();
    linkedList.insertAt(1, 0);
    linkedList.insertAt(2, 1);
    linkedList.insertAt(3, 2);
    linkedList.insertAt(4, 3);
    linkedList.removeAt(3);
    expect(linkedList.printList()).toBe("1->2->3->");
    linkedList.removeAt(1);
    expect(linkedList.printList()).toBe("1->3->");
    linkedList.removeAt(1);
    expect(linkedList.printList()).toBe("1->");
    linkedList.removeAt(0);
    expect(linkedList.printList()).toBe("");
  });

  it("should get node at specific index", () => {
    const linkedList = new LinkedList<number>();
    linkedList.prepend(3);
    linkedList.prepend(2);
    linkedList.prepend(1);
    expect(linkedList.printList()).toBe("1->2->3->");
    expect(linkedList.get(0)?.value).toBe(1);
    expect(linkedList.get(1)?.value).toBe(2);
    expect(linkedList.get(2)?.value).toBe(3);
    expect(linkedList.get(3)).toBe(null);
  });
});
