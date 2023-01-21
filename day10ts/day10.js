"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
const fs = __importStar(require("fs"));
let cycle;
let X;
let count;
let screen;
function parseInput(url) {
    return fs.readFileSync(url).toString().split("\r\n");
}
function part1() {
    cycle = 1;
    X = 1;
    count = 0;
    const lines = parseInput("input.txt");
    lines.forEach((line) => {
        if (line == "noop") {
            noop(false);
        }
        else if (line.startsWith("addx")) {
            const [command, value] = line.split(" ");
            addx(parseInt(value), false);
        }
    });
    console.log(count);
}
function part2() {
    cycle = 1;
    X = 1;
    count = 0;
    screen = [];
    const lines = parseInput("input.txt");
    lines.forEach((line) => {
        if (line == "noop") {
            noop(true);
        }
        else if (line.startsWith("addx")) {
            const [command, value] = line.split(" ");
            addx(parseInt(value), true);
        }
    });
    console.log(drawScreen());
}
function drawScreen() {
    let s = "";
    for (let i = 0; i < screen.length; i++) {
        if (i > 0 && i % 40 === 0) {
            s += "\n";
        }
        s += screen[i];
    }
    return s;
}
function drawPixel() {
    if (cycle > 40) {
        cycle = 1;
    }
    if (Math.abs(cycle - 1 - X) <= 1) {
        screen.push("#");
    }
    else {
        screen.push(".");
    }
}
function noop(part2) {
    if (part2) {
        drawPixel();
    }
    cycle++;
    checkCycle();
}
function addx(value, part2) {
    for (let i = 0; i < 2; i++) {
        if (part2) {
            drawPixel();
        }
        cycle++;
        if (i === 1) {
            X += value;
        }
        checkCycle();
    }
}
function checkCycle() {
    if (cycle === 20 || (cycle > 0 && (cycle - 20) % 40 === 0)) {
        count += cycle * X;
    }
}
part1();
part2();
