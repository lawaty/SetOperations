package SetOperations;

public class BitNumStub implements IBitNum {
  private int bits;

  // Constructor to initialize the bit number with a given integer (default is 0)
  public BitNumStub(int initialBits) {
    this.bits = initialBits;
  }

  @Override
  public void updateBit(int index, int val) {
     if(val == 1){
      bits = setBit(bits,index);
     }else{
      bits = clearBit(bits,index);
     }
  }

  @Override
  public boolean getBit(int number,int index) {
    int compare = 1 << index;
    return (number & compare) != 0;
   
  }
  public int setBit(int number,int index){
    int compare = 1 << index;
    number |= compare;
    return number;
    }
  public int clearBit(int number,int index){
    int compare = 1 << index;
    number &= ~compare;
    return number;
  }
  public int updateBit(int number,int index,int val){
    if(val == 1){
      return setBit(number,index);
    }else{
      return clearBit(number,index);
    }
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
