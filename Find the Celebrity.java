/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n <= 0) return -1;
        if(n == 1) return 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){ //push all the candidate into the stack 
            stack.push(i);
        }
        int a = 0, b = 0;
        while(stack.size() > 1){
            a = stack.pop(); 
            b = stack.pop();
            //get 2 candidates
            if(knows(a, b)) stack.push(b); //b could be celebirty 
            else stack.push(a);
        }
        int c = stack.pop();
        for(int i = 0; i < n; i++){ //need to check again since we might miss a pair
            if(i != c && (knows(c,i) || !knows(i,c))) return -1; //the first knows the second
        }
        return c;
    }
}
