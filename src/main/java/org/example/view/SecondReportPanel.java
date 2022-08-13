package org.example.view;

import org.example.repository.ProjectRepository;
import org.example.util.JDBCUtilities;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SecondReportPanel extends JPanel {

    private static final String[] COLUMNS = {"Id", "Constructora", "Habitaciones", "Ciudad"};

    public SecondReportPanel() {
        var layout = new BorderLayout();
        setLayout(layout);
        setBackground(new Color(222,184,135));

        var label = new JLabel("Second Report - Projects");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        try {
            var repository = new ProjectRepository(JDBCUtilities.getConnection());

            var projects = repository.searchAll();
            var data = new Object[projects.size()][COLUMNS.length];
            for (int i = 0; i < projects.size(); i++) {
                var project = projects.get(i);
                data[i][0] = project.getId();
                data[i][1] = project.getBuilder();
                data[i][2] = project.getRooms();
                data[i][3] = project.getCity();
            }

            var table = new JTable(new DefaultTableModel(data, COLUMNS));

            var scrollPane = new JScrollPane(table);

            add(scrollPane, BorderLayout.CENTER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
