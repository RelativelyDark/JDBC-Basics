package com.cars24.runner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter choice : ");
            System.out.println("1 for adding customer");
            System.out.println("2 for getting customer");
            System.out.println("3 for updating customer");
            System.out.println("4 for deleting customer");
            System.out.println("0 to exit");
            int choice = scanner.nextInt();
            switch(choice){
                case 1 : UI.addCustomer();
                break;
                case 2 : UI.getCustomer();
                break;
                case 3 : UI.updateCustomer();
                break;
                case 4 : UI.deleteCustomer();
                break;
                default : System.exit(69);
            }
        }
    }
}
