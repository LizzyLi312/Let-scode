//using stack since we need to look back
class StockSpanner {
    private Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int res = 1;
        while(!stack.empty() && stack.peek()[0] <= price){ //find the last one who is smaller than value(there might be several max so we add then all)
            res += stack.pop()[1];
        }
        stack.push(new int[]{price, res}); //push it into the stack
        return res;
    }
}
