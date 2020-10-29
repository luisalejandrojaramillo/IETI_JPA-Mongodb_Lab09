package eci.ieti;

import eci.ieti.data.CustomerRepository;
import eci.ieti.data.ProductRepository;
import eci.ieti.data.TodoRepository;
import eci.ieti.data.UserRepository;
import eci.ieti.data.model.Customer;
import eci.ieti.data.model.Product;

import eci.ieti.data.model.Todo;
import eci.ieti.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        customerRepository.deleteAll();
        userRepository.deleteAll();
        todoRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");

        customerRepository.findAll().stream().forEach(System.out::println);
        System.out.println();

        productRepository.deleteAll();

        productRepository.save(new Product(1L, "Samsung S8", "All new mobile phone Samsung S8"));
        productRepository.save(new Product(2L, "Samsung S8 plus", "All new mobile phone Samsung S8 plus"));
        productRepository.save(new Product(3L, "Samsung S9", "All new mobile phone Samsung S9"));
        productRepository.save(new Product(4L, "Samsung S9 plus", "All new mobile phone Samsung S9 plus"));
        productRepository.save(new Product(5L, "Samsung S10", "All new mobile phone Samsung S10"));
        productRepository.save(new Product(6L, "Samsung S10 plus", "All new mobile phone Samsung S10 plus"));
        productRepository.save(new Product(7L, "Samsung S20", "All new mobile phone Samsung S20"));
        productRepository.save(new Product(8L, "Samsung S20 plus", "All new mobile phone Samsung S20 plus"));
        productRepository.save(new Product(9L, "Samsung S20 ultra", "All new mobile phone Samsung S20 ultra"));

        User user1 = userRepository.save(new User(1L,"Luis Jaramillo","luis@mail.com"));
        User user2 = userRepository.save(new User(2L,"Alejandro Jaramillo","alejo@mail.com"));
        User user3 = userRepository.save(new User(3L,"Pepito Perez","pepe@mail.com"));
        User user4 = userRepository.save(new User(4L,"Son Goku","goku@mail.com"));
        User user5 = userRepository.save(new User(5L,"Johny Cage","johny@mail.com"));
        User user6 = userRepository.save(new User(6L,"Juan Luis","juan@mail.com"));
        User user7 = userRepository.save(new User(7L,"Cristiano Ronaldo","cristiano@mail.com"));
        User user8 = userRepository.save(new User(8L,"Lionel Messi","messi@mail.com"));
        User user9 = userRepository.save(new User(9L,"James Rodriguez","james@mail.com"));
        User user10 = userRepository.save(new User(10L,"Camila Suarez","cami@mail.com"));


        todoRepository.save(new Todo("Primer Todo",1,new Date(System.currentTimeMillis() + 99999),user1,"Ready"));
        todoRepository.save(new Todo("Segundo Todo",5,new Date(System.currentTimeMillis()+ 9999),user2,"Readys"));
        todoRepository.save(new Todo("Tercer Todo",8,new Date(System.currentTimeMillis()- 9999),user3,"Ready"));
        todoRepository.save(new Todo("Cuarto Todo",5,new Date(System.currentTimeMillis()-999),user4,"Ready"));
        todoRepository.save(new Todo("Quinto Todo",6,new Date(System.currentTimeMillis()-9999),user5,"Ready"));
        todoRepository.save(new Todo("Sexto Todo",10,new Date(System.currentTimeMillis()- 9999),user6,"In Progress"));
        todoRepository.save(new Todo("Septimo Todo",6,new Date(System.currentTimeMillis()+999),user7,"In Progress"));
        todoRepository.save(new Todo("Octavo Todo",7,new Date(System.currentTimeMillis()+99999),user7,"In Progress"));
        todoRepository.save(new Todo("Noveno Todo",7,new Date(System.currentTimeMillis()-99999),user7,"In Progress"));
        todoRepository.save(new Todo("Decimo Todo",7,new Date(System.currentTimeMillis()- 99999),user6,"In Progress"));
        todoRepository.save(new Todo("Onceavo Todo",9,new Date(System.currentTimeMillis()+9999),user6,"In Progress"));
        todoRepository.save(new Todo("Doceavo Todo",1,new Date(System.currentTimeMillis()+ 99999),user1,"Done"));
        todoRepository.save(new Todo("Treceavo Todo",20,new Date(System.currentTimeMillis()- 99999),user1,"Done"));
        todoRepository.save(new Todo("Catorceavoaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa Todo",4,new Date(System.currentTimeMillis()+ 9999),user1,"Done"));
        todoRepository.save(new Todo("Quinceavoaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa Todo",20,new Date(System.currentTimeMillis()+99999),user2,"Done"));
        todoRepository.save(new Todo("16 Todo",12,new Date(System.currentTimeMillis()+99999),user3,"Done"));
        todoRepository.save(new Todo("17 Todo",13,new Date(System.currentTimeMillis()- 9999),user4,"Done"));
        todoRepository.save(new Todo("18 Todo",7,new Date(System.currentTimeMillis()+99),user6,"Ready"));
        todoRepository.save(new Todo("19 Todo",2,new Date(System.currentTimeMillis()+999),user5,"Ready"));
        todoRepository.save(new Todo("20 Todo",11,new Date(System.currentTimeMillis()-9999),user8,"Ready"));
        todoRepository.save(new Todo("21 Todo",14,new Date(System.currentTimeMillis()+99999),user8,"In Progress"));
        todoRepository.save(new Todo("22 Todo",5,new Date(System.currentTimeMillis()-99999),user9,"In Progress"));
        todoRepository.save(new Todo("23 Todo",6,new Date(System.currentTimeMillis()+ 9999),user10,"Done"));
        todoRepository.save(new Todo("24 Todo",7,new Date(System.currentTimeMillis()+99999),user9,"Done"));
        todoRepository.save(new Todo("25 Todo",8,new Date(System.currentTimeMillis()-999),user8,"Done"));


        System.out.println("Query 1: Todos where the dueDate has expired");
        Query query = new Query();
        query.addCriteria(Criteria.where("dueDate").lt(new Date()));
        List<Todo> lateTodo = mongoOperation.find(query,Todo.class);
        System.out.println("TODOs Vencidos: "+lateTodo.size());
        for(Todo todo: lateTodo){
            System.out.println(todo.toString());
        }

        System.out.println("Query 2: Todos that are assigned to given user and have priority greater equal to 5");
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("priority").gt(5));
        List<Todo> grear5Todo = mongoOperation.find(query2,Todo.class);
        System.out.println("Great than 5: "+grear5Todo.size());
        for(Todo todo: grear5Todo){
            System.out.println(todo.toString());
        }

        System.out.println("Query 3: Users that have assigned more than 2 Todos.");
        userRepository.findAll().stream().forEach(user -> {
            Query query3 = new Query();
            query3.addCriteria(Criteria.where("responsible").is(user));
            if (mongoOperation.find(query3, Todo.class).size() >= 2)
                System.out.print(user.getEmail()+", ");
        });
        System.out.println();



        System.out.println("Query 4: Todos that contains a description with a length greater than 30 characters");
        Query query4 = new Query();
        query4.addCriteria(Criteria.where("description").regex(".{30,}"));
        List<Todo> todo4 = mongoOperation.find(query4,Todo.class);
        for(Todo todo: todo4){
            System.out.println(todo.toString());
        }

        /**
        System.out.println("Paginated search of products by criteria:");
        System.out.println("-------------------------------");
        productRepository.findByDescriptionContaining("plus", PageRequest.of(0, 2)).stream()
        	.forEach(System.out::println);
        System.out.println();*/
    }

}