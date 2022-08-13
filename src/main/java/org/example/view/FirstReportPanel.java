package org.example.view;

import org.example.repository.LeaderRepository;
import org.example.util.JDBCUtilities;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FirstReportPanel extends JPanel {

    private static final String[] COLUMNS = {"Id", "Nombre", "Primer apellido", "Ciudad"};

    public FirstReportPanel() {
        var layout = new BorderLayout();
        setLayout(layout);
        setBackground(new Color(222,184,135));

        var label = new JLabel("First Report - Leaders");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        try {
            var repository = new LeaderRepository(JDBCUtilities.getConnection());

            var leaders = repository.findAll();
            var data = new Object[leaders.size()][COLUMNS.length];
            for (int i = 0; i < leaders.size(); i++) {
                var leader = leaders.get(i);
                data[i][0] = leader.getId();
                data[i][1] = leader.getName();
                data[i][2] = leader.getLastName();
                data[i][3] = leader.getCity();
            }

            var table = new JTable(new DefaultTableModel(data, COLUMNS));

            var scrollPane = new JScrollPane(table);

            add(scrollPane, BorderLayout.CENTER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
