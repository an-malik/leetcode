// Leetcode_683
// K Empty Slots

class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        
        TreeSet<Integer> tree = new TreeSet<>();
        int count = 0;
        for(int pos : flowers) {
            count++;
            tree.add(pos);
            Integer low = tree.lower(pos);
            Integer high = tree.higher(pos);
            
            if( low != null && pos - low == k + 1 || high != null && high - pos == k + 1) {
                return count;
            }
        }
        
        return -1;
    }
}