package bdaytracker;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BirthdayTrackerWindow extends JFrame {

    private static final int BUTTON_SIZE_WIDTH = 120;
    private static final int BUTTON_SIZE_HEIGHT = 20;

    private static final int WINDOW_SIZE_WIDTH = 450;
    private static final int WINDOW_SIZE_HEIGHT = 300;

    private static final int WINDOW_COLUMN_ONE_X = 10;
    private static final int WINDOW_COLUMN_TWO_X = 10;
    private static final int WINDOW_COLUMN_THREE_X = 300;

    final SpringLayout layout = new SpringLayout();
    Frame windowFrame;

    private FileIO fileIO = new FileIO();

    private JButton btnFind, btnNew, btnSave, btnDelete;
    private JButton btnBinarySearch, btnBirthdayInMonth;
    private JButton btnForward, btnFastForward, btnBack, btnRewind;
    private JTextField textFieldFind;

    public void startForm() {

        windowFrame = this;

        // add GUI objects
        addBirthdayTrackerTitleLabel();

        addFindLabel();
        addFindTextField();
        addFindButton();

        setupWindow();

    }

    private void setupWindow() {
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // apply layout to Form
        Container contentPane = this.getContentPane();
        contentPane.setLayout(layout);

        // put window in middle of screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int halfScreenHeight = screenSize.height / 2;
        int halfScreenWidth = screenSize.width / 2;

        this.setLocation(
                halfScreenWidth - (WINDOW_SIZE_WIDTH / 2),
                halfScreenHeight - (WINDOW_SIZE_HEIGHT / 2)
        );

        this.setResizable(false);
        this.setPreferredSize(new Dimension(WINDOW_SIZE_WIDTH, WINDOW_SIZE_HEIGHT));
        this.pack();
        this.setVisible(true);
    }


    private void addBirthdayTrackerTitleLabel() {
        JLabel label = UIComponentLibrary.createJLabel(
                "Birthday Tracker",
                WINDOW_COLUMN_ONE_X,
                10,
                this,
                layout);
        label.setFont(new Font(label.getName(), Font.BOLD, 15));
        label.setForeground(Color.BLUE);
    }

    private void addFindLabel() {
        JLabel label = UIComponentLibrary.createJLabel(
                "Find:    ",
                WINDOW_COLUMN_THREE_X,
                10,
                this,
                layout);

        Font currentFont = label.getFont();
        label.setFont(new Font(label.getName(), Font.BOLD, currentFont.getSize()));
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setBackground(Color.BLUE);
    }

    private void addFindTextField() {

        textFieldFind = UIComponentLibrary.createJTextField(
                7,
                WINDOW_COLUMN_THREE_X + 40,
                10,
                this,
                layout);
    }

    private void addFindButton() {

        int posY = 32;

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                java.util.List<PersonDTO> persons = fileIO.read(textFieldFind.getText());

                if (persons != null && !persons.isEmpty()) {

                    for (PersonDTO person : persons) {
                        JOptionPane.showMessageDialog(windowFrame, person.getName() + " " + person.getLikes());
                    }

                }

            }
        };

        btnFind = UIComponentLibrary.createJButton(
                "Find",
                BUTTON_SIZE_WIDTH,
                BUTTON_SIZE_HEIGHT,
                WINDOW_COLUMN_THREE_X,
                posY,
                al,
                this,
                layout);
    }

}
