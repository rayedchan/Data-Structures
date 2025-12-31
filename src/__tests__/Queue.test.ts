import Queue from "../data_structures/Queue";

describe("Queue", () => {
  it("should add elements to Queue", () => {
    const queue = new Queue<number>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    expect(queue.length).toBe(3);
  });

  it("should peek at the first element of the queue", () => {
    const queue = new Queue<number>();
    queue.enqueue(5);
    expect(queue.peek()).toBe(5);
    queue.enqueue(7);
    expect(queue.peek()).toBe(5);
    expect(queue.length).toBe(2);
  });

  it("should remove elements at the front of the queue", () => {
    const queue = new Queue<number>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    expect(queue.peek()).toBe(1);
    expect(queue.length).toBe(3);
    expect(queue.dequeue()).toBe(1);
    expect(queue.dequeue()).toBe(2);
    expect(queue.dequeue()).toBe(3);
    expect(queue.dequeue()).toBe(undefined);
  });
});
