package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Domain {

    public static void main(String[] args) {
//        session.beginTransaction();

/*
        Address address = new Address();
        address.setCountry("DC");
        address.setCity("Metro City");
        address.setStreet("Street 3");
        address.setPostCode("1234567");

        Employee employee = new Employee();
        employee.setFirstName("Clark");
        employee.setLastName("Kent");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1940, Calendar.FEBRUARY, 17);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Project project = new Project();
        project.setTitle("Super Man");

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        addressService.add(address);
        projectService.add(project);
        employeeService.add(employee);
*/

        AddressService addressService2 = new AddressService();
        addressService2.getAll().forEach(System.out::println);
        System.out.println(addressService2.getById((long) 389));

//        session.save(address);
//        session.save(employee);
//        session.save(project);

//        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
