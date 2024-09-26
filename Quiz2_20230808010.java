public class Quiz2_20230808010 {

    public static void main(String[] args) {
        System.out.println(decimalToBinary(10));
    }
   
    public static String sort(String text){
        String[] textsort=text.split("");
        String newText="";
        String temp="";

        for (int i = 0; i < textsort.length; i++) {

            for (int j = 0; j < textsort.length; j++) {
                if(textsort[j].compareToIgnoreCase(textsort[i])>0){
                temp=textsort[i];
                textsort[i]=textsort[j];
                textsort[j]=temp;
                }
                newText+=textsort[j];
            }
            
        }
        newText=newText.substring(newText.length()-text.length());
        return newText;
   }
  
   public static int[] lockerPuzzle(Boolean[] locker){
    for (int i = 0; i < locker.length; i++) {
        for (int j = locker.length; j >i; j--) {
          if(j%(i+1)==0){
            if(locker[j-1]){
                locker[j-1]=false;
            }
            else{
                locker[j-1]=true;
            }
         }
        }
    }
    int count=0;
    for (int i = 0; i < locker.length; i++) {
        if(locker[i]){
            count++;
        }
    }
    int[] openlocker= new int[count];
    int lockernum=0;
    for (int i = 0; i < locker.length; i++) {
        if(locker[i]){
            openlocker[lockernum]=i+1;
            lockernum++;
        }
    }
    return openlocker;
}
   
   public static boolean isMarkovMatrix(int[][] matrix){
    boolean result=true;
    int sum=0;
       if(matrix.length!=matrix[0].length){
        result=false;
       }
       else{
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[i][j]<=0){
                    result=false;
                    break;
                }
                if(result==true){
                 for (int j2 = 0; j2 < matrix.length; j2++) {
                    sum+=matrix[i][j2];
                 }
                 if(sum!=1){
                  result=false;
                 }
                }
            }
        }

       }
       return result;

    }
   public static void movingAverage(String source, String destination,int windowSize){

   }
   public static int factorial(int num){
    if(num==0){
     return 1;
    }
    else{
        return num*factorial(num-1);
    }
   }
   
   public static boolean isPalindrome(String text){
   boolean result=false;
   if(text.substring(0,1).equals(text.substring(text.length()-1))){
    result=true;
   }
   text=text.substring(1,text.length()-2);
   if(text.length()>1){
    isPalindrome(text);
   }
   return result;
   }

  public static String decimalToBinary(int number){
    int[] binary = new int[9];
    int c = binary.length - 1;
    while (number > 0) {
        if (number % 2 == 0) binary[c] = 0;
        else if (number % 2 == 1) binary[c] = 1;
        c--;
        number = number / 2;
    }
    String binaryn="";
    for (int i = 0; i < binary.length; i++) {
        binaryn+=binary[i];
    }
    return binaryn;
}
 
}
