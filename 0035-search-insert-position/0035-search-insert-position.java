class Solution {
    public int searchInsert(int[] nums, int target) {
      //  int nums[]={1,3,5,7};
       //// int target=5;
       // System.out.println(searchInsert);
         int start =0;
         int end =nums.length-1;
         while(start<=end){
            int mid =(start+end)/2;
            if(nums[mid]==target){
                return mid;
            } else if (nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }

         }
         return start;
    }
}