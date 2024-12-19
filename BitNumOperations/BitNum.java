package BitNumOperations;

public class BitNum implements IBitNum {
  private int num;

  public BitNum(int n) {
    this.num = n;
  }

  @Override
  public int getBit(int pos) {
    int bitmask = 1 << pos;
    if ((num & bitmask) % 2 == 0) {
      return 0;
    } else {
      return 1;
    }
  }

  public int setBit(int pos) {
    int bitmask = 1 << pos;
    return num | bitmask;
  }

  public int clearBit(int pos) {
    int bitmask = 1 << pos;
    return num & ~bitmask;
  }

  @Override
  public int updateBit(int pos, int value) {
    if (value == 0) {
      return clearBit(pos);
    } else {
      return setBit(pos);
    }
  }

  @Override
  public IBitNum clone() {
    return new BitNum(this.num);
  }

  @Override
  public void and(IBitNum operand) {
    this.num &= operand.getDecimal();
  }

  @Override
  public void or(IBitNum operand) {
    this.num |= operand.getDecimal();
  }

  @Override
  public void not() {
    this.num = ~this.num;
  }

  @Override
  public int getDecimal() {
    return this.num;
  }
}