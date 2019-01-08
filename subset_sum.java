public class Main {

    public static ArrayList<ArrayList<Integer>> AllSolutions = new ArrayList<>();
    public static ArrayList<Integer> temp = new ArrayList<>();
    public static int makeChangeHelper(int[] coins, int currIdx, ArrayList<Integer> currSet, int amount)
    {
        if (amount == 0) {
            AllSolutions.add(new ArrayList(){ {addAll(currSet);}});
            return 1;
        }
        if (amount < 0 || currIdx <= 0 && amount >= 1) {
            return 0;
        }

        int exclude = makeChangeHelper(coins, currIdx-1, currSet, amount);
        currSet.add(coins[currIdx - 1]);
        int include = makeChangeHelper(coins, currIdx, currSet,amount - coins[currIdx - 1]);
        currSet.remove(currSet.size()-1);
        return exclude + include;
    }

    public static int makeChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0 && amount > 0)
            return 0;
        return makeChangeHelper(coins, coins.length, new ArrayList<>(), amount);
    }
