package org.example.repository;

import org.example.models.Project;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    private final Connection connection;

    public ProjectRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Project> searchAll() {
        var projects = new ArrayList<Project>();

        try {
            var query = """
                    SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad, Clasificacion
                    FROM Proyecto WHERE Clasificacion = 'Casa Campestre' AND
                    Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla')
                    """;
            var statement = connection.prepareStatement(query);

            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                var id = resultSet.getInt("ID_Proyecto");
                var builder = resultSet.getString("Constructora");
                var rooms = resultSet.getInt("Numero_Habitaciones");
                var city = resultSet.getString("Ciudad");
                projects.add(new Project(id, builder, rooms, city));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return projects;
    }
}
