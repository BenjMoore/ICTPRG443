package com.company;


import java.io.*;
/** Manages Read And Write Input and Output**/
public class FileManager
{
    private static String ErrorLog = "Errorlog.oas";
    private static String LogFile = "RelocationData.Oas";


    /**
     * Writes data to a file.
     *
     * @param data An array of RelocationModel objects to be written to the file.
     */
    public void WriteDataToFile(RelocationModel[] data){
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(LogFile));
            // iterator = 0 , while iterator != length of array, iterate
            for (int i = 0; i < data.length; i++)
            {
                // if empty, break
                if(data[i] == null)
                {
                    break;
                }
                // write file, string format [data];[data];[data]
                writer.write(
                        data[i].contactName + ";"
                        + data[i].contactType + ";"
                        +  data[i].phoneNUM + ";"
                        + data[i].emailWeblink + ";"
                        + data[i].contactNotes
                );

                //new line
                writer.newLine();
            }
            // close buffered writer
            writer.close();
        }
        // check for exception
        catch (Exception ex)
        {
            LogError(ex.getMessage());
            System.out.println("[! ERROR !]" +ex.getMessage());
        }
    }

    /**
     * Logs an error message to a file.
     *
     * @param error The error message to be logged.
     */
    public static void LogError(String error)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ErrorLog));
            // iterator = 0 , while iterator != length of array, iterate

                // write file, string format [data];[data];[data]
                writer.write("[! ERROR !] " + error);
                //new line
                writer.newLine();

            // close buffered writer
            writer.close();
        }
        // check for exception
        catch (Exception ex)
        {

        }
    }
    /**
     * Reads data from a file and returns an array of RelocationModel objects.
     *
     * @return An array of RelocationModel objects read from the file.
     */
    public static RelocationModel[] ReadDataFromFile()
    {
        // new instance of RelocationModel, Size 100
        RelocationModel[] data = new RelocationModel[100];

        try
        {
            // New Reader
            BufferedReader reader = new BufferedReader(new FileReader(LogFile));

            // Current line
            String line;
            // Current Place in array
            int count = 0;

            // while line is not empty
            while ((line = reader.readLine()) != null)
            {
                // split file using regex
                String[] temp = line.split(";");
                // add entry to data model
                RelocationModel newentry = new RelocationModel(temp[0],temp[1],temp[2],temp[3],temp[4]);
                // set data
                data[count] = newentry;
                // itterate
                count++;
            }

            // close reader
            reader.close();
        }
        catch (Exception ex)
        {
            // log error
            LogError("[! Error !]" + ex.getMessage());
        }
        return data;
    }
}
