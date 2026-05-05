
public class ViDuDinhNghia {
    public static void main(String[] args) {
        // doesnt do
    }
}

class Student {
    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toHelloString(){
        return "Hello [id: " + this.getId() + " name : " + this.getName() + "] ";
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

abstract class StudentAbstract {
    private Integer id;
    private String name;

    public StudentAbstract(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract String toHelloString();

}

interface HasSchoolObject {

    public abstract String toHelloString();
} 

class Student1 extends Student {

    public Student1(Integer id, String name) {
        super(id, name);
    }
    
} 

class Student2 extends StudentAbstract {

    public Student2(Integer id, String name) {
        super(id, name);
    }

    @Override
    public String toHelloString() {
        return "Hello [id: " + this.getId() + " name : " + this.getName() + "] ";
    }

    
    
}

class Student3 implements HasSchoolObject{

    private Integer id;
    private String name;

    public Student3(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toHelloString() {
        return "Hello [id: " + this.getId() + " name : " + this.getName() + "] ";
    }
    
}