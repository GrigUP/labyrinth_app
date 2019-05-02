package ru.grig.labyrinth_app.common;

public class StatusMessage {

    private StatusEnum status;

    private String description;

    public StatusMessage(StatusEnum status, String description) {
        this.status = status;
        this.description = description;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
