import * as fs from "fs";
import Rope from "./rope";
import { Move, Point } from "./types";

let moves: Move[] = [];

function parseMoves(url: string) {
  let lines = fs.readFileSync(url).toString().split("\n");
  lines.forEach((line) => {
    let move: string = line.replace(new RegExp(/[0-9 ]/g), "");
    let numberOfMoves: number = parseInt(
      line.replace(new RegExp(/[A-Z ]/gi), "")
    );
    moves.push({ move: move, numberOfMoves: numberOfMoves });
  });
}
function part1(): void {
  let rope = new Rope({ x: 0, y: 0 });
  moves.forEach((move) => {
    for (let i = 0; i < move.numberOfMoves; i++) {
      rope.move(move.move);
    }
  });

  console.log(rope.getUniqueLocations());
}

parseMoves("input.txt");
part1();

export default {};
