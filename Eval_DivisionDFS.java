class Solution { 
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            Map<String,Map<String,Double>> adj = new HashMap<>();
            for(int row = 0; row < equations.length; row++){
                if(!adj.containsKey(equations[row][0])){
                    Map<String,Double> temp = new HashMap<String,Double>();
                    temp.put(equations[row][0],1.0);
                    adj.put(equations[row][0],temp);
                }
                if(!adj.containsKey(equations[row][1])){
                    Map<String,Double> temp = new HashMap<String,Double>();
                    temp.put(equations[row][1],1.0);
                    adj.put(equations[row][1],temp);
                }                
                adj.get(equations[row][0]).put(equations[row][1],values[row]);
                adj.get(equations[row][1]).put(equations[row][0],1/values[row]);
            }   // a-> b:2.0    b-> c:3.0
            double[] ans = new double[queries.length];
            for(int row = 0; row < queries.length; row++){
                Set<String> visited = new HashSet<String>();
                String numerator = queries[row][0]; String denominator = queries[row][1];
                //System.out.println(adj.containsKey(numerator) + " "+ adj.containsKey(denominator));
                if(!adj.containsKey(numerator)|| !adj.containsKey(denominator)){
                    ans[row]= -1;
                    continue;
                }
                double res = dfs(numerator,denominator,adj,visited);
                ans[row] = res;
            } 
            return ans;
    }
    /**
     * return -1.0 if only if numerator and denominator aren't reachable.
     */
    public double dfs(String numerator,String denominator,Map<String,Map<String,Double>>adj, Set<String> visited){
        if(numerator.equals(denominator))
            return 1.0;
        else if(adj.get(numerator).size()==1)
            return -1;  // don't find
        visited.add(numerator);
        double res = 1;
        for(String neighbor : adj.get(numerator).keySet()){
            //res=1;
            if(!visited.contains(neighbor)){
                res = 1.0; 
                res = dfs(neighbor,denominator,adj,visited); 
                if(res>0)
                    return res*adj.get(numerator).get(neighbor).doubleValue();
            }
        }
        return -1.0;
    }  
}   
    