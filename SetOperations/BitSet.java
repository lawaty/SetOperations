package SetOperations;

import java.util.List;
import java.util.ArrayList;

import BitNumOperations.IBitNum;


public class BitSet  {
  private Universe universe;
  private IBitNum num;

  public BitSet(Universe universe, IBitNum num) {
    this.universe = universe;
    this.num = num;
  }

  public IBitNum getBits() {
    return num;
  }

  public void add(String element) {
    int index = universe.indexOf(element);
    if (index != -1)
      this.num.updateBit(index, 1);
  }

  public BitSet union(BitSet otherSet) {
    IBitNum temp = this.num.clone();
    temp.or(otherSet.getBits());

    BitSet result = new BitSet(this.universe, temp);
    return result;
  }

  public BitSet intersection(BitSet otherSet) {
    IBitNum temp = this.num.clone();
    temp.and(otherSet.getBits());

    BitSet result = new BitSet(this.universe, temp);
    return result;
  }

  public BitSet complement() {
    IBitNum temp = this.num.clone();
    temp.not();

    BitSet result = new BitSet(this.universe, temp);
    return result;
  }

  public BitSet difference(BitSet otherSet) {
    return intersection(otherSet.complement());
  }

  public int cardinality() {
    int decimal = this.num.getDecimal();

    int result = 0;
    while(decimal > 0) {
      result += decimal & 1;
      decimal >>= 1;
    }

    return result;
  }

  public List getElements() {
    ArrayList<String> result = new ArrayList<String>();

    for(int i = 0; i < universe.size(); i++)
      if (this.num.getBit(i) == 1)
        result.add(universe.at(i));

    return result;
  }
}
