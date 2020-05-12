package com.lev.example.messages;

public class CloseRecordRequest {

    private int idReader;
    private int idBook;

    public CloseRecordRequest() {
    }

    public int getIdReader() {
        return idReader;
    }

    public void setIdReader(int idReader) {
        this.idReader = idReader;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    @Override
    public String toString() {
        return "CloseRecordRequest{" +
                "idReader=" + idReader +
                ", idBook=" + idBook +
                '}';
    }
}
