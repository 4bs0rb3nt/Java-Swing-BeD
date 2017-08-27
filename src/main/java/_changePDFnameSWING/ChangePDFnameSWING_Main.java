package _changePDFnameSWING;

import javax.swing.*;
import java.awt.*;

public class ChangePDFnameSWING_Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChangePDFnameSWING_jFrame changePDFnameSWING_jFrame = new ChangePDFnameSWING_jFrame();
                changePDFnameSWING_jFrame.setVisible(true);
                changePDFnameSWING_jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        });
    }
}

