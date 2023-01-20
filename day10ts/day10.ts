import * as fs from "fs";

let cycle: number;
let X: number;
let count: number;
function parseInput(url: string): string[] {
  return fs.readFileSync(url).toString().split("\r\n");
}

function part1(): void {
  cycle = 1;
  X = 1;
  count = 0;
  const lines = parseInput("input.txt");
  lines.forEach((line) => {
    if (line == "noop") {
      noop();
    } else if (line.startsWith("addx")) {
      const [command, value] = line.split(" ");
      addx(parseInt(value));
    }
  });
  console.log(count);
}

function noop() {
  cycle++;
  checkCycle();
}

function addx(value: number) {
  for (let i = 0; i < 2; i++) {
    cycle++;
    if (i === 1) {
      X += value;
    }
    checkCycle();
  }
}

function checkCycle() {
  if (cycle === 20 || (cycle > 0 && (cycle - 20) % 40 === 0)) {
    count += cycle * X;
  }
}
part1();
