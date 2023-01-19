import * as fs from "fs";

function parseInput(url: string): string[] {
  const lines = fs.readFileSync(url).toString().split("\n");

  return lines;
}
