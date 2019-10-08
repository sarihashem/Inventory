package com.sariHunter.inventory.Classes;

public class Chat {

    // if we use private we need to use setters and getters;


    private String id;
    private String senderID;
    private String message;
    private long timeStamp;

    public Chat() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     *
     * Date d = new Date();
     * long time = d.getTime();
     *
     * Chat c = new Chat(.........)
     *
     * DatabaseRef.getInstance.getReference().child("stores").child(uid).push().setValue(CLASS " c ");
     *
     *
     * **/


}
