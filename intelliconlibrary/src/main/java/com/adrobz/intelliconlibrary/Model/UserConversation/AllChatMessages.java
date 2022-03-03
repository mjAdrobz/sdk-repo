package com.adrobz.intelliconlibrary.Model.UserConversation;

import com.adrobz.intelliconlibrary.Model.Attachment;
import com.adrobz.intelliconlibrary.Model.Payload;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class AllChatMessages {

    @SerializedName("options")
    public ArrayList<String> options;
    @SerializedName("_id")
    public String _id;
    @SerializedName("text")
    public String text;
    @SerializedName("author")
    public String author;
    @SerializedName("timestamp")
    public Date timestamp;
    @SerializedName("read")
    public ArrayList<AllReadMessages> read;
    @SerializedName("id")
    public String id;
    @SerializedName("attachment")
    public Attachment attachment;
    @SerializedName("payload")
    public Payload payload;

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<AllReadMessages> getRead() {
        return read;
    }

    public void setRead(ArrayList<AllReadMessages> read) {
        this.read = read;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
