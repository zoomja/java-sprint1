class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > sumSteps) {
                sumSteps = days[i];
            }
        }
        return sumSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int steps = 0; steps < days.length; steps++) {
            if (days[steps] >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                if (finalSeries < currentSeries)
                    finalSeries = currentSeries;
                currentSeries = 0;
            }
        } return finalSeries;
    }

}
