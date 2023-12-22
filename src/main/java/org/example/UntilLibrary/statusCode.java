package org.example.UntilLibrary;

enum statusCode {
    OK(200), NOT_FOUND(404);

    private int status;

    statusCode(int status){
        this.status = status;
    }

    public int getStatusNumber() {
        return status;
    }
}
