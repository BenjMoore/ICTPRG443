package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.BufferedReader;
import java.io.FileReader;


public class RelocationModel {



    public String contactName;
    public String contactType;
    public String phoneNUM;
    public String emailWeblink;
    public String contactNotes;


    public RelocationModel(String contactName, String contactType, String phoneNUM, String emailWeblink, String contactNotes)
    {
        this.contactName = contactName;
        this.contactType = contactType;
        this.phoneNUM = phoneNUM;
        this.emailWeblink = emailWeblink;
        this.contactNotes = contactNotes;
    }

    public String getContactName() { return contactName; }
    public void setContactName(String contactName) { this.contactName = contactName; }
    public String getPhoneNUM() { return phoneNUM; }
    public void setPhoneNUM(String phoneNUM) { this.phoneNUM = phoneNUM; }
    public String getContactNotes() { return contactNotes; }
    public void setContactNotes(String contactNotes) {this.contactNotes = contactNotes; }
    public String getEmailWeblink() { return emailWeblink; }
    public void setEmailWeblink(String emailWeblink) { this.emailWeblink = emailWeblink; }
    public String getContactType() { return contactType; }
    public void setContactType(String contactType) { this.contactType = contactType; }
}






