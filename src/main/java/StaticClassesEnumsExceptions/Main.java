package StaticClassesEnumsExceptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger Logger= LogManager.getLogger(Calculator.class);
    public static void main(String[] args) {

        double result = Calculator.calculate(2, 3, Calculator.Type.MULTIPLICATION);
        System.out.println("result: " + result);
        Logger.info("result"+ result);


        try {
        result = Calculator.calculate(22, 3, null);
        System.out.println("result: " + result);
            Logger.info("result"+ result);
      }
                catch (Exception err){
            System.out.println("Something bad has happened ");
                    Logger.error("Something bad has happened ", err);

        }

        result = Calculator.calculate(244, 3, Calculator.Type.SUBTRACTION);
        System.out.println("result: " + result);
        Logger.info("result"+ result);

        result = Calculator.calculate(244, 3, Calculator.Type.DIVISION);
        System.out.println("result: " + result);
        Logger.info("result"+ result);
    }
}
