# jee-test-app

## Technical hints

###Prepare Postgres DB

```
docker run -it --rm -p 5432:5432 -e POSTGRES_DB=courses -e POSTGRES_USER=courses -e POSTGRES_PASSWORD=courses postgres:12.5
```

```
mvn flyway:migrate
```

###Configure Wildfly

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


