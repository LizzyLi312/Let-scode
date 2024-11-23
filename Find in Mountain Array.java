/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr == null || mountainArr.length() == 0) return -1;

        int l = 0, r = mountainArr.length() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) r = mid;
            else l = mid + 1;
        }

        int R = r;
        l = 0;
        int res = -1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        res = mountainArr.get(r) == target ? r : -1; 
        if (res == -1) {
            l = R;
            r = mountainArr.length() - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (mountainArr.get(mid) <= target) r = mid;
                else l = mid + 1;
            }
            res = mountainArr.get(r) == target ? r : -1;
        }
        return res;
    }
}
