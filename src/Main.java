import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String arg[]){
        System.out.println("В какую игру будем играть: 1 или 2?");
        int gameNumber =readIntegerFromConsole();
        if (gameNumber == 1){
            System.out.println("Я загадал число от 0 до 9.");
            System.out.println("У вас есть три попытки чтобы угадать.");
            guessNumber();
        }
        else if (gameNumber == 2){
            guessFruit();
        }
    }


    static void guessNumber() {
        System.out.println("Игра начинается!");
        Random rnd=new Random();
        int randomize = rnd.nextInt(10);
        int attempt = 0;
        while (attempt<3){
            int numberUser = readIntegerFromConsole();
            if (randomize == numberUser) {
                System.out.println("Вы угадали. Поздравляю! Желаете ли попробывать еще раз? 1-да, 2-нет");
                newAttempt();
            } else if (randomize > numberUser) {
                attempt += 1;
                System.out.println("Загаданое число больше.");
            } else {
                attempt += 1;
                System.out.println("Загаданое число меньше.");
            }
        }

        System.out.println("Вы проиграли! Я загадал число " + randomize + ". Попробуете еще раз? 1-да, 2-нет");
        newAttempt();
        }
        static void newAttempt(){
            Scanner sc = new Scanner(System.in);
            int x=sc.nextInt();
            if(x==1){
                guessNumber();
                sc.close();
            }
        }
        static int readIntegerFromConsole(){
            Scanner sc = new Scanner(System.in);
            do {
                if (sc.hasNextInt()){
                    return sc.nextInt();
                }
                else{
                    System.out.println("Введите целое число!");
                }
                sc.nextLine();
            }
            while (true);
        }


    static void guessFruit() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random rnd = new Random();
        int rndFruit = rnd.nextInt(words.length);
        String conceived = words[rndFruit];
        System.out.println("Я загадал фрукт из этого списка " + Arrays.toString(words));
        System.out.println("Угадайте его!");
        String userFruit;
        do {
            Scanner sc = new Scanner(System.in);
            userFruit = sc.nextLine();
            if (userFruit.equals(conceived)) {
                System.out.println("Поздравляю, Вы победили! Желаете ли попробывать еще раз? 1-да, 2-нет");
                attemptFruit();
            } else {
                comparison(userFruit, conceived);
            }
        } while (!userFruit.equals(conceived));
    }
    static void comparison(String conceived, String userFruit){
        System.out.println("Не угадали.Вот вам подсказка:");
        for (int x=0; x<15; x++) {
             if(x >= userFruit.length() || x>=conceived.length()){
                System.out.print("#");
            }
                else if( userFruit.charAt(x) == conceived.charAt(x)) {
                    System.out.print(conceived.charAt(x));
                }
                else{
                    System.out.print("#");
                }
        }System.out.println();
        System.out.println("Игра начинается!");
    }
    static void attemptFruit(){
            Scanner sc = new Scanner(System.in);
            int x=sc.nextInt();
            if(x==1){
                guessFruit();
                sc.close();
            }
        }
    }

