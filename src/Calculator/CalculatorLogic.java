package Calculator;

public class CalculatorLogic {
    public static String CalculateCase;
    public static Integer a;
    public static Integer b;
    public static String action;

    public static void start() {
        // TODO: Validate case

        CalculatorLogic.CalculateCase = CalculatorInterface.getUserFormula();
        CalculatorLogic.ParseValues();
        CalculatorLogic.Calculate();
    }

    public static void Calculate(){
        int a = CalculatorLogic.a;
        int b = CalculatorLogic.b;
        int result;

        switch (CalculatorLogic.action) {
            case "/" -> {
                result = a / b;
                System.out.println("Result is: " + result);
            }
            case "+" -> {
                result = a + b;
                System.out.println("Result is: " + result);
            }
            case "-" -> {
                result = a - b;
                System.out.println("Result is: " + result);
            }
            case "*" -> {
                result = a * b;
                System.out.println("Result is: " + result);
            }
        }

    }

    public static void ParseValues(){
        String[] values = CalculatorLogic.CalculateCase.split(" ");
        CalculatorLogic.action = values[1];

        if(values.length == 3){
            CalculatorLogic.a = Integer.valueOf(ReplaceInt(values[0]));
            CalculatorLogic.b = Integer.valueOf(ReplaceInt(values[2]));
        }else{
            System.out.println("Error");
        }
    }

    public static String ReplaceInt(String value){
        switch (value) {
            case "I" -> {
                return "1";
            }
            case "II" -> {
                return "2";
            }
            case "III" -> {
                return "3";
            }
            case "IV" -> {
                return "4";
            }
            case "V" -> {
                return "5";
            }
            case "VI" -> {
                return "6";
            }
            case "VII" -> {
                return "7";
            }
            case "VIII" -> {
                return "8";
            }
            case "IX" -> {
                return "9";
            }
            case "X" -> {
                return "10";
            }
            default -> {
                return value;
            }
        }
    }
}
