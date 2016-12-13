package IHM.Gantt;

import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

public class GRenderer extends GanttRenderer {
    private static final int PASS = 2; // assumes two passes
    private List <Color> clut = new ArrayList<>();
    private TaskSeriesCollection model = null;
    private int row;
    private int col;
    private int index;
    
    public GRenderer(TaskSeriesCollection model) {
        this.model = model;
    }

    @Override
    public Paint getItemPaint(int row, int col) {
        if (clut.isEmpty() || this.row != row || this.col != col) {
            initClut(row, col);
            this.row = row;
            this.col = col;
            index = 0;
        }
        int clutIndex = index++ / PASS;
        return clut.get(clutIndex);
    }

    private void initClut(int row, int col) {
        clut.clear();
        Color c = (Color) super.getItemPaint(row, col);
        float[] a = new float[3];
        Color.RGBtoHSB(100, 200, 250, a);
        TaskSeries series = (TaskSeries) model.getRowKeys().get(row);
        List<Task> tasks = series.getTasks(); // unchecked
        int taskCount = tasks.get(col).getSubtaskCount();
        taskCount = Math.max(1, taskCount);
        for (int i = 0; i < taskCount; i++) {
            float r = (float)i / taskCount;
            clut.add(Color.getHSBColor(r, a[1], a[2]));
        }
    }
}