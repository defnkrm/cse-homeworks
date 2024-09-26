/*
 *Defne Demir 20230808010 
 * started on 8.12.2023
 */

import java.util.Scanner;

public class Assignment3_20230808010 {
    public static int menu(Scanner input,String[
        
    ] array){

        formatCategoryName(array);
        String choice="";
        int result=0;
        do{
        System.out.println("Please enter a choice below");
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+" - "+ array[i]);
        }
        System.out.println("Q - to Quit");
        choice=input.next();
        if(choice.equals("-1")){
            System.out.println("Invalid choice.");
        }
        else if(choice.equals("Q") || choice.equals("q")){
            choice= "-1";
        }
        result=Integer.valueOf(choice);
        if(result>array.length-1){
            System.out.println("Invalid choice.");
        }
       }while(result>array.length-1);       
       return result;
       
    }
        public static int menu2(Scanner input,String[] array){
        formatCategoryName(array);
        String choice="";
        int result=0;
        System.out.println("Please enter a choice below");
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+" - "+ array[i]);
        }
        System.out.println("Q - to Quit");
        choice=input.next();
        if(choice.equals("Q") || choice.equals("q")){
            choice= "-1";
        }
        result=Integer.valueOf(choice);
        if(result>array.length-1){
            System.out.println("Invalid input.");
        }        
       return result;
       
    }

    public static void calculateGrade(String[] category,int[] quantity,int[] weight){
        //checking if array values are valid
        int totalWeight=0;
        boolean result=true;
        boolean weightValid=true;
        for (int i = 0; i < weight.length; i++) {
            totalWeight+=weight[i];
        }
        for (int i = 0; i < quantity.length; i++) {
            if(quantity[i]<=0){
                result=false;
                break;
            }
        }
        for (int i = 0; i < weight.length; i++) {
            if(weight[i]<=0){
                weightValid=false;
                break;
            }
        }
        if(totalWeight!=100 || weightValid==false){
          System.out.println("ERROR: Invalid weight entered");
        }
        else if(result==false){
            System.out.println("ERROR: Invalid quantity entered");
        }
         else{
      System.out.println("\nWelcome to our university grading system.");
      formatCategoryName(category);

      if(category.length==quantity.length && category.length==weight.length){
       Scanner input=new Scanner(System.in);
       String[] itemList={"Enter ALL THE GRADES","Display grade information",
       "change a single grade",};
       int val=menu(input, itemList);
         int sum=0;
         for (int i = 0; i < quantity.length; i++) {
         sum+=quantity[i];
         }
       int[] grades=new int[sum];
       do{

       while(val==0){
        int count=0;
        for (int j = 0; j < category.length; j++) {
         for (int i = 0; i < quantity[j]; i++) {
            System.out.println("Enter grades for the "+ category[j]+" "+(i+1)+":");
            grades[count]=input.nextInt();
            if(grades[count]>100 || grades[count]<0){
                System.out.println("Error. Invalid grade entered.");
                val=-1;
                break;
            }
            count++;
         }
      }
      val=menu(input, itemList);
    }
        while(val==1){         
            double[] averages= new double[category.length];
            int count=0;
            double ave=0.0;
            for (int i = 0; i < category.length; i++) {
                
                for (int j = 0; j < quantity[i]; j++) {
                  ave+=grades[count];
                  count++;  
                }
               ave/=quantity[i];
               averages[i]=ave;
               ave=0.0;
            }
            System.out.println("--Category information--");

            for (int i = 0; i < category.length; i++) {
                System.out.println(category[i]+" - "+averages[i]);
            }

            double overall=0;
            for (int i = 0; i < averages.length; i++) {
                overall+=averages[i]*weight[i]/100;
            }
            //overall/=averages.length;
            System.out.println("\nOverall Grade - "+overall);

            String gradeLetter="";
            if(overall<=34){gradeLetter="FF";}
            else if (overall<=45){gradeLetter="FD";}
            else if (overall<=52){gradeLetter="DD";}
            else if(overall<=59){gradeLetter="DC";}
            else if(overall<=66){gradeLetter="CC";}
            else if(overall<=73){gradeLetter="CB";}
            else if(overall<=80){gradeLetter="BB";}
            else if(overall<=87){gradeLetter="BA";}
            else{gradeLetter="AA";}
            System.out.println("Grade Letter - "+gradeLetter);

            Double gpaPoints=0.0;
            if(overall<=34){gpaPoints=0.0;}
            else if (overall<=45){gpaPoints=0.5;}
            else if (overall<=52){gpaPoints=1.0;}
            else if(overall<=59){gpaPoints=1.5;}
            else if(overall<=66){gpaPoints=2.0;}
            else if(overall<=73){gpaPoints=2.5;}
            else if(overall<=80){gpaPoints=3.0;}
            else if(overall<=87){gpaPoints=3.5;}
            else{gpaPoints=4.0;}
            System.out.println("GPA Points - "+gpaPoints);

            String status="";
            if (overall<=45){status="failed";}
            else if(overall<=59){status="conditionally passed";}
            else {status="passed";}
            System.out.println("Status - "+status+"\n");
            val=menu(input, itemList);
        }
        //CHANGING JUST ONE OF THE GRADES
        if(val==2){
          int catValue=menu2(input, category);
          if(catValue>category.length){
            System.out.println("Invalid input.");
          }
          else if(catValue==-1){
            val=catValue;
            break;
          }
          else{
            System.out.println("Enter which "+category[catValue]+
            " you'd like to change (1-"+quantity[catValue]+")");
            int whichItem=input.nextInt();
            if(whichItem<1 || whichItem>quantity[catValue]){
                System.out.println("Invalid choice.");
            }
            else{
                //grades
                int count=0;
                for (int i = 0; i < catValue+1; i++) {
                  while(i<catValue){
                    for (int j = 0; j < quantity[i]; j++) {
                        count++;
                    }
                 }
                 for(int j=0; j<whichItem;j++){
                    count++;
                 }
                }
                double currentgrade=grades[count-1];                
                System.out.println("Current grade for "+category[catValue]+" "+
                +whichItem+ " is "+currentgrade);
                System.out.print("Enter the new grade value: ");
                grades[count-1]=input.nextInt();

            }
          }

          val=menu(input, itemList);
        }

    }while(val!=-1);
    if(val==-1){
        System.out.println("Thank you for using our system. Have a nice day.");
    }
 }
      else{
        System.out.println("Error. Array lenghts are not the same");
      }
    
    }
    }

    public static void formatCategoryName(String[] array){
        for (int i = 0; i < array.length; i++) {
         String a=(array[i].substring(0, 1)).toUpperCase();
         String b=(array[i].substring(1)).toLowerCase();
         array[i]= a.concat(b);
        }
    }
    public static void main(String[] args) {
     String[] category={"Quiz","Attendance","hOMEWORK","mİDterm","final"};
     int[] quantity={4,2,3,1,1};
     int[] weight={10,10,10,30,40};
     calculateGrade(category, quantity, weight);
    } 
    
}