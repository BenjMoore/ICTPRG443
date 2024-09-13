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
import java.util.Comparator;
import java.util.List;
/** Main class that impliments ui and logic methods **/
public class Main extends JFrame implements ActionListener {


    FileManager file = new FileManager();

    ////////////////////////////////
    //// --- UI Components --- /////
    ////////////////////////////////


//-----------------Declare Labels---------------------\\
    

    public static  JButton btnClose;
    public static  Button btnInput;
    public static  JTextField txtName;
    public static JTextField txtContactType;
    public static JTextField txtPhonenum;
    public static JTextField txtEmail;
    public static JTextArea txtNotes;
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


    /**
     * Appends information from the relocation array to the main text area.
     * Iterates through the array and adds each entry's details to the text area.
     */
    public void addtxt()
    {

        int i = 0;
        while(i != numOfEntry) {

            main_txt_area.append("-------------------------------------\n");
            main_txt_area.append("Name: " + relocationarray[i].contactName); // Print the sorted name
            main_txt_area.append("\n"); // Add a separator
            main_txt_area.append("Contact Type: " + relocationarray[i].contactType);
            main_txt_area.append("\n");
            main_txt_area.append("Phone Number: " + relocationarray[i].phoneNUM);
            main_txt_area.append("\n");
            main_txt_area.append("Email: " + relocationarray[i].emailWeblink);
            main_txt_area.append("\n");
            main_txt_area.append("Contact Notes: " + relocationarray[i].contactNotes + "\n");
            i++;

        }
        }

    // END ADD TXT \\

