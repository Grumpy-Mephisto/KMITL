package PolishNotation;

import java.util.ArrayList;

public class Notation {

    private String equation;
    
    public Notation(String equation) {
        this.equation = equation;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public String getInfix() {
        return equation;
    }

    public String getPrefix() {
        return infixToPrefix(equation);
    }

    public String getPostfix() {
        return infixToPostfix(equation);
    }

    private String infixToPrefix(String infix) {
        String prefix = "";
        infix = infix.replaceAll("\s", "");
        ArrayList<Character> stack = new ArrayList<>();
        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);
            if (Character.isLetter(c)) {
                stack.add(c);
            } else {
                while (!stack.isEmpty() && getPrecedence(c) < getPrecedence(stack.get(stack.size() - 1))) {
                    prefix += stack.remove(stack.size() - 1) + " ";
                }
                stack.add(c);
            }
        }
        for(int i = stack.size() - 1; i >= 0; i--) {
            prefix += stack.get(i) + " ";
        }
        return prefix;
    }

    private String infixToPostfix(String infix) {
        String postfix = "";
        infix = infix.replaceAll("\\s+", "");
        ArrayList<Character> stack = new ArrayList<Character>();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isDigit(c)) {
                postfix += c + " ";
            } else {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.get(stack.size() - 1))) {
                    postfix += stack.remove(stack.size() - 1) + " ";
                }
                stack.add(c);
            }
        }
        for(int i = stack.size() - 1; i >= 0; i--) {
            postfix += stack.get(i) + " ";
        }
        return postfix;
    }

    private int getPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
