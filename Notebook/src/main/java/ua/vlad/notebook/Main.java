package ua.vlad.notebook;

import ua.vlad.notebook.controller.NotebookController;
import ua.vlad.notebook.model.Notebook;

import java.util.Scanner;

/**
 * Created by vlad on 06.11.16.
 */
public class Main {

    public static void main(String args[]) {
        View view = new View();
        Scanner in = new Scanner(System.in);
        Notebook notebook = new Notebook();
        NotebookController controller = new NotebookController(notebook, view, in);

        controller.processUser();
    }
}
