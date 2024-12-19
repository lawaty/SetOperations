package BitNumOperations;

public class part1 {
  public static void main(String[] args) {
    // Initialize BitNum object
    BitNum num = new BitNum(0);
    
    assert num.getBit(1) == 0 : "Test failed: getBit(1) should return 0";
    System.out.println("Test 1 Passed: getBit(1) = 0");

    num.setBit(2);
    assert num.getDecimal() == 4 : "Test failed: setBit(2) should set decimal value to 4";
    System.out.println("Test 2 Passed: setBit(2), Decimal = " + num.getDecimal());

    num.clearBit(0);
    assert num.getDecimal() == 4 : "Test failed: clearBit(0) should leave decimal value as 4";
    System.out.println("Test 3 Passed: clearBit(0), Decimal = " + num.getDecimal());

    num.updateBit(3, 1);
    assert num.getDecimal() == 12 : "Test failed: updateBit(3, 1) should set decimal value to 12";
    System.out.println("Test 4 Passed: updateBit(3, 1), Decimal = " + num.getDecimal());

    num.updateBit(2, 0);
    assert num.getDecimal() == 8 : "Test failed: updateBit(2, 0) should set decimal value to 8";
    System.out.println("Test 5 Passed: updateBit(2, 0), Decimal = " + num.getDecimal());

    assert num.getBit(3) == 1 : "Test failed: getBit(3) should return 1";
    System.out.println("Test 6 Passed: getBit(3) = " + num.getBit(3));

    num.not();
    assert num.getDecimal() == -9 : "Test failed: Complement operation should set decimal value to -9";
    System.out.println("Test 7 Passed: not(), Decimal = " + num.getDecimal());
  }
}
