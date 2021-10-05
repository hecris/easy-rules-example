package com.mycompany.app;

public class QueryContext {
    private String submittedApp;
    private String submittedSubApp;
    private String queryType;
    private String label;
    private String routingGroup;

    QueryContext(
            String submittedApp,
            String submittedSubApp,
            String queryType,
            String label) {
        this.submittedApp = submittedApp;
        this.submittedSubApp = submittedSubApp;
        this.queryType = queryType;
        this.label = label;
            }

    public String getSubmittedApp() {
        return this.submittedApp;
    }

    public String getSubmittedSubApp() {
        return this.submittedSubApp;
    }

    public String getQueryType() {
        return this.queryType;
    }

    public String getLabel() {
        return this.label;
    }

    public String getRoutingGroup() {
        return this.routingGroup;
    }

    public void setRoutingGroup(String routingGroup) {
        this.routingGroup = routingGroup;
    }
}
