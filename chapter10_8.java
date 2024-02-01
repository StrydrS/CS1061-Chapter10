import java.util.LinkedList;

public class chapter10_8 {
    public static void main(String[] args) {
        LinkedList<Customer> customers = new LinkedList<>();
        Customer friend = new Customer("Pratima");

        customers.add(new Customer("Pranoj"));
        customers.add(new Customer("Rachel"));
        customers.add(new Customer("Peter"));
        customers.add(friend);
        customers.add(new Customer("Mohammad"));
        customers.add(new Customer("Jasur"));
        customers.add(new Customer("Shyan"));

        int index = customers.indexOf(friend);

        System.out.println(index);

        for(int i = 0; i < customers.size(); i++) {
            if(index == i) {
                Customer removed = customers.get(index + 1);
                customers.remove(removed);
                System.out.println(removed.NAME + " goes home.");
            }
        }
    }
}

class Customer { 
    String NAME;

    public Customer(String name) {
        this.NAME = name;
    }
    }

