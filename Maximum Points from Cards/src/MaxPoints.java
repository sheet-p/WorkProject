public class MaxPoints {
    public static void main(String[] args) {
        int[] cardPoints = {1,79,80,1,1,1,200,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k , 0, cardPoints.length-1));
    }

    private static int maxScore(int[] cards, int k, int left, int right) {
        //int[][] memo = new int[k+1][right+1];

        if(left==cards.length || right<0 || k==0)
            return 0;
        return Math.max(cards[left] + maxScore(cards, k-1, ++left, right), cards[right] + maxScore(cards, k-1, left, --right));
    }
}
