package com.company;
import java.lang.String;
import java.util.*;

public class NewSplit {
    public static String[] split(String s , String regex){
        Queue<Character> queue = new LinkedList<Character>();
        ArrayList<String> arrayList = new ArrayList<String>();
        Set<Character> set = new HashSet<Character>();
        for(int i = 0;i < s.length(); i++){
            //将s全部录入队列中
            queue.add(s.charAt(i));
        }
        for (int i = 0;i < regex.length();i++){
            //将待匹配字符串录入Hashset中
            if(regex.charAt(i)!='['||regex.charAt(i)!=']'){
                set.add(regex.charAt(i));
            }
        }
        String Changeable = "";
        //拼接一个完整的字符串
        while(true){
            char CharAtFirst = queue.poll();
            if(set.contains(CharAtFirst)){
                arrayList.add(Changeable);
                arrayList.add(String.valueOf(CharAtFirst));
                Changeable = "";
            }
            else{
                Changeable += CharAtFirst;
            }
            if(queue.isEmpty()){
                if(!Changeable.equals(""))
                    arrayList.add(Changeable);
                break;//没有元素为止
            }
        }
        String [] ans = new String[arrayList.size()];
        for(int i = 0;i < ans.length;i++){
            ans[i] = arrayList.get(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "ab#12#453";
        String regex = "#";
        String [] Newsplit = split(s,regex);
        for(int i = 0;i < Newsplit.length;i++){
            System.out.print(" "+Newsplit[i]);
        }
        System.out.println();
        s = "a?b?gf#e";
        regex = "[?#]";
        String [] Newsplit2 = split(s,regex);
        for(int i = 0;i < Newsplit2.length;i++){
            System.out.print(" "+Newsplit2[i]);
        }
    }
}
