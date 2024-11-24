package todoapp;

import todoapp.config.Database;
import todoapp.repositories.TodoListRepository;
import todoapp.repositories.TodoListRepositoryDbImpl;
import todoapp.services.TodoListService;
import todoapp.services.TodoListServiceImpl;
import todoapp.views.TodoListTerminalViewImpl;
import todoapp.views.TodoListView;

public class Main {
    public static void main(String[] args) {

        Database database = new Database("todo_si", "root", "", "localhost", "3306");
        database.setup();

        TodoListRepository todoListRepository = new TodoListRepositoryDbImpl(database);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListTerminalViewImpl(todoListService);
        todoListView.run();
    }
}
