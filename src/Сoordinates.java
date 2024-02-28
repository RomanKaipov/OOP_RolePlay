import java.util.ArrayList;
import java.util.List;

public class Сoordinates {
    protected int x, y;

    public Сoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<Integer> GetСoordinates (int x, int y){
        List<Integer> coordinates = new ArrayList<>();
        coordinates.add(x);
        coordinates.add(y);
        return coordinates;

    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public float calculateDistance(Сoordinates coordinates) {
        return (float) Math.sqrt(Math.pow(this.x - coordinates.x, 2) + Math.pow(this.y - coordinates.y, 2));
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
