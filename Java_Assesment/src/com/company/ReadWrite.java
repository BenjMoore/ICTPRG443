package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.BufferedReader;
import java.io.FileReader;


public class ReadWrite {

    public static List<String[]> read(String filename) throws IOException {

        List<String[]> data = new ArrayList<String[]>();

        BufferedReader br = new BufferedReader(new FileReader(filename));

        String line;

        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            data.add(row);
        }

        br.close();

        return data;

    }

    public static void writeToFile(String fileName, String content) throws IOException {

            List<String[]> data = new ArrayList<String[]>();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            int i = 0;


            writer.close();
            System.out.println("Successfully wrote to the file.");

        }

        }




