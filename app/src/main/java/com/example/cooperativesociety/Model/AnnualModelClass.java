package com.example.cooperativesociety.Model;

public class AnnualModelClass {

    private String typeOfProgram,programLocatiion,programHistory,stringImage;

    public AnnualModelClass() {
    }

    public AnnualModelClass(String typeOfProgram, String programLocatiion,
                            String programHistory,String stringImage) {
        this.typeOfProgram = typeOfProgram;
        this.programLocatiion = programLocatiion;
        this.programHistory = programHistory;
        this.stringImage = stringImage;
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

    public String getStringImage() {
        return stringImage;
    }

    public AnnualModelClass(String stringImage) {
        this.stringImage = stringImage;
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
