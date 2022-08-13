package org.example.view;

import javax.swing.*;
import java.awt.*;

public class InitialPanel extends JPanel {

    public InitialPanel() {
        var layout = new BorderLayout();
        setLayout(layout);
        setBackground(new Color(222,184,135));

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("First Report", new FirstReportPanel());
        tabbedPane.addTab("Second Report", new SecondReportPanel());
        tabbedPane.addTab("Third Report", new ThirdReportPanel());

        add(tabbedPane);
    }
}
