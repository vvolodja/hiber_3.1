package model;

import java.util.Scanner;


class Main {

    public static void main ( String[] args ) {

        new Main();
    }

    Menu menu = new Menu();

//    Организация вывода пользовательского меню:

//    public void displayMainMenu() {
//        System.out.println("Введите, пожалуйста, число, соответствующее вашему запросу.\n");
//        System.out.println (
//                "1 -- Ваша цель - получить информацию\n" +
//                "2 -- Ваша цель - изменить данные\n"
//        );
//        System.out.print ( "Ваш выбор: " );
//    }
//
//    public void displayGetInformationMenu() {
//        System.out.println("Введите, пожалуйста, число, соответствующее вашему запросу.\n");
//        System.out.println (
//                "1 -- Информация о разработчиках\n" +
//                "2 -- Информация о проектах\n"
//        );
//        System.out.print ( "Ваш выбор: " );
//    }
//
//    public void displayEditDataMenu() {
//        System.out.println("Введите, пожалуйста, число, соответствующее вашему запросу.\n");
//        System.out.println (
//                "1 -- Редактировать данные разработчиков\n" +
//                "2 -- Редактировать данные по проектам\n"
//        );
//        System.out.print ( "Ваш выбор: " );
//    }

//    Анализ и реакция на вводимые значения:

    private Main() {
        Scanner in = new Scanner ( System.in );

        menu.displayMainMenu();
        switch ( in.nextInt() ) {
            case 1:
                menu.displayGetInformationMenu();
                break;
            case 2:
                menu.displayEditDataMenu();
                break;
            default:
                System.err.println ( "Введите только число 1 или 2" );
                break;
        }
    }
}
