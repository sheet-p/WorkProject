public class alphabetBoard {
    static final char[][] board = {   {'A','B','C','D','E'},
                                      {'F','G','H','I','J'},
                                      {'K','L','M','N','O'},
                                      {'P','Q','R','S','T'},
                                      {'U','V','W','X','Y'},
                                      {'Z','#','#','#','#'} };

    public static void main(String[] args) {
        String target = "BALL";
        char[] chars = target.toCharArray();
        int currx = 0, curry = 0;

        for(char ch : chars) {
            if(ch == 'Z') {
                ch = 'U';
            }
            //x co-ordinate
            int x = (ch - 65) % 5 ;
            // y co-ordinate
            int y = (ch - 65) / 5;

            //finding target y coordinate
            if(curry < y) {
                int diff = y - curry;
                for(int i=0; i<diff; i++)
                    System.out.print("D");
            }
            else {
                int diff = curry - y;
                for(int i=0; i<diff; i++)
                    System.out.print("U");
            }

            //finding target x coordinate
            if(currx < x) {
                int diff = x - currx;
                for(int i=0; i<diff; i++)
                    System.out.print("R");

            }
            else {
                int diff = currx - x;
                for(int i=0; i<diff; i++)
                    System.out.print("L");
            }
            currx = x;
            curry = y;
            System.out.print("!");
        }
    }
}
