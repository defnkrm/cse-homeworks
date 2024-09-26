import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment4_20230808010 {

    public static void main(String[] args) {
        try {
        if(args.length==1){
            //getting category info
            int courseNum=countCategory(args[0]+"_CourseDetails.txt");
            String[] category=new String[courseNum];
            int[] items=new int[courseNum];
            int gradeNum=0;
            int[] weight=new int[courseNum];

            getCategory(category, items, weight,args[0]+"_CourseDetails.txt");
            int weightSum=0;
            for (int i = 0; i < weight.length; i++) {
                weightSum+=weight[i];
            }
            if(weightSum!=100){
                PrintWriter nWriter=new PrintWriter(args[0]+"_Errors.log");
                nWriter.print("ERROR: Course details - invalid weight - does not sum to 100");
                nWriter.flush();
                nWriter.close();
            }
            else{
            for (int i = 0; i < items.length; i++) {
                gradeNum+=items[i];
            }
            //getting student info
            int studentNum=countCategory(args[0]+"_CourseDetails.txt");
            String[] studentName=new String[studentNum];
            Double[][] studentGrades=new Double[studentNum][gradeNum];
            Scanner input=new Scanner(new File(args[0]+"StudentScores.txt"));

            int s=0;
            while(input.hasNextLine()){
                String newLine=input.nextLine();
                String[] array=newLine.split(" ");
                
                studentName[s]=array[0];
                for (int i = 1,j=0; i < array.length; i++,j++) {
                    studentGrades[s][j]=Double.parseDouble(array[i]);
                }
                s++;
            }
            //writing to a file
            double[] gradeArray= new double[studentNum];
            for (int i = 0; i < gradeArray.length; i++) {
                double sum=0;
                for (int j = 0; j < studentGrades[0].length; j++) {
                    if(studentGrades[s][j]<0 || studentGrades[s][j]>100){
                    PrintWriter nWriter=new PrintWriter(args[0]+"_Errors.log");
                    nWriter.print("ERROR: Student Cannot - cannot calculate due to invalid grade entered");
                    nWriter.flush();
                    nWriter.close();
                    }
                    else{
                    if(j<items[0]){
                        sum+=studentGrades[s][j]*(weight[0]/100);
                    }
                    else if(j<items[0]+items[1]){
                        sum+=studentGrades[s][j]*(weight[1]/100);
                    }
                    else if(j<items[0]+items[1]+items[2]){
                        sum+=studentGrades[s][j]*(weight[2]/100);
                    }
                    else{
                        sum+=studentGrades[s][j]*(weight[3]/100);
                    }
                gradeArray[i]=sum;
                }
              }
            }

            PrintWriter output=new PrintWriter("_StudentGrades.txt");
            writeGrades(studentName, gradeArray, args[0]+"_StudentGrades.txt", args[0]+"_Errors.log");
            output.flush();
            output.close();
        }
    }
        else if(args.length==4){
            Scanner reader=new Scanner(args[0]+".txt");
            int catNum=countCategory(args[0]+".txt");

            String[] category=new String[catNum];
            int[] items=new int[catNum];
            int gradeNum=0;
            int[] weight=new int[catNum];

            getCategory(category, items, weight,args[0]+"txt");
            int weightSum=0;
            for (int i = 0; i < weight.length; i++) {
                weightSum+=weight[i];
            }
            if(weightSum!=100){
                PrintWriter nWriter=new PrintWriter(args[0]+"_Errors.log");
                nWriter.print("ERROR: Course details - invalid weight - does not sum to 100");
                nWriter.flush();
                nWriter.close();
            }
            else{
            for (int i = 0; i < items.length; i++) {
                gradeNum+=items[i];
            }
            //getting student info
            int studentNum=countCategory(args[0]+".txt");
            String[] studentName=new String[studentNum];
            Double[][] studentGrades=new Double[studentNum][gradeNum];
            Scanner input=new Scanner(new File(args[1]+".txt"));

            int s=0;
            while(input.hasNextLine()){
                String newLine=input.nextLine();
                String[] array=newLine.split(" ");
                
                studentName[s]=array[0];
                for (int i = 1,j=0; i < array.length; i++,j++) {
                    studentGrades[s][j]=Double.parseDouble(array[i]);
                }
                s++;
            }
            //writing to a file
            double[] gradeArray= new double[studentNum];
            for (int i = 0; i < gradeArray.length; i++) {
                double sum=0;
                for (int j = 0; j < studentGrades[0].length; j++) {
                    if(studentGrades[s][j]<0 || studentGrades[s][j]>100){
                    PrintWriter nWriter=new PrintWriter(args[3]+".log");
                    nWriter.print("ERROR: Student Cannot - cannot calculate due to invalid grade entered");
                    nWriter.flush();
                    nWriter.close();
                    }
                    else{
                    if(j<items[0]){
                        sum+=studentGrades[s][j]*(weight[0]/100);
                    }
                    else if(j<items[0]+items[1]){
                        sum+=studentGrades[s][j]*(weight[1]/100);
                    }
                    else if(j<items[0]+items[1]+items[2]){
                        sum+=studentGrades[s][j]*(weight[2]/100);
                    }
                    else{
                        sum+=studentGrades[s][j]*(weight[3]/100);
                    }
                gradeArray[i]=sum;
                }
              }
            }

            PrintWriter output=new PrintWriter(args[2]+".txt");
            writeGrades(studentName, gradeArray, args[2]+".txt", args[3]+".log");
            output.flush();
            output.close();
            }
        }
        else{
            System.out.println("ERROR: invalid argument count.");
        }

        } catch (Exception e) {
///////////////////////////////////////////////

        }

    }

    public static int countCategory(String filename){
        //CSE101_CourseDetails.txt
        int count=0;
        try {    
            File cat=new File(filename);
            Scanner input=new Scanner(cat);
            while(input.hasNextLine()){
                input.nextLine();
                count++;
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: file not found.");
        }
        return count;
    }

    public static void getCategory(String[] category,int[] quantity,int[] weight,String filename){
        File readFrom=new File(filename);
        Scanner input;
        boolean isValid=true;
        try {
            input = new Scanner(readFrom);
        for (int j = 0; j < category.length; j++) {
            category[j]=input.next();
            quantity[j]=input.nextInt();
            weight[j]=input.nextInt();
            if(weight[j]<0 || weight[j]>100){
                isValid=false;
                j--;
                continue;
            }
        }
        input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void writeGrades(String[] student,double[] grade, String filename,String errorLog) throws FileNotFoundException{
        try {
            PrintWriter writer=new PrintWriter(filename);
            String[] letterGrade=new String[grade.length];
            for (int i = 0; i < letterGrade.length; i++) {
                if(grade[i]<=34){letterGrade[i]="FF";}
                else if (grade[i]<=45){letterGrade[i]="FD";}
                else if (grade[i]<=52){letterGrade[i]="DD";}
                else if(grade[i]<=59){letterGrade[i]="DC";}
                else if(grade[i]<=66){letterGrade[i]="CC";}
                else if(grade[i]<=73){letterGrade[i]="CB";}
                else if(grade[i]<=80){letterGrade[i]="BB";}
                else if(grade[i]<=87){letterGrade[i]="BA";}
                else{letterGrade[i]="AA";}
            }
            Double[] gpaPoints=new Double[student.length];
            for (int i = 0; i < gpaPoints.length; i++) {
                if(grade[i]<=34){gpaPoints[i]=0.0;}
                else if (grade[i]<=45){gpaPoints[i]=0.5;}
                else if (grade[i]<=52){gpaPoints[i]=1.0;}
                else if(grade[i]<=59){gpaPoints[i]=1.5;}
                else if(grade[i]<=66){gpaPoints[i]=2.0;}
                else if(grade[i]<=73){gpaPoints[i]=2.5;}
                else if(grade[i]<=80){gpaPoints[i]=3.0;}
                else if(grade[i]<=87){gpaPoints[i]=3.5;}
                else{gpaPoints[i]=4.0;}
            }
            String[] status=new String[student.length];
            for (int i = 0; i < status.length; i++) {
                if (grade[i]<=45){status[i]="failed";}
                else if(grade[i]<=59){status[i]="conditionally passed";}
                else {status[i]="passed";}
            }
            for (int i = 0; i < student.length; i++) {
                writer.print(student[i]+" ");
                writer.print(grade[i]+" ");
                writer.print(letterGrade[i]+" ");
                writer.print(gpaPoints[i]+ " ");
                writer.print(status[i]+"\n");
                
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
