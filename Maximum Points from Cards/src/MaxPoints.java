public class MaxPoints {
    public static void main(String[] args) {
        int[] cardPoints = {1,79,80,1,1,1,200,1};
        int k = 3;
        //System.out.println(maxScore(cardPoints, k , 0, cardPoints.length-1));
        System.out.println(maxScore(cardPoints, k));
    }

    /*private static int maxScore(int[] cards, int k, int left, int right) {
        //int[][] memo = new int[k+1][right+1];

        if(left==cards.length || right<0 || k==0)
            return 0;
        return Math.max(cards[left] + maxScore(cards, k-1, ++left, right), cards[right] + maxScore(cards, k-1, left, --right));
    } --> works only for few test cases */

    private static int maxScore (int[] cardPoints, int k) {
        k = Math.min(cardPoints.length, k);
        int[] left = new int[k+1];
        int[] right = new int[k+1];
        for(int i=0;i<k;i++) {
            left[i+1] += left[i] + cardPoints[i];
        }

        for(int i=cardPoints.length-1, j = 0;j<k;j++) {
            right[j+1] += right[j] + cardPoints[i--];
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++) {
            int l = left[k-i] + right[i];
            int r = right[k-i]+left[i];
            max = Math.max(max, Math.max(l,r));
        }

        return max;
    }
}
