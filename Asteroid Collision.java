class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0) return new int[0];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            if(stack.empty() || asteroids[i] > 0){
                stack.push(asteroids[i]);
                continue;
            }
            while(true){
                int prev = stack.peek();
                if(prev < 0){ //it won't collision
                    stack.push(asteroids[i]);
                    break;
                }
                if(Math.abs(prev) == Math.abs(asteroids[i])){
                    stack.pop();
                    break;
                }
                if(prev > -asteroids[i]) break;
                stack.pop();
                if(stack.empty()){
                    stack.push(asteroids[i]);
                    break;
                }
            }
        }
        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0) return new int[0];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            if(stack.empty() || asteroids[i] > 0) stack.push(asteroids[i]); //push only positive integer since if we have negtive go left and the upcoming positive ones would not crush them together
            else{
                while(true){
                    if(stack.peek() * asteroids[i] > 0){ //same direction as the previous one
                        stack.push(asteroids[i]);
                        break;
                    }
                    else if(Math.abs(stack.peek()) < Math.abs(asteroids[i])){ //collision
                        stack.pop();
                    }
                    else if(Math.abs(stack.peek()) == Math.abs(asteroids[i])){ //collision
                        stack.pop();
                        break;
                    }
                    else{ 
                        break;
                    }
                    if(stack.empty()){ 
                        stack.push(asteroids[i]);
                        break;
                    }
                }
                
            }
        }
        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
