package com.example.RuleEngineAST.controller;


import com.example.RuleEngineAST.model.Node;
import com.example.RuleEngineAST.service.RuleEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/rules")
public class RuleEngineController {

    @Autowired
    private RuleEngineService ruleEngineService;

    // API to create a rule from a rule string
    @PostMapping("/create")
    public Node createRule(@RequestBody String ruleString) {
        return ruleEngineService.createRule(ruleString);
    }

    // API to combine two rules with a given operator (AND/OR)
    @PostMapping("/combine")
    public Node combineRules(@RequestBody Map<String, Object> body) {
        Node rule1 = (Node) body.get("rule1");
        Node rule2 = (Node) body.get("rule2");
        String operator = (String) body.get("operator");
        return ruleEngineService.combineRules(rule1, rule2, operator);
    }

    // API to evaluate a rule against user data
    @PostMapping("/evaluate")
    public boolean evaluateRule(@RequestBody Map<String, Object> body) {
        Node rule = (Node) body.get("rule");
        Map<String, Object> data = (Map<String, Object>) body.get("data");
        return ruleEngineService.evaluateRule(rule, data);
    }
}
