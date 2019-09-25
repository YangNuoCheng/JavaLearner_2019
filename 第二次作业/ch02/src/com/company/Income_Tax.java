package com.company;

import java.util.Scanner;

public class Income_Tax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年收入：");
        double Tot=input.nextDouble();
        double Tax=0;
        if(Tot>=36000)
        {
            Tot-=36000;
            if(Tot<=108000){
                //第二段缴税
                Tax+=Tot*0.1;
            }
            else {
                Tax+=108000*0.01;
                Tot-=144000;
                if(Tot<=156000)
                    Tax+=Tot*0.2;
                else{
                    Tax+=156000*0.2;
                    Tot-=156000;
                    if(Tot<=120000)
                    {
                        Tax+=Tot*0.25;
                    }
                    else{
                        Tax+=120000*0.25;
                        Tot-=120000;
                        if(Tot<=240000) {
                            Tax += Tot * 0.3;
                        }
                        else{
                            Tot-=240000;
                            Tax+=240000 * 0.3;
                            if(Tot<=300000){
                                Tax+=Tot*0.35;
                            }
                            else {
                                Tot-=300000;
                                Tax+=300000*0.35;
                                Tax+=Tot*0.45;
                            }
                        }
                    }
                }
            }
        }
        else Tax=Tot*0.03;
        System.out.print("需要缴纳"+Tax+"的税金.");
    }
}
