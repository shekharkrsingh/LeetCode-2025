class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Boolean> visited= new ArrayList<>();
        List<Boolean> pathVisited= new ArrayList<>();
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<n;i++){
            visited.add(false);
            pathVisited.add(false);
        }
        for(int i=0;i<n;i++){
            if(!isCycle(i, graph, pathVisited, visited)){
                res.add(i);
            }
        }
        return res;
    }

    private boolean isCycle(int i, int[][]graph, List<Boolean> pathVisited, List<Boolean> visited){
        visited.set(i, true);
        pathVisited.set(i, true);
        for(int val: graph[i]){
            if(!visited.get(val)){
                if(isCycle(val, graph, pathVisited, visited))
                return true;
            }else if(pathVisited.get(val)){
                return true;
            }
        }
        pathVisited.set(i, false);
        return false;
    }
}