   // MAIN CLASS \\
     /**

       main class, calls main
        @param args String[]
        @throws FileNotFoundException

         */
    public static void main(String[] args) throws FileNotFoundException
    {
        Main mainFrame = new Main();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
    // END MAIN CLASS \\


    // CREATE AND SHAPE LABELS \\
     /**

       Main method that initialises all of the jframe components, the jframe itself

        @throws FileNotFoundException

         */

     public Main() throws FileNotFoundException {
         // Set up the main frame
         JPanel topPanel = new JPanel();
         topPanel.setLayout(new BorderLayout());
         add(topPanel);

         SpringLayout myLayout = new SpringLayout();
         this.setLayout(myLayout);
         this.setSize(750, 700); // Set the frame size to 750x700
         this.getContentPane().setBackground(Color.lightGray);
         this.setLocation(0, 0);

         // Main text area
         main_txt_area = new JTextArea("Relocation Manager");
         main_txt_area.setLineWrap(true);
         main_txt_area.setEditable(false);
         main_txt_area.setVisible(true);
         // Setup Scrollpane
         JScrollPane scroll = new JScrollPane(main_txt_area);
         scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
         scroll.setPreferredSize(new Dimension(500, 200));

         // Add Initial Data
         relocationarray =  FileManager.ReadDataFromFile();
         numOfEntry = UpdateNumberOfEntriesCount();
         addtxt();

         // Add the scroll pane to the layout
         this.add(scroll);

         // Set SpringLayout constraints for scroll
         myLayout.putConstraint(SpringLayout.SOUTH, scroll, -10, SpringLayout.SOUTH, this.getContentPane());
         myLayout.putConstraint(SpringLayout.WEST, scroll, 10, SpringLayout.WEST, this.getContentPane());
         myLayout.putConstraint(SpringLayout.EAST, scroll, -10, SpringLayout.EAST, this.getContentPane());
         /**
          * Label for the main title "Relocation Manager".
          */
         // Title
         lblTitle = new JLabel("Relocation Manager");
         myLayout.putConstraint(SpringLayout.WEST, lblTitle, 25, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, lblTitle, 10, SpringLayout.NORTH, this);
         lblTitle.setForeground(Color.BLACK);
         lblTitle.setFont(new Font("Courier", Font.BOLD, 25));
         this.add(lblTitle);
         /**
          * Label for the search field titled "Name Search".
          */
         Searchlbl = new JLabel("Name Search");
         myLayout.putConstraint(SpringLayout.WEST, Searchlbl, 555, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, Searchlbl, 10, SpringLayout.NORTH, this);
         Searchlbl.setForeground(Color.BLACK);
         Searchlbl.setFont(new Font("Courier", Font.ITALIC, 15));
         this.add(Searchlbl);
         /**
          * Label for the contact name field.
          */
         // Person's Name
         lblName = new JLabel("<html><span bgcolor=\"Black\"> Contact Name:  </span></html>");
         myLayout.putConstraint(SpringLayout.WEST, lblName, 25, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, lblName, 65, SpringLayout.NORTH, this);
         lblName.setForeground(Color.WHITE);
         lblName.setFont(new Font("Calbri", Font.BOLD, 12));
         this.add(lblName);
         /**
          * Label for the contact type field.
          */
         // Contact Type
         lblContactType = new JLabel("<html><span bgcolor=\"Black\"> Contact Type:  </span></html>");
         myLayout.putConstraint(SpringLayout.WEST, lblContactType, 25, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, lblContactType, 95, SpringLayout.NORTH, this);
         lblContactType.setForeground(Color.WHITE);
         lblContactType.setFont(new Font("Calbri", Font.BOLD, 12));
         this.add(lblContactType);
         /**
          * Label for the phone number field.
          */
         // Phone Number
         lblPhonenum = new JLabel("<html><span bgcolor=\"Black\"> Phone/Mobile:  </span></html>");
         myLayout.putConstraint(SpringLayout.WEST, lblPhonenum, 25, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, lblPhonenum, 125, SpringLayout.NORTH, this);
         lblPhonenum.setForeground(Color.WHITE);
         lblPhonenum.setFont(new Font("Calbri", Font.BOLD, 12));
         this.add(lblPhonenum);
        /**
         * Label for the email or web link field.
         */
         // Email or Weblink
         lblEmail = new JLabel("<html><span bgcolor=\"Black\"> Weblink/Email:  </span></html>");
         myLayout.putConstraint(SpringLayout.WEST, lblEmail, 25, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, lblEmail, 155, SpringLayout.NORTH, this);
         lblEmail.setForeground(Color.WHITE);
         lblEmail.setFont(new Font("Calbri", Font.BOLD, 12));
         this.add(lblEmail);
         /**
          * Label for the contact notes field.
          */
         // Notes
         lblNotes = new JLabel("<html><span bgcolor=\"Black\"> Contact Notes:  </span></html>");
         myLayout.putConstraint(SpringLayout.WEST, lblNotes, 25, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, lblNotes, 185, SpringLayout.NORTH, this);
         lblNotes.setForeground(Color.WHITE);
         lblNotes.setFont(new Font("Calbri", Font.BOLD, 12));
         this.add(lblNotes);
         /**
          * Label for the search filter field.
          */
         // Search
         lblSearch = new JLabel("<html><span bgcolor=\"Black\"> Find:  </span></html>");
         myLayout.putConstraint(SpringLayout.WEST, lblSearch, 545, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, lblSearch, 40, SpringLayout.NORTH, this);
         lblSearch.setForeground(Color.WHITE);
         lblSearch.setFont(new Font("Calbri", Font.BOLD, 12));
         this.add(lblSearch);
         /**
          * Label for the search filter field.
          */
         // Filter Text
         txtFilters = new JLabel("");
         myLayout.putConstraint(SpringLayout.WEST, txtFilters, 10, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, txtFilters, 400, SpringLayout.NORTH, this);
         txtFilters.setForeground(Color.black);
         txtFilters.setFont(new Font("Calbri", Font.BOLD, 13));
         this.add(txtFilters);

         // Text Fields
         txtFilter = new JTextField("Text to Filter / Binary Search", 22);
         myLayout.putConstraint(SpringLayout.WEST, txtFilter, 500, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, txtFilter, 430, SpringLayout.NORTH, this);
         txtFilter.setForeground(Color.BLACK);
         txtFilter.setFont(new Font("Calbri", Font.PLAIN, 10));
         this.add(txtFilter);
        /**
         * Text field to input contact name.
         */
         txtName = new JTextField("", 25);
         myLayout.putConstraint(SpringLayout.WEST, txtName, 175, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, txtName, 65, SpringLayout.NORTH, this);
         txtName.setForeground(Color.BLACK);
         txtName.setFont(new Font("Calbri", Font.PLAIN, 9));
         this.add(txtName);
        /**
         * Text field to input contact type.
         */
         txtContactType = new JTextField("", 25);
         myLayout.putConstraint(SpringLayout.WEST, txtContactType, 175, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, txtContactType, 95, SpringLayout.NORTH, this);
         txtContactType.setForeground(Color.BLACK);
         txtContactType.setFont(new Font("Calbri", Font.PLAIN, 9));
         this.add(txtContactType);
         /**
          * Text field to input phone number.
          */
         txtPhonenum = new JTextField("", 25);
         myLayout.putConstraint(SpringLayout.WEST, txtPhonenum, 175, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, txtPhonenum, 125, SpringLayout.NORTH, this);
         txtPhonenum.setForeground(Color.BLACK);
         txtPhonenum.setFont(new Font("Calbri", Font.PLAIN, 9));
         this.add(txtPhonenum);
         /**
          * Text field to input email or web link.
          */
         txtEmail = new JTextField("", 25);
         myLayout.putConstraint(SpringLayout.WEST, txtEmail, 175, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, txtEmail, 155, SpringLayout.NORTH, this);
         txtEmail.setForeground(Color.BLACK);
         txtEmail.setFont(new Font("Calbri", Font.PLAIN, 9));
         this.add(txtEmail);
         /**
          * Text area to input contact notes.
          */
         txtNotes = new JTextArea(3, 25);
         myLayout.putConstraint(SpringLayout.WEST, txtNotes, 175, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, txtNotes, 185, SpringLayout.NORTH, this);
         txtNotes.setForeground(Color.BLACK);
         txtNotes.setFont(new Font("Calbri", Font.PLAIN, 9));
         this.add(txtNotes);
         /**
          * Text field for performing a search by contact name.
          */
         txtSearch = new JTextField("", 8);
         myLayout.putConstraint(SpringLayout.WEST, txtSearch, 600, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, txtSearch, 40, SpringLayout.NORTH, this);
         txtSearch.setForeground(Color.BLACK);
         txtSearch.setFont(new Font("Calbri", Font.PLAIN, 12));
         this.add(txtSearch);
         /**
          * Button to navigate back by one entry.
          */
         // Buttons
         Back = new JButton("<");
         Back.addActionListener(this);
         myLayout.putConstraint(SpringLayout.WEST, Back, 570, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, Back, 190, SpringLayout.NORTH, this);
         Back.setForeground(Color.BLACK);
         Back.setBackground(Color.GRAY);
         this.add(Back);
         /**
          * Button to navigate back to the first entry.
          */
         FullBack = new JButton("|<");
         FullBack.addActionListener(this);
         myLayout.putConstraint(SpringLayout.WEST, FullBack, 530, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, FullBack, 190, SpringLayout.NORTH, this);
         FullBack.setForeground(Color.BLACK);
         FullBack.setBackground(Color.GRAY);
         this.add(FullBack);
         /**
          * Button to navigate forward by one entry.
          */
         Forward = new JButton(">");
         Forward.addActionListener(this);
         myLayout.putConstraint(SpringLayout.WEST, Forward, 610, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, Forward, 190, SpringLayout.NORTH, this);
         Forward.setForeground(Color.BLACK);
         Forward.setBackground(Color.GRAY);
         this.add(Forward);
         /**
          * Button to navigate to the last entry.
          */
         FullForward = new JButton(">|");
         FullForward.addActionListener(this);
         myLayout.putConstraint(SpringLayout.WEST, FullForward, 650, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, FullForward, 190, SpringLayout.NORTH, this);
         FullForward.setForeground(Color.BLACK);
         FullForward.setBackground(Color.GRAY);
         this.add(FullForward);
         /**
          * Button to save the current entry.
          */
         Save = new JButton("                   Save                  ");
         Save.addActionListener(this);
         myLayout.putConstraint(SpringLayout.WEST, Save, 525, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, Save, 125, SpringLayout.NORTH, this);
         Save.setForeground(Color.BLACK);
         Save.setBackground(Color.GRAY);
         this.add(Save);
         /**
          * Button to exit the application.
          */
         Exit = new JButton("                   Exit                    ");
         Exit.addActionListener(this);
         myLayout.putConstraint(SpringLayout.WEST, Exit, 525, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, Exit, 225, SpringLayout.NORTH, this);
         Exit.setForeground(Color.BLACK);
         Exit.setBackground(Color.GRAY);
         this.add(Exit);
         /**
          * Button to find entries based on the search criteria.
          */
         Find = new JButton("                    Find                   ");
         Find.addActionListener(this);
         myLayout.putConstraint(SpringLayout.WEST, Find, 525, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, Find, 65, SpringLayout.NORTH, this);
         Find.setForeground(Color.BLACK);
         Find.setBackground(Color.GRAY);
         this.add(Find);
         /**
          * Button to apply a filter based on the filter text.
          */
         filterBtn = new JButton("Filter By:");
         filterBtn.addActionListener(this);
         myLayout.putConstraint(SpringLayout.WEST, filterBtn, 400, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, filterBtn, 425, SpringLayout.NORTH, this);
         filterBtn.setForeground(Color.BLACK);
         filterBtn.setBackground(Color.GRAY);
         this.add(filterBtn);
         /**
          * Button to perform a binary search by contact name.
          */
         txtBinary_Submit = new JButton("Binary Search by Contact Name");
         txtBinary_Submit.addActionListener(this);
         myLayout.putConstraint(SpringLayout.WEST, txtBinary_Submit, 175, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, txtBinary_Submit, 425, SpringLayout.NORTH, this);
         txtBinary_Submit.setForeground(Color.BLACK);
         txtBinary_Submit.setBackground(Color.GRAY);
         this.add(txtBinary_Submit);
         /**
          * Button to sort the entries by contact name.
          */
         txtSortbyName = new JButton("Sort by Contact Name");
         txtSortbyName.addActionListener(this);
         myLayout.putConstraint(SpringLayout.WEST, txtSortbyName, 10, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, txtSortbyName, 425, SpringLayout.NORTH, this);
         txtSortbyName.setForeground(Color.BLACK);
         txtSortbyName.setBackground(Color.GRAY);
         this.add(txtSortbyName);

         New = new JButton("                   New                   ");
         New.addActionListener(this);
         myLayout.putConstraint(SpringLayout.WEST, New, 525, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, New, 95, SpringLayout.NORTH, this);
         New.setForeground(Color.BLACK);
         New.setBackground(Color.GRAY);
         this.add(New);

         Delete = new JButton("                  Delete                ");
         Delete.addActionListener(this);
         myLayout.putConstraint(SpringLayout.WEST, Delete, 525, SpringLayout.WEST, this);
         myLayout.putConstraint(SpringLayout.NORTH, Delete, 155, SpringLayout.NORTH, this);
         Delete.setForeground(Color.BLACK);
         Delete.setBackground(Color.GRAY);
         this.add(Delete);

         // Force layout manager to update and repaint the window
         this.revalidate();
         this.repaint();
     }
    // END CREATE LABELS \\


    // DISPLAY TEXT FROM ARRAY \\
     /**

      displays the current record in text area
        @param currentRecord


         */
    private void displayEntry(int currentRecord)
    {
        try {


        txtName.setText(relocationarray[currentRecord].contactName);
        txtContactType.setText(relocationarray[currentRecord].contactType);
        txtPhonenum.setText(relocationarray[currentRecord].phoneNUM);
        txtEmail.setText(relocationarray[currentRecord].emailWeblink);
        txtNotes.setText(relocationarray[currentRecord].contactNotes);
        System.out.println(relocationarray);
        numOfEntry = UpdateNumberOfEntriesCount();
        }
        catch (Exception e) {
            return;
        }
    }

    // SEARCH CONTACT NAME \\
     /**

        Searches array based on name, displays in text area
      */
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
     /**

       Filters the array based on either the contact notes or name



         */
    public void Filter() {
        String searchTerm = txtFilter.getText().trim();

        int found = 0;

        String Notes[] = new String[numOfEntry];
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
            Notes[i] = relocationarray[i].getContactNotes();
            contactName[i] = relocationarray[i].getContactName();
            contactType[i] = relocationarray[i].getContactType();
            phoneNUM[i] = relocationarray[i].getPhoneNUM();
            emailWeblink[i] = relocationarray[i].getEmailWeblink();

            if (contactName[i].contains(searchTerm))
            {
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

                String NameF = String.format("Contact Notes: %s!", Notes[i]);
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
     /**

        binary searches the array for a specific value. displays the value with a highlight


         */
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
            else{ main_txt_area.setText("No Client Found! (Exact Matches Only)"); }
            }

        // END BINARY SEARCH \\


    // UPDATE ENTRIES FROM ARRAY \\
     /**

        Updates the number of entries


      */
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
     /**

       Sorts the array to be displayed in the text area

         **/
    public void Sort() {
        // Create arrays to store information for sorting
        String[] Name = new String[numOfEntry];
        String[] ContactType = new String[numOfEntry];
        String[] PhoneNum = new String[numOfEntry];
        String[] EmailLink = new String[numOfEntry];
        String[] ContactNotes = new String[numOfEntry];

        // Populate arrays with data from relocationarray
        for (int i = 0; i < numOfEntry; i++) {
            Name[i] = relocationarray[i].getContactName();
            ContactType[i] = relocationarray[i].getContactType();
            PhoneNum[i] = relocationarray[i].getPhoneNUM();
            EmailLink[i] = relocationarray[i].getEmailWeblink();
            ContactNotes[i] = relocationarray[i].getContactNotes();
        }

        // Create a custom sorting mechanism to keep track of original indices
        Integer[] indices = new Integer[numOfEntry];
        for (int i = 0; i < numOfEntry; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparing(nameIndex -> Name[nameIndex]));
        main_txt_area.append("----------- Sorted By Name ----------\n");
        // Display sorted information
        for (int x = 0; x < numOfEntry; x++) {
            int index = indices[x];
            main_txt_area.append("-------------------------------------\n");
            main_txt_area.append("Name: "+Name[index]); // Print the sorted name
            main_txt_area.append("\n"); // Add a separator
            main_txt_area.append("Contact Type: "+ContactType[index]);
            main_txt_area.append("\n");
            main_txt_area.append("Phone Number: "+PhoneNum[index]);
            main_txt_area.append("\n");
            main_txt_area.append("Email: "+EmailLink[index]);
            main_txt_area.append("\n");
            main_txt_area.append("Contact Notes: "+ContactNotes[index]+"\n");

        }
            main_txt_area.append("-------------------------------------\n");
    }




    // SORT BY CLIENT NAME END\\

    // ACTION LISTENER \\
     /**

       actionPerformed
       class to manage action triggers
        @param e Action Event


         */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == filterBtn)
        {
            Filter();
        }
        //If statements to check which component event triggered
        if (e.getSource() == filterBtn)//Done
        {
            Filter();

            //Close application
        }
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


