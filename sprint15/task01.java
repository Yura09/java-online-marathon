import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
public class MyUtils {
	private Connection connection;
	private Statement statement;
	private String schemaName;
 
    public Connection createConnection() throws SQLException {
    	DriverManager.registerDriver(new org.h2.Driver());
		connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
		return connection;
    }
 
public void closeConnection() throws SQLException {

        connection.close();

    }

    public Statement createStatement() throws SQLException {
        statement = connection.createStatement();
        return statement;
    }

    public void closeStatement() throws SQLException {
        statement.close();
    }

    public void createSchema(String schemaName) throws SQLException {
        this.schemaName = schemaName;
        statement.executeUpdate("create schema " + schemaName);


        // code
    }

    public void dropSchema() throws SQLException {
        // code
        statement.executeUpdate("drop schema " + schemaName);
    }

    public void useSchema() throws SQLException {
        // code
      statement.execute("USE " + schemaName + ";");
    }

    public void createTableRoles() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Roles (\n"
                + "	id serial PRIMARY KEY,\n"
                + "	roleName varchar NOT NULL\n"
                + ");";
        statement.executeUpdate(sql);

    }

    public void createTableDirections() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Directions (\n"
                + "	id serial PRIMARY KEY,\n"
                + "	directionName varchar NOT NULL\n"
                + ");";
        statement.executeUpdate(sql);
    }

    public void createTableProjects() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Projects (\n"
                + "	id serial PRIMARY KEY,\n"
                + "	projectName varchar NOT NULL,\n"
                + " directionId integer not null,\n"
                + "  FOREIGN KEY (directionId) REFERENCES Directions(id) ON DELETE CASCADE"
                + ");";
        statement.executeUpdate(sql);
    }

    public void createTableEmployee() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Employee (\n"
                + "	id serial PRIMARY KEY,\n"
                + "	firstName varchar NOT NULL,\n"
                + " roleId integer not null,\n"
                + " projectId integer not null,\n"
                + "FOREIGN KEY (roleId) REFERENCES Roles(id) ON DELETE CASCADE,\n"
                + "FOREIGN KEY (projectId) REFERENCES Projects(id) ON DELETE CASCADE"
                + ");";
        statement.executeUpdate(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        // code
        statement.executeUpdate("Drop table " + tableName);
    }

    public void insertTableRoles(String roleName) throws SQLException {
        statement.executeUpdate("insert into roles(roleName) " + "values ('" + roleName + "')");

    }

    public void insertTableDirections(String directionName) throws SQLException {
        statement.executeUpdate("insert into directions(directionname) " + "values ('" + directionName + "')");
    }

    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        String query = " insert into projects (projectname , directionid) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, projectName);
        preparedStatement.setInt(2, getDirectionId(directionName));
        preparedStatement.executeUpdate();
    }

    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        String query = " insert into employee (firstName , roleid, projectid) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, firstName);
        preparedStatement.setInt(2, getRoleId(roleName));
        preparedStatement.setInt(3, getProjectId(projectName));
        preparedStatement.executeUpdate();
    }

    public int getRoleId(String roleName) throws SQLException {

        ResultSet rs = statement.executeQuery("select id from roles where rolename='" + roleName + "'");
        if (rs.next()) {
            return rs.getInt("id");
        }
        return 0;
    }

    public int getDirectionId(String directionName) throws SQLException {
        ResultSet rs = statement.executeQuery("select id from directions where directionname='" + directionName + "'");
        if (rs.next()) {
            return rs.getInt("id");
        }
        return 0;
        // code
    }

    public int getProjectId(String projectName) throws SQLException {
        ResultSet rs = statement.executeQuery("select id from projects where projectname='" + projectName + "'");
        if (rs.next()) {
            return rs.getInt("id");
        }
        return 0;
    }

    public int getEmployeeId(String firstName) throws SQLException {
        ResultSet rs = statement.executeQuery("select id from employee where firstname='" + firstName + "'");
        if (rs.next()) {
            return rs.getInt("id");
        }
        return 0;
    }

    public List<String> getAllRoles() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT rolename FROM roles");
        List<String> roles = new ArrayList<>();
        while (rs.next()) {
            roles.add(rs.getString("rolename"));
        }
        return roles;
    }

    public List<String> getAllDirestion() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT directionname FROM directions");
        List<String> directions = new ArrayList<>();
        while (rs.next()) {
            directions.add(rs.getString("directionname"));
        }
        return directions;
    }

    public List<String> getAllProjects() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT projectname FROM projects");
        List<String> projects = new ArrayList<>();
        while (rs.next()) {
            projects.add(rs.getString("projectname"));
        }
        return projects;
    }

    public List<String> getAllEmployee() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT firstname FROM employee");
        List<String> employees = new ArrayList<>();
        while (rs.next()) {
            employees.add(rs.getString("firstname"));
        }
        return employees;
    }

    public List<String> getAllDevelopers() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT firstname FROM employee inner join roles on employee.roleid=roles.id where rolename='Developer'");
        List<String> developers = new ArrayList<>();
        while (rs.next()){
            developers.add(rs.getString("firstname"));
        }
        return developers;
    }

    public List<String> getAllJavaProjects() throws SQLException {
      ResultSet rs=statement.executeQuery("select projectname from projects inner join directions on projects.directionid = directions.id where directionname='Java'");
        List<String> projects = new ArrayList<>();
        while (rs.next()){
            projects.add(rs.getString("projectname"));
        }
        return projects;
    }

    public List<String> getAllJavaDevelopers() throws SQLException {
     ResultSet rs=statement.executeQuery("select firstname from employee inner join projects on projects.id=employee.projectid inner join roles on employee.roleid = roles.id inner join directions d on projects.directionid = d.id where directionname='Java' and rolename='Developer'" );
        List<String> employee = new ArrayList<>();
        while (rs.next()){
            employee.add(rs.getString("firstname"));
        }
        return employee;
    }

}

