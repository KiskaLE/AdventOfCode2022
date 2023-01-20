"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class System {
    constructor() {
        this.X = 1;
        this.cyclus = 0;
    }
    /**
     * noop
     */
    noop() {
        this.cyclus++;
    }
    /**
     * addx
     */
    addx(value) {
        this.cyclus += value;
    }
}
exports.default = System;
