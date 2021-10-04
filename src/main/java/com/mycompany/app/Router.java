package com.mycompany.app;

import com.mycompany.app.QueryContext;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.reader.JsonRuleDefinitionReader;
import org.jeasy.rules.support.reader.YamlRuleDefinitionReader;

import java.io.FileReader;
// import java.io.IOException;

class Router {
    private Rules rules;
    private RulesEngine rulesEngine;

    Router() {
        this.rules = new Rules();
        this.rulesEngine =  new DefaultRulesEngine();
    }

    public void loadRulesFromFile(String fileName) {
        try {
            MVELRuleFactory ruleFactory = new MVELRuleFactory(new JsonRuleDefinitionReader());
            this.rules = ruleFactory.createRules(new FileReader(fileName));
        }
        catch(Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println(e);
        }
    }

    public String getRoutingGroup(QueryContext context) {
        Facts facts = new Facts();
        facts.put("context", context);
        rulesEngine.fire(rules, facts);
        return context.getRoutingGroup();
    }
}
