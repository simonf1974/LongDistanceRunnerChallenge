package io.nology;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LongDistanceRunner runner = new LongDistanceRunner();

        System.out.println(runner);

        do {
            System.out.println("Choose move: \n 1: run \n 2: eat \n 3: sleep \n 4: wee");
            String move = scanner.next();

            switch(move) {
                case "1":
                    System.out.println("Choose number of miles to run");
                    int miles = scanner.nextInt();
                    System.out.println(runner.run(miles));
                    break;
                case "2":
                    System.out.println(runner.eat());
                    break;
                case "3":
                    System.out.println(runner.sleep());
                    break;
                case "4":
                    System.out.println(runner.wee());
                    break;
                default:
                    System.out.println("Please choose one of the valid options");
            }
        } while (!runner.isDead());

        System.out.println("You have killed your runner1");
    }
}
