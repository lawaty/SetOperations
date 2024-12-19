package SetOperations;

import java.util.ArrayList;
import java.util.List;

public class Universe {
  private List<String> elements;

  public Universe() {
    this.elements = new ArrayList<String>();
  }

  public void add(String element) {
    this.elements.add(element);
  }

  public int size() {
    return this.elements.size();
  }

  public int indexOf(String element) {
    return this.elements.indexOf(element);
  }

  public void print() {
    System.out.println("{"+ String.join(", ", elements)+"}");
  }

  public String at(int index) {
    if (index >= 0 && index < elements.size()) {
      return elements.get(index);
    } else {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
  }

  @Override
  public String toString() {
    return "{" + String.join(", ", elements) + "}";
  }

}
