package onetoone.Orders;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import onetoone.Users.Employee;

/**
 * @author Peter Yehl
 */

@Entity
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String date;
    private String image;
    private String totalPrice;

    private String numberOfItems;

    private String pricePerItem;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToMany(mappedBy = "orders")
    @JsonIgnore
    private Set<Item> items = new HashSet<>();

    public Order(String name, String date, String image, String totalPrice){
        this.name = name;
        this.date = date;
        this.image = image;
        this.totalPrice = totalPrice;
    }

    public Order(){
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getImage(){
        return image;
    }

    public void setImage(String image){
        this.image = image;
    }

    public String getTotalPrice(){
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice){
        this.totalPrice = totalPrice;
    }

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public Set<Item> getItems(){
        return items;
    }

    public void setItems(Set<Item> items){
        this.items = items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

}
