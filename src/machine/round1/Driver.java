package machine.round1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Driver {
    private static ArrayList<Record> records = new ArrayList<Record>();
    static int curIndex = -1;
    public static void main(String[] arg) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] op = input.readLine().split(" ");
            if(op[0].equals("ALLOCATE")){
                createRecord(op);
                curIndex++;
            }
            else if(op[0].equals("SIP")){
                records.get(curIndex).setSip(op);
            }
            else if(op[0].equals("CHANGE")){
                records.get(curIndex).addChange(op);
            }
            else if(op[0].equals("BALANCE")){
                showBalance(op);
            }
            else if(op[0].equals("REBALANCE")){
                long equity_rebalance = records.get(curIndex).getRebalanceEqity();
                long debt_rebalance = records.get(curIndex).getRebalanceDebt();
                long gold_rebalance = records.get(curIndex).getRebalanceGold();
                System.out.println(equity_rebalance + " " + debt_rebalance + " " + gold_rebalance);
            }
        }
    }

    private static void showBalance(String[] op) {
        long equity_current = 0;
        long debt_current = 0;
        long gold_current = 0;

        switch (op[1]){
            case "JANUARY": equity_current = records.get(curIndex).getEquity().get(1);
                debt_current = records.get(curIndex).getDebt().get(1);
                gold_current = records.get(curIndex).getGold().get(1);
                System.out.println(equity_current + " " + debt_current + " " + gold_current);
            break;
            case "FEBRUARY": equity_current = records.get(curIndex).getEquity().get(2);
                debt_current = records.get(curIndex).getDebt().get(2);
                gold_current = records.get(curIndex).getGold().get(2);
                System.out.println(equity_current + " " + debt_current + " " + gold_current);
                break;
            case "MARCH": equity_current = records.get(curIndex).getEquity().get(3);
                debt_current = records.get(curIndex).getDebt().get(3);
                gold_current = records.get(curIndex).getGold().get(3);
                System.out.println(equity_current + " " + debt_current + " " + gold_current);
                break;
            case "APRIL": equity_current = records.get(curIndex).getEquity().get(4);
                debt_current = records.get(curIndex).getDebt().get(4);
                gold_current = records.get(curIndex).getGold().get(4);
                System.out.println(equity_current + " " + debt_current + " " + gold_current);
                break;
            case "MAY": equity_current = records.get(curIndex).getEquity().get(5);
                debt_current = records.get(curIndex).getDebt().get(5);
                gold_current = records.get(curIndex).getGold().get(5);
                System.out.println(equity_current + " " + debt_current + " " + gold_current);
                break;
            case "JUNE": equity_current = records.get(curIndex).getEquity().get(6);
                debt_current = records.get(curIndex).getDebt().get(6);
                gold_current = records.get(curIndex).getGold().get(6);
                System.out.println(equity_current + " " + debt_current + " " + gold_current);
                break;
            case "JULY": equity_current = records.get(curIndex).getEquity().get(7);
                debt_current = records.get(curIndex).getDebt().get(7);
                gold_current = records.get(curIndex).getGold().get(7);
                System.out.println(equity_current + " " + debt_current + " " + gold_current);
                break;
            case "AUGUST": equity_current = records.get(curIndex).getEquity().get(8);
                debt_current = records.get(curIndex).getDebt().get(8);
                gold_current = records.get(curIndex).getGold().get(8);
                System.out.println(equity_current + " " + debt_current + " " + gold_current);
                break;
            case "SEPTEMBER": equity_current = records.get(curIndex).getEquity().get(9);
                debt_current = records.get(curIndex).getDebt().get(9);
                gold_current = records.get(curIndex).getGold().get(9);
                System.out.println(equity_current + " " + debt_current + " " + gold_current);
                break;
            case "OCTOBER": equity_current = records.get(curIndex).getEquity().get(10);
                debt_current = records.get(curIndex).getDebt().get(10);
                gold_current = records.get(curIndex).getGold().get(10);
                System.out.println(equity_current + " " + debt_current + " " + gold_current);
                break;
            case "NOVEMBER": equity_current = records.get(curIndex).getEquity().get(11);
                debt_current = records.get(curIndex).getDebt().get(11);
                gold_current = records.get(curIndex).getGold().get(11);
                System.out.println(equity_current + " " + debt_current + " " + gold_current);
                break;
            case "DECEMBER": equity_current = records.get(curIndex).getEquity().get(12);
                debt_current = records.get(curIndex).getDebt().get(12);
                gold_current = records.get(curIndex).getGold().get(12);
                System.out.println(equity_current + " " + debt_current + " " + gold_current);
                break;
            default:break;

        }
    }


    private static void createRecord(String[] op) {
        records.add(new Record(op));
    }
}
