class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);

        for(int n : stones){
            pq.offer(n);
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int sec = pq.poll();

            if(first == sec) continue;

            int res = first - sec;

            pq.offer(res);
        }

        if(pq.size() == 0) return 0;

        return pq.peek();
    }
}
