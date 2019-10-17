package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    static class Account{
        private int id = 0;
        private double balance = 0.0;//本金
        private double annualInterestRate = 0.0;//年利率
        private Date dateCreated;
        private ArrayList<Double> history_Value = new ArrayList<Double>();
        private ArrayList<Date> history_Date = new ArrayList<Date>();
        Account(){
            dateCreated = new Date();
//            无参构造方法
        }
        Account(int id ,double balance){
            System.out.println("this.id= "+ this.id+'\n'+"id= "+id);
            dateCreated = new Date();
            this.id = id;
            this.balance = balance;
        }
        int getId(){
            return this.id;
        }
        void setId(int id){
            this.id = id;
        }
        String getBalance(){
            return String.valueOf(this.balance*100)+"%";
        }
        void setBalance(double balance){
            this.balance = balance;
        }
        double getAnnualInterestRate(){
            return this.annualInterestRate;
        }
        void setannualInterestRate(double annualInterestRate){
            this.annualInterestRate = annualInterestRate/100;
//            由小数转化为百分数（ 75 -> 75% ）
        }
        Date getdateCreate(){
            return this.dateCreated;
        }
        double getMonthlyInterestRate(){
            return balance*(annualInterestRate/12.0);
        }
        void withDraw(double balance){
            if(balance<this.balance){
                this.balance -= balance;
                System.out.println("用户取出"+balance+"元,"+"余额为"+this.balance);
                history_Value.add(-1*balance);
                history_Date.add(new Date());
            }
            else System.out.println("余额不足，请重新输入！");
        }
        void deposit(double balance){
            this.balance += balance;
            System.out.println("用户存入"+balance+"元,"+"余额为"+this.balance);
            history_Value.add(balance);
            history_Date.add(new Date());
        }
        void showHistory(){
            for(int i=0;i<history_Date.size();i++){
                if(i!=0) System.out.println("");
                System.out.print("用户在"+history_Date.get(i).toString());
                System.out.print(history_Value.get(i)<0 ? " 取出 ":" 存入 " + Math.abs(history_Value.get(i)));
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Account MirSmith = new Account(1122,20000);
        MirSmith.setannualInterestRate(4.5);
        System.out.println("Smith先生下个月将获得的利息为："+MirSmith.getMonthlyInterestRate());
        System.out.println("Smith先生开户的时间为 "+MirSmith.getdateCreate().toString());
        Thread.sleep(5000);
        MirSmith.deposit(100000);
        Thread.sleep(5000);
        MirSmith.withDraw(9000);
        Thread.sleep(5000);
        MirSmith.withDraw(999999999);
        MirSmith.showHistory();
    }
}
