package hortsman;

import java.util.Arrays;
import java.util.Scanner;

/**
 * В этой программе демонстрируется обращение с массивами
 */

public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.println("What is the highest number you can draw? ");
        int n = in.nextInt();

        // Заполняем массив числами 1 2 3 .... n

        int[] numbers = new int[n];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = i + 1;
        }

        //Выбрать k номеров и заполнить ими второй массив

        int[] result = new int[k];
        for(int i = 0; i < result.length; i++){
            // Получить случайный индекс в пределах от 0 до n - 1;
            int r = (int)(Math.random() * n);

            // Выбрать элемент из произвольного места
            result[i] = numbers[r];

            //Переместить последний элемент в произвольное место
            numbers[r] = numbers[n - 1];
            n--;
        }

        // Вывести отсортированный массив
        Arrays.sort(result);
        System.out.println("Попробуйте следующую комбинацию, чтобы разбогатеть");
        for(int r :result){
            System.out.println(r);
        }
    }
}
