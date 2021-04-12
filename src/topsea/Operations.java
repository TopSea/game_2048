package topsea;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Operations {

    private static int index;
    private static boolean first;
    private static boolean sign;
    private static int score = 0;
    private static int zeros = 2;

    public static void main(String[] args) throws IOException {

        while (true) {
            boolean over = false;
            System.out.println("在游戏中：2代表向下移动，4代表向左移动，6代表向右移动，8代表向上移动，\n" +
                    "其他数字表示回到菜单，在菜单输入0即退出。现在请输入你想要的大小" +
                    "（例如输入3代表3*3大小）");
            Scanner scan = new Scanner(System.in);
            int sign = scan.nextInt();
            if(sign == 0){
                break;
            }
            int[][] a = randomArray.initArray(sign);
            Print(a);

            while(true){
                boolean gameOver = false;
                Scanner scanner = new Scanner(System.in);
                int operate = scanner.nextInt();
                switch (operate) {
                    case 2 :
                        a = operationDown(a);
                        System.out.println("Score: " + score + "\t");
                        if (randomArray.RandomArray(a, zeros + 1)) {
                            over = true;
                        }
                        break;
                    case 4 :
                        a = operationLeft(a);
                        System.out.println("Score: " + score + "\t");
                        if (randomArray.RandomArray(a, zeros + 1)) {
                            over = true;
                        }
                        break;
                    case 6 :
                        a = operationRight(a);
                        System.out.println("Score: " + score + "\t");
                        if (randomArray.RandomArray(a, zeros + 1)) {
                            over = true;
                        }
                        break;
                    case 8 :
                        a = operationUp(a);
                        System.out.println("Score: " + score + "\t");
                        if (randomArray.RandomArray(a, zeros + 1)) {
                            over = true;
                        }
                        break;
                    default : gameOver = true;
                }
                if(gameOver || over){
                    System.out.println("游戏结束..., Score:" + score);
                    break;
                }
                Print(a);
            }
        }

    }

    public static int[][] operationRight(int[][] a) {
        int[][] result = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            index = a[0].length - 1;
            first = true;
            sign = true;
            for (int j = a[0].length - 1; j >= 0; j--) {
                if (a[i][j] != 0) {
                    if (first) {
                        result[i][index] = a[i][j];
                        first = false;
                        continue;
                    }
                    if (a[i][j] == result[i][index] && sign) {
                        result[i][index] *= 2;
                        sign = false;
                    } else {
                        index--;
                        result[i][index] = a[i][j];
                        sign = true;
                    }
                }
            }
        }
        score += 10;
        return result;
    }

    public static int[][] operationLeft(int[][] a) {
        int[][] result = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            index = 0;
            first = true;
            sign = true;
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != 0) {
                    if (first) {
                        result[i][index] = a[i][j];
                        first = false;
                        continue;
                    }
                    if (a[i][j] == result[i][index] && sign) {
                        result[i][index] *= 2;
                        sign = false;
                    } else {
                        index++;
                        result[i][index] = a[i][j];
                        sign = true;
                    }
                }
            }
        }
        score += 10;
        return result;
    }

    public static int[][] operationUp(int[][] a) {
        int[][] result = new int[a.length][a[0].length];

        for (int j = 0; j < a[0].length; j++) {
            index = 0;
            first = true;
            sign = true;
            for (int i = 0; i < a.length; i++) {
                if (a[i][j] != 0) {
                    if (first) {
                        result[index][j] = a[i][j];
                        first = false;
                        continue;
                    }
                    if (a[i][j] == result[index][j] && sign) {
                        result[index][j] *= 2;
                        sign = false;
                    } else {
                        index++;
                        result[index][j] = a[i][j];
                        sign = true;
                    }
                }
            }
        }
        score += 10;
        return result;
    }

    public static int[][] operationDown(int[][] a) {
        int[][] result = new int[a.length][a[0].length];

        for (int j = 0; j < a[0].length; j++) {
            index = a.length - 1;
            first = true;
            sign = true;
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i][j] != 0) {
                    if (first) {
                        result[index][j] = a[i][j];
                        first = false;
                        continue;
                    }
                    if (a[i][j] == result[index][j] && sign) {
                        result[index][j] *= 2;
                        sign = false;
                    } else {
                        index--;
                        result[index][j] = a[i][j];
                        sign = true;
                    }
                }
            }
        }
        score += 10;
        return result;
    }

    public static void Print(int[][] array) {
        for (int[] i : array)
            System.out.println(Arrays.toString(i));
    }
}
