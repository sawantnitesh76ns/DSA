public class MinimalXor {

    public static void main(String[] args) {
        System.out.println(minimizeXor(79  , 74));
    }
    public static int minimizeXor(int num1, int num2) {
            
        // First we count how many bits does num2 have
        // Using n & (n - 1)
        
        int n = num2;
        int bitsCounter = 0;
        
        while(n > 0) {
            bitsCounter++;
            n = n & n - 1;
        }
        
        // Now we know how many bits does num2 have we will iterate upto we find a num 
        // which has same bits and give us minimal answer
        
        int min = Integer.MAX_VALUE;
        int result = 0;
        int max = num1 > num2? num1: num2;
        for(int i = 0; i <= max ; i++) {
            int temp = i;
            int tempBitsCounter = 0;
            
            while(tempBitsCounter <= bitsCounter && temp > 0) {
                tempBitsCounter++;
                temp = temp & temp - 1;
            }

            
            if(temp == 0 && tempBitsCounter == bitsCounter) {
                if(min > (i ^ num1)) {
                    result = i;
                    min = i ^ num1;
                }
            }
            
        }
        
        return result;
    }
}
