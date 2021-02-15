//https://leetcode.com/discuss/interview-question/396769/
//You are given a string that represents time in the format hh:mm. Some of the digits are blank
// (represented by ?). Fill in ? such that the time represented by this string is the maximum possible.
// Maximum time: 23:59, minimum time: 00:00. You can assume that input string is always valid.
public class Time {
    public static void main(String[] args) {
        String time = "2?:2?";
        char[] ans="23:59".toCharArray(), cTime=time.toCharArray();

        ans[0] = cTime[1]!='?' && cTime[1] > '3' ? '1' : ans[0];
        ans[1] = cTime[0]!='?' && cTime[0] < '2' ? '9' : ans[1];

        for(int i=0; i<cTime.length; i++) {
            ans[i] = cTime[i]!='?' ? cTime[i] : ans[i];
        }

        for(char ch : ans)
            System.out.print(ch);
    }
}
