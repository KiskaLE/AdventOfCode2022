import { Point, Move } from "./types";

export default class RopeV2 {
  bodies: Point[] = [];
  uniquePositions: Point[] = [];

  constructor(point: Point, ropeLenght: number) {
    for (let i = 0; i < ropeLenght; i++) {
      this.bodies.push({ x: 0, y: 0 });
    }
  }

  public move(move: Move) {
    for (let i = 0; i < move.numberOfMoves; i++) {
      let lastPosition = { ...this.bodies[0] };
      switch (move.move) {
        case "L":
          this.bodies[0].x--;
          break;
        case "U":
          this.bodies[0].y++;
          break;
        case "R":
          this.bodies[0].x++;
          break;
        case "D":
          this.bodies[0].y--;
          break;
        default:
          break;
      }
      for (let j = 1; j < this.bodies.length; j++) {
        if (
          Math.abs(this.bodies[j - 1].x - this.bodies[j].x) > 1 ||
          Math.abs(this.bodies[j - 1].y - this.bodies[j].y) > 1
        ) {
          let temp = { ...this.bodies[j] };
          this.bodies[j] = lastPosition;
          lastPosition = temp;
          if (j === this.bodies.length - 1 && this.isUnique(this.bodies[j])) {
            this.uniquePositions.push({ ...this.bodies[j] });
          }
        } else {
          break;
        }
      }
    }
  }

  private isUnique(body: Point): boolean {
    for (let i = 0; i < this.uniquePositions.length; i++) {
      const e = this.uniquePositions[i];
      if (JSON.stringify(e) === JSON.stringify(body)) {
        return false;
      }
    }
    return true;
  }

  public getUniqueLoacationsNumber(): number {
    return this.uniquePositions.length;
  }
}
