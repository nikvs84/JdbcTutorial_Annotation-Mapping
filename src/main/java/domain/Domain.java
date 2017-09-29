package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Domain {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

//        session.beginTransaction();

        Address address = new Address();
        address.setCountry("DC");
        address.setCity("Gotham City");
        address.setStreet("Arkham Street 2");
        address.setPostCode("123456");

        Employee employee = new Employee();
        employee.setFirstName("Bruce");
        employee.setLastName("Wayne");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1940, Calendar.FEBRUARY, 17);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Project project = new Project();
        project.setTitle("Dark knight");

        Set<Project> projects = new HashSet<>();
//        projects.add(project);
        employee.setProjects(projects);

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        addressService.add(address);
//        employeeService.add(employee);
//        projectService.add(project);

//        session.save(address);
//        session.save(employee);
//        session.save(project);

//        session.getTransaction().commit();
//        HibernateUtil.shutdown();
    }
}
