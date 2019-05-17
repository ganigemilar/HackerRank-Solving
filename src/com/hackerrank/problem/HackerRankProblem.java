package com.hackerrank.problem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HackerRankProblem {
    public static int solveMeFirst(int a, int b) {
        return a + b;
    }

    public static int simpleArraySum(int[] ar) {
        int result = 0;
        for (int tmp : ar)
            result += tmp;
        return result;
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size())
            return null;

        List<Integer> listScore = new ArrayList<>();
        listScore.add(0);
        listScore.add(0);

        final int ALICE = 0;
        final int BOB = 1;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i))
                listScore.set(ALICE, listScore.get(ALICE) + 1);
            else if (a.get(i) < b.get(i))
                listScore.set(BOB, listScore.get(BOB) + 1);
        }

        return listScore;
    }

    public static long aVeryBigSum(long[] ar) {
        long result = 0;
        for (long tmp : ar)
            result += tmp;
        return result;
    }

    public static int diagonalDifference(int[][] arr) {
        int resLeftToRight = 0;
        int resRightToLeft = 0;
        int result = 0;

        for (int i = 0; i < arr[0].length; i++) {
            resLeftToRight += arr[i][i];
            //System.out.println("a : " + resLeftToRight);
        }

        int j = 0;
        for (int i = arr[0].length - 1; i >= 0; i--) {
            resRightToLeft += arr[i][j++];
            //System.out.println("b : " + resRightToLeft);
        }

        result = resLeftToRight - resRightToLeft;
        return result < 0 ? result * -1 : result;
    }

    public static void plusMinus(int[] arr) {
        int negative = 0;
        int positive = 0;
        int zero = 0;
        for (int tmp : arr) {
            if (tmp > 0)
                positive++;
            else if (tmp < 0)
                negative++;
            else
                zero++;
        }

        float rasioPositive = positive / (float) arr.length;
        float rasioNegative = negative / (float) arr.length;
        float rasioZero = zero / (float) arr.length;

        System.out.println(String.format("%f\n%f\n%f", rasioPositive, rasioNegative, rasioZero));
    }

    public static void staircase(int n) {
        final char HASH = '#';
        final char SPACE = ' ';

        for (int i = 0; i < n; i++) {
            int limitSpace = n - (i + 1);
            String line = "";
            for (int l = 0; l < n; l++) {
                if (limitSpace > l)
                    line += SPACE;
                else
                    line += HASH;
            }
            System.out.println(line);
        }
    }

    public static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        long min = arr[0];
        long max = arr[arr.length - 1];

        for (int i = 1; i < arr.length - 1; i++) {
            min += arr[i];
            max += arr[i];
        }

        System.out.println(String.format("%s %s", min, max));
    }

    public static int birthdayCakeCandles(int[] ar) {
        Arrays.sort(ar);
        int result = 0;
        int highest = ar[ar.length - 1];
        System.out.println(Arrays.toString(ar));
        for (int i = ar.length - 1; i >= 0; i--) {
            if (ar[i] < highest)
                return result;
            result++;
        }
        return result;
    }

    public static String timeConversion(String s) throws ParseException {
        SimpleDateFormat format12AmPm = new SimpleDateFormat("hh:mm:ssa");
        Date parseDate = format12AmPm.parse(s);
        SimpleDateFormat format24Hours = new SimpleDateFormat("HH:mm:ss");
        return format24Hours.format(parseDate);
    }

    public static void main(String[] args) throws ParseException {
        /*String result = HackerRankProblem.compareTriplets(Arrays.asList(17, 28, 30), Arrays.asList(99, 16, 8)).toString();
        System.out.println(result);*/

        /*int result = HackerRankProblem.diagonalDifference(new int[][]{{11, 2, 4}, {4, 5, 6}, {10, 8, -12}});
        System.out.println(result);*/

        /*int result = HackerRankProblem.birthdayCakeCandles(new int[]{3, 2, 1, 3});
        System.out.println(result);*/

        String result = HackerRankProblem.timeConversion("07:05:45PM");
        System.out.println(result);
    }
}
