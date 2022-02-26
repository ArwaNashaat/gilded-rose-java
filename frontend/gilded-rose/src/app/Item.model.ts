export class Item {
    public id: number
    public name: string;
    public sellIn: number;
    public quality: number;
  
    constructor(name: string, sellIn: number, quality: number) {
      this.id = null;
      this.name = name;
      this.sellIn = sellIn;
      this.quality = quality;
    }
  }