package com.company;

import java.util.Scanner;

public class MOOM_NAAN {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入一串字符串：");
        String Huiwen = input.nextLine();
        int Length=Huiwen.length();
        boolean Ans=true;
        for(int i=Length-1;i>=0;i--){
            if(Huiwen.charAt(i)!=Huiwen.charAt(Length-i-1))
                Ans=false;
        }
    if (Ans)
        System.out.print(Huiwen+"是回文字符串。");
    else System.out.print(Huiwen+"不是一个回文字符串.");
    }
}
