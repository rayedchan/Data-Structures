function sum_char_code(str: string): number {
  let sum = 0;
  for (let i = 0; i < str.length; i++) {
    sum = sum + str.charCodeAt(i);
  }
  return sum;
}

function altArray(array: number[]) {
  for (let i = 1; i < array.length; i++) {
    let curr = array[i] % 2;
    let prev = array[i - 1] % 2;

    if (curr === prev) {
      return i;
    }
  }
  return -1;
}

function matrixManipulation(
  matrix: number[][],
  commands: string[]
): number[][] {
  // iterate each command
  for (const command of commands) {
    const tokens: string[] = command.split(" ");
    const action = tokens[0];

    switch (action) {
      case "SWAP_ROW": {
        const i = Number(tokens[1]);
        const j = Number(tokens[2]);
        [matrix[i], matrix[j]] = [matrix[j], matrix[i]];
        break;
      }
      case "SWAP_COL": {
        const i = Number(tokens[1]);
        const j = Number(tokens[2]);

        for (let r = 0; r < matrix.length; r++) {
          [matrix[r][i], matrix[r][j]] = [matrix[r][j], matrix[r][j]];
        }
        break;
      }
      case "REVERSE_ROW": {
        const i = Number(tokens[1]);
        matrix[i].reverse();
        break;
      }
      case "REVERSE_COL": {
        const j = Number(tokens[1]);
        const rows = matrix.length;
        let topPtr = 0;
        let bottomPtr = rows - 1;

        while (topPtr < bottomPtr) {
          [matrix[topPtr][j], matrix[bottomPtr][j]] = [
            matrix[bottomPtr][j],
            matrix[topPtr][j],
          ];
          topPtr++;
          bottomPtr--;
        }
        break;
      }
      case "ROTATE_90": {
        const rows = matrix.length;
        const cols = matrix[0].length;
        const results = Array.from({ length: cols }, () => Array().fill([]));

        for (let i = rows - 1; i >= 0; i--) {
          for (let j = 0; j < cols; j++) {
            results[j].push(matrix[i][j]);
          }
        }
        matrix = results;
        break;
      }
      default:
        console.log(`Invalid action: ${action}`);
    }
  }

  return matrix;
}

// const matrix = [
//   [1, 2, 3],
//   [4, 5, 6],
// ];

// const matrix = [
//   [1, 2, 3],
//   [4, 5, 6],
//   [7, 8, 9],
// ];

// const commands = ["ROTATE_90"];

// const results = matrixManipulation(matrix, commands);
// console.log(results);

function mostListenedAudiobook(times: number[], logs: number[][]) {
  for (const [index, time] of logs) {
    times[index] += time;
  }

  let maxIndex = 0;
  let max = -Infinity;
  for (let i = 0; i < times.length; i++) {
    if (times[i] > max) {
      max = times[i];
      maxIndex = i;
    }
  }

  return maxIndex;
}

const times = [30, 10, 20];

const logs = [
  [0, 15],
  [1, 30],
  [0, 10],
  [2, 25],
];

console.log(mostListenedAudiobook(times, logs));
