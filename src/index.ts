function sum_char_code(str: string): number {
  let sum = 0;
  for (let i = 0; i < str.length; i++) {
    sum = sum + str.charCodeAt(i);
  }
  return sum;
}

console.log(sum_char_code("hello"));
