package lebui.blogx.shared.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "parent", fetch=FetchType.LAZY)
    private Set<Child> children;

    public Parent() {
        children = new HashSet<>();
    }

    public Parent(String name) {
        super();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Set<Child> children) {
        this.children = children;
    }
    
    public void addChild(Child child) {
        child.setParent(this);
        children.add(child);
    }

    @Override
    public String toString() {
        return "Parent [name=" + name + ", children=" + children + "]";
    }

}
