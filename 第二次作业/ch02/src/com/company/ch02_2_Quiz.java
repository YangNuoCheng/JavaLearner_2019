package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ch02_2_Quiz {
    public static void main(String[] args) {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("加减法测试");
        // Setting the width and height of frame
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);

        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        //arrayRefVar = new dataType[arraySize];
        String[] CalNumber = new String[5];
        int[] Answer = new int[5];
        //创建计算公式的数组
        Random random = new Random();

        for (int i = 0; i < 5; ) {
            int a = Math.abs((random.nextInt()) % 100);
            int b = Math.abs((random.nextInt()) % 100);
            if (i % 2 == 0 && a != b && a >= 10 && b > 10) {
                //减法
                if (a < b) {
                    int bet = a;
                    a = b;
                    b = bet;
                }
                if (a - b > 0) {
                    CalNumber[i] = (String) (a + "-" + b);
                    Answer[i] = a - b;
                    i++;
                } else if (a + b < 100) {
                    CalNumber[i] = (String) (a + "+" + b);
                    Answer[i] = a + b;
                    i++;
                } else continue;
            } else if (a >= 10 && b >= 10) {
                //加法
                if (a + b < 100) {
                    CalNumber[i] = (String) (a + "+" + b);
                    Answer[i] = a + b;
                    i++;
                } else continue;
            }
        }
        for (int i = 0; i < 5; i++)
            System.out.println(CalNumber[i]);

        JLabel TotLabel = new JLabel(CalNumber[0]);
        TotLabel.setBounds(10, 20, 80, 25);
        panel.add(TotLabel);

        JLabel PriceLabel = new JLabel(CalNumber[1]);
        PriceLabel.setBounds(10, 50, 80, 25);
        panel.add(PriceLabel);

        JLabel YearLabel = new JLabel(CalNumber[2]);
        YearLabel.setBounds(10, 80, 80, 25);
        panel.add(YearLabel);

        JLabel AnsLabel = new JLabel(CalNumber[3]);
        AnsLabel.setBounds(10, 110, 80, 25);
        panel.add(AnsLabel);

        JLabel Text4Label = new JLabel(CalNumber[4]);
        Text4Label.setBounds(10, 140, 80, 25);
        panel.add(Text4Label);

        JTextField Text_1 = new JTextField(20);
        Text_1.setBounds(100, 20, 165, 25);
        panel.add(Text_1);

        JTextField Text_2 = new JTextField(20);
        Text_2.setBounds(100, 50, 165, 25);
        panel.add(Text_2);

        JTextField Text_3 = new JTextField(20);
        Text_3.setBounds(100, 80, 165, 25);
        panel.add(Text_3);

        JTextField Text_4 = new JTextField(20);
        Text_4.setBounds(100, 110, 165, 25);
        panel.add(Text_4);

        JTextField Text_5 = new JTextField(20);
        Text_5.setBounds(100, 140, 165, 25);
        panel.add(Text_5);

        JButton loginButton = new JButton("回答完毕");
        loginButton.setBounds(100, 200, 80, 25);
        panel.add(loginButton);

        JButton RestartButton = new JButton("重新计算");
        RestartButton.setBounds(200, 200, 80, 25);
        panel.add(RestartButton);

        RestartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double [] Student_Ans = new double[5];
                Student_Ans[0] = Double.parseDouble(Text_1.getText());
                Student_Ans[1] = Double.parseDouble(Text_2.getText());
                Student_Ans[2] = Double.parseDouble(Text_3.getText());
                Student_Ans[3] = Double.parseDouble(Text_4.getText());
                Student_Ans[4] = Double.parseDouble(Text_5.getText());
                int Wrong = 0;
                int Right = 0;
                int[] Wrong_Number = new int[5];
                for (int i=0;i<5;i++) {
                    Wrong_Number[i]=0;
                }
                for(int i=0;i<5;i++)
                {
                    if(Student_Ans[i]!=Answer[i])
                    {
                        switch (i) {
                        case 0:Text_1.setText("");break;
                        case 1:Text_2.setText("");break;
                        case 2:Text_3.setText("");break;
                        case 3:Text_4.setText("");break;
                        case 4:Text_5.setText("");break;
                        }
                    }
                }
            }
        });
        //创建文本输出框
        JTextArea AnswerText = new JTextArea();
        AnswerText.setBounds(10,170,255,25);
        panel.add(AnswerText);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double [] Student_Ans = new double[5];
                Student_Ans[0] = Double.parseDouble(Text_1.getText());
                Student_Ans[1] = Double.parseDouble(Text_2.getText());
                Student_Ans[2] = Double.parseDouble(Text_3.getText());
                Student_Ans[3] = Double.parseDouble(Text_4.getText());
                Student_Ans[4] = Double.parseDouble(Text_5.getText());
                int Wrong = 0;
                int Right = 0;
                int[] Wrong_Number = new int[5];
                for (int i=0;i<5;i++) {
                    Wrong_Number[i]=0;
                }
                for(int i=0;i<5;i++)
                {
                    if(Student_Ans[i]!=Answer[i])
                    {
                        Wrong++;
                        Wrong_Number[i]=1;
                    }
                    else Right++;
                }
                AnswerText.setText("你做错了"+Wrong+"道题目");
                if(Wrong!=0) {
                    AnswerText.append("他们分别是: ");
                    for(int j=0;j<5;j++)
                    {
                        if(Wrong_Number[j]==1)
                            AnswerText.append(j+1+" ");
                    }
                }
                else AnswerText.setText("恭喜你，你全都做对了！");
                System.out.println("Wrong: "+Wrong);
                System.out.println("Right: "+Right);
//               AnswerText.setText(String.valueOf(Answer));
            }
        });
    }

}
