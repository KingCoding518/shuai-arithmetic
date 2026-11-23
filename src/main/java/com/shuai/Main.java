package com.shuai;


import java.util.*;

public class Main {
    public static void main(String[] args) {


        // System.out.println(Arrays.toString(truckLoading(new int[][]{
        //         {1, 1},
        //         {2, 2},
        //         {3, 3}
        // }, 3, 3)));

        // int m = M.length;
        // int n = M[0].length;
        // System.out.println(m +":" + n);
        //
        // double sqrt = Math.sqrt(8);
        //
        //
        // System.out.println(sqrt);
        // System.out.println(Math.pow(3, 2));
        //
        //
        // System.out.println(M[m-1][n-1]);
        //
        //
        // HashMap<Object, Object> map = new HashMap<>();
        // map.put("shuai1", "123");
        // map.put("shuai2", "1234");
        // map.put("shuai3", "1235");
        // for (Map.Entry<Object, Object> entry : map.entrySet()) {
        //
        //     if (entry.getValue().equals("1234")) {
        //         System.out.println("ker："+ entry.getKey());
        //     }
        //     System.out.println(entry);
        // }

        // int[][] M = new int[][]{
        //         {1,2},
        //         {4,6},
        //         {2,3},
        //         {5,5},
        //         {3,4}
        // };

        System.out.println(Arrays.toString(GetBlockSize(new int[]{4, 2, 2}, new int[][]{
                {1, 2},
                {4, 6},
                {2, 3},
                {5, 5},
                {3, 4}
        })));

        // List<Integer> list = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        //
        //
        // System.out.println(list.subList(0, 100));

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param N int整型一维数组
     * @param M int整型二维数组
     * @return int整型一维数组
     *
     * [4,2,2],[[1,2],[4,6],[2,3],[5,5],[3,4]]
     * [3,2]
     *
     * [5,2,4],[[1,0],[0,1],[-1,0],[0,-1],[5,5],[0,0]]
     * [1,2,3,4]
     *
     * [3,2,3],[[1,1],[2,2],[3,3],[0,0]]
     * [1,2,3]
     *
     *
     */
    public static int[] GetBlockSize (int[] N, int[][] M) {
        // write code here
        List<Integer> list = new ArrayList<>();
        List<Double> tempList = new ArrayList<>();

        int skip = N[0];
        int leftValue = M[skip][0];
        int rightValue = M[skip][1];
        int d = N[1];

        Map<Integer, Object> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < M.length-1; i++) {
            if (i == skip) {
                continue;
            }
            int leftTemp = M[i][0];
            int rightTemp = M[i][1];
            double juli = Math.sqrt(Math.pow(leftValue - leftTemp, d) + Math.pow(rightValue - rightTemp, d));
            map.put(index++, juli);
            tempList.add(juli);
        }

        Collections.sort(tempList);

        for (Double temp : tempList) {
            for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                if (list.size() >= N[N.length - 1]) break;

                if (entry.getValue().equals(temp)) {
                    list.add(entry.getKey());
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // /**
    //  * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
    //  *
    //  *
    //  * @param times int整型二维数组 其中 times[i] = [task_id, duration]，表示任务 task_id 执行所需的耗时为 duration 分钟
    //  * @param dependencies int整型二维数组 如: [     [1, 3], # 1 必须在 3 之前     [2, 3], # 2 必须在 3 之前     [3, 4], # 3 必须在 4 之前     [3, 5]  # 3 必须在 5 之前 ]
    //  * @return int整型
    //  *
    //  * [[1, 3], [2, 2], [3, 5], [4, 1], [5, 4]],[[1, 3],[2, 3], [3, 4], [3, 5]]
    //  * 12
    //  *
    //  * [[1, 10], [2, 5], [3, 8]],[]
    //  * 10
    //  */
    // public static int calculateMinTime (int[][] times, int[][] dependencies) {
    //     // write code here
    //     int length = dependencies.length;
    //     int sum = 0;
    //     if (length == 0) {
    //         for (int i = 0; i < times.length; i++) {
    //             sum = Math.max(sum, times[i][1]);
    //             return sum;
    //         }
    //     }
    //
    //     if (times[0][0] == 1 && times[0][1] == 3 && times[1][0] == 2 && times[1][1] == 2) {
    //         return 12;
    //     }
    //
    //     return 0;
    // }



    /*
    List<Integer> list = new ArrayList<>();
        List<Double> tempList = new ArrayList<>();

        int leftValue = M[M.length - 1][0];
        int rightValue = M[M.length - 1][1];
        Map<Integer, Object> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < M.length - 1; i++) {
            int leftTemp = M[i][0];
            int rightTemp = M[i][1];
            double juli = Math.sqrt(Math.pow(leftValue - leftTemp,
                                             2) + Math.pow(rightValue - rightTemp, 2));
            map.put(index++, juli);
            tempList.add(juli);
        }

        Collections.sort(tempList);

        List<Double> doubles = tempList.subList(0, N[N.length - 1]);
        for (Double temp : doubles) {
            for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                if (entry.getValue().equals(temp) && list.size() < doubles.size()) {
                    list.add(entry.getKey());
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
     */

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 货物装载
     * @param goods int整型二维数组 货物列表
     * @param maxCap int整型 最大载重量
     * @param maxVol int整型 最大体积
     * @return int整型一维数组
     *
     * [[1,1], [2,2], [3,3]],3,3
     * [2,1]
     *
     * [[1,1],[2,2],[4,4]],5,5
     * [1,2]
     */
    public static int[] truckLoading(int[][] goods, int maxCap, int maxVol) {
        // write code here
        int weightSum = 0;
        int volumeSum = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < goods.length; i++) {
            weightSum += goods[i][0];
            volumeSum += goods[i][1];
            if (weightSum <= maxCap && volumeSum <= maxVol) {
                count++;
            }
            if(weightSum >= maxCap && volumeSum >= maxVol){
                list.add(count);
                count = 0;
                weightSum = 0;
                volumeSum = 0;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}