package CodeChef.DecLC;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class HailXOR {
    public static void main(String[] arg) throws Exception {

//        System.out.println(setBitIndices(14));
//        System.out.println(Integer.toBinaryString(14));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(input.readLine());
        while (t-- > 0) {

            String[] NXStrings = input.readLine().split(" ");
            int N = Integer.parseInt(NXStrings[0]);
            int X = Integer.parseInt(NXStrings[1]);

            int[] A = new int[N];
            String[] aStrings = input.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(aStrings[i]);
            }


            Map<Integer, LinkedList<Integer>> bitIndexToAIndexMap = new HashMap<>();

            for (int i = 0; i < N; i++) {
                List<Integer> setBitIndices = setBitIndices(A[i]);
                for (int setBitIndex : setBitIndices) {
                    if (!bitIndexToAIndexMap.containsKey(setBitIndex)) {
                        bitIndexToAIndexMap.put(setBitIndex, new LinkedList<>());
                    }
                    bitIndexToAIndexMap.get(setBitIndex).add(i);
                }
            }

            int x = X;
            for (int i = 0; x > 0 && i < N - 1; x--) {

                Optional<Integer> msbOptional = msb(i, A, bitIndexToAIndexMap);
                if (!msbOptional.isPresent()) {
                    i++;
                    x++;
                    continue;
                }
                int msb = msbOptional.get();
                bitIndexToAIndexMap.get(msb).removeFirst();
                if (bitIndexToAIndexMap.get(msb).size() > 0) {
                    bitIndexToAIndexMap.get(msb).removeFirst();
                } else {
                    bitIndexToAIndexMap.get(msb).addLast(N - 1);
                }
                i++;
            }

            int[] output = new int[N];
            for (int bitIndex : bitIndexToAIndexMap.keySet()) {
                for (int arrayIndex : bitIndexToAIndexMap.get(bitIndex)) {
                    output[arrayIndex] += Math.round(Math.pow(2, bitIndex));
                }
            }


            if (x > 0) {
                if (x % 2 == 1) {

                    output[N - 2] += 1;
                    if (bitIndexToAIndexMap.get(0).size() > 0) {
                        output[N - 1] -= 1;
                    } else {
                        output[N - 1] += 1;
                    }

                }
            }

            for(int out: output){
                result.append(out+" ");
            }
            result.append("\n");


        }
        System.out.println(result);
    }

    private static Optional<Integer> msb(int i, int[] A, Map<Integer, LinkedList<Integer>> bitIndexToAIndexMap) {
        for (int setBitIndex : setBitIndices(A[i])) {
            if (bitIndexToAIndexMap.get(setBitIndex).peekFirst().equals(i)) return Optional.of(setBitIndex);
        }
        return Optional.empty();
    }

    private static List<Integer> setBitIndices(int n) {
        ArrayList<Integer> integers = new ArrayList<>();
        String binString = Integer.toBinaryString(n);

        for (int i = 0; i < binString.length(); i++) {
            if (binString.charAt(i) == '1') {
                integers.add(binString.length() - i - 1);
            }
        }

        return integers;
    }

    public static int getDaysCount(int[] a, int n, int d) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= 9 || a[i] >= 80) {
                count++;
            }
        }
        double daysCount = 0;
        daysCount = Math.ceil(count / (d * 1.0));
        daysCount = daysCount + Math.ceil((n - count) / (d * 1.0));
        return (int) daysCount;
    }
}
