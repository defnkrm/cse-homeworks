import java.util.Scanner;

public class Ex05_20230808010 {
    public static double computePI(int input){
        if(input==0){return 3;}
        else{
            double pi;
            double sum=0;
            for(int i=1;i<=input;i++){
                double add=(Math.pow((-1),(i+1)))/(2*i-1); 
                sum+=add;}
           pi=4.0*(sum);
           return pi; }  
    }
        
     public static int factorial(int number){
        int factorial=1;
        for(int i=1;i<=number;i++){
            factorial=factorial*i; }
         return factorial;
    }
    
     //boolean mı???
    public static String isPrime(int a){
        boolean isPrime=true;
        for(int i=2; i<a;i++){
            if(a%i==0){
               isPrime=false;
               break; }
        }
        String result="";
        if(a==1){result+="1 is not a prime number.";}
        else{if(isPrime==false){
          result+= a+" is not a prime number.";
        }
        else{result+= a+" is a prime number.";}}
        return result;
    }

    public static void nPrimes(int n){
        int count=0;
        Boolean isPrime=true;
        for(int i=2;count<n;i++){
            for(int j=2;j<i;j++){
               if(i%j==0){
                isPrime=false;
                break;
               }
            }  
         if(isPrime==true){
        count++;
        System.out.print(i + " ");}
        isPrime=true;
        }
      System.out.println();
    }
    public static void nPerfectNumbers(int n){
        int count=0;
        int dividerSum=1;
        for(int i=6; count<n;i++){
           for(int j=2;j<i;j++){
            if(i%j==0){
                dividerSum+=j;
            }           
           }
          if(dividerSum==i){
            System.out.print(i+" ");
           count++;  }
           dividerSum=1;
         }   
        }  
   public static void displayStatistics(){
    Scanner input= new Scanner(System.in);
    int data=input.nextInt();
    double sum=0; 
    double add=0;
    double deviation=0;
     for(int i=0;i<data;i++){
      System.out.print("Enter data "+(i+1)+" : ");
      add=input.nextDouble();
      sum+=add;
      deviation+=Math.pow(add, 2);

     }
     deviation =  Math.sqrt((deviation - (Math.pow(sum, 2) / data)) / (data- 1));
     System.out.println("The mean is "+ (sum/data));
     System.out.printf("The deviation is %.5f",deviation);
     

   }
    public static void main(String[] args) {
     Scanner input=new Scanner(System.in);
     //exercise 1 output
     System.out.println("Enter number to compute pi:");
     int piInput= input.nextInt();
     System.out.println(computePI(piInput));
     //exercise 2 output
     System.out.println("Enter the number to calculate its factorial:");
     int factorialInput= input.nextInt();
     System.out.println(factorial(factorialInput));
     //exercise 3a output
     System.out.println("Enter a number to see if it's prime number or not");
     int isPrimeNumber= input.nextInt();
     System.out.println(isPrime(isPrimeNumber));
     //exercise 3b output
     System.out.println("Enter a number n to see first n prime numbers");
     int firstn=input.nextInt();
     nPrimes(firstn);
     //exercise 4 output
     System.out.println("Enter number n to see first n perfect numbers.");
     int primeN=input.nextInt();
     nPerfectNumbers(primeN);
     //exercise 5 output
     System.out.println("\nEnter how many data will be given:");
     displayStatistics();
      
    }
}