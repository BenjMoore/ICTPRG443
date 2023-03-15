package com.company;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager
{
    public void WriteDataToFile(RelocationModel[] data){
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("RelocationData.Oas"));
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
    public void LogError(String error)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Errorlog.Oas"));
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
}
