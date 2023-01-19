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
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const fs = __importStar(require("fs"));
const rope_1 = __importDefault(require("./rope"));
const ropeV2_1 = __importDefault(require("./ropeV2"));
function parseMoves(url) {
    let moves = [];
    let lines = fs.readFileSync(url).toString().split("\n");
    lines.forEach((line) => {
        let move = line.replace(new RegExp(/[0-9 ]/g), "");
        let numberOfMoves = parseInt(line.replace(new RegExp(/[A-Z ]/gi), ""));
        moves.push({ move: move, numberOfMoves: numberOfMoves });
    });
    return moves;
}
function part1() {
    const moves = parseMoves("input.txt");
    let rope = new rope_1.default({ x: 0, y: 0 });
    rope.setStoreLoacation(true);
    moves.forEach((move) => {
        for (let i = 0; i < move.numberOfMoves; i++) {
            rope.move(move.move);
        }
    });
    console.log(rope.getUniqueLocations());
}
function part2() {
    const moves = parseMoves("input.txt");
    let rope = new ropeV2_1.default({ x: 0, y: 0 }, 10);
    moves.forEach((move) => {
        rope.move(move);
    });
    console.log(rope.getUniqueLoacationsNumber());
}
part1();
//nefunguje
//part2();
exports.default = {};
