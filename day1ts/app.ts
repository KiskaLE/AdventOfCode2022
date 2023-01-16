import * as fs from "fs";

const lines: string[] = fs.readFileSync("input.txt").toString().split("\n");

let cals: number[] = [];
let curCals: number = 0;
lines.forEach((line) => {
  if (line == "") {
    cals.push(curCals);
    curCals = 0;
  } else {
    curCals += parseInt(line);
  }
});
cals.sort((a, b) => a - b);
console.log(cals.at(cals.length - 1));
