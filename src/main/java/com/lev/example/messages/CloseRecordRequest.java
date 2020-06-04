package com.lev.example.messages;

public class CloseRecordRequest {

    private int id;

    public CloseRecordRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CloseRecordRequest{" +
                "id=" + id +
                '}';
    }
}
