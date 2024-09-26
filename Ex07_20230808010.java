
public class Ex07_20230808010 {
    /*
     * Change the X's in the both file name and class' name to your own
     * student number and submit your file to the assignment given through
     * Teams.
     * 
     * if you do NOT submit your assignment in time, you will recieve 0
     * if your file has compile time errors, and do not compile you will recieve 10
     * if your file does compile but a runtime error occurs, you will recieve 20
     * You MUST NOT change the method headers and comply with their return types
     * 
     * Main method is just there for you to test your program, you will not be evaluated by your main method
     * You can write any method you like, and use them in suitable places but you will only be graded
     * for your work for the questions
     */
    public static void main(String[] args) {
        // Question 1
        /*
        int[][] array2D = generateArray2D(4, 4, 0, 10);
        display2D(array2D);
        int diagonalSum = sumDiagonal(array2D);
        System.out.println("Sum of the diagonal for the given 2D array is: " + diagonalSum);
        */

        // Question 2
        /*
        int[][] employees = generateArray2D(8, 7, 4, 9);
        display2D(employees);
        int[] workingHours = employeeWorkingHours(employees);
        display2D(employees);
        display(workingHours);
        */
      
        // Question 3
        /*
        int[][] matrixA = generateArray2D(3, 2, 1, 10);
        int[][] matrixB = generateArray2D(2, 3, 1, 10);
        display2D(matrixA);
        display2D(matrixB);

        int[][] productMatrix = matmul(matrixA, matrixB);
        display2D(productMatrix);
        */

        // Question 4
        /*
        int[][] points = generateArray2D(12, 5, -2, 2);
        display2D(points);
        int[] closestPoints = getClosestPoints(points, 0);
        System.out.println("Indexes of points with closest distance");
        display(closestPoints);
        */
        // Question 5
        /*
        char[][] charArray2D = headsNtails(7);
        display2D(charArray2D);
        */
    }

    // Question 1: Sum the major diagonal in a matrix
    public static int sumDiagonal(int[][] array2D) {
        /*
         * Write a method that sums all the numbers in the major diagonal
         * in an n x n matrix
         * 
         * Args:
         *      array2D (int[n][n]) : two dimensional array of integers
         * 
         * Returns:
         *      (int) : sum of all the numbers in the major diagonal
         */

        // Your code goes here...
       int sum=0;
       for (int i = 0; i < array2D.length; i++) {
        sum+=array2D[i][i];
       }
       return sum;
    }

    // Question 2: Compute the weekly hours for each employee <<<
    public static int[] employeeWorkingHours(int[][] employees) {
        /*
         * Suppose the weekly hours for all employees are stored in a
         * two-dimensional array. Each row records an employee's seven
         * day work hours with seven columns. Write a method that sorts the
         * employee's according to their sum of working hours for an enteire week
         * in decreasing order. Finally returns the sum of working hours for each
         * employee (sort both returned array and given employees array)
         * 
         * Args:
         *      employees (int[8][7]) : the array of employees. Each row contains
         *      the employee's seven day work hours.
         * 
         * Returns:
         *      int[8] : the array of sum working hours for each employee in decreasing order.
         */

        // Your code goes here...
        int[] workHour=new int[employees.length];
        
        for (int i = 0; i < employees.length; i++) {
            int hourSum=0;
            for (int j = 0; j < 7; j++) {
                hourSum+=employees[i][j];
            }
            workHour[i]=hourSum;
        }
        int number=0;
        int eliminate=0;
        int[] sorted=new int[workHour.length];
        for (int i = 0; i < workHour.length; i++) {
           number=0;
            for (int j = 0; j < workHour.length; j++) {
                if(workHour[j]>number){
                    number=workHour[j];
                    eliminate=j;
                }
            }
           workHour[eliminate]=0; 
           sorted[i]=number;
        }
        return sorted;
  }

    // Question 3: multiply two matrices
     public static int[][] matmul(int[][] matrixA, int[][] matrixB) {
        /*# see: https://www.khanacademy.org/math/multivariable-calculus/thinking-about-multivariable-function/x786f2022:vectors-and-matrices/a/matrices--intro-mvc
        * https://www.khanacademy.org/math/precalculus/x9e81a4f98389efdf:matrices/x9e81a4f98389efdf:multiplying-matrices-by-matrices/v/matrix-multiplication-intro
        * https://en.wikipedia.org/wiki/Matrix_multiplication
         * Write a method to multiply two matrices.
         * 
         * Args:
         *      matrixA (int[m][n]) : the two-dimensional array of integers
         *      matrixB (int[n][k]) : the two-dimensional array of integers
         * 
         * Returns:
         *      int[m][k] : the two-dimensional array of result matrix multiplication of
         *      matrixA and matrixB
         */

        // Your code goes here...
        int[][] multiMatrix=new int[matrixA.length][matrixB[0].length];

        for (int k = 0; k < multiMatrix.length; k++) {//satır
         for (int i = 0; i < multiMatrix[0].length; i++) {   //sutun  
             for (int j = 0; j < matrixB.length; j++) {//toplama
                multiMatrix[k][i]+=matrixA[k][j]*matrixB[j][i];
                }

            }
        }
        return multiMatrix;
    }
    //????
    // Question 4: All closest pairs of points <<<
   public static int[] getClosestPoints(int[][] points, int pointIndex) {
        /*
         * Write a method that returns the array indices of the closest points to the given
         * point index. if m number of points share the same minimum distance to
         * given point index, then your array will have all of those points
         * 
         * Args:
         *      points (int[n][d]) : array of n points in d dimensional space
         *      pointIndex (int) : index of a point from points array that we will search for closest m points
         * 
         * Returns:
         *      (int[m]) : array of point indices that share the same minimum distance to given point
         */

        // Your code goes here...
        double minPoint=2147483647;
        int count=0;
        int[] wantedPoints=points[pointIndex];
        int[] index= new int[points[0].length];
        for (int i = 0; i < index.length; i++) {
            index[i]=pointIndex;
        } 
        //double distance=0;
        for (int i = 0; i < wantedPoints.length; i++) {
                if(distance(points[i],index)<minPoint &&
                distance(points[i],index) !=0){
                    minPoint=distance(points[i],index);
                }
        }
            for (int j = 0; j < points.length; j++) {
               if(distance(points[j],index)==minPoint){
                count++;
            }
          }

        int[] result=new int[count];
        int counter=0;
        for (int i = 0; i < points.length; i++) {
            if(minPoint==distance(points[i],index)){
                result[counter]=i;
                counter++;
            }
        }
        return result;
        
    }

