import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double a, double y, int d) { //с такими названиями параметров не сразу понимаешь, какие аргументы принимаются
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return setRound(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return setRound(amount + amount * yearRate * depositPeriod, 2);
    }

    double setRound(double value, int places) {
        double ScaLe = Math.pow(10, places); //Не забывай про lowerСamelCase для названий переменных
        return Math.round(value * ScaLe) / ScaLe;
    }

    void setDeposit() {
        int period;
        int action;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = in.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = in.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = in.nextInt();
        double sumDeposit = 0;
        if (action == 1)
            sumDeposit = calculateSimplePercent(amount, 0.06, period);
        else if (action == 2) {
            sumDeposit = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + sumDeposit);
    }

    public static void main(String[] args) {
        new DepositCalculator().setDeposit();
    }
}

