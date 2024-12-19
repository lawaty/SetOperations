package BitNumOperations;

public interface IBitNum {  
  /**
   * sets the bit at index `index`
   */
  public int updateBit(int index, int val);
  /* 
   * returns the value at index `index`
   * 
   */
  public int getBit(int index);
  /**
   * returns a clone of the current object with the same content. Must return a pointer to a new object
   */
  // 
  public IBitNum clone();

  // Some Necessary Bitwise Operations. All these operations update the object and return nothing
  public void or(IBitNum operand);

  public void and(IBitNum operand);

  public void not();

  public int getDecimal();
}
