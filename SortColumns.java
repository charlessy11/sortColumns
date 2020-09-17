import java.util.*;

public class SortColumns {
    private List<Integer> minDeletionSize(String[] A, List<Integer> newList) {
        //set 'size' to length of first string
        int size = A[0].length();
        for (String word : A){
            //check if length of every other string in array is not equal to length of 'size'
            if (word.length() != size){
                return null;
            }
        }
        //nested loop that goes through every char in each string
        for (int col = 0; col < size; col++){
            for (int row = 0; row < A.length - 1; row++) {
              //check if char in previous string is > char in next string (w/ same index)
              if (A[row].charAt(col) > A[row + 1].charAt(col)) {
                  //if so, add index to 'newList'
                  newList.add(col);
                    break;
              }
            }
        }
        return newList;
    }
    public static void main (String[] args) {
        System.out.println("Enter strings separated by commas (no spaces): ");
        Scanner scan = new Scanner(System.in);
        List<Integer> newList = new ArrayList<>();
        //store scan in a string
        String input = scan.next(); 
        //parse scan with split
        String[] A = input.split(",");
        SortColumns sort = new SortColumns();
        List<Integer> result = sort.minDeletionSize(A, newList);
        System.out.println(result);
    }
}