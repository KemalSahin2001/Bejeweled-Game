public class Gamer  implements Comparable<Gamer>{
    private String name;
    private Integer point;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPoint() {
        return point;
    }
    public void setPoint(Integer point) {
        this.point = point;
    }
    public Gamer(String name, Integer point) {
        this.name = name;
        this.point = point;
    }
    @Override
    public int compareTo(Gamer o) {
        if (this.getPoint().equals(o.getPoint())) return 0;
        return this.getPoint().compareTo(o.getPoint());
    }
    @Override
    public String toString() {
        return  name + " " + point;
    }   
    
}
