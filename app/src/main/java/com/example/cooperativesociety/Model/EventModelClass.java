package com.example.cooperativesociety.Model;

public class EventModelClass {
    private String image1,image2,image3,image4,eventName,eventCost,eventDescription;

    public EventModelClass() {
    }

    public EventModelClass(String image1, String image2, String image3, String image4, String eventName, String eventCost, String eventDescription) {
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.eventName = eventName;
        this.eventCost = eventCost;
        this.eventDescription = eventDescription;
    }

    public String getImage1() {
        return image1;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }

    public String getImage4() {
        return image4;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventCost() {
        return eventCost;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventCost(String eventCost) {
        this.eventCost = eventCost;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
