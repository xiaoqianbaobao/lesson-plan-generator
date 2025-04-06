package leetcode.contest.Leetcode263;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description 2848. 与车相交的点 显示英文描述

 * 给你一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标。对于任意下标 i，nums[i] = [starti, endi] ，其中 starti 是第 i 辆车的起点，endi 是第 i 辆车的终点。
 *
 * 返回数轴上被车 任意部分 覆盖的整数点的数目。
 */
public class Solution {
    public int countCoveredPoints(List<List<Integer>> nums) {
        List<Integer> allPoints = new ArrayList<>();

        for (List<Integer> point : nums) {
            int start = point.get(0);
            int end = point.get(1);

            // 将每个车辆覆盖的点加入到列表中
            for (int i = start; i <= end; i++) {
                allPoints.add(i);
            }
        }

        Collections.sort(allPoints);

        int coveredPoints = 0;
        int currentPoint = allPoints.get(0);

        for (int i = 1; i < allPoints.size(); i++) {
            int nextPoint = allPoints.get(i);

            // 如果下一个点不等于当前点，说明有一个车辆覆盖了当前点
            if (nextPoint != currentPoint) {
                coveredPoints++;
            }

            currentPoint = nextPoint;
        }

        // 最后一个点
        coveredPoints++;

        return coveredPoints;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> nums1 = new ArrayList<>();
        nums1.add(Arrays.asList(3, 6));
        nums1.add(Arrays.asList(1, 5));
        nums1.add(Arrays.asList(4, 7));
        int result1 = solution.countCoveredPoints(nums1);
        System.out.println("示例 1 的被覆盖的整数点数量为: " + result1);

        List<List<Integer>> nums2 = new ArrayList<>();
        nums2.add(Arrays.asList(1, 3));
        nums2.add(Arrays.asList(5, 8));
        int result2 = solution.countCoveredPoints(nums2);
        System.out.println("示例 2 的被覆盖的整数点数量为: " + result2);
    }
}
