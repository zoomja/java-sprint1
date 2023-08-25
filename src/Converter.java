public class Converter {
    int convertKm(int steps) {
        return (steps * 75 / 100000);
    }

    int convertKilocalor(int steps) {
        if (steps == 0) {
            return 0;
        }
        return steps * 50 / 1000;
    }
}
