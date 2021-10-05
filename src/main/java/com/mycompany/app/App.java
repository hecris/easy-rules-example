package com.mycompany.app;

import com.mycompany.app.Router;

public class App 
{
    public static void main( String[] args )
    {
        Router router = new Router();
        router.loadRulesFromFile("routing_rules.yml");

        // query coming from airflow with type scheduled
        QueryContext airflow_query = new QueryContext(
                "airflow", "", "", "");

        // query coming from airflow with label coco
        QueryContext airflow_scheduled_query = new QueryContext(
                "airflow", "", "", "coco");
        
        // query coming from verity with submitted_sub_app blocking
        QueryContext verity_blocking_query = new QueryContext(
                "verity", "blocking", "", "");
        
        // query coming from verity with submitted_sub_app non-blocking
        QueryContext verity_non_blocking_query = new QueryContext(
                "verity", "non_blocking", "", "");

        // query from mode
        QueryContext mode_query = new QueryContext(
                "mode", "", "", "");
       
        // query from spellbook - defaults to adhoc
        QueryContext spellbook_query = new QueryContext(
                "spellbook", "", "", "");
      
        System.out.println(router.getRoutingGroup(airflow_query)); // etl
        System.out.println(router.getRoutingGroup(airflow_scheduled_query)); // etl-critical
        System.out.println(router.getRoutingGroup(verity_blocking_query)); // etl-critical
        System.out.println(router.getRoutingGroup(verity_non_blocking_query)); // etl-scheduled
        System.out.println(router.getRoutingGroup(mode_query)); // scheduled
        System.out.println(router.getRoutingGroup(spellbook_query)); // adhoc
    }
}
