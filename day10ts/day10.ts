import * as fs from "fs";

function parseInput(url: string): string[] {
  return fs.readFileSync(url).toString().split("\r\n");
}

function part1(): void {
  const lines = parseInput("input.txt");
  console.log(lines);
}

part1();
