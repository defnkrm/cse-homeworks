/*@author Defne Demir 20230808010
 *@since 7.11.2023 */

import java.util.Scanner;
public class Assignment2_20230808010 {
  public static String formatCategoryName(String category){
     String categoryName;
     String a=(category.substring(0, 1)).toUpperCase();
     String b=(category.substring(1)).toLowerCase();
     categoryName= a.concat(b);
     return categoryName;
  }
  public static boolean isQuantityValid(int Quantity){
    boolean result;
    if(Quantity>0){
      result=true;}
    else {result=false;}
    return result;
  }
  public static boolean isWeightValid(int weight, int totalWeight){
    boolean result;
    if (weight>=0 && totalWeight <=100){
      result=true;}
    else {result=false;}
    return result;
  }
  public static String gradeLetter(double grade){
    String result;
    if(grade<=34){result="FF";}
    else if (grade<=45){result="FD";}
    else if (grade<=52){result="DD";}
    else if(grade<=59){result="DC";}
    else if(grade<=66){result="CC";}
    else if(grade<=73){result="CB";}
    else if(grade<=80){result="BB";}
    else if(grade<=87){result="BA";}
    else{result="AA";}
    return result;
  }
  public static double gpaPoints(double grade){
    double result; 
    if(grade<=34){result=0.0;}
    else if (grade<=45){result=0.5;}
    else if (grade<=52){result=1.0;}
    else if(grade<=59){result=1.5;}
    else if(grade<=66){result=2.0;}
    else if(grade<=73){result=2.5;}
    else if(grade<=80){result=3.0;}
    else if(grade<=87){result=3.5;}
    else{result=4.0;}
    return result;
  }
   public static String status(double grade){
    String result;
    if(grade<=34){result="failed";}
    else if (grade<=45){result="failed";}
    else if (grade<=52){result="conditionally passed";}
    else if(grade<=59){result="conditionally passed";}
    else {result="passed";}
    return result;
   }
  public static void main(String[] args) {
    Scanner input= new Scanner(System.in);
    System.out.println("*******Category Information Entry*******\n");
    //category 1
    System.out.print("Enter the name of category 1: ");
    String catname1= input.nextLine();
    catname1=formatCategoryName(catname1);
    System.out.print("Enter how many items "+catname1+" has: ");
    int items1=input.nextInt();
    while(isQuantityValid(items1)==false){
      System.out.print("Enter how many items "+catname1+" has: ");
      items1=input.nextInt();}
    System.out.print("Enter the percentage weight of "+catname1+" :");
    int percentage1=input.nextInt();
    while(isWeightValid(percentage1,percentage1)==false){
      System.out.print("Enter the percentage weight of "+catname1+" :");
      percentage1=input.nextInt();}
    //category 2
    System.out.print("Enter the name of category 2: ");
    String catname2= input.next();
    catname2=formatCategoryName(catname2);
    System.out.print("Enter how many items "+catname2+" has: ");
    int items2=input.nextInt();
    while(isQuantityValid(items2)==false){
      System.out.print("Enter how many items "+catname2+" has: ");
      items2=input.nextInt();}
    System.out.print("Enter the percentage weight of "+catname2+" :");
    int percentage2=input.nextInt();
    while(isWeightValid(percentage2,percentage1+percentage2)==false){
      System.out.print("Enter the percentage weight of "+catname2+" :");
      percentage2=input.nextInt();} 
    //category 3
    System.out.print("Enter the name of category 3: ");
    String catname3= input.next();
    catname3=formatCategoryName(catname3);
    System.out.print("Enter how many items "+catname3+" has: ");
    int items3=input.nextInt();
    while(isQuantityValid(items3)==false){
      System.out.print("Enter how many items "+catname3+" has: ");
      items3=input.nextInt();}
    System.out.print("Enter the percentage weight of "+catname3+" :");
    int percentage3=input.nextInt();
    int sum=percentage1+percentage2;
    while(isWeightValid(percentage3,sum+percentage3)==false){
      System.out.print("Enter the percentage weight of "+catname3+" :");
      percentage3=input.nextInt();}
    //category 4
    System.out.print("Enter the name of category 4: ");
    String catname4= input.next();
    catname4=formatCategoryName(catname4);
    System.out.print("Enter how many items "+catname4+" has: ");
    int items4=input.nextInt();
    while(isQuantityValid(items4)==false){
      System.out.print("Enter how many items "+catname4+" has: ");
      items4=input.nextInt();}
    System.out.print("Enter the percentage weight of "+catname4+" :");
    int percentage4=input.nextInt();
    sum+=percentage3;
    while(isWeightValid(percentage4,sum+percentage4)==false){
      System.out.print("Enter the percentage weight of "+catname4+" :");
      percentage4=input.nextInt();}
    //category 5
    System.out.print("Enter the name of category 5: ");
    String catname5= input.next();
    catname5=formatCategoryName(catname5);
    System.out.print("Enter how many items "+catname5+" has: ");
    int items5=input.nextInt();
    while(isQuantityValid(items5)==false){
      System.out.print("Enter how many items "+catname5+" has: ");
      items5=input.nextInt();}
    System.out.print("Enter the percentage weight of "+catname5+" :");
    int percentage5=input.nextInt();
    sum+=percentage4;
    while(isWeightValid(percentage5,sum+percentage5)==false){
      System.out.print("Enter the percentage weight of "+catname5+" :");
      percentage5=input.nextInt();}
    if(sum!=100){
      System.out.println("Error. Percentages doesn't sum up to 100.");
    }
    
    else{
      System.out.println("*******Student Grade Entry*******\n");
      double sum1=0;
      for(int i=0;i<items1;i++){
        System.out.print(catname1+" "+(i+1)+" : ");
        double grade=input.nextInt();
        sum1+=grade;
        }
      double sum2=0;
      for(int i=0;i<items2;i++){
        System.out.print(catname2+" "+(i+1)+" : ");
        double grade=input.nextInt();
        sum2+=grade;
        }
      double sum3=0;
      for(int i=0;i<items3;i++){
        System.out.print(catname3+" "+(i+1)+" : ");
        double grade=input.nextInt();
        sum3+=grade;
        }
      double sum4=0;
      for(int i=0;i<items4;i++){
        System.out.print(catname4+" "+(i+1)+" : ");
        double grade=input.nextInt();
        sum4+=grade;
        }
      double sum5=0;
      for(int i=0;i<items5;i++){
        System.out.print(catname5+" "+(i+1)+" : ");
        double grade=input.nextInt();
        sum5+=grade;
        }
      double avg1= sum1/items1;
      double avg2= sum2/items2;
      double avg3= sum3/items3;
      double avg4= sum4/items4;
      double avg5= sum5/items5;
      System.out.println("*******Student Grade Results*******\n");
      System.out.println(catname1+": "+avg1);
      System.out.println(catname2+": "+avg2);
      System.out.println(catname3+": "+avg3);
      System.out.println(catname4+": "+avg4);
      System.out.println(catname5+": "+avg5);
      double finalscore=(avg1*percentage1/100)+(avg2*percentage2/100)+
      (avg3*percentage3/100)+(avg4*percentage4/100)+(avg5*percentage5/100);

      System.out.print("Student has "+status(finalscore)+
      " CSE 101 with a score of "+ finalscore+", GPA points of "+
      +gpaPoints(finalscore)+", and grade letter of "+gradeLetter(finalscore));
    }
  input.close();
  } 
 }