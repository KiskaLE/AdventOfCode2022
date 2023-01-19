"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Rope {
    constructor(point) {
        this.parent = Object.assign({}, point);
        this.child = Object.assign({}, point);
        this.locations = [];
        this.parentLastPosition = Object.assign({}, point);
        this.childLastPosition = Object.assign({}, point);
        this.storeLoacation = false;
    }
    move(move) {
        this.parentLastPosition = Object.assign({}, this.parent);
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
    moveChild() {
        if (Math.abs(this.parent.x - this.child.x) > 1 ||
            Math.abs(this.parent.y - this.child.y) > 1) {
            this.childLastPosition = Object.assign({}, this.child);
            this.child = Object.assign({}, this.parentLastPosition);
            if (this.storeLoacation && this.isUnique()) {
                this.locations.push(this.child);
            }
        }
        else {
        }
    }
    setStoreLoacation(store) {
        this.storeLoacation = store;
    }
    getUniqueLocations() {
        return this.locations.length + 1;
    }
    isUnique() {
        for (let i = 0; i < this.locations.length; i++) {
            const e = this.locations[i];
            if (JSON.stringify(e) === JSON.stringify(this.child)) {
                return false;
            }
        }
        return true;
    }
    getEnd() {
        return this.child;
    }
    setParent(parent) {
        this.parent = parent;
    }
    moveSecond() {
        this.parentLastPosition = Object.assign({}, this.parent);
        this.moveChild();
    }
    toString() {
        return `Parent: x:${this.parent.x} y:${this.parent.y} Child: x:${this.child.x} y: ${this.child.y}`;
    }
}
exports.default = Rope;
