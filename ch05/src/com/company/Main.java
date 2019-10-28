package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        List<Account> players = new ArrayList<Account>();
        Scanner input = new Scanner(System.in);
        int id = 0;
        int choice = 0;
        Account players[];
        players = new Account[10];
        for(int i=0;i<players.length;i++) {
            players[i] = new Account(i+1,100);
        }
        while (true){
            while (true) {
            System.out.print("Enter an id: ");
            id = input.nextInt();
            if (id < 0 || id > 10)
                System.out.println("Please try again!");
            else break;
            }
            while(true) {
                System.out.print("\nMain menu:\n1: Check balance\n2: withdraw\n3: deposit\n4: exit");
                System.out.print("\nEnter a choice:");
                choice = input.nextInt();
                if (choice == 1) {
                    System.out.println("The balabce is " + players[id].getBalance());
                } else if (choice == 2) {
                    System.out.print("Enter an amount to withdraw: ");
                    players[id].withDraw(input.nextDouble());
                } else if (choice == 3) {
                    System.out.print("Enter an amount to deposit: ");
                    players[id].deposit(input.nextDouble());
                } else {
                    break;
                }
            }
        }
    }
}
