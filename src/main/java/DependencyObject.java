/**
 * Created by sadknight on 04.08.16.
 */
//data file for question
public class DependencyObject {
    int id;
    int idDependency;

    public DependencyObject(int id, int idDependency) {
        this.id = id;
        this.idDependency = idDependency;
    }

    @Override
    public String toString() {
        return id +
                " " + idDependency;
    }
}
