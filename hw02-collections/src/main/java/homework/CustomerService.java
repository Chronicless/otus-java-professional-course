package homework;


import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private TreeMap<Customer,String> customers = new TreeMap<>(Comparator.comparing(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        return getCopy(customers.firstEntry()); // это "заглушка, чтобы скомилировать"
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return getCopy(customers.higherEntry(customer)); // это "заглушка, чтобы скомилировать"
    }

    public void add(Customer customer, String data) {
        customers.put((Customer) customer, data);
    }

    private Map.Entry<Customer, String> getCopy(Map.Entry<Customer, String> entry) {

        return entry!= null? new AbstractMap.SimpleImmutableEntry<>(new Customer(entry.getKey().getId(), entry.getKey().getName(), entry.getKey().getScores()), entry.getValue()):null;
    }

}
