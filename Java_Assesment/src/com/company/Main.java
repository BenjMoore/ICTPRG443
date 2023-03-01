package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame implements ActionListener {



    ////////////////////////////////
    //// --- UI Components --- /////
    ////////////////////////////////
    // Declare Lables //

    public static  JButton btnClose;
    public static  Button btnInput;
    public static  JTextField txtName;
    public static JTextField txtContactType;
    public static JTextField txtPhonenum;
    public static JTextField txtEmail;
    public static JTextField txtNotes;
    public static  JTextField txtSearch;
    public static JTextField txtBinary_Query;
    public static JLabel txtBinary_Sub;
    public static JButton txtBinary_Submit;
    public static JLabel Searchlbl;
    public static JLabel lblTitle;
    public static JLabel lblName;
    public static JLabel lblContactType;
    public static JLabel lblEmail;
    public static JLabel lblNotes;
    public static JLabel lblSearch;
    public static JTextField txtMessage;
    public static JButton FullBack;
    public static JButton Back;
    public static JButton Forward;
    public static JButton FullForward;
    public static JButton Find;
    public static JButton New;
    public static JButton Save;
    public static JButton Delete;
    public static JLabel ListLabel;
    public static JButton Exit;
    public static JButton txtSortbyName;
    public static JTextField txtFilter;
    public static JLabel txtFilters;
    public static JButton filterBtn;
    public static JTextArea customerList;
    public static JLabel lblPhonenum;
    public static List<String[]> data;
    public static int currentRecord;

    public static void main(String[] args) throws FileNotFoundException
    {
        new Main();
        //ReadFile

    }


    public Main() throws FileNotFoundException{

        new ReadWrite();
        SpringLayout myLayout = new SpringLayout();//Creating Spring layout
        this.setLayout(myLayout);//Setting spring layout to form
        this.setSize(600, 550);//Set Form size
        this.getContentPane().setBackground(Color.lightGray);//Change form background color
        this.setLocation(250, 250);//Set form start position

        // Title
        lblTitle = new JLabel("Relocation Manager");
        myLayout.putConstraint(SpringLayout.WEST, lblTitle, 15, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblTitle, 10, SpringLayout.NORTH, this);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Courier", Font.BOLD, 25));
        this.add(lblTitle);

        Searchlbl = new JLabel("Company Search");
        myLayout.putConstraint(SpringLayout.WEST, Searchlbl, 410, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, Searchlbl, 20, SpringLayout.NORTH, this);
        Searchlbl.setForeground(Color.BLACK);
        Searchlbl.setFont(new Font("Courier", Font.ITALIC, 15));
        this.add(Searchlbl);

        // Persons Name
        lblName = new JLabel("<html><span bgcolor=\"Black\"> Contact Name:  </span></html>");
        myLayout.putConstraint(SpringLayout.WEST, lblName, 25, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblName, 65, SpringLayout.NORTH, this);
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Calbri", Font.BOLD, 12));
        this.add(lblName);

        // Likes
        lblContactType = new JLabel("<html><span bgcolor=\"Black\"> Contact Type:  </span></html>");
        myLayout.putConstraint(SpringLayout.WEST, lblContactType, 25, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblContactType, 95, SpringLayout.NORTH, this);
        lblContactType.setForeground(Color.WHITE);
        lblContactType.setFont(new Font("Calbri", Font.BOLD, 12));
        this.add(lblContactType);

        // Dislikes
        lblPhonenum = new JLabel("<html><span bgcolor=\"Black\"> Phone/Mobile:  </span></html>");
        myLayout.putConstraint(SpringLayout.WEST, lblPhonenum, 25, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblPhonenum, 125, SpringLayout.NORTH, this);
        lblPhonenum.setForeground(Color.WHITE);
        lblPhonenum.setFont(new Font("Calbri", Font.BOLD, 12));
        this.add(lblPhonenum);

        // Bday Day
        lblEmail = new JLabel("<html><span bgcolor=\"Black\"> Weblink/Email:  </span></html>");
        myLayout.putConstraint(SpringLayout.WEST, lblEmail, 25, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblEmail, 155, SpringLayout.NORTH, this);
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Calbri", Font.BOLD, 12));
        this.add(lblEmail);

        // Bday Month
        lblNotes = new JLabel("<html><span bgcolor=\"Black\"> Contact Notes:  </span></html>");
        myLayout.putConstraint(SpringLayout.WEST, lblNotes, 25, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblNotes, 185, SpringLayout.NORTH, this);
        lblNotes.setForeground(Color.WHITE);
        lblNotes.setFont(new Font("Calbri", Font.BOLD, 12));
        this.add(lblNotes);

        // Search

        lblSearch = new JLabel("<html><span bgcolor=\"Black\"> Company:  </span></html>");
        myLayout.putConstraint(SpringLayout.WEST, lblSearch, 335, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblSearch, 62, SpringLayout.NORTH, this);
        lblSearch.setForeground(Color.WHITE);
        lblSearch.setFont(new Font("Calbri", Font.BOLD, 12));
        this.add(lblSearch);

        // List lable

        txtBinary_Sub = new JLabel("Contact List:");
        myLayout.putConstraint(SpringLayout.WEST, txtBinary_Sub, 15, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtBinary_Sub, 325, SpringLayout.NORTH, this);
        txtBinary_Sub.setForeground(Color.black);
        txtBinary_Sub.setFont(new Font("Calbri", Font.BOLD, 13));
        this.add(txtBinary_Sub);

        txtFilters = new JLabel("Filter By:");
        myLayout.putConstraint(SpringLayout.WEST, txtFilters, 15, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtFilters, 275, SpringLayout.NORTH, this);
        txtFilters.setForeground(Color.black);
        txtFilters.setFont(new Font("Calbri", Font.BOLD, 13));
        this.add(txtFilters);

        // Text Fields  \\
        customerList = new JTextArea("Customers displayed here!");
        customerList.setLineWrap(true);
        customerList.setWrapStyleWord(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        customerList.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(50, 250, 50, 200)));

        myLayout.putConstraint(SpringLayout.WEST, customerList, 10, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, customerList, 350, SpringLayout.NORTH, this);
        this.add(customerList);

        txtFilter = new JTextField("", 25);
        myLayout.putConstraint(SpringLayout.WEST, txtFilter, 100, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtFilter, 275, SpringLayout.NORTH, this);
        txtFilter.setForeground(Color.BLACK);
        txtFilter.setFont(new Font("Calbri", Font.PLAIN, 10));
        this.add(txtFilter);

        txtName = new JTextField("", 25);
        myLayout.putConstraint(SpringLayout.WEST, txtName, 125, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtName, 65, SpringLayout.NORTH, this);
        txtName.setForeground(Color.BLACK);
        txtName.setFont(new Font("Calbri", Font.PLAIN, 9));
        this.add(txtName);

        txtContactType = new JTextField("", 25);
        myLayout.putConstraint(SpringLayout.WEST, txtContactType, 125, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtContactType, 95, SpringLayout.NORTH, this);
        txtContactType.setForeground(Color.BLACK);
        txtContactType.setFont(new Font("Calbri", Font.PLAIN, 9));
        this.add(txtContactType);

        txtPhonenum = new JTextField("", 25);
        myLayout.putConstraint(SpringLayout.WEST, txtPhonenum, 125, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtPhonenum, 125, SpringLayout.NORTH, this);
        txtPhonenum.setForeground(Color.BLACK);
        txtPhonenum.setFont(new Font("Calbri", Font.PLAIN, 9));
        this.add(txtPhonenum);

        txtEmail = new JTextField("", 25);
        myLayout.putConstraint(SpringLayout.WEST, txtEmail, 125, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtEmail, 155, SpringLayout.NORTH, this);
        txtEmail.setForeground(Color.BLACK);
        txtEmail.setFont(new Font("Calbri", Font.PLAIN, 9));
        this.add(txtEmail);

        txtNotes = new JTextField("", 25);
        myLayout.putConstraint(SpringLayout.WEST, txtNotes, 125, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtNotes, 185, SpringLayout.NORTH, this);
        txtNotes.setForeground(Color.BLACK);
        txtNotes.setFont(new Font("Calbri", Font.PLAIN, 9));
        this.add(txtNotes);

        txtSearch = new JTextField("", 8);
        myLayout.putConstraint(SpringLayout.WEST, txtSearch, 400, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtSearch, 60, SpringLayout.NORTH, this);
        txtSearch.setForeground(Color.BLACK);
        txtSearch.setFont(new Font("Calbri", Font.PLAIN, 12));
        txtSearch.setSize(10, 10);
        this.add(txtSearch);


        // Buttons //



        Back = new JButton("<");
        Back.addActionListener(this);
        Back.setSize(80, 25);
        myLayout.putConstraint(SpringLayout.WEST, Back, 420, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, Back, 180, SpringLayout.NORTH, this);
        Back.setForeground(Color.BLACK);
        Back.setBackground(Color.GRAY);
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        Back.setBorder(compound);
        this.add(Back);

        FullBack = new JButton("|<");
        FullBack.addActionListener(this);
        FullBack.setSize(80, 25);
        myLayout.putConstraint(SpringLayout.WEST, FullBack, 380, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, FullBack, 180, SpringLayout.NORTH, this);
        FullBack.setForeground(Color.BLACK);
        FullBack.setBackground(Color.GRAY);
        Border line11 = new LineBorder(Color.BLACK);
        Border margin11 = new EmptyBorder(5, 15, 5, 15);
        Border compound11 = new CompoundBorder(line, margin);
        FullBack.setBorder(compound);
        // FullBack.addActionListener(new ActionListener);
        this.add(FullBack);

        Forward = new JButton(">");
        Forward.addActionListener(this);
        Forward.setSize(80, 25);
        myLayout.putConstraint(SpringLayout.WEST, Forward, 460, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, Forward, 180, SpringLayout.NORTH, this);
        Forward.setForeground(Color.BLACK);
        Forward.setBackground(Color.GRAY);
        Border line1 = new LineBorder(Color.BLACK);
        Border margin1 = new EmptyBorder(5, 15, 5, 15);
        Border compound1 = new CompoundBorder(line, margin);
        Forward.setBorder(compound);
        this.add(Forward);

        filterBtn = new JButton("Filer!");
        filterBtn.addActionListener(this);
        filterBtn.setSize(80, 25);
        myLayout.putConstraint(SpringLayout.WEST, filterBtn, 340, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, filterBtn, 270, SpringLayout.NORTH, this);
        // FullBack.addActionListener(new ActionListener);
        filterBtn.setForeground(Color.BLACK);
        filterBtn.setBackground(Color.GRAY);
        Border line2 = new LineBorder(Color.BLACK);
        Border margin2 = new EmptyBorder(5, 15, 5, 15);
        Border compound2 = new CompoundBorder(line, margin);
        filterBtn.setBorder(compound);
        this.add(filterBtn);

        FullForward = new JButton(">|");
        FullForward.addActionListener(this);
        FullForward.setSize(80, 25);
        myLayout.putConstraint(SpringLayout.WEST, FullForward, 500, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, FullForward, 180, SpringLayout.NORTH, this);
        FullForward.setForeground(Color.BLACK);
        FullForward.setBackground(Color.GRAY);
        Border line3 = new LineBorder(Color.BLACK);
        Border margin3 = new EmptyBorder(5, 15, 5, 15);
        Border compound3 = new CompoundBorder(line, margin);
        FullForward.setBorder(compound);
        this.add(FullForward);

        Find = new JButton("Find");
        Find.addActionListener(this);
        myLayout.putConstraint(SpringLayout.WEST, Find, 500, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, Find, 55, SpringLayout.NORTH, this);
        Find.setForeground(Color.BLACK);
        Find.setBackground(Color.GRAY);
        Border line4 = new LineBorder(Color.BLACK);
        Border margin4 = new EmptyBorder(5, 15, 5, 15);
        Border compound4 = new CompoundBorder(line, margin);
        Find.setBorder(compound);
        this.add(Find);

        Exit = new JButton("Exit");
        Exit.addActionListener(this);
        myLayout.putConstraint(SpringLayout.WEST, Exit, 510, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, Exit, 475, SpringLayout.NORTH, this);
        Exit.setForeground(Color.BLACK);
        Exit.setBackground(Color.GRAY);
        Border line5 = new LineBorder(Color.BLACK);
        Border margin5 = new EmptyBorder(5, 15, 5, 15);
        Border compound5 = new CompoundBorder(line, margin);
        Exit.setBorder(compound);
        this.add(Exit);

        ///
        New = new JButton("  New ");
        New.addActionListener(this);
        myLayout.putConstraint(SpringLayout.WEST, New, 425, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, New, 100, SpringLayout.NORTH, this);
        New.setForeground(Color.BLACK);
        New.setBackground(Color.GRAY);
        Border line6 = new LineBorder(Color.BLACK);
        Border margin6 = new EmptyBorder(5, 15, 5, 15);
        Border compound6 = new CompoundBorder(line, margin);
        New.setBorder(compound);
        this.add(New);

        Save = new JButton(" Save ");
        Save.addActionListener(this);
        myLayout.putConstraint(SpringLayout.WEST, Save, 425, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, Save, 125, SpringLayout.NORTH, this);
        Save.setForeground(Color.BLACK);
        Save.setBackground(Color.GRAY);
        Border line7 = new LineBorder(Color.BLACK);
        Border margin7 = new EmptyBorder(5, 15, 5, 15);
        Border compound7 = new CompoundBorder(line, margin);
        Save.setBorder(compound);
        this.add(Save);

        Delete = new JButton("Delete");
        Delete.addActionListener(this);
        myLayout.putConstraint(SpringLayout.WEST, Delete, 425, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, Delete, 150, SpringLayout.NORTH, this);
        Delete.setForeground(Color.BLACK);
        Delete.setBackground(Color.GRAY);
        Border line8 = new LineBorder(Color.BLACK);
        Border margin8 = new EmptyBorder(5, 15, 5, 15);
        Border compound8 = new CompoundBorder(line, margin);
        Delete.setBorder(compound);
        this.add(Delete);

        txtBinary_Submit = new JButton("Binary Search by contact name");
        txtBinary_Submit.addActionListener(this);
        txtBinary_Submit.setSize(80, 25);
        myLayout.putConstraint(SpringLayout.WEST, txtBinary_Submit, 220, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtBinary_Submit, 220, SpringLayout.NORTH, this);
        txtBinary_Submit.setForeground(Color.BLACK);
        txtBinary_Submit.setBackground(Color.GRAY);
        Border line9 = new LineBorder(Color.BLACK);
        Border margin9 = new EmptyBorder(5, 15, 5, 15);
        Border compound9 = new CompoundBorder(line, margin);
        txtBinary_Submit.setBorder(compound);
        this.add(txtBinary_Submit);

        txtSortbyName = new JButton("Sort by contact name");
        txtSortbyName.addActionListener(this);
        txtSortbyName.setSize(80, 25);
        myLayout.putConstraint(SpringLayout.WEST, txtSortbyName, 25, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtSortbyName, 220, SpringLayout.NORTH, this);
        txtSortbyName.setForeground(Color.BLACK);
        txtSortbyName.setBackground(Color.GRAY);
        Border line10 = new LineBorder(Color.BLACK);
        Border margin10 = new EmptyBorder(5, 15, 5, 15);
        Border compound10 = new CompoundBorder(line, margin);
        txtSortbyName.setBorder(compound);
        this.add(txtSortbyName);


        /// Table


        // Keep Visibility
        this.setVisible(true);//Keep this at bottom, Displays form on screen

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //If statements to check which component event triggered
        if (e.getSource() == Exit) {
            System.exit(0);//Close application
        }
        if (e.getSource() == btnInput) {
            System.out.println(txtMessage.getText());//Gets text from textfield & prints to console
            txtMessage.setText("Hello Java Class");//Sets text in textfield.
        }
        if(e.getSource() == Save)
        {
            try {
                data = ReadWrite.read("..\\ICTPRG443\\Java_Assesment\\src\\com\\company\\data.csv");
                for (String[] row : data) {
                    for (String cell : row) {
                        System.out.print(cell + " <--> ");
                        txtName.setText(row[0]);
                        txtContactType.setText(row[1]);
                        txtPhonenum.setText(row[2]);
                        txtEmail.setText(row[3]);
                        txtNotes.setText(row[4]);

                    }
                    System.out.println();
                }
            } catch (IOException f) {
                System.err.println("Error reading CSV file: " + f.getMessage());
            }
        }
        if(e.getSource() == New)
        {
            int i = 0;
            BufferedWriter writer = null;

            try {
                data.add(new String[5]);
                currentRecord = data.size();
                for (String[] row : data) {
                    for (String cell : row) {
                        System.out.print(cell + " <--> ");
                        String txtbox = txtName.getText();
                        data.add(txtbox);
                        //txtContactType.getText(row[1]);
                        //txtPhonenum.getText(row[2]);
                        //txtEmail.getText(row[3]);
                        //txtNotes.getText(row[4]);

                    }
                    System.out.println();
                }
                writer = new BufferedWriter(new FileWriter("..\\ICTPRG443\\Java_Assesment\\src\\com\\company\\data.csv", true));

            }
            catch (IOException ioException)
            {
                ioException.printStackTrace();
            }

            while (data != null)
            {
                try
                {
                    writer.write(String.valueOf(data.get(i)));
                    i++;
                }
                catch (IOException ioException)
                {
                    ioException.printStackTrace();
                }

            }
            String content = "\ntest";
            try
            {
                ReadWrite.writeToFile("..\\ICTPRG443\\Java_Assesment\\src\\com\\company\\data.csv", content);
            }
            catch (IOException ioException)
            {
                ioException.printStackTrace();
            }

        }

    }
}



