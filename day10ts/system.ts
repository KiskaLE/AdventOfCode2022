export default class System {
  X: number;
  cyclus: number;
  constructor() {
    this.X = 1;
    this.cyclus = 0;
  }

  /**
   * noop
   */
  public noop() {
    this.cyclus++;
  }

  /**
   * addx
   */
  public addx(value: number) {
    this.cyclus += value;
  }
}
