
// Выполнил задание Ярослав Бондар


package com.geekbrains;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MainScanner {
    public static void main(String[] args) {
        int inputValue = -1;
        int restartGame = 1; //Присваиваю 1  для цикла (Повторить игру еще раз)


        Scanner scInput = new Scanner(System.in);
        Random randVal = new Random();




        while (restartGame == 1) {
            int randomValue = randVal.nextInt(9);
//            System.out.println(randomValue);                              // для проверки дз загаданого рандом числа
            int successCounter = 3;     //счетчик попыток

            while (successCounter != 0 ) {


                do {
                    System.out.println("Введите число от 0 до 9: ");
                    try {
                        inputValue = scInput.nextInt();
                    } catch (InputMismatchException exception) {
                        System.out.println("Вы ввели неверно ");
                    }
                    scInput.nextLine();
                } while (inputValue < 0 || inputValue > 9);





                if (inputValue == randomValue) {
                    System.out.println("Победа \nЧисло отгадано верно!");
                    break;
                } else if (inputValue < randomValue ) {
                    successCounter -= 1 ;
                    System.out.println("Загаданное число БОЛЬШЕ чем указаное");
                } else {
                    successCounter -= 1 ;
                    System.out.println("Загаданное число МЕНЬШЕ чем указаное");
                }
                System.out.println("Неудалось отгадать. Попыток (" + successCounter + "/3)");

                inputValue = -1;            //обнуляем ввод
            }

            System.out.println("«Хотите повторить игру еще раз? 1 – да / 0 – нет»");

            do {
                try {
                    restartGame = scInput.nextInt();
                } catch (InputMismatchException exception) {
                    System.out.println("Введите число верно  1 – да / 0 – нет»");
                }
                scInput.nextLine();
            } while (restartGame != 0 && restartGame != 1);

        }
        scInput.close();
        System.out.println("Конец игры");
    }

}


