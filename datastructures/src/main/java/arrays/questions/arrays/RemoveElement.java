package arrays.questions.arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int pivot = 0;
        int[] arr= new int[nums.length];
        if (nums.length == 0) return pivot;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                arr[pivot++] = nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
        return pivot;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int [] nums = new int[] {1,1,1,2,2,2,3,3,3};
        int val = 2;
        int retVal = removeElement.removeElement(nums,val);
        System.out.println(retVal);

    }
}
