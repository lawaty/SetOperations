package SetOperations;

public class BitNumStub implements IBitNum {
  private int bits;

  // Constructor to initialize the bit number with a given integer (default is 0)
  public BitNumStub(int initialBits) {
    this.bits = initialBits;
  }

  @Override
  public void updateBit(int index, int val) {
    // Stub implementation
  }

  @Override
  public boolean getBit(int index) {
    // Stub implementation
    return false;
  }

  @Override
  public IBitNum clone() {
    // Stub implementation
    return new BitNumStub(bits);
  }

  @Override
  public void or(IBitNum operand) {
    // Stub implementation
  }

  @Override
  public void and(IBitNum operand) {
    // Stub implementation
  }

  @Override
  public void not() {
    // Stub implementation
  }

  @Override
  public int getDecimal() {
    // Stub implementation
    return bits;
  }
}
