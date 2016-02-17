/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracownicy;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

public class LineChart extends JFrame implements Observer {

    private final Worker worker;
    private static DefaultCategoryDataset data;
    private final Subject subject;

    public LineChart(String applicationTitle, String chartTitle, Worker worker,Subject subject) {
        super(applicationTitle);
        this.worker = worker;
        this.subject = subject;
        this.subject.attach(this);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Worker", "Salary",
                createDataset(worker),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset(Worker product) {
        data = new DefaultCategoryDataset();
        // tu trzeba zrobic liste workerow 
        // przejsc o niej i zapisac pracownika i pensje
        return null ;
    }

    public void addValue(Worker worker) {
        data.clear();
        
    }

    public static void run(Worker worker,Subject subject) {
        LineChart chart = new LineChart(
                "Workers",
                "Salary", worker,subject);

        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }

    @Override
    public void update() {
        addValue(worker);

    }
}
