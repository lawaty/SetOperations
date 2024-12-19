package BitNumOperations;

public class part1 {
  public static void main(String[] args) {
    BitNum num = new BitNum(5);

    System.out.println(num.getBit(1));
    System.out.println(num.setBit(1));
    System.out.println(num.clearBit(0));
    System.out.println(num.updateBit(3, 1));
  }
}