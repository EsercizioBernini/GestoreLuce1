/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestoreluce1;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JsonMap {

    String id;
    String action, message, status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JsonMap() {
    }

    public JsonMap(String id, String action, String message) {
        this.id = id;
        this.action = action;
        this.message = message;
    }

    public JsonMap(String id, String status, String message, String action) {
        this.id = id;
        this.action = action;
        this.status = status;
        this.message = message;

    }
}
