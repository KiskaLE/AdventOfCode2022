import { Move, Point } from "./types";
export default class Rope {
  parent: Point;
  child: Point;
  locations: Point[];
  parentLastPosition: Point;
  constructor(point: Point) {
    this.parent = { ...point };
    this.child = { ...point };
    this.locations = [];
    this.parentLastPosition = { ...point };
  }

  public move(move: string): void {
    this.parentLastPosition = { ...this.parent };
    switch (move) {
      case "L":
        this.parent.x--;
        break;
      case "U":
        this.parent.y++;
        break;
      case "R":
        this.parent.x++;
        break;
      case "D":
        this.parent.y--;
        break;
      default:
        break;
    }
    this.moveChild();
  }
  private moveChild(): void {
    if (
      Math.abs(this.parent.x - this.child.x) > 1 ||
      Math.abs(this.parent.y - this.child.y) > 1
    ) {
      this.child = this.parentLastPosition;
      //add of unique
      if (this.isUnique()) {
        this.locations.push(this.child);
      }
    } else {
    }
  }

  public getUniqueLocations(): number {
    return this.locations.length + 1;
  }

  private isUnique(): boolean {
    for (let i = 0; i < this.locations.length; i++) {
      const e = this.locations[i];
      if (JSON.stringify(e) === JSON.stringify(this.child)) {
        return false;
      }
    }
    return true;
  }
  public getEnd(): Point {
    return this.child;
  }
  public setParent(parent: Point): void {
    this.parent = { ...parent };
    this.parentLastPosition = this.parent;
    this.moveChild();
  }

  public toString(): string {
    return `Parent: x:${this.parent.x} y:${this.parent.y} Child: x:${this.child.x} y: ${this.child.y}`;
  }
}
