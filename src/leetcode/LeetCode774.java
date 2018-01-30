package leetcode;

/**
 * title: 774. Minimize Max Distance to Gas Station
 * level: Hard
 * source: LeetCode Weekly Contest 69
 * link: https://leetcode.com/contest/weekly-contest-69/problems/minimize-max-distance-to-gas-station/
 * explanation：非常巧妙的利用了二分查找的思想，代码简洁但不好理解，答案虽有误差但在题目允许范围内，详细解释请参考本题目的LeetCode Discuss
 */
public class LeetCode774 {

    public double minmaxGasDist(int[] stations, int K) {
        int LEN = stations.length;
        double left = 0, right = stations[LEN - 1] - stations[0], mid = 0;

        while (right >= left + 0.000001) {
            mid = right - (right - left) / 2;
            int cnt = 0;
            for (int i = 0; i < LEN - 1; i++) {
                cnt += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1; //重点理解代码，d_i / (cnt_i + 1) <= mid
            }
            if (cnt > K) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return mid;
    }

}
