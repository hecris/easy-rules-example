package com.mycompany.app;

import com.mycompany.app.Router;


public class App 
{
    public static void main( String[] args )
    {
        Router router = new Router();
        router.addRuleFromFile("routing_rules.json");


        QueryContext context = new QueryContext(
                "airflow", "", "scheduled", "");

        QueryContext context2 = new QueryContext(
                "mode", "", "", "");

        System.out.println(router.getRoutingGroup(context));
        System.out.println(router.getRoutingGroup(context2));
    }
}
