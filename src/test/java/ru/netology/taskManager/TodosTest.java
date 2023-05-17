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
            "Приложение НетоБанка",
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
    public void shouldSearchQuery1() {
        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко"); // проверка epic
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQuery2() {
        Task[] expected = {};
        Task[] actual = todos.search("обеда"); // проверка meeting start
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQuery3() {
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("родителям"); // проверка simpleTask
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQuery4() {
        Task[] expected = {meeting};
        Task[] actual = todos.search("3й"); // проверка meeting
        Assertions.assertArrayEquals(expected, actual);
    }

}