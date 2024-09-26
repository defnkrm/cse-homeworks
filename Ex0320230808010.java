import java.util.Scanner;

public class Ex0320230808010 {
    public static void main(String[] args) {
        //exercise 1
        System.out.println("Enter 1 for Doner, 2 for Kebab, 3 for Lahmacun.");
        Scanner input = new Scanner(System.in);
        int meal= input.nextInt();
        System.out.println("Enter 1 for Ayran, 2 for Kola, 3 for Salgam.");
        int drink = input.nextInt(); 
        String mealname;
        String drinkname;
        int mealcost;
        int drinkcost;
        if (meal==1) {mealname= "Doner"; mealcost=80;}
        else if (meal==2) {mealname= "Kebab"; mealcost =110;}
        else if (meal==3) {mealname= "Lahmacun"; mealcost=75;}
        else {mealname= "ERROR"; mealcost=0;}

        if (drink==1) {drinkname = "Ayran"; drinkcost=10;}
        else if (drink==2) {drinkname= "Kola"; drinkcost=20;}
        else if (drink==3) {drinkname= "Salgam"; drinkcost=15;}
        else {drinkname= "ERROR"; drinkcost=0;}
        System.out.print("You ordered "+mealname+ " and " + drinkname );
        System.out.println(". Cost is " + (mealcost + drinkcost) + " liras.");

        //exercise 2
        System.out.println("Choose which membership you like. (1 or 2)");
        int membership=input.nextInt();
        System.out.println("Enter internet usage as GB.");
        int usage=input.nextInt();
        double cost;
        if (membership==1) {if (usage <= 100 && usage >=0){
            System.out.println("You have to pay 92 liras.");}
            else { cost = (92+(usage-100)*3*115/100.0);
                System.out.println("You have to pay " + cost + "liras.");} }
        else if (membership==2) {if (usage <=200 && usage >=0) {
            System.out.println("You have to pay 154 liras.");}
            else { cost = (154+(usage-200)*5+(usage-200)*5.0/10);
                System.out.println("You have to pay " + cost + " liras.");}}
        else {System.out.println("Error.");}
    
        //exercise 3
        System.out.println("Choose Attack (1 or 2)");
        int attack=input.nextInt();
        if (attack!=1 && attack!=2) {System.out.println("Invalid attack");}
        else {int damage=0;
        System.out.println("Enter 0 for tails, 1 for heads, 2 for random");
        int toss1= input.nextInt();
          if (toss1==2) {toss1= (int)(Math.random()*2);}
        System.out.println("enter for second toss");
        int toss2= input.nextInt();
          if (toss2==2) {toss2=(int)(Math.random()*2);}

        if (attack==1) { 
            if (toss1==1 && toss2==1) {System.out.println("60 damage");}
            else {System.out.println("0 damage");}}
        if (attack==2) {
            damage +=50;
            if (toss1==1) {damage +=20;} 
            if (toss2==1) {damage+=20;}
            System.out.println(damage + " damage." ); }}
        
        
        input.close();
        }}





          
            
        

        
    
