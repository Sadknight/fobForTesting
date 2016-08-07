/**
 * Created by sadknight on 04.08.16.
 */
//data file for answer
public class CycleDependencyObject {
    int object1;
    int object2;
    int object3;

    public CycleDependencyObject(int object1, int object2, int object3) {
        this.object1 = object1;
        this.object2 = object2;
        this.object3 = object3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CycleDependencyObject that = (CycleDependencyObject) o;

        if (object1 != that.object1) return false;
        if (object2 != that.object2) return false;
        return object3 == that.object3;

    }

    @Override
    public String toString() {
        return object1 +
                " " + object2 +
                " " + object3;
    }

    @Override
    public int hashCode() {
        int result = object1;
        result = 31 * result + object2;
        result = 31 * result + object3;
        return result;
    }
}
