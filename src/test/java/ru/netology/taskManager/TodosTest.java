package ru.netology.taskManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка установить родителям",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {


        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQuery1TaskEpic() {
        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко"); // проверка epic (находится 1 задача)
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchQueryStart() {
        Task[] expected = {};
        Task[] actual = todos.search("обеда"); // проверка meeting start (запрос не должен быть найден)
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryIfNotExist() {
        Task[] expected = {};
        Task[] actual = todos.search("мыло"); // проверка когда не находится ни одна задача
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryIfFSomeResults() {
        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("родителям"); // проверка нескольких результатов
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryTopic() {
        Task[] expected = {meeting};
        Task[] actual = todos.search("3й"); // проверка meeting
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQuerySimpleTask() {
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить"); // проверка simpleTask
        Assertions.assertArrayEquals(expected, actual);
    }

}