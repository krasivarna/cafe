import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name,int capacity){
        this.capacity=capacity;
        this.name=name;
        this.employees=new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if (this.employees.size()<this.capacity){
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        int index=-1;
        for(int i=0;i<employees.size();i++){
            if (employees.get(i).getName().equals(name)){
                index=i;
            };
        }
        if (index!=-1){
            employees.remove(index);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee(){
        return this.employees.stream().max((p1,p2)->Integer.compare(p1.getAge(), p2.getAge())).get();
    }

    public Employee getEmployee(String name){
        for(int i=0;i<employees.size();i++){
            if (employees.get(i).getName()==name){
                return employees.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder sb=new StringBuilder();
        for(Employee one:employees){
            sb.append(String.format("%s%n",one.toString()));
        }
        return sb.toString();
    }
}
