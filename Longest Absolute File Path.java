class Solution {
    public int lengthLongestPath(String input) {
        String[] tokens = input.split("\n");
        int res = 0;
        int curLen = 0;
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            int level = countLevel(s);
            //if current level is lower than the last one then pop it out. re build the array
            while(stack.size() > level){
                curLen -= stack.pop();
            }
            int len = s.replaceAll("\t", "").length() + 1;
            curLen += len;
            
            if(s.contains(".")){ //when there is a . we found the file
                res = curLen - 1 > res ? curLen - 1 : res;  // - 1 to remove the / in the last one 
            }
            stack.add(len);
        }
        return res;
    }
    private int countLevel(String s){
        String cur = s.replaceAll("\t", ""); //When you use \ and a number you are using octal numbers
        return s.length() - cur.length();
    }
}
