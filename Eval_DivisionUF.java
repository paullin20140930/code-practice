class Solution { //
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, var> parrents= new HashMap<String, var>();
        for(int row = 0; row<equations.length; row++ ){
            String numerator = equations[row][0];
            String denominator = equations[row][1];
            if(!parrents.containsKey(numerator)&& !parrents.containsKey(denominator)){
                parrents.put(numerator, new var(denominator, values[row]));  // A/B= 3   B-> A 3
                parrents.put(denominator, new var(denominator,1));
            }
            else if(!parrents.containsKey(numerator))   // C/A = 2
                parrents.put( numerator,new var(denominator, values[row]));
            else if(!parrents.containsKey(denominator))
                parrents.put(denominator,new var(numerator, 1/values[row]));
            else{
                var d = find( denominator,parrents); // 1.4 f
                var n = find( numerator,parrents); // 1.0 b
                parrents.put(n.parrent,new var(d.parrent, values[row]*d.ratio*n.ratio));        
            }
        }    // create union-find tree structure.
        double[] ans = new double[queries.length];
        for(int row=0; row<queries.length; row++){  // a,c
            String numerator = queries[row][0]; String denominator = queries[row][1];
            if(!parrents.containsKey(numerator)|| !parrents.containsKey(denominator)){
                ans[row] = -1;
                continue;
            }
            var n = find(queries[row][0],parrents); var d = find(queries[row][1],parrents);
            if(!n.parrent.equals(d.parrent))
                ans[row]=-1;
            else
                ans[row]=n.ratio/d.ratio; 
        }
        return ans;
    } 
    /**
    *  return query's var with var.parrent = tree root, var.ratio = root.val/this.val
    */
    public var find(String root, Map<String, var> parrents ){
        if(root == parrents.get(root).parrent)
            return new var(root,1.0);  // return node's ratio
        var p = find(parrents.get(root).parrent, parrents);
        parrents.get(root).ratio *= p.ratio;
        parrents.get(root).parrent = p.parrent;
        return parrents.get(root);
    }
}   

class var{
    double ratio;
    String parrent;
    var(String parrent, double ratio){
       this.parrent = parrent; this.ratio = ratio;
    }
}