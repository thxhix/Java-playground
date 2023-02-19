package Calculator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class CalculatorNums {

    enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private final int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }
    }
    static String[] Rome = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
            "IX", "V", "IV", "I"};
    static int[] Arab = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static int RometoArab(String rome){
        StringBuilder romeNumber = new StringBuilder(rome);
        int arabNumber = 0, i = 0;
        // Проверяем переданную строку на наличие символов
        if (romeNumber.length() > 0) {
            while (true) {
                do {

                    if (Rome[i].length() <= romeNumber.length()) {
                        // Выделяем из строки подстроку и сравниваем со
                        // значением из массива Arab
                        if (Rome[i].equals(romeNumber.substring(0,
                                Rome[i].length()))) {
                            // После чего прибавляем число соответствующее
                            // индексу элемента римской цифры из массива Arab
                            arabNumber += Arab[i];
                            // и удаляем из строки римскую цифру
                            romeNumber.delete(0, Rome[i].length());
                            if (romeNumber.length() == 0)
                                return arabNumber;
                        } else
                            break;
                    } else
                        break;
                } while (true && romeNumber.length() != 0);
                i++;
            }
        }
        return 0;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
