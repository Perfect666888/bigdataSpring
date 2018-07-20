package com.bigdata.student.bean;

public class Message {
    private String msg;
    private String tip;

    public Message() {
        super();
    }

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg + '\'' +
                ", tip='" + tip + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Message(String msg, String tip) {

        this.msg = msg;
        this.tip = tip;
    }
}
