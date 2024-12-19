package BitNumOperations;

public class BitNum implements IBitNum {
  private int num;

  public BitNum(int n) {
    this.num = n;
  }

  @Override
  public int getBit(int pos) {
    int bitmask = 1 << pos;
    return (num & bitmask) != 0 ? 1 : 0;
  }

  public void setBit(int pos) {
    int bitmask = 1 << pos;
    num |= bitmask;
  }

  public void clearBit(int pos) {
    int bitmask = 1 << pos;
    num &= ~bitmask;
  }


  @Override
  public int updateBit(int pos, int value) {
    if (value == 0) {
      clearBit(pos);
      return num;
    } else {
      setBit(pos);
      return num;
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