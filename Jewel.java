public class Jewel extends Symbol{
    public Jewel(String shape) {
        setShape(shape);
        switch (shape) {
            case "D":
                setPoint(30);
                break;
            case "S": 
            case "T":
                setPoint(15);
                break;
            case "W":  
                setPoint(10);
                break;           
        }
    }       
}
