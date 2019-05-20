package com.hackerrank.problem;

import java.math.BigInteger;
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
        //System.out.println(Arrays.toString(ar));
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

    public static void kaprekarNumbers(int p, int q) {
        List<BigInteger> listKaprekar = new ArrayList<>();
        for (;p <= q;p++) {
            BigInteger sqrt = new BigInteger(String.valueOf(p)).pow(2);
            int length = String.valueOf(sqrt).length();
            String l = String.valueOf(sqrt).substring(0, (length % 2 == 0 ? length / 2 : (length - 1) / 2));
            String r = String.valueOf(sqrt).substring(l.length());
            BigInteger kaprekar = new BigInteger(l.isEmpty() ? "0" : l).add(new BigInteger(r.isEmpty() ? "0" : r));

            /*if (sqrt.toString().contains("-"))
                System.out.println(String.format("count : %s | length : %s | sqrt : %s | l : %s | r : %s | kaprekar : %s", p, length, sqrt, l, r, kaprekar));*/

            if (kaprekar.equals(new BigInteger(String.valueOf(p))))
                listKaprekar.add(kaprekar);
        }

        if (listKaprekar.isEmpty())
            System.out.println("INVALID RANGE");
        else
            for (BigInteger kpkar : listKaprekar)
                System.out.printf(kpkar + " ");
    }

    public static int beautifulTriplets(int d, int[] arr) {
        int result = 0;
        //HashSet<Integer> numbers = new HashSet<>();
        List<Integer> numbers = new ArrayList<>();
        for (Integer number : arr) {
            numbers.add(number);
        }
        for (int i = 0; i < numbers.size(); i++) {
            int arrI = (int) numbers.toArray()[i];
            if (numbers.contains(arrI + d) && numbers.contains(arrI + (2 * d))) {
                result++;
            }
        }
        return result;
    }

    // Complete the minimumDistances function below.
    public static int minimumDistances(int[] a) {
            int left = a.length % 2 == 0 ? (a.length - 1) / 2: (a.length - 2) / 2;
            int right = a.length % 2 == 0 ? left + 1 : left + 2;
            do {
                if (left < 0 || right >= a.length)
                    return -1;
                if (a[left] == a[right]) {
                    return right - left;
                }
                System.out.println(String.format("Left[%s]=%s | Right[%s]=%s", left, a[left], right, a[right]));
                left--;
                right++;
            } while (true);
    }

    public static void main(String[] args) throws ParseException {
        /*String result = HackerRankProblem.compareTriplets(Arrays.asList(17, 28, 30), Arrays.asList(99, 16, 8)).toString();
        System.out.println(result);*/

        /*int result = HackerRankProblem.diagonalDifference(new int[][]{{11, 2, 4}, {4, 5, 6}, {10, 8, -12}});
        System.out.println(result);*/

        /*int result = HackerRankProblem.birthdayCakeCandles(new int[]{3, 2, 1, 3});
        System.out.println(result);*/

        /*String result = HackerRankProblem.timeConversion("07:05:45PM");
        System.out.println(result);*/

        //HackerRankProblem.kaprekarNumbers(1, 99999);

        /*int result = HackerRankProblem.beautifulTriplets(3, new int[]{1, 2, 4, 5, 7, 8, 10});
        System.out.println(result);*/

        System.out.println(HackerRankProblem.minimumDistances(new int[]{988,454,9087,2397,2541,1459,483,3944,2437,6544,982,8902,576,9336,9672,7742,5982,8461,4640,9236,9248,8333,9742,6718,6213,4368,4553,7815,4666,433,4071,3173,7239,3159,1923,9780,4618,2406,76,3407,5302,1058,2309,2231,6746,8333,9973,2728,3146,965,1964,2394,9299,8058,9112,5512,2426,3666,9680,7093,4099,3751,6618,7690,3262,4893,3823,7880,3651,3899,7640,8954,4958,6301,1185,8056,4635,7510,785,7781,8476,9101,176,7775,7160,9288,9639,9586,9306,9319,3031,3405,9423,6002,7448,2685,895,1271,6918,4547,5170,910,3501,6480,7211,1038,4537,1846,4900,1674,5980,3376,7127,6156,7503,4287,1796,3495,226,1103,2814,3257,860,8589,9259,8308,7627,155,5931,897,1054,1102,1807,4555,3934,9018,1945,4823,7217,6845,6497,3197,6574,3625,5705,4077,4264,7501,7572,4490,4956,6739,4100,5817,1680,3359,477,9307,9866,6409,204,920,3863,8363,1827,4149,7382,124,8973,951,6970,1822,4148,9896,1799,6205,3973,6064,3706,7898,6906,5015,989,1006,832,9021,718,7661,8329,6936,4070,4885,4209,4285,3249,6036,4787,6983,2513,3760,4286,9483,1934,4786,9379,3734,991,9704,6150,1049,3954,9408,6064,1295,6767,3248,317,7485,910,4998,773,1332,9883,4982,1970,9484,7371,6757,2819,9884,517,3457,9367,8803,8243,5098,8889,9234,1154,5039,284,1461,800,2700,2756,7567,5949,9425,1404,6859,4423,2177,8191,659,7160,161,6495,4531,6918,5667,767,3787,9124,6486,8943,7368,1584,7832,2954,9090,2872,9590,551,24,2291,9660,7591,4592,9085,5347,1451,9861,7524,5994,6872,1036,2508,3367,1919,5778,5386,2686,9566,4511,9172,8509,8231,7108,2693,7537,2551,1917,7128,3102,1941,5771,9114,5884,363,8200,1231,8166,4413,5108,4160,1285,2496,3020,1004,4416,8799,6391,3454,4717,7254,8979,9578,1837,2439,2271,5726,4990,4189,2854,4445,6130,4977,3559,2015,1692,8111,3246,9858,2524,4706,371,161,7203,3391,1166,7971,2190,3909,7777,3259,7515,3108,2837,9352,5548,5109,1430,6890,9298,4285,1335,5428,5614,1247,3795,7307,9358,3394,3517,8235,8100,240,8396,5303,3632,5914,9626,2174,6175,7404,5434,3690,512,8271,9394,2412,9732,825,9303,9030,1462,6990,811,3428,8237,4606,735,3948,8000,605,2183,2453,845,6931,4108,829,9198,3735,9356,5373,7491,1142,5416,4355,5765,4810,6768,5498,1987,2423,4528,9801,5765,1691,3230,4003,6298,317,7951,650,922,6486,9455,8120,3417,3564,8949,2615,3651,4657,7989,1142,5799,9757,5497,1565,4567,8617,7063,2907,1040,7943,2708,6806,9635,2290,7161,2285,2608,1464,9287,9882,7950,8743,8002,7719,2307,3304,335,5958,7961,4676,3452,3761,4433,8949,1678,5352,3919,8741,4611,4959,3036,3672,8117,9023,5962,5278,7660,8570,3094,6948,4805,1044,5691,2807,5116,4350,2463,5451,6660,425,6479,112,538,7264,5413,2216,8968,9332,7309,9932,4292,6697,3604,8761,5721,9566,392,3381,4489,3486,329,9294,883,2372,8453,5999,6722,917,7802,3382,7694,633,9846,8232,4249,5260,448,3217,4592,4109,3149,5236,806,3105,350,2879,2672,742,6261,3513,580,2942,2807,1463,1667,1260,3814,4741,8529,1616,4476,6223,8601,4322,4455,2850,5934,1255,2420,527,5364,1921,2115,2523,5027,2465,5402,4051,3207,8015,7564,3788,7310,371,1603,8977,7983,5418,3718,6513,3386,8194,9088,1988,8869,3544,4838,4803,1151,7258,1682,2868,9180,3798,5391,4207,6263,7145,4610,5823,5161,2174,5963,8823,2545,7566,7800,6880,9336,7870,9745,2723,2417,8834,4711,1286,8730,9549,6089,9881,3160,4124,9101,2340,7922,4492,2899,537,7990,7509,6360,9503,9683,8675,8326,8580,2594,2478,1812,1930,348,1558,1005,2765,6744,5716,403,5474,1618,2845,1707,4778,6969,809,3470,4891,1653,2721,5428,5995,6582,8141,5498,2617,3168,176,7549,5762,2654,9361,4045,3003,7271,1402,2120,4015,3471,2524,5841,5089,5369,3901,6219,8690,1062,6041,3581,9067,8762,5361,5063,5344,9854,561,7961,9375,738,5510,1489,9744,1223,5534,2747,8495,3289,1220,8862,6760,3744,4704,1849,5465,4957,4420,4155,6019,461,4088,5086,9223,5801,149,919,5656,7063,5232,5031,4153,7094,6520,3897,8317,8407,6645,3164,1696,7865,2027,4808,7961,6731,3009,9778,8040,7429,285,4059,7890,4373,9145,3465,174,5647,736,2182,2710,2320,7213,6863,9414,86,760,7731,4845,3757,7248,6541,7974,9275,7701,2287,2358,710,2065,398,8139,2350,4457,2381,3075,9954,2198,9602,5601,2934,1784,8311,5254,5350,1526,1020,5436,2287,5103,6633,2396,2351,9526,371,1626,7227,9010,3984,7937,1076,734,6076,9778,1543,4809,2854,1498,7007,2456,7099,6293,592,1763,7899,5942,3289,8919,7730,1928,4022,4363,677,6374,3889,7400,4352,1116,6410,4689,5405,7486,5423,1481,3617,6967,6290,2823,4817,9649,1631,1916,5942,2223,31,3841,4518,9673,9112,8600,7953,3135,9316,8630,5861,3205,6030,6565,674,2441,1254,6079,6279,3030,3913,6248,6349,6555,9071,1166,6205,702,9434,8499,9278,9466,2341,148,5491,7805,8748,3444,940,8064,2075,3153,7622,4457,9719,4648,3250,973,7079,9530,4003,992,2130,352,3900,1202,7870,6457,8256,7305,4956,3886,3123,3649,4034,8614,1455,2783,2058,8747,7199,4133,1901,4821,4943,1620,9469,8193,8945,6549,4075,9301,3893,6206,6005,4145,3760,3876,602,8368,1181,5559,2255,4304,5560,2641,2918,7015,5424,1328,2115,8976,1814,4016,3797,6757,5636,9619,4950,933,2520,5378,234,2765,1584,6240,6911,5344,116,7513,64,7649,9424,2319}));
    }
}
