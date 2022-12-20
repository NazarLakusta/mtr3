public class Solution {
    public static double Ux(double x) {
        return 0.01 * x * x;
    }

    public static double profit(double[] L) {
        return (L[0] + L[2]) * L[1];
    }

    public static double utility(double[] L) {
        return  0.5* Ux(L[0]) + 0.5 * Ux(L[2]);
    }

    public static double deterministicEquivalent(double[] L){
        return Math.sqrt(utility(L)/1);
    }
    public static double riskPremium(double[] L){
        return profit(L)-deterministicEquivalent(L);
    }
    public static String convexity(){
        if (0.2 > 0) {
            return "convexity down";
        }
        else if (0.2 < 0) {
            return "convexity up";
        }
        else {
            return "linear";
        }
    }

    public static String riskProneMain(String msg){
        if (msg == "convexity down") {
            return "A person who makes decisions is prone to risk";
        }
        else if (msg == "convexity up") {
            return "A person who makes decisions is not prone to risk";
        }
        else {
            return "A person who makes decisions is risk neutral";
        }
    }

    public static String choiceOfPerson(double[] L1, double[] L2, String msgRiskProne){
        if (msgRiskProne == "A person who makes decisions is prone to risk") {
            if (Math.abs(riskPremium(L1)) > Math.abs(riskPremium(L2))) {
                return "The person will choose the first lottery";
            }
            else {
                return "The person will choose the second lottery";
            }
        }
        else if (msgRiskProne == "A person who makes decisions is not prone to risk") {
            if (Math.abs(riskPremium(L1)) < Math.abs(riskPremium(L2))) {
                return "The person will choose the first lottery";
            }
            else {
                return "The person will choose the second lottery";
            }
        }
        else {
            return "A person will not care which lottery to choose";
        }
    }
    public static void main(String[] args) {
        double[] L1 = new double[]{3000, 0.5, 1000};

        double[] L2 = new double[]{4000, 0.5, 0};


        System.out.println("Profit loterry 1,2");
        System.out.println(profit(L1));
        System.out.println(profit(L2));

        System.out.println("\nExpected utility for loterrt 1,2");
        System.out.println(utility(L1));
        System.out.println(utility(L2));


        System.out.println("\nReady to risk: ");
        System.out.println(riskProneMain(convexity()));

        System.out.println("\nChoice of person: ");
        System.out.println(choiceOfPerson(L1,L2,riskProneMain(convexity())));
    }
}
