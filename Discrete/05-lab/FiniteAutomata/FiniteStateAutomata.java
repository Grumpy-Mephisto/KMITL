package FiniteAutomata;

import java.util.HashMap;
import java.util.Map;

public class FiniteStateAutomata {

  private int currentState;
  private Map<Integer, Map<Character, Integer>> transitions;

  public FiniteStateAutomata() {
    currentState = 0; // Start node is 0

    // Define the transitions
    transitions = new HashMap<>();
    transitions.put(0, Map.of('0', 1, '1', 2)); // Node 1 transitions to Node 2 on 0 and Node 3 on 1
    transitions.put(1, Map.of('0', 0, '1', 3)); // Node 2 transitions to Node 1 on 0 and Node 4 on 1
    transitions.put(2, Map.of('0', 3, '1', 0)); // Node 3 transitions to Node 4 on 0 and Node 1 on 1
    transitions.put(3, Map.of('0', 2, '1', 1)); // Node 4 transitions to Node 3 on 0 and Node 2 on 1
  }

  public void processInput(String input) {
    System.out.println("===== Start node: Node 1 - Final node: Node 4 =====");

    for (char ch : input.toCharArray()) {
      int previousState = currentState;
      currentState = transitions.get(currentState).get(ch);
      System.out.println("Input: " + ch);
      System.out.printf(
        "Node %d --%c--> Node %d\n",
        previousState + 1,
        ch,
        currentState + 1
      );
      System.out.println("===================================================");
    }

    if (currentState == 3) {
      System.out.printf("%s is accepted\n", input);
    } else {
      System.out.printf("%s is rejected\n", input);
    }
  }
}
