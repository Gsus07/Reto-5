package org.example.view;

import org.example.repository.PurchaseRepository;
import org.example.util.JDBCUtilities;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ThirdReportPanel extends JPanel {

    private static final String[] COLUMNS = {"Id", "Constructora", "Banco"};

    public ThirdReportPanel() {
        var layout = new BorderLayout();
        setLayout(layout);
        setBackground(new Color(222,184,135));

        var label = new JLabel("Third Report - Buy");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        try {
            var repository = new PurchaseRepository(JDBCUtilities.getConnection());

            var purchases = repository.searchAll();
            var data = new Object[purchases.size()][COLUMNS.length];
            for (int i = 0; i < purchases.size(); i++) {
                var purchase = purchases.get(i);
                data[i][0] = purchase.getId();
                data[i][1] = purchase.getBuilder();
                data[i][2] = purchase.getBank();
            }

            var table = new JTable(new DefaultTableModel(data, COLUMNS));

            var scrollPane = new JScrollPane(table);

            add(scrollPane, BorderLayout.CENTER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
