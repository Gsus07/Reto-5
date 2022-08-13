package org.example.repository;

import org.example.models.Buy;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PurchaseRepository {
    private final Connection connection;

    public PurchaseRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Buy> searchAll() {
        List<Buy> buys = new ArrayList<>();
        try {
            var query = """
                    SELECT c.ID_Compra, p.Constructora, p.Banco_Vinculado FROM Compra c JOIN Proyecto p on p.ID_Proyecto = c.ID_Proyecto
                    WHERE c.Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'
                    """;
            var statement = connection.prepareStatement(query);

            var resultSet = statement.executeQuery();

            while (resultSet.next()) {
                var id = resultSet.getInt("ID_Compra");
                var builder = resultSet.getString("Constructora");
                var bank = resultSet.getString("Banco_Vinculado");

                buys.add(new Buy(id, builder, bank));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return buys;
    }
}
