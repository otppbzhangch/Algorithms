public class BacktrackTemplate {

    // Some structure to hold all answers. Could be array, ArrayList, list,...
    private static List<List<Object>> results = new LinkedList<List<Object>>();

    public static void main(string[] args) {
        
        // For really simple input
        if (A == null || A.length == 0) {
            // print results
        }

        // Store single solution
        List<Object> solution = new LinkedList<Object>();

        // Kick off the process
        DFS(solution, A, 0);

        // print results
    }

    private static void DFS(List<Object> solution, int[] A, int pos) {
        // Base case
        if (isASolution(A, pos)) {
            // Add to result collection, or print out
            results.Add(solution);
            return;
        }

         // Seach all possible next move
        for (int i = pos; i < A.length; i++) {
            
            // Stop searching along this path
            if (!isValid(A[i])) continue; 

            // Add next possible move to the solution
            solution.Add(A[i]);
            visited(A[i]) = true; // maybe need to update this for path finding

            // Kick off next recursion - assume the solution will be added
            DFS(solution, A, i + 1);

            // After searching, rollback to go on with next possible move
            solution.Remove(A[i]);
            visited(A[i]) = false; // maybe need to update this for path finding

        }
    }
}
