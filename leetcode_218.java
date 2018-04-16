// Leetcode_218
// The Skyline Problem

class Solution {
    public List<int[]> getSkyline(int[][] buildings) {

        List<int[]> cPoints = new ArrayList<>();
        List<int[]> result = new ArrayList<>();

        for(int[] item : buildings) {
            cPoints.add(new int[]{item[0], -item[2]});
            cPoints.add(new int[]{item[1],  item[2]});
        }

        Collections.sort(cPoints, (a, b) -> {
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));
        heap.offer(0);
        int cHeight = 0;
        int rHeight = 0;

        for(int[] item : cPoints) {
            if(item[1] < 0)
                heap.offer(-item[1]);
            else
                heap.remove(item[1]);

            cHeight = heap.peek();
            if(cHeight != rHeight)
                result.add(new int[]{item[0], cHeight});

            rHeight = cHeight;
        }

        return result;
    }
}
