package _changePDFnameSWING;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ChangePDFnameSWING_jPanel extends JPanel {

    private JLabel jLabel1_docType, jLabel2_vendor, jLabel3_nrOfInvoiceOrContract, jLabel4_city,
            jLabel5_streetAndNr, jLabel6_date, jLabel503_nickName;
    private JTextField jTextField2_vendor,jTextField3_nrOfInvoiceOrContract, jTextField4_city,
            jTextField5_streetAndNr, jTextField6_date;
    private final JRadioButton jRadioButton1_invoice, jRadioButton2_contractInternet, jRadioButton3_contractTelephone;
    private ButtonGroup buttonGroup1_docType;
    private JTextArea jTextArea1_fileURL, jTextArea2_resultURL;
    private JFileChooser jFileChooser1_file;
    private JButton jButton1_chooseFile, jButton2_writeDown, jButton3_changeName;

    public ChangePDFnameSWING_jPanel() {
        setLayout(null); // wylacza domyslny zarzadca rozkladu
        //setLayout((LayoutManager)null);
        setVisible(true);

        jLabel1_docType = new JLabel("Przedmiot skanu:");
        jRadioButton1_invoice = new JRadioButton("Faktura");
        jRadioButton2_contractInternet = new JRadioButton("Umowa Int");
        jRadioButton3_contractTelephone = new JRadioButton("Umowa Tel");
        jLabel1_docType.setBounds(20, 70, 250, 20);
        jRadioButton1_invoice.setBounds(30, 90, 150, 20);
        jRadioButton2_contractInternet.setBounds(200, 90, 150, 20);
        jRadioButton3_contractTelephone.setBounds(370, 90, 150, 20);
        add(jLabel1_docType);
        add(jRadioButton1_invoice);
        add(jRadioButton2_contractInternet);
        add(jRadioButton3_contractTelephone);
        buttonGroup1_docType = new ButtonGroup();
        buttonGroup1_docType.add(jRadioButton1_invoice);
        buttonGroup1_docType.add(jRadioButton2_contractInternet);
        buttonGroup1_docType.add(jRadioButton3_contractTelephone);

        jLabel2_vendor = new JLabel("Dostawca:");
        jTextField2_vendor = new JTextField("");
        jLabel2_vendor.setBounds(20, 130, 150, 20);
        jTextField2_vendor.setBounds(20, 150, 150, 20);
        add(jLabel2_vendor);
        add(jTextField2_vendor);

        jLabel3_nrOfInvoiceOrContract = new JLabel("nr faktury/umowy:");
        jTextField3_nrOfInvoiceOrContract = new JTextField("");
        jLabel3_nrOfInvoiceOrContract.setBounds(200, 130, 150, 20);
        jTextField3_nrOfInvoiceOrContract.setBounds(200, 150, 150, 20);
        add(jLabel3_nrOfInvoiceOrContract);
        add(jTextField3_nrOfInvoiceOrContract);

        jLabel4_city = new JLabel("Miasto:");
        jTextField4_city = new JTextField("");
        jLabel4_city.setBounds(20, 180, 150, 20);
        jTextField4_city.setBounds(20, 200, 150, 20);
        add(jLabel4_city);
        add(jTextField4_city);

        jLabel5_streetAndNr = new JLabel("Ulica nr");
        jTextField5_streetAndNr = new JTextField("");
        jLabel5_streetAndNr.setBounds(200, 180, 150, 20);
        jTextField5_streetAndNr.setBounds(200, 200, 150, 20);
        add(jLabel5_streetAndNr);
        add(jTextField5_streetAndNr);

        jLabel6_date = new JLabel("Data:");
        jTextField6_date = new JTextField("");
        jLabel6_date.setBounds(400, 130, 100, 20);
        jTextField6_date.setBounds(400, 150, 150, 20);
        add(jLabel6_date);
        add(jTextField6_date);

        jLabel503_nickName = new JLabel("4bs0rb3nt");
        jLabel503_nickName.setBounds(500, 480, 100, 20);
        add(jLabel503_nickName);
        jTextArea1_fileURL = new JTextArea("ścieżka pliku");
        jTextArea1_fileURL.setBounds(10, 30, 550, 15);
        add(jTextArea1_fileURL);

        jFileChooser1_file = new JFileChooser(FileSystemView.getFileSystemView());
        jFileChooser1_file.setCurrentDirectory(new File("."));
        jTextArea2_resultURL = new JTextArea("");
        jTextArea2_resultURL.setBounds(10, 280, 550, 15);
        add(jTextArea2_resultURL);

        jButton1_chooseFile = new JButton("1) wybierz plik");
        jButton1_chooseFile.setBounds(150, 10, 300, 20);
        add(jButton1_chooseFile);

        jButton1_chooseFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFileChooser1_file.setDialogTitle("Select PDF file");
                int returnValue = jFileChooser1_file.showOpenDialog((Component)null);
                if (returnValue == 0) {
                    try {
                        Desktop.getDesktop().open(jFileChooser1_file.getSelectedFile());
                        jTextArea1_fileURL.setText(jFileChooser1_file.getSelectedFile().getPath());
                    } catch (IOException var4) {
                        var4.printStackTrace();
                    }
                } else {
                    jTextArea1_fileURL.setText("no file selected");
                }

            }
        });

        jButton2_writeDown = new JButton("2) wypisz");
        jButton2_writeDown.setBounds(150, 250, 300, 20);
        add(jButton2_writeDown);

        jButton2_writeDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String provider = jTextField2_vendor.getText();
                String fvnr = jTextField3_nrOfInvoiceOrContract.getText();
                String city = jTextField4_city.getText();
                String adress = jTextField5_streetAndNr.getText();
                String date = jTextField6_date.getText();
                if (jRadioButton1_invoice.isSelected()) {
                    jTextArea2_resultURL.setText(provider + "_" + date + "_" + fvnr + "_fin");
                } else if (jRadioButton2_contractInternet.isSelected()) {
                    jTextArea2_resultURL.setText(adress + "_" + city + "_" + provider + "_" + date + "_" + fvnr);
                } else if (jRadioButton3_contractTelephone.isSelected()) {
                    jTextArea2_resultURL.setText(adress + "_" + city + "_" + provider + "_" + date + "_" + fvnr);
                }

                String file = jTextArea2_resultURL.getText();

                try {
                    FileWriter fw = new FileWriter("lista.csv", true);
                    fw.append(provider + "," + date + "," + fvnr + "," + city + "," + adress + "," + file + "\n");
                    fw.close();
                    System.out.println("fw done!");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });

        jButton3_changeName = new JButton("3) zmień nazwę");
        jButton3_changeName.setBounds(150, 320, 300, 20);
        add(jButton3_changeName);
        jButton3_changeName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File oldName = new File(jFileChooser1_file.getSelectedFile().getPath());
                File newName = new File(jTextArea2_resultURL.getText() + ".pdf");
                if (oldName.renameTo(newName)) {
                    System.out.println("renamed");
                } else {
                    System.out.println("Error");
                }

            }
        });

    }
}










