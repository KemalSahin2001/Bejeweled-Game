public abstract class Symbol {
    private String shape;
    private Integer point;
    public String toString() {
        return this.shape;
    }
    public String getShape() {
        return shape;
    }
    public Integer getPoint() {
        return point;
    }
    public void setShape(String shape) {
        this.shape = shape;
    }
    public void setPoint(Integer point) {
        this.point = point;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((shape == null) ? 0 : shape.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Symbol other = (Symbol) obj;
        if (shape == null) {
            if (other.shape != null)
                return false;
        } else if (!shape.equals(other.shape))
            return false;
        return true;
    }   
}
