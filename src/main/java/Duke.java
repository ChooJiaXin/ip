import duke.command.Parser;
import duke.exception.InvalidUserCommandException;
import duke.exception.StorageException;
import duke.storage.Storage;
import duke.storage.TaskList;
import duke.ui.Ui;

public class Duke {
    Storage storage;
    Ui ui;
    TaskList tasks;
    
    public Duke(String filePath) {
        this.storage = new Storage(filePath);
        this.ui = new Ui();
        try {
            this.tasks = storage.load();
        } catch (StorageException e) {
            ui.showErrorMessage(e);
        }
    }

    private void run() {
        ui.loadTaskList(tasks);
        ui.showGreetings();
        
        while (!Ui.EXIT) {
            String userCommand = ui.readUserCommand();
            try {
                Parser.parseCommands(userCommand, ui, storage);
            } catch (InvalidUserCommandException e) {
                ui.showErrorMessage(e);
            }
        }
    }
    
    public static void main(String[] args) {
        new Duke("data/tasks").run();
    }
}
