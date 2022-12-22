public class Statistics {

    private static int[] numInAsc(int[] value) {
        int tempNum;

        /*for (int num : value) {
            System.out.print(", " + num);

        }
        

        System.out.print("\n"); */

        for (int x = 0; x <= value.length; x++) { // first x is incremented
            for (int t = x + 1; t <= value.length - 1; t++) {// for each "X" incr. we must incr. "t" with the index
                                                             // above
                if (value[x] >= value[t]) { // of "X" to get prev. value
                    tempNum = value[x];
                    value[x] = value[t];
                    value[t] = tempNum;
                }
            }
        }
        return value;
    }

    private static int findMedian(int[] val) {

        int[] arrVal = numInAsc(val); // get the values arrenged from "val"
        int arrSize, nxtNo, prevNo, finalVal;

        arrSize = arrVal.length;
        arrSize = arrSize / 2;

        if (arrSize % 2 == 0) {
            // if half of total array lenth is Even

            // System.out.println("\n Array size : " + arrSize);
            // System.out.println("The number is Even");

            prevNo = arrVal[arrSize - 1];
            nxtNo = arrVal[arrSize];

            /*
             * preNo = the index value of "arrSize" should be decremented by 1, since
             * array starts with 0
             */

            // System.out.println("Pre_num" + prevNo);
            // System.out.println("Nxt_num" + nxtNo);

            finalVal = (prevNo + nxtNo) / 2; // find the mid value
            
            // System.out.println("\n Median " + finalVal);
        } else {

            finalVal = arrVal[arrSize];

            // System.out.println("The number is ODD");
            // System.out.println("\n Median " + finalVal);
        }
        return finalVal;
    }
    
    
    private static String findMode(int[] unsoftedNumbers){
        int[] srtdNums = numInAsc(unsoftedNumbers);
        String mode = "";
        
        /*
         * first x is incremented
         * for each "X" incr. we must incr. "t" with the index higher than
         * "X" to get next value
         */

      /*   for (int x = 0; x <= srtdNums.length; x++) { 
            for (int t = x + 1; t <= srtdNums.length - 1; t++) { 
                if (srtdNums[x] == srtdNums[t]) { //if value of prev. and next index match, add to array  
                    mode = mode + srtdNums[t]+",";
                }
            }
        }
*/
       for (int x = 0; x <= srtdNums.length; x++) {

          if (x <= srtdNums.length - 2) {
              if (srtdNums[x] == srtdNums[x + 1]) { // if value of prev. and next index match, add to array
                  mode = mode + srtdNums[x] + ",";
              }
          }

      }
        
        return mode;
    }
    
    private static int[] findPrimeNumbers(int[] dataArray){
        int[] prmList = new int[dataArray.length];
        int val;
        boolean flag = false;
        

        for(int x = 0;x<=dataArray.length-2;x++){
            val = dataArray[x];

            for (int i = 2; i <= val / 2; ++i) {
                // if the number returns a remainder then it is a prime number
                  if (val % i == 0) {
                    flag = true;
                    break;
                  }
                }

                if(flag == true){
                    prmList[x] = dataArray[x];
                }
        }

        return prmList;
    } 
    
    public static void main(String[] args) {
        int[] numbers = { 47, 84, 75, 21, 14, 14, 79};
        int[] maxNum = new int[numbers.length];
        int[] primeNum = new int[numbers.length];
        
        for(int i: numbers){
            System.out.print(i+",");
        }

        System.out.println("\n");
        System.out.println("Median: "+findMedian(numbers)); 
        System.out.println("Mode: "+findMode(numbers));
        maxNum = numInAsc(numbers);
        System.out.println("Highest Number: "+maxNum[numbers.length-1]);
        primeNum = findPrimeNumbers(numbers);

        for(int y: primeNum){
            System.out.print(y+",");
        }

    }
}