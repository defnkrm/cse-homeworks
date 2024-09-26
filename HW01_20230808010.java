import java.util.ArrayList;
import java.util.List;

public class HW01_20230808010 {
    public static void main(String[] args) {
        TrafficControl lamba=new TrafficControl(5,5);
        System.out.println(lamba);
        System.out.println(lamba.countMalfunctioningLights());
        System.out.println(lamba.crucialIntersections().get(0)[0]);
        System.out.println(lamba.crucialIntersections().get(0)[1]);

        int[] array=new int[12];

    }
}
interface ITrafficControl{
    int[][] getCityGrid();
    int countMalfunctioningLights();
    String mostMalfunction();
    int countMalfunctioningNeighbors(int row,int col);
    List<int[]> crucialIntersections();
    String toString();
    }

class TrafficControl implements ITrafficControl{
    int[][] cityGrid;
    public TrafficControl(int m, int n){
        int[][] temp=new int[m][n];
        int tem;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tem=(int)(Math.random()*3);
                temp[i][j]=tem;
            }
        }
        this.cityGrid=temp;
    }
    public TrafficControl(int[][] cityGrid){
        this.cityGrid=cityGrid;
    }
    @Override
    public int[][] getCityGrid() {
        return cityGrid;
    }

    @Override
    public int countMalfunctioningLights() {
    //returns how many 1's the grid has
        int counter=0;
        for (int i = 0; i < cityGrid.length; i++) {
            for (int j = 0; j < cityGrid[0].length; j++) {
                if(cityGrid[i][j]==1)
                    counter++;
            }
        }
        return counter;
    }

    @Override
    public String mostMalfunction() {
        int[] rowMalfunctionCounter=new int[cityGrid[0].length];
        int[] columnMalfunctionCounter=new int[cityGrid.length];
        for (int i = 0; i < cityGrid.length; i++) {
            for (int j = 0; j < cityGrid[0].length; j++) {
                if(cityGrid[i][j]==1){
                    rowMalfunctionCounter[i]++;
                    columnMalfunctionCounter[j]++;
                }
            }
        }
        String result="";
        int maxRow=0;
        int maxCol=0;
        int temp=rowMalfunctionCounter[0];
        for (int i = 1; i < rowMalfunctionCounter.length; i++) {
            if(rowMalfunctionCounter[i]>temp){
                temp=rowMalfunctionCounter[i];
                maxRow=i;
            }
        }
        temp=columnMalfunctionCounter[0];
        for (int i = 1; i < columnMalfunctionCounter.length; i++) {
            if(columnMalfunctionCounter[i]>temp){
                temp=columnMalfunctionCounter[i];
                maxCol=i;
            }
        }
        if(rowMalfunctionCounter[maxRow]>columnMalfunctionCounter[maxCol])
            result+="Row: "+Integer.toString(maxRow);
        else if (columnMalfunctionCounter[maxCol]>rowMalfunctionCounter[maxRow])
            result+="Column: "+Integer.toString(maxCol);
        else
            result+="Row: "+Integer.toString(maxRow)+" and Column: "+Integer.toString(maxCol)+" both have the most malfunctions.";
        return result;
    }

    @Override
    public int countMalfunctioningNeighbors(int row, int col) {
        int count=0;
        if(col-1 >= 0){
            if(cityGrid[row][col-1] == 1)
                count++;
        }
        if(row-1 >= 0){
            if(cityGrid[row-1][col] == 1)
                count++;
        }
        if(row+1 < cityGrid.length){
            if(cityGrid[row+1][col] == 1)
                count++;
        }
        if(col+1 < cityGrid[0].length){
            if(cityGrid[row][col+1] == 1)
                count++;
        }
        return count;
    }

    @Override
    public List<int[]> crucialIntersections() {
        List<int[]> result=new ArrayList<>();

        for (int i = 0; i < cityGrid.length; i++) {
            for (int j = 0; j < cityGrid[0].length; j++) {
               if(countMalfunctioningNeighbors(i,j) >1){
                   int[] addThis=new int[] {i,j};
                   result.add(addThis);
               }
            }
        }
        return result;
    }

    @Override
    public String toString(){
        String result="";
        for (int i = 0; i < cityGrid.length; i++) {
            for (int j = 0; j < cityGrid[0].length; j++) {
                result+=Integer.toString(cityGrid[i][j])+"    ";
            }
            result+="\n";
        }
        return result;
    }

}