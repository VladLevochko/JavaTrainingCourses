package ua.vlad.notebook.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 06.11.16.
 */
public class Notebook {

    private List<NotebookRecord> records;

    public Notebook() {
        records = new ArrayList<>();
    }

    public void addRecord(NotebookRecord record) {
        records.add(record);
    }

    public void empty() {
        records.clear();
    }

    public List<NotebookRecord> getRecords() {
        return records;
    }
}
