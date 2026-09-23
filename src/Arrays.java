//Majority Element
public int majorityElement(int[] nums) {
    int el = 0,cnt = 0;
    for (int curr : nums){
        if (el == curr){
            cnt++;
        }
        else{
            if (cnt == 0){
                el = curr;
                cnt = 1;
            }
            else{
                cnt--;
            }
        }
    }
    return el;
}

//Kadane Algorithm
public int maxSubArray(int[] nums) {
    int curr = nums[0],max = nums[0];
    for (int i = 1; i < nums.length; i++){
        if (curr < 0) curr = 0;
        curr += nums[i];
        if (max < curr) max = curr;
    }
    return max;
}

//Majority Element - II
public List<Integer> majorityElementTwo(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    int curr1 = 0,curr2 = 0,cnt1 = 0,cnt2 = 0;
    for (int curr : nums){
        if (cnt1 == 0 && curr != curr2){
            curr1 = curr;
            cnt1++;
        }

        else if (cnt2 == 0 && curr != curr1){
            curr2 = curr;
            cnt2++;
        }

        else if (curr1 == curr){
            cnt1++;
        }

        else if (curr2 == curr) cnt2++;

        else{
            cnt1--;
            cnt2--;
        }
    }
    cnt1 = 0;
    cnt2 = 0;
    for (int curr : nums){
        if (curr == curr1) cnt1++;
        else if (curr == curr2) cnt2++;
    }
    if (cnt1 > nums.length / 3) ans.add(curr1);
    if (cnt2 > nums.length / 3) ans.add(curr2);
    return ans;
}

//Max Product Subarray
public int maxProduct(int[] nums) {
    int ans = nums[0],pref = 1,suff = 1;
    for (int i = 0; i < nums.length; i++){
        if (pref == 0) pref = 1;
        if (suff == 0) suff = 1;

        pref *= nums[i];
        suff *= nums[nums.length - i - 1];
        ans = Math.max(ans,Math.max(pref,suff));
    }
    return ans;
}

//Sort colors
public void sortZeroOneTwo(int[] nums) {
    int low = 0,mid = 0,high = nums.length - 1;
    while (mid <= high){
        if (nums[mid] == 0){
            int temp = nums[low];
            nums[low] = nums[mid];
            nums[mid] = temp;
            low++;
            mid++;
        }

        else if (nums[mid] == 1){
            mid++;
        }

        else{
            int temp = nums[mid];
            nums[mid] = nums[high];
            nums[high] = temp;
            high--;
        }
    }
}

//3 Sum
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++){
        if (i > 0 && nums[i] == nums[i - 1]){
            continue;
        }
        int j = i + 1,k = nums.length - 1;
        while (j < k){
            int curr = nums[i] + nums[j] + nums[k];
            if (curr == 0){
                List<Integer> in = new ArrayList<>();
                in.add(nums[i]);
                in.add(nums[j]);
                in.add(nums[k]);
                ans.add(in);
                j++;
                k--;
                while (j < k && nums[j] == nums[j - 1]) j++;
                while (j < k && nums[k] == nums[k + 1]) k--;
            }
            else if (curr < 0){
                j++;
            }
            else{
                k--;
            }
        }
    }
    return ans;
}

//Next Permutation
public void reverse(int[] nums,int start,int end){
    while (start <= end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
public void nextPermutation(int[] nums) {
    int n = nums.length;
    int ind = -1;
    for (int i = n - 2; i >= 0; i--){
        if (nums[i] < nums[i + 1]){
            ind = i;
            break;
        }
    }

    if (ind == -1){
        reverse(nums,0,n - 1);
        return;
    }

    for (int i = n - 1; i > ind; i--){
        if (nums[i] > nums[ind]){
            int temp = nums[i];
            nums[i] = nums[ind];
            nums[ind] = temp;
            break;
        }
    }

    reverse(nums,ind + 1,n - 1);
}

//4 Sum
public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++){
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        for (int j = i + 1; j < nums.length; j++){
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;
            int x = j + 1,y = nums.length - 1;
            while (x < y){
                long curr = (long)nums[i] + nums[j] + nums[x] + nums[y];
                if (curr == target){
                    ans.add(Arrays.asList(nums[i],nums[j],nums[x],nums[y]));
                    x++;
                    y--;
                    while (x < y && nums[x] == nums[x - 1]) x++;
                    while (x < y && nums[y] == nums[y + 1]) y--;

                }
                else if (curr > target){
                    y--;
                }
                else{
                    x++;
                }
            }
        }
    }
    return ans;
}

