package com.example.RuleEngineAST.service;


//package com.example.RuleEngineAST.service;

import com.example.RuleEngineAST.model.Node;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RuleEngineService {

    // Method to create a rule (AST from a rule string)
    public Node createRule(String ruleString) {
        // Simple parsing logic: Assuming ruleString is in format "A AND B"
        String[] parts = ruleString.split(" "); // Split the string by spaces

        if (parts.length == 3) {
            Node leftNode = new Node("operand", parts[0], null); // Create left operand node
            Node rightNode = new Node("operand", parts[2], null); // Create right operand node

            // Create combined node with operator
            Node operatorNode = new Node("operator", parts[1], null);
            operatorNode.setLeft(leftNode);
            operatorNode.setRight(rightNode);

            return operatorNode; // Return the combined node
        } else {
            throw new IllegalArgumentException("Invalid rule format. Expected format: 'A AND B'");
        }
    }

    // Method to combine multiple rules into a single AST
    public Node combineRules(Node rule1, Node rule2, String operator) {
        // Create a new node for combining
        Node combinedNode = new Node("operator", operator, null);
        combinedNode.setLeft(rule1);
        combinedNode.setRight(rule2);
        return combinedNode;
    }

    // Method to evaluate the rule against given user data
    public boolean evaluateRule(Node node, Map<String, Object> data) {
        if (node == null) {
            return false;
        }

        // Evaluate operand node
        if (node.getType().equals("operand")) {
            // Assuming we have a value in the data map corresponding to the operand
            return data.containsKey(node.getValue()) && (Boolean) data.get(node.getValue());
        }

        // Evaluate operator node (AND/OR)
        if (node.getType().equals("operator")) {
            boolean leftEval = evaluateRule(node.getLeft(), data);
            boolean rightEval = evaluateRule(node.getRight(), data);

            if (node.getOperator().equals("AND")) {
                return leftEval && rightEval;
            } else if (node.getOperator().equals("OR")) {
                return leftEval || rightEval;
            }
        }
        return false;
    }
}
