package exercises.src.zb;

import java.util.Scanner;

// 강은영
// 2022.8.15(월) 20h25
public class Mini8 {

    private static int[] taxBasis = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
    private static int[] taxRate = {6, 15, 24, 35, 38, 40, 42, 45};
    private static int[] progressiveDeduction = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("과세금액 계산 프로그램");
        System.out.print("연소득을 입력해 주세요.: ");

        int yearlyIncome = scanner.nextInt();

        int totalTax = 0;
        int taxCategory = 0;

        for (int i = 0; i < taxBasis.length; i++) {
            if (yearlyIncome <= taxBasis[i]) {
                taxCategory = i;
                totalTax = calculateTotalTax(yearlyIncome, taxCategory);
                break;
            } /* else if (yearlyIncome > taxBasis[taxBasis.length - 1]) {
                totalTax = calculateTotalTax(yearlyIncome, taxRate.length - 1);
            } */ else {
                continue;
            }
        }

        System.out.println("[세율에 의한 세금]: " + totalTax);
        System.out.println("[누진공제 계산에 의한 세금]: " + calculateProgressiveTax(yearlyIncome, taxCategory));
    }

    public static int calculateTotalTax(int yearlyIncome, int taxCategory) {
        int totalTax = 0;
        int newTaxBasis = yearlyIncome;

        for (int j = 0; j <= taxCategory; j++) {
            if (j < taxCategory) {
                newTaxBasis = yearlyIncome - taxBasis[j];

                if (j != 0) {
                    for (int k = 0; k < j; k++) {
                        taxBasis[j] -= taxBasis[k];
                    }
                }

                totalTax += calculateTaxByBasis(taxBasis[j], taxRate[j]);
            } else {
                totalTax += calculateTaxByBasis(newTaxBasis, taxRate[j]);
            }
        }

        return totalTax;
    }

    public static int calculateTaxByBasis(int taxBasis, int taxRate) {
        int taxByBasis = taxBasis * taxRate / 100;

        String format = String.format("%10d * %2d%% = \t%10d", taxBasis, taxRate, taxByBasis);
        System.out.println(format);

        return taxByBasis;
    }

    public static int calculateProgressiveTax(int yearlyIncome, int taxCategory) {
        int progressiveTax = yearlyIncome * taxRate[taxCategory] / 100 - progressiveDeduction[taxCategory];
        return progressiveTax;
    }
}
