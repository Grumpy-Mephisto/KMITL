package SpanningTree;

import java.util.Stack;

public class Graph {
    public Graph() {
        setGraph();
    }

    private Stack<String> setGraph() {
        Stack<String> stack = new Stack<String>();
        stack.push("Minneapolis");
        stack.push("Chicago");
        stack.push("Milwaukee");
        stack.push("Louisville");
        stack.push("Cincinnati");
        stack.push("Detroit");
        stack.push("Nashville");
        stack.push("St. Louis");

        return stack;
    }

    public Stack<String> getGraph() {
        return setGraph();
    }

    public void printGraph() {
        Stack<String> stack = setGraph();
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
