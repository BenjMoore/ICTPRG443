package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class uicomponentlibrary {

    public static JButton CreateaJbutton(String name, int sizeX, int sizeY, int posX, int posY,
                                         ActionListener listener, JFrame frame, SpringLayout layout)
    {

        JButton NewButton = new JButton(name);
        NewButton.addActionListener(listener);
        NewButton.setPreferredSize(new Dimension(posX,posY));
        layout.putConstraint(SpringLayout.WEST,NewButton,50,
                SpringLayout.WEST,  frame);
        layout.putConstraint(SpringLayout.NORTH,NewButton,50,
                SpringLayout.NORTH,  frame);
        frame.add(NewButton);
        return NewButton;

    }
    public static JTextField Createatextfield(String txtname, Color bgColor, Color fgColor,
                                              JFrame textframe, SpringLayout txtlayout)
    {
        JTextField Txtmsg = new JTextField(15);
        Txtmsg.setBackground(bgColor);
        Txtmsg.setForeground(fgColor);
        txtlayout.putConstraint(SpringLayout.WEST,Txtmsg,120,
                SpringLayout.WEST,  textframe);
        txtlayout.putConstraint(SpringLayout.NORTH,Txtmsg,80,
                SpringLayout.NORTH,  textframe);
        textframe.add(Txtmsg);
        return Txtmsg;


    }
    public static JLabel CreateLabel(String name, Color fgColor,
                                     JFrame textframe, SpringLayout txtlayout)
    {
        JLabel NewLbl = new JLabel(name);
        NewLbl.setForeground(fgColor);
        txtlayout.putConstraint(SpringLayout.WEST,NewLbl,120,
                SpringLayout.WEST,  textframe);
        txtlayout.putConstraint(SpringLayout.NORTH,NewLbl,100,
                SpringLayout.NORTH,  textframe);
        textframe.add(NewLbl);
        return NewLbl;
    }
}
