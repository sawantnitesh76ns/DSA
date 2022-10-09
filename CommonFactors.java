public class CommonFactors {
    public static void main(String[] args) {
        System.out.println(commonFactors(25 , 30));
    }

    public static int commonFactors(int a, int b) {
        int counter = 0;
        int start = 1;
        int smallest = a < b? a: b;
        while (start <=smallest ) {
            if(a % start == 0 && b % start == 0) {
                counter++;
            }
            start++;
        }
        return counter;
    }
}
