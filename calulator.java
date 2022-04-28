package com.company;





import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class calulator implements ActionListener {

    JFrame frame;
    JRadioButton jRadioButton2, jRadioButton1;
    JTextField textfield, textfield2;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton, mode;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    JButton[] trigonometry = new JButton[6];
    JButton cosx, sinx, tanx, secx, cosecx, cotx;
    JButton tentopow, rootx, logx, lnx, ex,xpowcube,xpowy,onebyx,nfactorial;
    JButton[] extrafunc = new JButton[9];

    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    calulator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 425, 535);
        frame.setLayout(null);


        tentopow = new JButton("10^x");
        rootx = new JButton("\u221A");
        logx = new JButton("log");
        lnx = new JButton("ln");
        ex = new JButton("e^x");
        xpowcube = new JButton("x^3");
        xpowy = new JButton("x^y");
        onebyx = new JButton("1/x");
         nfactorial = new JButton("n!");


        jRadioButton1 = new JRadioButton("On");
        jRadioButton1.addActionListener(this);
        jRadioButton1.setFocusable(false);
       jRadioButton1.setBorder(new LineBorder(Color.black));
        jRadioButton2 = new JRadioButton("Off");
        jRadioButton2.addActionListener(this);
        jRadioButton2.setFocusable(false);
        jRadioButton2.setBorder(new LineBorder(Color.black));


        cosecx = new JButton("cosec");
        cosx = new JButton("cos");
        sinx = new JButton("sin");
        cotx = new JButton("cot");
        secx = new JButton("sec");
        tanx = new JButton("tan");
        mode = new JButton("mode");


        mode.addActionListener(this);


        extrafunc[0] = tentopow;
        extrafunc[1] = ex;
        extrafunc[2] = lnx;
        extrafunc[3] = logx;
        extrafunc[4] = rootx;
        extrafunc[5] = xpowcube;
        extrafunc[6] = xpowy;
        extrafunc[7] = onebyx;
        extrafunc[8] = nfactorial;


        trigonometry[0] = sinx;
        trigonometry[1] = cosx;
        trigonometry[2] = cosecx;
        trigonometry[2].setFont(new Font("tahoma", Font.BOLD, 11));
        trigonometry[3] = tanx;
        trigonometry[4] = cotx;
        trigonometry[5] = secx;


        for (int i = 0; i < 9; i++) {
            extrafunc[i].addActionListener(this);

            extrafunc[i].setFocusable(false);
            extrafunc[i].setEnabled(false);
            extrafunc[i].setSize(58, 43);

        }


        for (int i = 0; i < 6; i++) {
            trigonometry[i].addActionListener(this);

            trigonometry[i].setEnabled(false);

            trigonometry[i].setFocusable(false);
        }


        textfield = new JTextField();
        textfield.setBounds(45, 25, 305, 50);

        textfield.setEditable(false);
        textfield2 = new JTextField();
        textfield2.setBounds(0, 25, 45, 50);

        textfield2.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);


            functionButtons[i].setSize(58, 43);
            functionButtons[i].setEnabled(false);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);


            numberButtons[i].setEnabled(false);
            numberButtons[i].setSize(58, 43);

            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        negButton.setEnabled(false);
        delButton.setBounds(150, 430, 100, 50);
        delButton.setEnabled(false);
        clrButton.setBounds(250, 430, 100, 50);
        clrButton.setEnabled(false);

        panel = new JPanel();
        mode.setBounds(140, 80, 70, 20);
        mode.setEnabled(false);
        jRadioButton1.setBounds(40, 80, 70, 20);
        jRadioButton2.setBounds(250, 80, 70, 20);

        panel.setBounds(0, 100, 410, 350);
        panel.setLayout(new GridLayout(6, 4, 5, 10));



        panel.add(trigonometry[0]);
        panel.add(trigonometry[1]);
        panel.add(trigonometry[2]);
        panel.add(trigonometry[3]);
        panel.add(trigonometry[4]);
        panel.add(trigonometry[5]);


        panel.add(tentopow);
        panel.add(rootx);
        panel.add(ex);
        panel.add(logx);
        panel.add(lnx);
        panel.add(onebyx);
        panel.add(xpowcube);
        panel.add(xpowy);
        panel.add(nfactorial);


        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);
        panel.add(negButton);
        panel.add(numberButtons[0]);
        panel.add(delButton);
        panel.add(clrButton);
        panel.add(decButton);
        panel.add(equButton);
        frame.add(mode);
        frame.add(panel);
        frame.add(textfield);
        frame.add(jRadioButton1);
        frame.add(jRadioButton2);
        frame.add(textfield2);

        frame.setVisible(true);
    }

    public static void main(String[] args) {

        calulator calc = new calulator();
    }

    String name;

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        for (int i = 0; i < 6; i++) {
            if (e.getSource() == trigonometry[i]) {
                textfield.setText(trigonometry[i].getText());
            }
        }

        if (e.getSource() == cosx) {
            name = "cosx";
            textfield.setText("cosx");
            textfield.setText("");
            textfield2.setText("cos");
        }
        if (e.getSource() == cosecx) {
            name = "cosecx";
            textfield.setText("");
            textfield2.setText("cosec");
        }
        if(e.getSource()==mode){

            frame.setVisible(false);
             Mode m=new Mode();
        }


        if (e.getSource() == secx) {
            name = "secx";
            textfield.setText("");
            textfield2.setText("sec");
        }


        if (e.getSource() == sinx) {
            name = "sinx";
            textfield.setText("");
            textfield2.setText("sin");
        }


        if (e.getSource() == tanx) {
            name = "tanx";
            textfield.setText("");
            textfield2.setText("tan");
        }

        if (e.getSource() == cotx) {
            name = "cotx";
            textfield.setText("");
            textfield2.setText("cot");
        }

        if (e.getSource() == tentopow) {
            name = "tentopow";

            textfield2.setText("10^");
        }

        if (e.getSource() == rootx) {
            name = "root(x)";

            textfield2.setText("root");
        }
        if (e.getSource() == ex) {
            name = "e^x";

            textfield2.setText("e^");
        }
        if (e.getSource() == logx) {
            name = "log";

            textfield2.setText("log");
        }








        if (e.getSource() == nfactorial) {
            name = "n!";
            num1= Double.parseDouble(textfield.getText());
            textfield2.setText("fact");
        }
        if(e.getSource()==xpowcube){

            name = "xpowcube";
            textfield2.setText("cube");


        }


        if(e.getSource()==onebyx){

            name = "onebyx";
            textfield2.setText("1/x");




        }


        if(e.getSource()==xpowy){

            name = "xpowy";

            num1= Double.parseDouble(textfield.getText());
            textfield.setText("");


        }

        if(e.getSource()==lnx){

            name="lnx";
            textfield2.setText("ln");

        }





        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }

        if(e.getSource()==jRadioButton1){
            jRadioButton2.setSelected(false);

             mode.setEnabled(true);
            for (int i = 0; i < 9; i++) {
                extrafunc[i].setEnabled(true);

            }


            for (int i = 0; i < 6; i++) {
                trigonometry[i].setEnabled(true);

            }



            for (int i = 0; i < 9; i++) {
                functionButtons[i].setEnabled(true);

            }

            for (int i = 0; i < 10; i++) {
                numberButtons[i].setEnabled(true);

            }


        }


        if(e.getSource()==jRadioButton2){
            textfield.setText("");
            textfield2.setText("");
                  jRadioButton1.setSelected(false);
            for (int i = 0; i < 9; i++) {
                extrafunc[i].setEnabled(false);

            }

            mode.setEnabled(false);
            for (int i = 0; i < 6; i++) {
                trigonometry[i].setEnabled(false);

            }



            for (int i = 0; i < 9; i++) {
                functionButtons[i].setEnabled(false);

            }

            for (int i = 0; i < 10; i++) {
                numberButtons[i].setEnabled(false);

            }


        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());

            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());
                  if (name == null) {
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    textfield.setText(String.valueOf(result));
                    textfield2.setText("Ans");
                    break;
                case '-':
                    result = num1 - num2;
                    textfield.setText(String.valueOf(result));
                    textfield2.setText("Ans");
                    break;
                case '*':
                    result = num1 * num2;
                    textfield.setText(String.valueOf(result));
                    textfield2.setText("Ans");
                    break;
                case '/':
                    if(num2==0.0){
                        textfield.setText("Math error");

                        break;
                    }else {
                        result = num1 / num2;
                        textfield.setText(String.valueOf(result));
                        textfield2.setText("Ans");

                        break;
                    }

            }
            } else {
                switch (name) {
                    case "n!":
                        int i,fact=1;
                        double number=num1;
                        for(i=1;i<=num1;i++){
                            fact=fact*i;
                        }
                       textfield.setText(String.valueOf(fact));
                        textfield2.setText("fact");
                        fact=0;
                        name=null;
                        result=0;
                        break;


                    case "xpowcube":

                        result = Math.pow(num2,3);
                        textfield.setText(String.valueOf(result));
                        textfield2.setText("Ans");
                        result=0;
                        name=null;
                        break;

                    case "onebyx":

                        result = (1/num2);
                        textfield.setText(String.valueOf(result));
                        textfield2.setText("Ans");
                        result=0;
                        name=null;
                        break;

                    case "lnx" :

                        if(num2==0.0||num2<0){
                            textfield.setText("Math error");
                            textfield2.setText("");
                            break;
                        }
                     else {
                            double num, mul, cal, sum = 0;
                            num = (num2 - 1) / (num2 + 1);
                            for (int j = 1; j <= 1000; j++) {
                                mul = (2 * j) - 1;
                                cal = Math.pow(num, mul);
                                cal = cal / mul;
                                sum = sum + cal;
                            }
                            sum = 2 * sum;

                            result = sum;
                            textfield.setText(String.valueOf(result));
                            textfield2.setText("Ans");
                            result = 0;
                            name = null;
                            break;
                        }

                    case "xpowy" :

                        result = Math.pow(num1,num2);
                        textfield.setText(String.valueOf(result));
                        textfield2.setText("Ans");
                        result=0;
                        name=null;
                        break;


                      case "cosx":
                        result = Math.cos(num2);
                        textfield.setText(String.valueOf(result));
                        textfield2.setText("Ans");
                        result=0;
                        name=null;
                        break;

                    case "cosecx":
                        if (num2 == 0.0) {
                            textfield.setText("Math error");
                            break;
                        } else {
                            result = 1 / Math.sin(num2);
                            textfield.setText(String.valueOf(result));
                            textfield2.setText("Ans");
                            result=0;
                            name=null;
                            break;
                        }
                    case "secx":
                        if (num2 == 90.0) {
                            textfield.setText("Math error");
                            break;
                        } else {
                            result = 1 / Math.cos(num2);
                            textfield.setText(String.valueOf(result));
                            textfield2.setText("Ans");
                            result=0;
                            name=null;
                            break;
                        }


                    case "sinx":
                        result = Math.sin(num2);
                        textfield.setText(String.valueOf(result));
                        textfield2.setText("Ans");
                        result=0;
                        name=null;
                        break;

                    case "cotx":



                        if (num2 == 0.0) {
                            textfield.setText("Math error");
                            break;

                        } else {
                            result = 1 / Math.tan(num2);
                            textfield.setText(String.valueOf(result));
                            textfield2.setText("Ans");
                            result=0;
                            name=null;
                            break;
                        }


                    case "tanx":
                        if (num2 == 90.0) {
                            textfield.setText("Math error");
                            break;
                        } else {
                            result = Math.tan(num2);
                            textfield.setText(String.valueOf(result));
                            textfield2.setText("Ans");
                            result=0;
                            name=null;
                            break;
                        }
                   case "tentopow":
                        result=Math.pow(10,num2);
                        textfield.setText(String.valueOf(result));
                        textfield2.setText("Ans");
                       result=0;
                       name=null;
                       break;

                    case "root(x)":
                        if (num2 <0) {
                            textfield.setText("Math error");
                            textfield2.setText("");
                            break;
                        } else {
                            result = Math.sqrt(num2);
                          textfield.setText(String.valueOf(result));
                            textfield2.setText("Ans");
                            result=0;
                            name=null;
                            break;
                        }




                    case "e^x":
                        result=Math.exp(num2);
                        textfield.setText(String.valueOf(result));
                        textfield2.setText("Ans");
                        result=0;
                        name=null;
                        break;

                    case "log":


                        if (num2==0.0||num2<0) {
                            textfield.setText("Math error");
                            textfield2.setText("");
                            break;
                        } else {
                            result=Math.log(num2);
                            textfield.setText(String.valueOf(result));
                            textfield2.setText("Ans");
                            result=0;
                            name=null;
                            break;
                        }



                }


            }


        }

            if (e.getSource() == clrButton) {
                textfield.setText("");
                textfield2.setText("");
            }
            if (e.getSource() == delButton) {
                String string = textfield.getText();
                textfield.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    textfield.setText(textfield.getText() + string.charAt(i));
                }
            }
            if (e.getSource() == negButton) {
                double temp = Double.parseDouble(textfield.getText());
                temp *= -1;
                textfield.setText(String.valueOf(temp));
            }
        }
    }
