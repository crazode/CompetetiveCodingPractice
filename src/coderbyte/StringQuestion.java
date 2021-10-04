package coderbyte;

public class StringQuestion {
    public static void main(String[] args) {
        StringQuestion sol = new StringQuestion();
        String[] strArr = new String[]{"ADOBECODEBANC",  "ABC"};
        System.out.println(sol.stringChallenge(strArr, 2));
    }
    public String stringChallenge(String[] strArr, int arrLength){
        int m[] = new int[256];


        int ans = Integer.MAX_VALUE; // length of ans
        int start = 0; // starting index of ans
        int count = 0;

        for (int i = 0; i < strArr[1].length(); i++) {
            if (m[strArr[1].charAt(i)] == 0)
                count++;
            m[strArr[1].charAt(i)]++;
        }


        int i = 0;
        int j = 0;


        while (j < strArr[0].length())
        {


            m[strArr[0].charAt(j)]--;
            if (m[strArr[0].charAt(j)] == 0)
                count--;


            if (count == 0)
            {
                while (count == 0)
                {


                    if (ans > j - i + 1)
                    {
                        ans = Math.min(ans, j - i + 1);
                        start = i;
                    }


                    m[strArr[0].charAt(i)]++;
                    if (m[strArr[0].charAt(i)] > 0)
                        count++;

                    i++;
                }
            }
            j++;
        }

        if (ans != Integer.MAX_VALUE)
            return String.valueOf(strArr[0]).substring(start, ans+start);
        else
            return "-1";
    }
}
