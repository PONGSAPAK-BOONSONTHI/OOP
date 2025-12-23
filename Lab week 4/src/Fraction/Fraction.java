package Fraction;

public class Fraction {
    public int topN;
    public int btmN;
    
    public String toFraction() {
        return (topN + "/" + btmN) + "";
    }
    public String toFloat() {
        return ((double) topN / btmN) + "";
    }
    public void addFraction(Fraction f) {
        if (btmN == f.btmN) {
            topN = topN + f.topN;
        } else {
            topN = topN * f.btmN + f.topN * btmN;
            btmN = btmN * f.btmN;
        }
    }
    public boolean myEquals(Fraction f) {
        return this.toFloat().equals(f.toFloat());
    }
    public void LowestTermFrac() {
        int a = topN;
        int b = btmN;
        while (b != 0) {            
            int x = a % b;
            a = b;
            b = x;
        }
        int gcd = a;
        topN = topN / gcd;
        btmN = btmN / gcd;
    }
}
