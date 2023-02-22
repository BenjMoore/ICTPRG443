package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class ReadWrite

{

    public static class WriteToFile {

        public static void main(String[] args) {
            try
            {
                FileWriter myWriter = new FileWriter("/com.company/data.csv");
                myWriter.write("Test");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");

            }
            catch (IOException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

}

