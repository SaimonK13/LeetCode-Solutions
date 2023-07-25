class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int result = 0;
        Map<Integer, ArrayList<int[]>> adj = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int[] weights = new int[n+1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[0] = 0;
        weights[k] = 0;
        minHeap.add(new int[]{0, k});
        
        for(int[] path : times){
            int key = path[0];
            ArrayList<int[]> list = adj.getOrDefault(key, new ArrayList<int[]>());
            list.add(new int[]{path[2], path[1]});
            adj.put(key, list);
        }

        while(!minHeap.isEmpty()){

            int size = minHeap.size();
            for(int i = 0; i < size; i++){
                int[] path = minHeap.poll();
                int curr = path[1];
                int cost = path[0];

                ArrayList<int[]> edges = adj.getOrDefault(curr, new ArrayList<int[]>());
                
                for(int[] edge : edges){

                    int next = edge[1];
                    int weight = edge[0];

                    if(weights[next] > weight+cost){
                        minHeap.add(new int[]{weight+cost, next});
                        weights[next] = weight+cost;
                    }
                }
            }
        }

        for(int time : weights){
            result = Math.max(result, time);
            if(result == Integer.MAX_VALUE){
                return -1;
            }
        }

        return result;
    }
}