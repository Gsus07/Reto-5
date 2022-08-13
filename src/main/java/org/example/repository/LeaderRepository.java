package org.example.repository;

import org.example.models.Leader;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeaderRepository {
    private final Connection connection;

    public LeaderRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Leader> findAll() {
        List<Leader> leaders = new ArrayList<>();
        try {
            var query = "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia";
            var statement = connection.prepareStatement(query);

            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                var id = resultSet.getInt("ID_Lider");
                var name = resultSet.getString("Nombre");
                var lastName = resultSet.getString("Primer_Apellido");
                var city = resultSet.getString("Ciudad_Residencia");
                leaders.add(new Leader(id, name, lastName, city));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return leaders;
    }
}
