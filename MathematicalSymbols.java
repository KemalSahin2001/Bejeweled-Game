public class MathematicalSymbols extends Symbol{

    public MathematicalSymbols(String shape) {
        setShape(shape);
        switch (shape) {           
            case "/":
            case "-":
            case "+":
            case "\\":
            case "|":
                setPoint(20);
                break;
        }
    }
    
}
