package com.example.cooperativesociety.Model;

public class HelpModelClass  {

    private int helpCost,totalHelpCost;
    private String helpDesc;
    public HelpModelClass() {
    }

    public HelpModelClass(int helpCost, String helpDesc) {
        this.helpCost = helpCost;
        this.helpDesc = helpDesc;
    }

    public HelpModelClass(int totalHelpCost) {
        this.totalHelpCost = totalHelpCost;
    }

    public int getTotalHelpCost() {
        return totalHelpCost;
    }

    public void setTotalHelpCost(int totalHelpCost) {
        this.totalHelpCost = totalHelpCost;
    }

    public int getHelpCost() {
        return helpCost;
    }

    public void setHelpCost(int helpCost) {
        this.helpCost = helpCost;
    }

    public String getHelpDesc() {
        return helpDesc;
    }

    public void setHelpDesc(String helpDesc) {
        this.helpDesc = helpDesc;
    }
}