    // Calculates the euclidean distance between two points in d dimensional space
    public static double distance(int[] pointA, int[] pointB) {
        /*
         * Helper method for calculating distance between given two points
         * 
         * Args:
         *      pointA (int[d]) : a point in d-dimensional space
         *      pointB (int[d]) : a point in d-dimensional space
         * 
         * Returns:
         *      (double): distance between given two points UP TO 1 DECIMAL PLACE (see round method bellow)
         */

        // Your code goes here...
        int sum=0;
        for (int i = 0; i < pointB.length; i++) {
            sum+=(pointA[i]-pointB[i])*(pointA[i]-pointB[i]);
        }
        double result= round(Math.sqrt(sum), 1);
        return result;
    }

    // Question 5: Nine heads and tails <<<
    public static char[][] headsNtails(int number) {
        /*
         * Nine coins are placed in a 3-by-3 matrix with some face up and
         * some face down. You can represent the state of the coins using a 
         * 3-by-3 matrix with values 0 (heads) and 1 (tails). Here are some examples:
         *      0 0 0       1 0 1       1 0 0
         *   A: 0 1 0    B: 0 0 1   C:  1 1 1
         *      0 0 0       1 0 0       1 1 0
         * 
         *  Each state can also be represented using a binary number: For example,
         *  the preceding A, B and C matrices correspond to the numbers
         *      A: 0 0 0 0 1 0 0 0 0
         *      B: 1 0 1 0 0 1 1 0 0
         *      C: 1 0 0 1 1 1 1 1 0
         * 
         *  There are a total of 512 posibilities, so you can use
         *  decimal numbers 0, 1, 2, ..., 511 to represent all states of the matrix.
         *      for A: number == 10
         *      for B: number == 332
         *      for C: number == 318
         * 
         * Write a program that accepts a number and returns the corresponding matrix with
         * the characters H and T
         * 
         *      if the number == 7;
         *      then the binary of 7 == 0 0 0 0 0 0 1 1 1;
         *      so in matrix format it will be;
         *              0 0 0
         *              0 0 0
         *              1 1 1
         * 
         *      finally we can represent it with coins like;
         *              H H H
         *              H H H
         *              T T T
         * 
         * Args:
         *      number (int): the number to represent with the characters H and T in matrix format
         * 
         * Returns:
         *      (char[3][3]): the corresponding matrix representation of given number with coins
         */
        
        // Your code goes here...
/*        int[] binary= new int[9];
        int pow=8;
        double left=0;
        for (int i = 0; i < binary.length; i++) {
            left=number;
            if(left / (Math.pow(2,pow))>1  ){
                left=number % (Math.pow(2,pow));
                binary[i]=1;
            }
            pow--;
        }
        */
        int[] binary=decimalToBinary(number);
        char[][] coins=new char[3][3];
        int counter=0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(binary[counter]==1){
                coins[i][j]='T';      
                }
                else{
                    coins[i][j]='H';
               }
                counter++;
            }
        }
        return coins;   
    }

    // Converts the given decimal number to a binary represented with an array <<< # Sınav
   public static int[] decimalToBinary(int number) {
        /*
         * Helper method to conver the given decimal number to binary representation
         * 
         * Args: number (int): the decimal number convert to binary
         * Returns: int[9]: the binary representation of the given number
         */
        int[] binary= new int[9];
        int pow=8;
        double left=0;
        for (int i = 0; i < binary.length; i++) {
            left=number;
            if(left / (Math.pow(2,pow))>1  ){
                left=number % (Math.pow(2,pow));
                binary[i]=1;
            }
            pow--;
        }
        return binary;
    }

    /////////////// HELPER METHODS ////////////////////////////

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void display(int[] array) {
        for (int i : array) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }

    public static void display(char[] array) {
        for (int i : array) {
            System.out.printf("%c\t", i);
        }
        System.out.println();
    }

    public static void display2D(int[][] array2D) {
        for (int[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }


    public static void display2D(char[][] array2D) {
        for (char[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }

    public static int[][] generateArray2D(int m, int n, int start, int end) {
        int[][] array2D = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array2D[i][j] = random(start, end);
            }
        }

        return array2D;
    }

    public static int random(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}