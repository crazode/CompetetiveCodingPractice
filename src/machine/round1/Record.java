package machine.round1;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class Record {

    private final double equity_percent_initial;
    private final double debt_percent_initial;
    private final double gold_percent_initial;
    private long equity_sip;
    private long debt_sip;
    private long gold_sip;
    private ArrayList<Long> equity = new ArrayList<>();
    private ArrayList<Long> debt = new ArrayList<>();
    private ArrayList<Long> gold = new ArrayList<>();

    public Record(String[] op) {

        equity.add(Long.parseLong(op[1]));
        debt.add(Long.parseLong(op[2]));
        gold.add(Long.parseLong(op[3]));
        long total = equity.get(0) + debt.get(0) + gold.get(0);
        this.equity_percent_initial = (equity.get(0) *1.0)/(total*1.0);
        this.debt_percent_initial = (debt.get(0) *1.0)/(total*1.0);
        this.gold_percent_initial = (gold.get(0) *1.0)/(total*1.0);
    }

    public void setSip(String[] op) {
        this.equity_sip = Long.parseLong(op[1]);
        this.debt_sip = Long.parseLong(op[2]);
        this.gold_sip = Long.parseLong(op[3]);
    }

    public void addChange(String[] op) {
        long equity_current = (long)Math.ceil((equity.get(equity.size() - 1) + equity_sip) * (100.0 + Double.parseDouble(op[1])))/100;
        equity.add(equity_current);
        long debt_current = (long)Math.ceil((debt.get(debt.size() - 1) + debt_sip) * (100.0+Double.parseDouble(op[2])))/100;
        debt.add(debt_current);
        long gold_current = (long)Math.ceil((gold.get(gold.size() - 1) + gold_sip) * (100.0 + Double.parseDouble(op[3])))/100;
        gold.add(gold_current);
    }


    public List<Long> getEquity() {
        return this.equity;
    }
    public List<Long> getDebt() {
        return this.debt;
    }
    public List<Long> getGold() {
        return this.gold;
    }

    public long getRebalanceEqity() {
        long total = equity.get(equity.size() - 1) + debt.get(debt.size() - 1) + gold.get(gold.size() - 1);
        return (long)Math.ceil(total * equity_percent_initial);
    }
    public long getRebalanceDebt() {
        long total = equity.get(equity.size() - 1) + debt.get(debt.size() - 1) + gold.get(gold.size() - 1);
        return (long)Math.ceil(total * debt_percent_initial);
    }
    public long getRebalanceGold() {
        long total = equity.get(equity.size() - 1) + debt.get(debt.size() - 1) + gold.get(gold.size() - 1);
        return (long)Math.ceil(total * gold_percent_initial);
    }
}
