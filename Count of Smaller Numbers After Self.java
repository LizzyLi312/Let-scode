// merged sort 
    /*
      [2, 0, 1, 10, 5, 6, 3]
      [                                                           processing: [0, 1], [2, 0],                      unprocessed: [1, 2], [10, 3], [5, 4], [6, 5], [3, 6]]
      [processed: [0, 1], [2, 0],                                 processing: [1, 2], [10, 3],                     unprocessed: [5, 4], [6, 5], [3, 6]]
      [                                                           processing: [0, 1], [1, 2], [2, 0], [10, 3],     unprocessed:[5, 4], [6, 5], [3, 6]]
      [processed:[0, 1], [1, 2], [2, 0], [10, 3],                 processing: [5, 4], [6, 5],                      unprocessed:[3, 6]]
      [processed:[0, 1], [1, 2], [2, 0], [10, 3], [3, 6], [5, 4], processing: [6, 5]]
      [processed:[0, 1], [1, 2], [2, 0], [3, 6],                  processing: [5, 4], [6, 5], [10, 3]]
     */
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        int n = nums.length;
        int[] res = new int[n];
        int[][] numsWithIdx = new int[n][2];
        for (int i = 0; i < n; i++) {
            numsWithIdx[i] = new int[]{nums[i], i};
        }

        mergeSort(numsWithIdx, 0, n - 1, res);

        List<Integer> resList = new ArrayList<>();
        for (int i : res) {
            resList.add(i);
        }
        return resList;
    }

    private void mergeSort(int[][] nums, int l, int r, int[] res) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid, res);
        mergeSort(nums, mid + 1, r, res);
        
        int i = l, j = mid + 1;
        int cnt = 0;

        int[][] temp = new int[r - l + 1][2]; // need to copy the origin value too 
        int idx = 0;
        while (i <= mid && j <= r) {
            if (nums[i][0] <= nums[j][0]) {
                res[nums[i][1]] += cnt; //Since both sides are already sorted, then all elements that has idx smaller than i should have the same count as last round
                temp[idx++] = nums[i++];
            } else {
                temp[idx++] = nums[j++];
                cnt++; 
            }
        }
        while (i <= mid) { 
          // if this block is executed then that means we have visited all the elements on the right side 
          // and all the right side elements are smaller than the left side elements starting from i
            res[nums[i][1]] += cnt;
            temp[idx++] = nums[i++];
        }
        while (j <= r) temp[idx++] = nums[j++];

        for (i = l, j = 0; i <= r; i++, j++) {
            nums[i] = temp[j];
        }
    }
}
