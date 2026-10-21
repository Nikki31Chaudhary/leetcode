class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        int n=nums.length;
       Stack<Long>st=new Stack<>();
       for(int i=0;i<n;i++){
        long cur=(long)nums[i];
        while(!st.isEmpty() && st.peek()==cur){
            st.pop();
            cur*=2;
        }
        st.push(cur);
       } 
       List<Long>res=new ArrayList<>();
       while(!st.isEmpty()){
        res.add(st.pop());
       }
       Collections.reverse(res);
       return res;
    }
}