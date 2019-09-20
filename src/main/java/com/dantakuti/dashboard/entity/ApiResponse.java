package com.dantakuti.dashboard.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adarshbhattarai on 2019-09-10
 * @project dashboard
 */
public class ApiResponse {

    List<String> messages;

    public ApiResponse(){
        messages = new ArrayList();
    }
    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
