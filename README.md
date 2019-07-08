# EmployeePortalSG
Employee Portal For Societe Generale

Build Steps :

1. Import as Existing Gradle Project
2. Gradle Sync & Build
3. Run EmployeePortalMain as a normal Java Application [Default uses port 8080]

Launch Config :
For Application open URL : http://localhost:8080
For H2 Database console open URL : http://localhost:8080/h2-console

H2 In memory Db details :
JDBC URL: jdbc:h2:mem:employeeDB
User Name : SocGen
Password : Leave Empty
Note : Department Table Records are loaded from a sql script under resources folder

For Api Docs :
Launch http://localhost:8080/swagger-ui.html
