public class ArrayOps {
    public static void main(String[] args) {
        System.out.println(findMissingInt(new int[] {0}));
        System.out.println(secondMaxValue(new int[] {6, 9, 4, 7, 10}));
        System.out.println(containsTheSameElements(new int[] {2, 2, 3, 7, 8, 3, 2}, new int[] {8, 2, 7, 7, 3, 9}));
        System.out.println(isSorted(new int[] {7, 5, 4, 3, -12}));
        System.out.println(isSorted(new int[] {1, 3, 2}));

    }
    
    public static int findMissingInt (int [] array) {
        int sumInt = 0;
        int totalSum = 0;
        for (int j=1; j<=array.length; j++){
            totalSum += j;
        }
        for (int i=0; i<array.length; i++){
            sumInt += array[i];
        }
        return (totalSum - sumInt);
    }

    public static int secondMaxValue(int [] array) {
        int highest = 0;
        int secondHigh = 0;
        
        for(int i=0; i<array.length; i++){
            highest = Math.max(highest,array[i]);
        }

        for(int j=0; j<array.length; j++){
            if(array[j] !=highest){
                secondHigh = Math.max(secondHigh, array[j]);
            }
        }
        return secondHigh;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean check = false;
        boolean totalCheck1 = true;
        boolean totalCheck2 = true;
        for(int i=0; i<array1.length && totalCheck1; i++){
            for(int j=0; j<array2.length; j++){
                check = false;
                if(array1[i]==array2[j]){
                    check = true;
                    break;
                }
                if(j == array2.length-1 && check == false){
                    totalCheck1 = false;
                }
            }
        }

        for(int i=0; i<array2.length && totalCheck2; i++){
            for(int j=0; j<array1.length; j++){
                check = false;
                if(array2[i]==array1[j]){
                    check = true;
                    break;
                }
                if(j == array1.length-1 && check == false){
                    totalCheck2 = false;
                }
            }
        }
        return (totalCheck1 && totalCheck2);
    }

    public static boolean isSorted(int [] array) {
        boolean lowToHigh = true;
        boolean highToLow = true;

        for (int i=0; i<array.length-1; i++){
            if(!(array[i]<=array[i+1])){
                lowToHigh = false;
            }
            if(!(array[i]>=array[i+1])){
                highToLow = false;
            }
        }
        return (lowToHigh || highToLow);
    }
}
