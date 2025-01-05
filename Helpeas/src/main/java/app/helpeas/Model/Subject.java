package app.helpeas.Model;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<String> nameSections;
    private String name;
    public Subject(String name) {
        nameSections = new ArrayList<String>();
        this.name = name;
    }
    public List<String> getNameSections() {
        return nameSections;
    }
    public void setNameSections(List<String> nameSections) {
        this.nameSections = nameSections;
    }
    public String getName() {
        return this.name;
    }
    public void addSection(String section){
        this.nameSections.add(section);
    }
}
