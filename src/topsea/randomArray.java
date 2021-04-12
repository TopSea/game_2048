package topsea;

import java.util.Arrays;

public class randomArray {

    public static void main(String[] args) {
        int[][] array = initArray(4);
        for(int[] i : array)
            System.out.println(Arrays.toString(i));
        System.out.println("----------------");
    }

    public static int[][] initArray(int length) {
        if(length <= 2){
            throw new RuntimeException("数组太小");
        }
        int[][] array = new int[length][length];
        array[(int)(Math.random()*length)][(int)(Math.random()*length)] = 2;
        array[(int)(Math.random()*length)][(int)(Math.random()*length)] = 4;
        return array;
    }

    public static boolean RandomArray(int[][] array, int a) {
        int y = 0;
        boolean fail = true;
        for(int i = 0; i< array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(array[i][j] == 0){
                    y++;
                }
                if(y == 1 && ((int)(a / 2) == a/2)){
                    array[i][j] = 2;
                    y = 200;
                    fail = false;
                    break;
                }
                if(y == 2 && ((int)(a / 2) != a/2)){
                    array[i][j] = 2;
                    y = 200;
                    fail = false;
                    break;
                }
            }
            if(y == 200){
                break;
            }
        }
        return fail;
    }
}
