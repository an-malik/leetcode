// Median of Two Sorted Arrays

class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        
        int m = a.length;
        int n = b.length;
        if(n < m) return findMedianSortedArrays(b, a);

        int i = 0, j = 0;
        int iMin = 0, iMax = m, half = (m + n + 1)/2;

        while(iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = half - i;
            
            if(i < m && a[i] < b[j - 1])
                iMin = i + 1;
            else if (i > 0 && a[i - 1] > b[j])
                iMax = i - 1;
            else
                break;
        }

        double maxLeft = -1, minRight = -1;
        if(i == 0) maxLeft = b[j - 1];
        else if(j == 0) maxLeft = a[i - 1];
        else maxLeft = Math.max(a[i - 1], b[j - 1]);

        if((m+n)%2 == 1)
            return maxLeft;

        if(i == m) minRight = b[j];
        else if(j == n) minRight = a[i];
        else minRight = Math.min(a[i], b[j]);

        return (maxLeft + minRight) / 2;

    }
}
