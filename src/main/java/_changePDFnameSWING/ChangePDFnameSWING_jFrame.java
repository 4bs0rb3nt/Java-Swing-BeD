package _changePDFnameSWING;

import javax.swing.*;

public class ChangePDFnameSWING_jFrame extends JFrame {


    public ChangePDFnameSWING_jFrame() {
        setSize(600, 600);
        setLocation(50, 50);
        setTitle("changePDFnameSWING");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        ChangePDFnameSWING_jPanel changePDFnameSWINGj_panel = new ChangePDFnameSWING_jPanel();
        add(changePDFnameSWINGj_panel);

    }
}

