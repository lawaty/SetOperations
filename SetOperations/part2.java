package SetOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BitNumOperations.BitNum;

enum Action {
  UNION, INTERSECTION, COMPLEMENT, DIFFERENCE, CARDINALITY, PRINT, EXIT
}

public class part2 {
  private Scanner scanner;
  private Universe universe;
  private List<BitSet> sets;

  public part2() {
    scanner = new Scanner(System.in);
    sets = new ArrayList<>();
    universe = new Universe(); // Initialize here
  }


  public static void main(String[] args) {
    part2 app = new part2();
    app.readUniverse();
    app.readSets();

    while (true) {
      System.out.println("\nChoose an operation (1-6) or 7 to exit:");
      System.out.println("1) Union, 2) Intersection, 3) Complement, 4) Difference, 5) Cardinality, 6) Print");

      int choice = app.scanner.nextInt();
      app.scanner.nextLine(); // Consume the newline character

      if (choice == 7) {
        System.out.println("Exiting...");
        break;
      }

      if (choice < 1 || choice > 6) {
        System.out.println("Invalid choice. Try again.");
        continue;
      }

      Action action = Action.values()[choice - 1];

      if (action == Action.COMPLEMENT || action == Action.CARDINALITY || action == Action.PRINT) {
        System.out.println("Enter the index of the set:");
        int index = app.scanner.nextInt();
        app.scanner.nextLine(); // Consume the newline character

        if (!app.isValidIndex(index)) {
          System.out.println("Invalid set index.");
          continue;
        }
        app.performOperation(index, action);
      } else {
        System.out.println("Enter the indices of the two sets:");
        int index1 = app.scanner.nextInt();
        int index2 = app.scanner.nextInt();
        app.scanner.nextLine(); // Consume the newline character

        if (!app.isValidIndex(index1) || !app.isValidIndex(index2)) {
          System.out.println("Invalid set indices.");
          continue;
        }
        app.performOperation(index1, index2, action);
      }
    }
  }

  private void performOperation(int index, Action action) {
    switch (action) {
      case COMPLEMENT:
        BitSet complementResult = sets.get(index).complement();
        System.out.println("Result: " + complementResult.getElements());
        break;
      case CARDINALITY:
        int cardinalityResult = sets.get(index).cardinality();
        System.out.println("Cardinality: " + cardinalityResult);
        break;
      case PRINT:
        System.out.println("Set elements: " + sets.get(index).getElements());
        break;
      default:
        System.out.println("Invalid operation.");
        break;
    }
  }

  private void performOperation(int index1, int index2, Action action) {
    switch (action) {
      case UNION:
        BitSet unionResult = sets.get(index1).union(sets.get(index2));
        System.out.println(sets.get(index1).getElements());
        System.out.println("Union Result: " + unionResult.getElements());
        break;
      case INTERSECTION:
        BitSet intersectionResult = sets.get(index1).intersection(sets.get(index2));
        System.out.println("Intersection Result: " + intersectionResult.getElements());
        break;
      case DIFFERENCE:
        BitSet differenceResult = sets.get(index1).difference(sets.get(index2));
        System.out.println("Difference Result: " + differenceResult.getElements());
        break;
      default:
        System.out.println("Invalid operation.");
        break;
    }
  }

  private void readUniverse() {
    System.out.println("Enter the elements of the Universe (U), separated by spaces:");
    universe = new Universe();
    String[] elements = scanner.nextLine().split("\\s+");
    for (String elem : elements)
      universe.add(elem);

    System.out.println("Universe: " + universe);
  }

  private void readSets() {
    System.out.print("Enter the number of sets: ");
    int numSets = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character

    for (int i = 0; i < numSets; i++) {
      System.out.println("Enter elements for Set " + i + " (separated by spaces):");
      String[] setElements = scanner.nextLine().split("\\s+");
      BitSet set = new BitSet(universe, new BitNum(0));
      for (String item : setElements) {
        set.add(item);
      }

      sets.add(set);
    }

    System.out.println("Sets:- ");
    for(BitSet set: sets)
      System.out.println(set.getElements());
  }

  private boolean isValidIndex(int index) {
    return index >= 0 && index < sets.size();
  }
}
