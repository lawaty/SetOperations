package BitNumOperations;

public class part1 {
  public static void main(String[] args) {
    BitNum num = new BitNum(0);

    System.out.println(num.getBit(1));
    num.setBit(2);
    System.out.println(num.getDecimal());
    num.clearBit(0);
    System.out.println(num.getDecimal());
    System.out.println(num.updateBit(3, 1));
  }
}