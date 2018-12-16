package pl.azurix.message;

public class MinMessage {
    Long senderId;
    String message;

    public MinMessage(Long senderId, String message) {
        this.senderId = senderId;
        this.message = message;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getSenderId() {
        return senderId;
    }

    public String getMessage() {
        return message;
    }
}
