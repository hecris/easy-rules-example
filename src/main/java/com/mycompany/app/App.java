package com.mycompany.app;

import com.mycompany.app.Router;

public class App 
{
    public static void main( String[] args )
    {
        Router router = new Router();
        router.loadRulesFromFile("routing_rules.json");

        // query coming from airflow with type scheduled
        QueryContext airflow_query = new QueryContext(
                "airflow", "", "", "");

        // query coming from airflow with type scheduled
        QueryContext airflow_scheduled_query = new QueryContext(
                "airflow", "", "scheduled", "");

        // query from mode
        QueryContext mode_query = new QueryContext(
                "mode", "", "", "");

        System.out.println(router.getRoutingGroup(airflow_query)); // etl
        System.out.println(router.getRoutingGroup(airflow_scheduled_query)); // etl-scheduled
        System.out.println(router.getRoutingGroup(mode_query)); // scheduled
    }
}
