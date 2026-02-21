class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        int f0 = 0, f1 = 1;
        for(int i = 1; i < n; i++){
            int temp = f0 + f1;
            f0 = f1;
            f1 = temp;
        }
        return f1;
    }
}