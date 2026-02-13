class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxL = 0;

        //case 1
        int index = 0;
        while(index < n){
            int end = index;
            while(end < n && s.charAt(end) == s.charAt(index)){
                end++;
            }
            maxL = Math.max(maxL, end - index);
            index = end;
        }

        //case 2
        maxL = Math.max(maxL, longestTwoCharBalanced(s, 'a', 'b', 'c'));
        maxL = Math.max(maxL, longestTwoCharBalanced(s, 'a', 'c', 'b'));
        maxL = Math.max(maxL, longestTwoCharBalanced(s, 'b', 'c', 'a'));

        //case 3
        int countA = 0, countB = 0, countC = 0;
        Map<String, Integer> prefixMap = new HashMap<>();
        prefixMap.put("0,0", -1);
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == 'a') countA++;
            else if(ch == 'b') countB++;
            else countC++;
            String key = (countA - countB) + "," + (countA - countC);
            if(prefixMap.containsKey(key)){
                maxL = Math.max(maxL, i - prefixMap.get(key));
            }
            else{
                prefixMap.put(key, i);
            }
        }
        return maxL;
    }
    //helper method
    private int longestTwoCharBalanced(String s, char char1, char char2, char ignoreChar){
        int n = s.length();
        int maxLen = 0;
        int i = 0;

        while(i < n){
            if(s.charAt(i) == ignoreChar){
                i++;
                continue;
            }
            int start = i;
            int balance = 0;
            Map<Integer, Integer> firstOccurence = new HashMap<>();
            firstOccurence.put(0, start);
            int j = start;
            while(j < n && s.charAt(j) != ignoreChar){
                balance += (s.charAt(j) == char1) ? 1 : -1;
                if(!firstOccurence.containsKey(balance)){
                    firstOccurence.put(balance, j+1);
                }
                else{
                    maxLen = Math.max(maxLen, j+1 - firstOccurence.get(balance));
                }
                j++;
            }
            i = j;
        }
        return maxLen;
    }
}