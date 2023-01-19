import * as fs from "fs";
import Rope from "./rope";
import RopeV2 from "./ropeV2";
import { Move, Point } from "./types";

function parseMoves(url: string): Move[] {
  let moves: Move[] = [];
  let lines = fs.readFileSync(url).toString().split("\n");
  lines.forEach((line) => {
    let move: string = line.replace(new RegExp(/[0-9 ]/g), "");
    let numberOfMoves: number = parseInt(
      line.replace(new RegExp(/[A-Z ]/gi), "")
    );
    moves.push({ move: move, numberOfMoves: numberOfMoves });
  });
  return moves;
}
function part1(): void {
  const moves = parseMoves("input.txt");
  let rope = new Rope({ x: 0, y: 0 });
  rope.setStoreLoacation(true);
  moves.forEach((move) => {
    for (let i = 0; i < move.numberOfMoves; i++) {
      rope.move(move.move);
    }
  });

  console.log(rope.getUniqueLocations());
}

function part2(): void {
  const moves = parseMoves("input.txt");
  let rope = new RopeV2({ x: 0, y: 0 }, 10);
  moves.forEach((move) => {
    rope.move(move);
  });
  console.log(rope.getUniqueLoacationsNumber());
}
part1();
//nefunguje
//part2();

export default {};
