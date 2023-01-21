import * as fs from "fs";

let cycle: number;
let X: number;
let count: number;
let screen: string[];
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
      noop(false);
    } else if (line.startsWith("addx")) {
      const [command, value] = line.split(" ");
      addx(parseInt(value), false);
    }
  });
  console.log(count);
}

function part2() {
  cycle = 1;
  X = 1;
  count = 0;
  screen = [];
  const lines = parseInput("input.txt");
  lines.forEach((line) => {
    if (line == "noop") {
      noop(true);
    } else if (line.startsWith("addx")) {
      const [command, value] = line.split(" ");
      addx(parseInt(value), true);
    }
  });
  console.log(drawScreen());
}

function drawScreen(): string {
  let s: string = "";
  for (let i = 0; i < screen.length; i++) {
    if (i > 0 && i % 40 === 0) {
      s += "\n";
    }
    s += screen[i];
  }

  return s;
}

function drawPixel(): void {
  if (cycle > 40) {
    cycle = 1;
  }
  if (Math.abs(cycle - 1 - X) <= 1) {
    screen.push("#");
  } else {
    screen.push(".");
  }
}

function noop(part2: boolean) {
  if (part2) {
    drawPixel();
  }
  cycle++;
  checkCycle();
}

function addx(value: number, part2: boolean) {
  for (let i = 0; i < 2; i++) {
    if (part2) {
      drawPixel();
    }
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
part2();
