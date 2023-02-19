package Calculator;

import java.util.Scanner;
public class CalculatorInterface {

    public static Scanner scanner = new Scanner(System.in);
    public static void start(Boolean is_Retry) {
        if(!is_Retry){
            CalculatorInterface.textHeader();
        }

        CalculatorInterface.textChose();

        String chose = CalculatorInterface.getUserChose();

        if(chose.equals("1")){
            CalculatorLogic.start();
        }else if(chose.equals("2")){
            System.out.println("Closing app...");
            return;
        }else{
            System.out.println("\n * Bad key, try again * \n");
            CalculatorInterface.start(true);
        }
    }
    private static void textHeader(){
        System.out.println("Hi, this is a my first Java App! \n");
    }

    private static void textChose(){
        System.out.println("Now you located in main menu, allowed commands:");
        System.out.println("1) Start calculate");
        System.out.println("2) Exit");
    }

    private static String getUserChose(){
        return CalculatorInterface.scanner.nextLine();
    }

    public static String getUserFormula(){
        System.out.println("Type your case for calculate: (example: 1 + 3 or II * IV)");
        return CalculatorInterface.scanner.nextLine();
    }
}
