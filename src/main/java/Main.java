import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //read from file
        List<String> fileLines = new ArrayList<String>();
        try {
            fileLines = Files.readAllLines(Paths.get(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //transfer String list to question list
        List<DependencyObject> dependencyObjectList = new ArrayList<DependencyObject>();
        for (String st : fileLines) {
            dependencyObjectList.add(new DependencyObject(Integer.parseInt(st.substring(0, st.lastIndexOf(" "))),
                    Integer.parseInt(st.substring(st.lastIndexOf(" ") + 1, st.length()))));
            System.out.println(dependencyObjectList.get(dependencyObjectList.size() - 1));
        }

        Set<CycleDependencyObject> cycleDependencyObjectSet = new HashSet<CycleDependencyObject>();
        //compare dependency object
        for (int i = 0; i < dependencyObjectList.size(); i++) {
            int id = dependencyObjectList.get(i).id;
            int depID = dependencyObjectList.get(i).idDependency;
            for (int j = i + 1; j < dependencyObjectList.size(); j++) {
                int tt = dependencyObjectList.get(j).idDependency;
                int tt1 = dependencyObjectList.get(j).id;
                if ((id == dependencyObjectList.get(j).idDependency) && (depID == dependencyObjectList.get(j).id)) {
                    cycleDependencyObjectSet.add(new CycleDependencyObject(id, depID, id));
                }
            }
        }
        //Write to file answer
        try {
            File fl = new File(Paths.get(args[0]).getParent().toString()+cycleDependencyObjectSet.size()+
                    ".txt");
            FileWriter fw = new FileWriter(fl,false);
        for (CycleDependencyObject cp : cycleDependencyObjectSet) {
         fw.write(cp.toString());
            fw.append('\n');
        }
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
