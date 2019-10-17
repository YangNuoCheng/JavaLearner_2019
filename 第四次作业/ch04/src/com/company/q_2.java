package com.company;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class q_2 {
    static class Location{
        int row = 0;
        int column = 0;
        double maxValue = 0.0;
    }
    public static Location locationLargest(double [][]a){
        Location myTable = new Location();
        myTable.maxValue = a[0][0];
        myTable.column = 0;
        myTable.row = 0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(myTable.maxValue != Math.max(a[i][j],myTable.maxValue)){
                    myTable.column = i;
                    myTable.row = j;
                    myTable.maxValue = Math.max(a[i][j],myTable.maxValue);
                }
            }
        }
        return myTable;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns in the array:");
        int rows = input.nextInt();//行
        int colums = input.nextInt();//列
        double [][] table = new double [rows][colums];
        System.out.println("Do you want to input Automatic?(input y/n)");
        if(input.next().equals("n")){
            for (int i=0;i<rows;i++)
                for (int j=0;j<colums;j++)
                    table[i][j] = input.nextDouble();
        }
        else{
            Random rand =new Random((long) Math.random());
            DecimalFormat df = new DecimalFormat( "00");
            for (int i=0;i<rows;i++) {
                for (int j = 0; j < colums; j++)
                    table[i][j] = Double.parseDouble(df.format(rand.nextInt(100)));
            }
            System.out.println("The table we created is :");
            for (int i=0;i<rows;i++){
                for(int j=0;j<colums;j++)
                    System.out.print(table[i][j]+" ");
                System.out.println("");
            }
        }
        Location ans = locationLargest(table);
        System.out.println("The location of the largest element is "+ans.maxValue+" at ("+(ans.column+1)+","+(ans.row+1)+")");
    }
}
