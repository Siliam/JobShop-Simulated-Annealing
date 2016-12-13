/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM.Gantt;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import org.jfree.chart.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.*;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.ui.ApplicationFrame;

public class ExempleGantt extends ApplicationFrame {

    public ChartPanel GanttChart;
    public static int[][][] LesTemps;
    public static int nb_Machines;
    public static int nb_Jobs;
    public static int Duree;
    public static int[] Permutations;
    public static TaskSeriesCollection collection;

    public ExempleGantt(String title, int[][][] LesTemps, int nb_Machines, int nb_Jobs, int Duree, int[] Permutations) {
        super(title);
        ExempleGantt.LesTemps = LesTemps;
        ExempleGantt.nb_Machines = nb_Machines;
        ExempleGantt.nb_Jobs = nb_Jobs;
        ExempleGantt.Duree = Duree;
        ExempleGantt.Permutations = Permutations;
        collection = new TaskSeriesCollection();

        IntervalCategoryDataset dataset = createDataset();

        final JFreeChart chart = ChartFactory.createGanttChart(
                "Diagramme de Gantt", // chart title
                "Machines", // domain axis label
                "Durée", // range axis label
                dataset, // data
                false, // include legend
                true, // tooltips
                false // urls
                );

        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        // plot.getDomainAxis().setMaxCategoryLabelWidthRatio(10.0f);
        final CategoryItemRenderer renderer = plot.getRenderer();
        CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.00"));
        renderer.setBaseItemLabelGenerator(generator);
        plot.getRenderer().setSeriesPaint(0, new Color(128, 0, 0));
        plot.getRenderer().setSeriesPaint(1, new Color(0, 0, 255));
        renderer.setSeriesPaint(0, Color.green);
        renderer.setBaseItemLabelsVisible(true);
        plot.setRenderer(new GRenderer(collection));

        // add the chart to a panel...
        GanttChart = new ChartPanel(chart,
                true, //propreties
                true, //save
                true, //print
                true, //zoom
                true);	//tooltips
        GanttChart.setPreferredSize(new java.awt.Dimension(200, 70));
        setContentPane(GanttChart);
    }

    public static IntervalCategoryDataset createDataset() {
        TaskSeries s1 = new TaskSeries("J1");

        // Parcourir la liste des machines
        for (int i = 0; i < nb_Machines; i++) {
            Task M = new Task("Machine M" + (i + 1),
                    new SimpleTimePeriod(new Integer(0), new Integer(Duree)));
            // Construire la suite des jobs
            for (int j = 0; j < nb_Jobs; j++) {
                Task J = new Task("J",
                        new SimpleTimePeriod(new Integer(LesTemps[j][i][0]), 
                                             new Integer(LesTemps[j][i][1])));
                M.addSubtask(J);
            }
            s1.add(M);
        }
        collection.add(s1);
        return collection;
    }
}
