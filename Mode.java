package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mode implements ActionListener{

    JFrame frame;
    JTextField textfield,textField1,textField2,textField3;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[7];
    JButton addButton,subButton,mulButton,divButton,back;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    JLabel label;
    double num3;
    int count=0;


    Font myFont = new Font("Ink Free",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;

    Mode(){

        frame = new JFrame("Calculator");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 650);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(58, 50, 347, 50);


        label = new JLabel();

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.BOLD, 22));
        label.setBounds(35, 11, 301, 35);
        label.setText("ax^2+bx+c");

        frame.add(label);

        textfield.setEditable(false);
        textField1 = new JTextField();
        textField1.setBounds(58, 100, 347, 50);

        textField1.setEditable(false);
        textField3 = new JTextField();
        textField3.setBounds(0, 50, 60, 50);

        textField3.setEditable(false);
        textField2 = new JTextField();
        textField2.setBounds(0, 100, 60, 50);

        textField2.setEditable(false);
        frame.add(textField1);
        frame.add(textField2);
        frame.add(textField3);

        addButton = new JButton("+");
        subButton = new JButton("-");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");
        back = new JButton("back");
        back.addActionListener(this);
        frame.add(back);
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = decButton;
        functionButtons[3] = equButton;
        functionButtons[4] = delButton;
        functionButtons[5] = clrButton;
        functionButtons[6] = negButton;

        for(int i =0;i<7;i++) {
            functionButtons[i].addActionListener(this);

            functionButtons[i].setFocusable(false);
        }

        for(int i =0;i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);

            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,460,100,50);

        delButton.setBounds(150,460,100,50);

        clrButton.setBounds(250,460,100,50);


        panel = new JPanel();
        panel.setBounds(50, 160, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(back);


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        panel.setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        Mode calc = new Mode();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==back){
            frame.setVisible(false);
            calulator c=new calulator();

        }
        if(e.getSource()==addButton) {
            if(count==0) {
                num1 = Double.parseDouble(textfield.getText());
            }
            if(count==1){
                num3=  Double.parseDouble(textfield.getText());

            }
            count++;

            operator ='+';
            textfield.setText("");
        }
        if(e.getSource()==subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator ='-';
            textfield.setText("");
        }
        if(e.getSource()==equButton) {
            num2=Double.parseDouble(textfield.getText());

            switch(operator) {
                case'+':
                    count=0;
                    System.out.println(num1);
                    System.out.println(num3);
                    System.out.println(num2);
                    double root1, root2;
                    double determinant = num3 * num3 - 4 * num1 * num2;
                    if (determinant > 0) {
                        System.out.println("First");
                        // two real and distinct roots
                        root1 = (-num3 + Math.sqrt(determinant)) / (2 * num1);
                        root2 = (-num3 - Math.sqrt(determinant)) / (2 * num1);

                        textfield.setText(String.valueOf(root1));
                        textField3.setText("root1");
                        textField1.setText(String.valueOf(root2));
                        textField2.setText("root2");
                        root1=0;
                        root2=0;
                    }
                    else if (determinant == 0) {

                        System.out.println("second");
                        root1 = root2 = -num3 / (2 * num1);
                        textfield.setText(String.valueOf(root1));
                        textField3.setText("root1");
                        textField1.setText(String.valueOf(root2));
                        textField2.setText("root2 ");
                        root1=0;
                        root2=0;
                    }

                    else {
                        System.out.println("third");
                        // roots are complex number and distinct
                        double real = -num3 / (2 * num1);
                        double imaginary = Math.sqrt(-determinant) / (2 * num1);
                        textfield.setText(String.valueOf(real+imaginary));
                        textField2.setText("Imaginary");
                        textField1.setText(String.valueOf(real+imaginary));
                        textField3.setText("Imaginary");
                        real=0;
                        imaginary=0;
                    }



                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }

            num1=result;
        }
        if(e.getSource()==clrButton) {
            textfield.setText("");
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
        }
        if(e.getSource()==delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if(e.getSource()==negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
    }
}





