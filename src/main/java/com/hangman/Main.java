package com.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>(List.of("Рубль", "Собака", "Креветка", "Рак", "Вафли",
                "Печенье", "Отвертка", "Угол", "Мерило", "Солнце", "Планета", "Утконос", "Рыба", "Замок", "Забор"));
        ArrayList<String> alphabet = new ArrayList<>(List.of("а", "б", "в", "г", "д", "е", "ё", "ж", "з",
                "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы",
                "ь", "э", "ю", "я"));
        ArrayList<String> word = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        ArrayList<String> allAnswer = new ArrayList<>(alphabet.size());
        int hp = 6;
        int number = (int) (Math.random() * words.size());
        char[] randomWord = words.get(number).toCharArray();

        for (int i = 0; i < randomWord.length; i++) {
            word.add(String.valueOf(randomWord[i]).toLowerCase());
            answer.add("_");
        }

        System.out.println("Добро пожаловать в игру \"Виселица\"!\n" +
                "Ваша задача отгадать слово, у вас есть право на 6 ошибок.\n" +
                "Удачи");

        while (hp > 0) {
            System.out.println(answer.toString());
            System.out.print("Введите букву: ");
            String a = console.next().trim().toLowerCase();
            System.out.println();

            if (!alphabet.contains(a)) {
                System.out.println("Некорректный ввод!");
                System.out.println();
                continue;
            }

            if (allAnswer.contains(a)) {
                System.out.println("Вы уже ввели эту букву! Попробуйте другую");
                System.out.println();
                continue;
            }

            allAnswer.add(a);

            if (!word.contains(a)) {
                hp--;
                if (hp == 0) {
                    System.out.println("Вы проиграли! Это было слово: " + words.get(number) + " !");
                    break;
                }
                System.out.println("Ошибка, нет такой буквы! Осталось " + hp + " жизней!");
                System.out.println();
                continue;
            }

            for (int i = 0; i < word.size(); i++) {
                if (word.get(i).equals(a)) {
                    answer.set(i, a);
                }
            }

            if (!answer.contains("_")) {
                System.out.println("Поздравляю! Это слово: " + words.get(number) + " ! Вы победили!");
                break;
            }
        }
    }
}