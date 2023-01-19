"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class RopeV2 {
    constructor(point, ropeLenght) {
        this.bodies = [];
        this.uniquePositions = [];
        for (let i = 0; i < ropeLenght; i++) {
            this.bodies.push({ x: 0, y: 0 });
        }
    }
    move(move) {
        for (let i = 0; i < move.numberOfMoves; i++) {
            let lastPosition = Object.assign({}, this.bodies[0]);
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
                if (Math.abs(this.bodies[j - 1].x - this.bodies[j].x) > 1 ||
                    Math.abs(this.bodies[j - 1].y - this.bodies[j].y) > 1) {
                    let temp = Object.assign({}, this.bodies[j]);
                    this.bodies[j] = lastPosition;
                    lastPosition = temp;
                    if (j === this.bodies.length - 1 && this.isUnique(this.bodies[j])) {
                        this.uniquePositions.push(Object.assign({}, this.bodies[j]));
                    }
                }
                else {
                    break;
                }
            }
        }
    }
    isUnique(body) {
        for (let i = 0; i < this.uniquePositions.length; i++) {
            const e = this.uniquePositions[i];
            if (JSON.stringify(e) === JSON.stringify(body)) {
                return false;
            }
        }
        return true;
    }
    getUniqueLoacationsNumber() {
        return this.uniquePositions.length;
    }
}
exports.default = RopeV2;