//Merge 2 sorted arrays without extra space
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1,j = n - 1,k = m + n - 1;
    while (i >= 0 && j >= 0){
        if (nums1[i] <= nums2[j]) nums1[k--] = nums2[j--];
        else nums1[k--] = nums1[i--];
    }
    while (j >= 0) nums1[k--] = nums2[j--];
}

//Trapping Rain Water
public int trap(int[] height) {
    int ans = 0,lmax = 0,rmax = 0,left = 0,right = height.length - 1;
    while (left <= right){
        if (height[left] <= height[right]){
            lmax = Math.max(lmax,height[left]);
            ans += (lmax - height[left]);
            left++;
        }
        else{
            rmax = Math.max(rmax,height[right]);
            ans += (rmax - height[right]);
            right--;
        }
    }
    return ans;
}

//Count Inversions
public long numberOfInversions(int[] nums) {
    return sort(nums, 0, nums.length - 1);
}

public long sort(int[] nums, int left, int right) {
    long cnt = 0;

    if (left < right) {
        int mid = left + (right - left) / 2;

        cnt += sort(nums, left, mid);
        cnt += sort(nums, mid + 1, right);
        cnt += merge(nums, left, mid, right);
    }

    return cnt;
}

public long merge(int[] nums, int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int[] l1 = new int[n1];
    int[] l2 = new int[n2];

    for (int i = 0; i < n1; i++) {
        l1[i] = nums[left + i];
    }

    for (int i = 0; i < n2; i++) {
        l2[i] = nums[mid + 1 + i];
    }

    int i = 0;
    int j = 0;
    int k = left;

    long res = 0;

    while (i < n1 && j < n2) {
        if (l1[i] <= l2[j]) {
            nums[k++] = l1[i++];
        } else {
            nums[k++] = l2[j++];
            res += n1 - i;
        }
    }

    while (i < n1) {
        nums[k++] = l1[i++];
    }

    while (j < n2) {
        nums[k++] = l2[j++];
    }

    return res;
}
void main() {
    int[] nums = {2, 2, 1, 1, 1, 2, 2};

    int result = majorityElement(nums);

    System.out.println("Majority Element: " + result);

    int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    int result1 = maxSubArray(nums1);

    System.out.println("Maximum Subarray Sum: " + result1);

    int[] nums2 = {1, 2, 2, 3, 2, 1, 1, 1};

    List<Integer> result2 = majorityElementTwo(nums2);

    System.out.println("Majority Elements: " + result2);

    int[] nums3 = {2, 3, -2, 4};

    int result3 = maxProduct(nums3);

    System.out.println("Maximum Product: " + result3);

    int[] nums4 = {2, 0, 2, 1, 1, 0};

    sortZeroOneTwo(nums4);

    System.out.println("Sorted Array: " + Arrays.toString(nums4));

    int[] nums5 = {-1, 0, 1, 2, -1, -4};

    List<List<Integer>> result4 = threeSum(nums5);

    System.out.println("Triplets: " + result4);

    int[] nums6 = {1, 2, 3};

    nextPermutation(nums6);

    System.out.println("Next Permutation: " + Arrays.toString(nums6));

    int[] nums7 = {1, 0, -1, 0, -2, 2};
    int target = 0;

    List<List<Integer>> result5 = fourSum(nums7, target);

    System.out.println("Quadruplets: " + result5);

    int[] nums8 = {1, 2, 3, 0, 0, 0};
    int m = 3;

    int[] nums9 = {2, 5, 6};
    int n = 3;

    merge(nums8, m, nums9, n);

    System.out.println("Merged Array: " + Arrays.toString(nums8));

    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    int result6 = trap(height);

    System.out.println("Trapped Rain Water: " + result6);

    int[] nums11 = {5,6,7,8,2};
    long ans = numberOfInversions(nums11);
    System.out.println("No. of Inversions : " + ans);
    System.out.println(Arrays.toString(nums11));
}