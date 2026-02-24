declare type Point = {
  x: number;
  y: number;
};

declare type BinaryNode<T> = {
  value: T;
  left: BinaryNode<T> | null;
  right: BinaryNode<T> | null;
};

declare type WeightedAdjacencyMatrix = number[][];

declare type GraphEdge = { to: number; weight: number };
declare type WeightedAdjacencyList = GraphEdge[][];

declare interface ILRU<K, V> {
  update(key: K, value: V): void;
  get(key: K): V | undefined;
}
