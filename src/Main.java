import java.util.Scanner;
class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker trecker = new StepTracker(scanner);

        while (true) {

            printMenu();

            int i = scanner.nextInt();
            if (i == 1) {
                trecker.addNewNumberStepsPerDay();
            } else if (i == 2) {
                trecker.changeStepGoal();
            } else if (i == 3) {
                trecker.printStatistic();
            } else if (i == 0) {
                System.out.println("Пока!");
                scanner.close();
                return;
            }
             else{
                    System.out.println("Такой команды нет");
             }
        }
    }

    static void printMenu() {
        System.out.println("Ввод количества шагов в день - 1");
        System.out.println("Ввод цели по количеству шагов в день - 2");
        System.out.println("Вывод статистика за выбранный месяц - 3");
        System.out.println("выход - 0");
    }

}
