// Sum of Mutated Array Closest to Target

class Solution {
    public int findBestValue(int[] arr, int target) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int max = 0;
        for(int i : arr) {
            max = Math.max(i , max);
        }
        
        int count = arr.length;
        int[] nums = new int[max + 1];
        for(int i : arr) {
            nums[i] += 1;
        }
        //System.out.println(Arrays.toString(nums));
        int currSum = 0;
        int minDiff = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] > 0) {
                int tempSum = currSum + (count * i);
                if(Math.abs(target-tempSum) < minDiff) {
                    result = i;
                    minDiff = Math.abs(target-tempSum);
                }
                currSum += i * nums[i];
                count -= nums[i];
                //System.out.println(tempSum);
            } else {
                int tempSum = currSum + (count * i);
                if(Math.abs(target-tempSum) < minDiff) {
                    result = i;
                    minDiff = Math.abs(target-tempSum);
                }
                //System.out.println(tempSum);
            }
            //System.out.println(minDiff);
        } 
        
        return result;
    }
    
}


// Car Pooling

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips == null || trips.length == 0) {
            return true;
        }
        
        //Arrays.sort(trips, (a,b) -> a[1] - b[1]);
        
        //System.out.println(Arrays.deepToString(trips));
        int max = 0;
        for(int[] trip : trips) {
            max = Math.max(trip[2], max);
        }
        //System.out.println(max);
        
        int[] arr = new int[max+2];
        
        for(int[] trip : trips) {
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];    
        }
        
        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i];
        }
        //System.out.println(Arrays.toString(arr));
        
        for(int i : arr) {
            if(i > capacity) {
                //System.out.println(i);
                return false;
            }
        }
        return true;
    }
}