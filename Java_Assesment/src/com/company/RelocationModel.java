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

    public RelocationModel()
    {

    }

    public RelocationModel(String contactName, String contactType, String phoneNUM, String emailWeblink, String contactNotes)
    {
        this.contactName = contactName;
        this.contactType = contactType;
        this.phoneNUM = phoneNUM;
        this.emailWeblink = emailWeblink;
        this.contactNotes = contactNotes;
    }


}






