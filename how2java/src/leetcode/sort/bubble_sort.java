package leetcode.sort;

public class bubble_sort {
    public static void main(String[] args) {
        int[] nums = {1,2,4,9,3,8,6,7};
        System.out.println(nums);
        bubbleSort(nums);
        System.out.println(nums);

    }

    private static void bubbleSort(int[] nums) {
        //外循环：未排序区间为[0, i]
        for (int i = nums.length-1; i >0; i--) {
            //内循环：将未排序区间[0, i] 中最大元素交换至该区间的最右端
            for (int j = 0 ; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    //交换nums[j] 与nums[j+1]
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }
}
