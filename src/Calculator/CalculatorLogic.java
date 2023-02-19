package Calculator;

public class CalculatorLogic {
    public static String CalculateCase;
    public static Integer a;
    public static Integer b;
    public static String action;
    public static String mode;

    public static void start() {
        CalculatorLogic.reset();

        CalculatorLogic.CalculateCase = CalculatorInterface.getUserFormula();
        CalculatorLogic.ParseValues();
        CalculatorLogic.Calculate();

        CalculatorLogic.start();
    }

    public static void reset(){
        CalculatorLogic.a = null;
        CalculatorLogic.b = null;
        CalculatorLogic.mode = null;
        CalculatorLogic.action = null;
        CalculatorLogic.CalculateCase = null;
    }

    public static void Calculate(){
        int a = CalculatorLogic.a;
        int b = CalculatorLogic.b;

        switch (CalculatorLogic.action) {
            case "/" -> {
                int raw_result = a / b;
                CalculatorLogic.printResult(raw_result);
            }
            case "+" -> {
                int raw_result = a + b;
                CalculatorLogic.printResult(raw_result);
            }
            case "-" -> {
                int raw_result = a - b;
                CalculatorLogic.printResult(raw_result);
            }
            case "*" -> {
                int raw_result = a * b;
                CalculatorLogic.printResult(raw_result);
            }
        }

    }


    private static void printResult(Integer raw_result){
        if(CalculatorLogic.mode.equals("rome")){
            if(raw_result > 0){
                String result = CalculatorNums.arabicToRoman(raw_result);
                System.out.println("Result is: " + result);
            }else{
                throw new IllegalArgumentException("Rome numeric system not allow for negative numbers");
            }

        }else{
            System.out.println("Result is: " + raw_result);
        }
    }
    public static void ParseValues(){
        String[] values = CalculatorLogic.CalculateCase.split(" ");
        CalculatorLogic.action = values[1];

        if(values.length == 3){
            CalculatorLogic.a = ReplaceInt(values[0]);
            CalculatorLogic.b = ReplaceInt(values[2]);
        }else{
            throw new IllegalArgumentException("Invalid calc pattern (allowed: 1 + 1, X + IV, not allowed 1 + 1 + 1)");
        }
    }

    public static int ReplaceInt(String value) {
        char firstChar = value.charAt(0);
        String temp = null;

        if(CalculatorLogic.mode != null && !CalculatorLogic.mode.isEmpty()) {
            temp = CalculatorLogic.mode;
        }

        if(Character.isLetter(firstChar)){
            CalculatorLogic.mode = "rome";
            if(temp != null && !temp.equals(CalculatorLogic.mode)){
                throw new IllegalArgumentException("You can use only one numeric system (X + 1 not allowed)");
            }
            return CalculatorNums.RometoArab(value);
        }else{
            CalculatorLogic.mode = "arab";
            if(temp != null && !temp.equals(CalculatorLogic.mode)){
                throw new IllegalArgumentException("You can use only one numeric system (X + 1 not allowed)");
            }
            return Integer.parseInt(value);
        }
    }
}
