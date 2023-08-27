import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();


    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void changeStepGoal() {
        System.out.println("Введите цель на день.");
        int goal = scanner.nextInt();
        if(goal <= 0) {
            System.out.println("Значение больжно быть больше нуля");
            return;
        }
        goalByStepsPerDay = goal;
    }

    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if(month < 1 || month > 12) {
            System.out.println("Неверный номер месяца");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 0 || day > 30) {
            System.out.println("Неверные данные");
            return;
        }


        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Неверное количество шагов");
            return;
        }


        MonthData monthData = monthToData[month - 1];

        monthData.days[day -1] = steps;
    }

    void printStatistic() {
        System.out.println("Введите число месяца");
        MonthData monthData = monthToData[scanner.nextInt() - 1];
        int sumSteps = monthData.sumStepsFromMonth();
        monthData.printDaysAndStepsFromMonth(); // вывод общей статистики по дням
        System.out.println("Общее количество шагов за месяц " + sumSteps); // вывод суммы шагов за месяц
        System.out.println("Макс. количество шагов " + monthData.maxSteps()); // вывод максимального пройденного количества шагов за месяц
        System.out.println("Среднее количество шагов " + (sumSteps / monthData.days.length));       // вывод среднего пройденного количества шагов за месяц
        System.out.println("Дистанция в км за месяц " + converter.convertKm(sumSteps));
        System.out.println("Калории за месяц " + converter.convertKilocalor(sumSteps)); // вывод количества сожжённых килокалорий за месяц
        System.out.println("Лучшая серия " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println(); //дополнительный перенос строки
    }

}