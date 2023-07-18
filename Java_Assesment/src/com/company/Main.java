// TAFE QLD ASSIGNMENT
// Writen By Benjamin Moore
// Last Edit 29/03/2023

package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Main extends JFrame implements ActionListener {


    FileManager file = new FileManager();

    ////////////////////////////////
    //// --- UI Components --- /////
    ////////////////////////////////


//-----------------Declare Labels---------------------\\
    // Enjoy the declarations ;)\\

    public static  JButton btnClose;
    public static  Button btnInput;
    public static  JTextField txtName;
    public static JTextField txtContactType;
    public static JTextField txtPhonenum;
    public static JTextField txtEmail;
    public static JTextField txtNotes;
    public static  JTextField txtSearch;
    public static JTextField txtBinary_Query;
    public static JTextArea main_txt_area;
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
    public static JButton Exit;
    public static JButton txtSortbyName;
    public static JTextField txtFilter;
    public static JLabel txtFilters;
    public static JLabel entryCount;
    public static JButton filterBtn;
    public static JTextArea customerList;
    public static JLabel lblPhonenum;
    public static List<String[]> data;
    public boolean isNewEntry = false;
    public JTable Globaltable;

    //----------END DECLARE VAR---------\\


    //-------- SET VALUES FOR CURRENT RECORD AND NUM OF ENTRY ----------\\
    public static int currentRecord = 0;
    int numOfEntry = 0;

    //-------------------------END SET VALUES----------------------------\\
    // CREATE NEW RELOCATION ARRAY \\
    RelocationModel[] relocationarray = new RelocationModel[100];
    // END\\

    // ADD TXT TO TXT FIELD \\
    public void addtxt()
    {

        int i = 0;
        while(i != numOfEntry)
        {
            main_txt_area.append(relocationarray[i].getContactName() + "");
            main_txt_area.append(relocationarray[i].getContactType() + "");
            main_txt_area.append(relocationarray[i].getPhoneNUM() + "");
            main_txt_area.append(relocationarray[i].getEmailWeblink() + "");
            main_txt_area.append(relocationarray[i].getContactNotes() + "");
            main_txt_area.append("\n");
            i++;
        }
    }
    // END ADD TXT \\

   // MAIN CLASS \\
    public static void main(String[] args) throws FileNotFoundException { new Main(); }
    // END MAIN CLASS \\


    // CREATE AND SHAPE LABELS \\
    public Main() throws FileNotFoundException{

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        add(topPanel);

        // Create column names

        // Create a new table instance

        SpringLayout myLayout = new SpringLayout();//Creating Spring layout
        this.setLayout(myLayout);//Setting spring layout to form
        this.setSize(1200, 700);//Set Form size
        this.getContentPane().setBackground(Color.lightGray);//Change form background color
        this.setLocation(0, 0);//Set form start position


        main_txt_area = new JTextArea("Relocation Manager");

        myLayout.putConstraint(SpringLayout.WEST,main_txt_area,10,SpringLayout.WEST,this);
        myLayout.putConstraint(SpringLayout.NORTH,main_txt_area,350,SpringLayout.NORTH,this);


        main_txt_area.setSize(550,100);
        main_txt_area.setLocation(200,100);
        main_txt_area.setLineWrap(true);
        main_txt_area.setEditable(false);
        main_txt_area.setVisible(true);

        JScrollPane scroll = new JScrollPane(main_txt_area);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        this.add(scroll);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        // Title
        lblTitle = new JLabel("Relocation Manager");
        myLayout.putConstraint(SpringLayout.WEST, lblTitle, 600, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblTitle, 10, SpringLayout.NORTH, this);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Courier", Font.BOLD, 25));
        this.add(lblTitle);

        Searchlbl = new JLabel("Company Search");
        myLayout.putConstraint(SpringLayout.WEST, Searchlbl, 975, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, Searchlbl, 20, SpringLayout.NORTH, this);
        Searchlbl.setForeground(Color.BLACK);
        Searchlbl.setFont(new Font("Courier", Font.ITALIC, 15));
        this.add(Searchlbl);

        // Persons Name
        lblName = new JLabel("<html><span bgcolor=\"Black\"> Contact Name:  </span></html>");
        myLayout.putConstraint(SpringLayout.WEST, lblName, 600, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblName, 65, SpringLayout.NORTH, this);
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Calbri", Font.BOLD, 12));
        this.add(lblName);

        // Likes
        lblContactType = new JLabel("<html><span bgcolor=\"Black\"> Contact Type:  </span></html>");
        myLayout.putConstraint(SpringLayout.WEST, lblContactType, 600, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblContactType, 95, SpringLayout.NORTH, this);
        lblContactType.setForeground(Color.WHITE);
        lblContactType.setFont(new Font("Calbri", Font.BOLD, 12));
        this.add(lblContactType);

        // Dislikes
        lblPhonenum = new JLabel("<html><span bgcolor=\"Black\"> Phone/Mobile:  </span></html>");
        myLayout.putConstraint(SpringLayout.WEST, lblPhonenum, 600, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblPhonenum, 125, SpringLayout.NORTH, this);
        lblPhonenum.setForeground(Color.WHITE);
        lblPhonenum.setFont(new Font("Calbri", Font.BOLD, 12));
        this.add(lblPhonenum);

        // Bday Day
        lblEmail = new JLabel("<html><span bgcolor=\"Black\"> Weblink/Email:  </span></html>");
        myLayout.putConstraint(SpringLayout.WEST, lblEmail, 600, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblEmail, 155, SpringLayout.NORTH, this);
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Calbri", Font.BOLD, 12));
        this.add(lblEmail);

        // Bday Month
        lblNotes = new JLabel("<html><span bgcolor=\"Black\"> Contact Notes:  </span></html>");
        myLayout.putConstraint(SpringLayout.WEST, lblNotes, 600, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblNotes, 185, SpringLayout.NORTH, this);
        lblNotes.setForeground(Color.WHITE);
        lblNotes.setFont(new Font("Calbri", Font.BOLD, 12));
        this.add(lblNotes);

        // Search
        lblSearch = new JLabel("<html><span bgcolor=\"Black\"> Company:  </span></html>");
        myLayout.putConstraint(SpringLayout.WEST, lblSearch, 925, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, lblSearch, 62, SpringLayout.NORTH, this);
        lblSearch.setForeground(Color.WHITE);
        lblSearch.setFont(new Font("Calbri", Font.BOLD, 12));
        this.add(lblSearch);


        // return



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
        txtFilter = new JTextField("Text to Filter / Binary Search", 25);
        myLayout.putConstraint(SpringLayout.WEST, txtFilter, 600, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtFilter, 305, SpringLayout.NORTH, this);
        txtFilter.setForeground(Color.BLACK);
        txtFilter.setFont(new Font("Calbri", Font.PLAIN, 10));
        this.add(txtFilter);

        txtName = new JTextField("", 25);
        myLayout.putConstraint(SpringLayout.WEST, txtName, 700, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtName, 65, SpringLayout.NORTH, this);
        txtName.setForeground(Color.BLACK);
        txtName.setFont(new Font("Calbri", Font.PLAIN, 9));
        this.add(txtName);

        txtContactType = new JTextField("", 25);
        myLayout.putConstraint(SpringLayout.WEST, txtContactType, 700, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtContactType, 95, SpringLayout.NORTH, this);
        txtContactType.setForeground(Color.BLACK);
        txtContactType.setFont(new Font("Calbri", Font.PLAIN, 9));
        this.add(txtContactType);

        txtPhonenum = new JTextField("", 25);
        myLayout.putConstraint(SpringLayout.WEST, txtPhonenum, 700, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtPhonenum, 125, SpringLayout.NORTH, this);
        txtPhonenum.setForeground(Color.BLACK);
        txtPhonenum.setFont(new Font("Calbri", Font.PLAIN, 9));
        this.add(txtPhonenum);

        txtEmail = new JTextField("", 25);
        myLayout.putConstraint(SpringLayout.WEST, txtEmail, 700, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtEmail, 155, SpringLayout.NORTH, this);
        txtEmail.setForeground(Color.BLACK);
        txtEmail.setFont(new Font("Calbri", Font.PLAIN, 9));
        this.add(txtEmail);

        txtNotes = new JTextField("", 25);
        myLayout.putConstraint(SpringLayout.WEST, txtNotes, 700, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtNotes, 185, SpringLayout.NORTH, this);
        txtNotes.setForeground(Color.BLACK);
        txtNotes.setFont(new Font("Calbri", Font.PLAIN, 9));
        this.add(txtNotes);

        txtSearch = new JTextField("", 8);
        myLayout.putConstraint(SpringLayout.WEST, txtSearch, 1000, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtSearch, 60, SpringLayout.NORTH, this);
        txtSearch.setForeground(Color.BLACK);
        txtSearch.setFont(new Font("Calbri", Font.PLAIN, 12));
        txtSearch.setSize(10, 10);
        this.add(txtSearch);


        // Buttons //
        Back = new JButton("<");
        Back.addActionListener(this);
        Back.setSize(80, 25);
        myLayout.putConstraint(SpringLayout.WEST, Back, 800, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, Back, 350, SpringLayout.NORTH, this);
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
        myLayout.putConstraint(SpringLayout.WEST, FullBack, 760, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, FullBack, 350, SpringLayout.NORTH, this);
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
        myLayout.putConstraint(SpringLayout.WEST, Forward, 840, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, Forward, 350, SpringLayout.NORTH, this);
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
        myLayout.putConstraint(SpringLayout.WEST, filterBtn, 850, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, filterBtn, 300, SpringLayout.NORTH, this);
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
        myLayout.putConstraint(SpringLayout.WEST, FullForward, 880, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, FullForward, 350, SpringLayout.NORTH, this);
        FullForward.setForeground(Color.BLACK);
        FullForward.setBackground(Color.GRAY);
        Border line3 = new LineBorder(Color.BLACK);
        Border margin3 = new EmptyBorder(5, 15, 5, 15);
        Border compound3 = new CompoundBorder(line, margin);
        FullForward.setBorder(compound);
        this.add(FullForward);

        Find = new JButton("Find");
        Find.addActionListener(this);
        myLayout.putConstraint(SpringLayout.WEST, Find, 1100, SpringLayout.WEST, this);
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
        myLayout.putConstraint(SpringLayout.WEST, Exit, 1100, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, Exit, 600, SpringLayout.NORTH, this);
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
        myLayout.putConstraint(SpringLayout.WEST, New, 1020, SpringLayout.WEST, this);
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
        myLayout.putConstraint(SpringLayout.WEST, Save, 1020, SpringLayout.WEST, this);
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
        myLayout.putConstraint(SpringLayout.WEST, Delete, 1020, SpringLayout.WEST, this);
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
        myLayout.putConstraint(SpringLayout.WEST, txtBinary_Submit, 920, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtBinary_Submit, 300, SpringLayout.NORTH, this);
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
        myLayout.putConstraint(SpringLayout.WEST, txtSortbyName, 900, SpringLayout.WEST, this);
        myLayout.putConstraint(SpringLayout.NORTH, txtSortbyName, 220, SpringLayout.NORTH, this);
        txtSortbyName.setForeground(Color.BLACK);
        txtSortbyName.setBackground(Color.GRAY);
        Border line10 = new LineBorder(Color.BLACK);
        Border margin10 = new EmptyBorder(5, 15, 5, 15);
        Border compound10 = new CompoundBorder(line, margin);
        txtSortbyName.setBorder(compound);
        this.add(txtSortbyName);


        relocationarray = file.ReadDataFromFile();
        if (relocationarray != null && relocationarray[0] != null)
        {
            numOfEntry = UpdateNumberOfEntriesCount();
            displayEntry(currentRecord);
            addtxt();
        }
        // Keep Visibility
        this.setVisible(true);//Keep this at bottom, Displays form on screen

    }
    // END CREATE LABELS \\


    // DISPLAY TEXT FROM ARRAY \\
    private void displayEntry(int currentRecord)
    {
        txtName.setText(relocationarray[currentRecord].contactName);
        txtContactType.setText(relocationarray[currentRecord].contactType);
        txtPhonenum.setText(relocationarray[currentRecord].phoneNUM);
        txtEmail.setText(relocationarray[currentRecord].emailWeblink);
        txtNotes.setText(relocationarray[currentRecord].contactNotes);
        System.out.println(relocationarray);
        UpdateNumberOfEntriesCount();
    }

    // SEARCH CONTACT NAME \\
    public void Find()
    {
        String searchTerm = txtSearch.getText();

        int found = 0;

        String Name[] = new String[numOfEntry];

        for (int i = 0; i < numOfEntry; i++)
        {
            Name[i] = relocationarray[i].getContactName();

            if(Name[i].contains(searchTerm))
            {
                displayEntry(i);
                break;
            }
        }


    }
    // END CONTACT SEARCH \\
    public void Filter() {
        String searchTerm = txtFilter.getText();

        int found = 0;

        String Name[] = new String[numOfEntry];
        String contactName[] = new String[numOfEntry];
        String contactType[] = new String[numOfEntry];
        String phoneNUM[] = new String[numOfEntry];
        String emailWeblink[] = new String[numOfEntry];
        String contactNotes[] = new String[numOfEntry];
        main_txt_area.setText("");
        main_txt_area.setText("Search for >> ");
        main_txt_area.append(searchTerm);
        main_txt_area.append("<< \n");
        int count = 0;
        for (int i = 0; i < numOfEntry; i++) {
            Name[i] = relocationarray[i].getContactNotes();
            contactName[i] = relocationarray[i].getContactName();
            contactType[i] = relocationarray[i].getContactType();
            phoneNUM[i] = relocationarray[i].getPhoneNUM();
            emailWeblink[i] = relocationarray[i].getEmailWeblink();

            if (Name[i].contains(searchTerm)) {
                displayEntry(i);

                String contactNameF = String.format("Contact Name: %s!", contactName[i]);
                main_txt_area.append(contactNameF);

                main_txt_area.append("\n");

                String contactTypeF = String.format("Contact Type: %s!", contactType[i]);
                main_txt_area.append(contactTypeF);

                main_txt_area.append("\n");

                String phoneNUMF = String.format("Phone Num: %s!", phoneNUM[i]);
                main_txt_area.append(phoneNUMF);

                main_txt_area.append("\n");

                String emailWebLinkF = String.format("Email Web Link: %s!", emailWeblink[i]);
                main_txt_area.append(emailWebLinkF);

                main_txt_area.append("\n");

                String NameF = String.format("Contact Notes: %s!", Name[i]);
                main_txt_area.append(NameF);

                main_txt_area.append("\n");
                String Count = String.format("|------------------------------|");
                main_txt_area.append(Count);
                main_txt_area.append("\n");
                count++;
            }
        }
    }

    // BINARY SEARCH \\
    public void binarySearch()
        {
            String Name[] = new String[numOfEntry];

            for(int i=0; i < numOfEntry;i++ ) {
                Name[i] = relocationarray[i].getContactName();
            }
            Arrays.sort(Name);

            int position = Arrays.binarySearch(Name,txtFilter.getText());
            // position is -1
            if (position >= 0)
            {
                main_txt_area.append(txtFilter.getText() + " Is an index of: "+ (position + 1 ));
                for(int i=0; i<numOfEntry; i++)
                {
                    if(i == position)
                    {
                        main_txt_area.append("\n");
                        main_txt_area.append(Name[i]);
                        main_txt_area.append(" <<< Here!");
                    }
                    else
                    {
                        main_txt_area.append("\n");
                        main_txt_area.append(Name[i]);
                    }
                }
            }
            else{ main_txt_area.setText("No Client Found!"); }
            }

        // END BINARY SEARCH \\


    // UPDATE ENTRIES FROM ARRAY \\
    public int UpdateNumberOfEntriesCount()
    {
        // track size of array
        int count = 0;
        // if not empty
        for (int i = 0; i < relocationarray.length; i++)
        {
            // if empty
            if (relocationarray[i] == null)
            {
                return count;
            }
            count++;
        }
        // return
        return count;
    }

    // --------------------------- \\
   // SORT BY CLIENT NAME \
    public void Sort(){
        String Name[] = new String[numOfEntry];

        for(int i=0; i < numOfEntry;i++ ) {
            Name[i] = relocationarray[i].getContactNotes();
        }
        Arrays.sort(Name);
        int x = 0;
        while(x != numOfEntry){
            main_txt_area.append(Name[x]);
            main_txt_area.append("\n");
            x++;
        }

    }
    // SORT BY CLIENT NAME END\\

    // ACTION LISTENER \\
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == filterBtn)
        {
            Filter();
        }
        //If statements to check which component event triggered
        if (e.getSource() == Exit)//Done
        {
            System.exit(0);//Close application
        }
        if (e.getSource() == btnInput)//Done
        {
            System.out.println(txtMessage.getText());//Gets text from textfield & prints to console
            txtMessage.setText("Relocation Manager");//Sets text in textfield.
        }
        if (e.getSource() != New && e.getSource() != Save)
        {
            isNewEntry = false;
        }
        if (e.getSource() == New)
        {
            txtName.setText("");
            txtContactType.setText("");
            txtPhonenum.setText("");
            txtEmail.setText("");
            txtNotes.setText("");
            isNewEntry = true;
            UpdateNumberOfEntriesCount();
        }
        if (e.getSource() == Save)
        {
            //Checks if the array is empty. If so it sets the save more to new.
            if (numOfEntry == 0)
            {
                isNewEntry = true;
            }

            //Create a new empty data model object
            RelocationModel newEntry = new RelocationModel(txtName.getText(),
            txtContactType.getText(),
            txtPhonenum.getText(),
            txtEmail.getText(),
            txtNotes.getText()
                    );

            //Copy data from entry fields on form to the model object




            if (isNewEntry)
            {
                //Add the data model object to the array
                relocationarray[numOfEntry] = newEntry;
                //Sets the current entry to the position the data was just saved at.
                currentRecord = numOfEntry;
                //Increment the numberOfEntries count to reflect the updated amount
                numOfEntry++;
            }
            else
            {
                //Replace the current entry with the new
                relocationarray[currentRecord] = newEntry;
            }
            file.WriteDataToFile(relocationarray);
            isNewEntry = false;
            UpdateNumberOfEntriesCount();



        }
        if(e.getSource() == Delete)
        {
            // if empty, do nothing
            if(numOfEntry == 0)
            {
                return;
            }
            // cycle through the array
            for (int i = currentRecord; i < numOfEntry; i++)
            {
                // if on the last entry
                if(i == numOfEntry - 1)
                {
                    // set entry to null
                    relocationarray[i] = null;
                    // go back one pos in array
                    currentRecord--;
                }
                // Otherwise, overwrite the entry with the element after it in the array
                relocationarray[i] = relocationarray[i + 1];
            }
            // Decrease the array count
            numOfEntry--;
            // update
            displayEntry(currentRecord);
            // update file
            file.WriteDataToFile(relocationarray);
        }
        if (e.getSource() == FullBack || e.getSource() ==Back || e.getSource() ==Forward || e.getSource() ==FullForward)
        {
            if (numOfEntry <= 0)
            {
                return;
            }
        }
        if (e.getSource() == FullBack)
        {
            currentRecord = 0;
            displayEntry(currentRecord);
        }
        if (e.getSource() == FullForward)
        {
            currentRecord = numOfEntry - 1;
            displayEntry(currentRecord);
        }
        if (e.getSource() == Back)
        {
            if (currentRecord > 0)
            {
                currentRecord--;
                displayEntry(currentRecord);
            }
        }
        if (e.getSource() == Forward)
        {
            if (currentRecord < numOfEntry -1)
            {
                currentRecord++;
                displayEntry(currentRecord);
            }
        }
        if (e.getSource() == Find)
        {

            Find();
            txtSearch.setText("");
        }
        if (e.getSource() == txtBinary_Submit)
        {
            main_txt_area.setText("");
            binarySearch();
        }
        if (e.getSource() == txtSortbyName)
        {
        main_txt_area.setText("");
        Sort();
        }
    }
    // END ACTION LISTENER \\



}
// END OF PROGRAM \\


