package com.example.cooperativesociety.Model;

public class AnnualModelClass {

    private String typeOfProgram,programLocatiion,programHistory;

    public AnnualModelClass() {
    }

    public AnnualModelClass(String typeOfProgram, String programLocatiion, String programHistory) {
        this.typeOfProgram = typeOfProgram;
        this.programLocatiion = programLocatiion;
        this.programHistory = programHistory;
    }

    public String getTypeOfProgram() {
        return typeOfProgram;
    }

    public void setTypeOfProgram(String typeOfProgram) {
        this.typeOfProgram = typeOfProgram;
    }

    public String getProgramLocatiion() {
        return programLocatiion;
    }

    public void setProgramLocatiion(String programLocatiion) {
        this.programLocatiion = programLocatiion;
    }

    public String getProgramHistory() {
        return programHistory;
    }

    public void setProgramHistory(String programHistory) {
        this.programHistory = programHistory;
    }
}
