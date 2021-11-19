# jee-test-app

## Technical hints

### Prepare Postgres DB

```
docker run -it --rm -p 5432:5432 -e POSTGRES_DB=courses -e POSTGRES_USER=courses -e POSTGRES_PASSWORD=courses postgres:12.5
```

```
mvn flyway:migrate
```

### Configure Wildfly

Extract `src/test/resources/misc/wildfly/postgres_driver.zip` into `$WILDFLY_HOME/modules`

Add a datasource into `$WILDFLY_HOME/standalone/configuration/standalone.xml` under `<subsystem xmlns="urn:jboss:domain:datasources...">/<datasoures>`

```
<datasource jndi-name="java:jboss/datasources/CoursesDS" pool-name="CoursesDS" enabled="true">
    <connection-url>jdbc:postgresql://localhost:5432/courses</connection-url>
    <driver>postgresql</driver>
    <security>
        <user-name>courses</user-name>
        <password>courses</password>
    </security>
</datasource>
```

Add a postgres driver into `$WILDFLY_HOME/standalone/configuration/standalone.xml` under `<subsystem xmlns="urn:jboss:domain:datasources...">/<drivers>`

```
<driver name="postgresql" module="org.postgresql">
    <driver-class>org.postgresql.Driver</driver-class>
</driver>
```

Set Property
```
cheetunit.enabled=true
```

## Dojo tasks

### Generel
****
#### Preparation

Build and deploy application. You must see the start page with two tables: courses and persons.



#
### JPA
****
#### Dependencies

 - The fields `Course.teacher` and `Person.coursesTeached` are marked transient. Repair them to implement bidirectional Many-To-One / One-To-Many relationship.
One teacher may have many courses. But one course has always only one teacher. This relationship is implemented via DB-Column `course.teacher_id`
 - The fields `Course.participants` and `Person.coursesParticipating` are marked transient. Repair them to implement bidirectional Many-To-Many relationship.
One course may have many participants. And one person may participate on multiple courses. This relationship is implemented vie DB-Table `course_participation(course_id, person_id)`

Test result: the columns "Teacher" and "Number of participants" must be filled



#
### JSF
****
#### CRUD

- Implement `PersonEditController.init` method according comments
- Extend button Save on the page "person" such that PersonEditController.save action will be called
- Extend button Delete on the page "person" such that PersonEditController.delete action will be called
- Extend button Back on the page "person" such that PersonEditController.back action will be called
- Implement `PersonEditController.save` method to save the current changes on a person according comments
- Implement `PersonEditController.delete` method to delete current person according comments
- Implement `PersonEditController.back` method to go to the start page

Test functionality in the application by performing corresponding actions and controlling the results.



#
### Validation
****
#### Bean Validation
Implement Validation on `PersonDto`, such that only letters in firstname and lastname are accepted



#
### Debugging
****

As it can be seen on the start page the ending date of each course is always the next day after the beginning date.
But DB has correct duration values. Debug application to repair the problem.



#
### CDI
****
#### Duration logger

Make an interceptor for business methods that logs out the method name and duration. Example
```
public class GuiPersonService {
    
    @Duration
    public PersonDto findPersonById(Long id) {
        return mapper.personToDto(personService.getPersonById(id));
    }
}
```



#
### JSF2
****
#### Search

Implement a page to search courses by participant name:
- Create a page `/app/search?by=<search string>`
- Create a controller for the page
- Create a named query on Course to find courses containing participants, such that the search string is the part of their name.
- Extend a CourseService by a new method to find courses by the search string
- Show the result on the page. You can reuse the table for the courses from the main page.


#
### Unit-Testing with Mockito
****

Implement a Mockito test in `PersonServiceTest` using hints in comments.
