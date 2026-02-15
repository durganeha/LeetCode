class Solution {
    public String addBinary(String a, String b) {
       int i = a.length()-1;
       int j = b.length()-1;
       int carry = 0;
       
       StringBuilder result = new StringBuilder();
       
       while(i >=0 || j >= 0 || carry != 0){
           int bit1 = 0;
           int bit2 = 0;
           
           if(i >= 0){
               bit1 = a.charAt(i) - '0';
               i--;
           }
           if(j >= 0){
               bit2 = b.charAt(j) - '0';
               j--;
           }
           
           int bitSum = bit1 + bit2 + carry;
           result.append(bitSum % 2);
           carry = bitSum / 2;
       }
       return result.reverse().toString();
    }
}

    

