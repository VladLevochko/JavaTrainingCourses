package ua.vlad.notebook.controller;

import ua.vlad.notebook.View;
import ua.vlad.notebook.globalvariables.MenuCommands;
import ua.vlad.notebook.model.Notebook;

import java.util.Scanner;

/**
 * Created by vlad on 06.11.16.
 */
public class NotebookController {

    private View view;
    private Notebook notebook;
    private Scanner scanner;
    private RecordController recordController;

    /**
     * Constructor
     * @param notebook object of Notebook
     * @param view View object
     * @param scanner Scanner object
     */
    public NotebookController(Notebook notebook, View view, Scanner scanner) {
        this.notebook = notebook;
        this.view = view;
        this.scanner = scanner;
        recordController = new RecordController(scanner, view);
    }

    /**
     * read user's commands and perform it
     */
    public void processUser() {
        view.printMessage(View.GREETING);

        String command;
        boolean exit = false;
        do {
            view.printMessage(MenuCommands.COMMANDS);
            command = scanner.nextLine();
            switch (command) {
                case MenuCommands.ADD:
                    notebook.addRecord(recordController.processRecord());
                    break;
                case MenuCommands.SHOW_ALL:
                    view.printRecords(notebook.getRecords());
                    break;
                case MenuCommands.EXIT:
                    view.printMessage("goodbye!");
                    exit = true;
                    break;
                default:
                    view.printMessage(View.INCORRECT_COMMAND);
            }
        } while(!exit);
    }
}
