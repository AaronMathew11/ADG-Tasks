packpackage com.example.dogbreedapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class Root {
    public Message message;
    public String status;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}