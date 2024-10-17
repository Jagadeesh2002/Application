package com.example.RuleEngineAST.model;


public class Node {
    private String type;        // "operator" or "operand"
    private Node left;          // left child node
    private Node right;         // right child node
    private String operator;    // AND/OR for operator nodes
    private String value;       // condition for operand nodes

    // Constructors
    public Node(String type, String operator, String value) {
        this.type = type;
        this.operator = operator;
        this.value = value;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

