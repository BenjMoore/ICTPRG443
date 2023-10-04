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

    /*

          Relocation Model, Creates a DTO for all of the information needed to populate the text fields
           @param contactName,contactType,phoneNUM,emailWeblink,contactNotes


            */
    public RelocationModel(String contactName, String contactType, String phoneNUM, String emailWeblink, String contactNotes)
    {
        this.contactName = contactName;
        this.contactType = contactType;
        this.phoneNUM = phoneNUM;
        this.emailWeblink = emailWeblink;
        this.contactNotes = contactNotes;
    }
    /*

           Gets contact name from dto

           @returns contactName

            */
    public String getContactName() { return contactName; }
    /*

       Set Contact Name
       @param contactName


        */
    public void setContactName(String contactName) { this.contactName = contactName; }
    /*

        Gets PhoneNum from dto

        @returns PhoneNUM

         */
    public String getPhoneNUM() { return phoneNUM; }
    /*

       Set Phone Number
       @param phoneNUM


        */
    public void setPhoneNUM(String phoneNUM) { this.phoneNUM = phoneNUM; }
    /*

        Gets Contact Notes from dto

        @returns ContactNotes

         */
    public String getContactNotes() { return contactNotes; }
    /*

       Set Contact Notes
       @param contactNotes


        */
    public void setContactNotes(String contactNotes) {this.contactNotes = contactNotes; }
    /*

        Gets Email Web Link from dto

        @returns emailWebLink

         */
    public String getEmailWeblink() { return emailWeblink; }
    /*

       Set Email Web Link
       @param emailWebLink


        */
    public void setEmailWeblink(String emailWeblink) { this.emailWeblink = emailWeblink; }
    /*

        Gets contact Type from dto

        @returns contactType

         */
    public String getContactType() { return contactType; }
    /*

       Set Contact Type
       @param contactType


        */
    public void setContactType(String contactType) { this.contactType = contactType; }
}






