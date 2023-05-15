package ru.netology.taskManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TaskTest {

    @Test
    public void testTrueOrFalseSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertTrue(simpleTask.matches("Позвонить")); // проверка существующейго слова
        Assertions.assertTrue(simpleTask.matches("Позвонить родителям")); // проверка существующего словосочетания
        Assertions.assertFalse(simpleTask.matches("позвонить")); // проверка регистра
        Assertions.assertFalse(simpleTask.matches("боссу")); //проверка несуществующей строки
    }

        @Test
        public void testTrueOrFalseMeeting() {
            Meeting meeting = new Meeting(
                    555,
                    "Выкатка 3й версии приложения",
                    "Приложение НетоБанка",
                    "Во вторник после обеда");

            Assertions.assertTrue(meeting.matches("Выкатка")); // проверка поиска в topic
            Assertions.assertFalse(meeting.matches("выкатка")); // проверка поиска в topic регистр
            Assertions.assertFalse(meeting.matches("Выкатку")); // проверка поиска в topic окончание
            Assertions.assertFalse(meeting.matches("Обновление")); // проверка поиска отсутствующего слова
            Assertions.assertTrue(meeting.matches("НетоБанка")); // проверка поиска в project
            Assertions.assertTrue(meeting.matches("НетоБанк")); // проверка поиска в project без окончания
            Assertions.assertFalse(meeting.matches("Нетобанка")); // проверка поиска в project регистр
            Assertions.assertFalse(meeting.matches("вторник")); // проверка поиска в start
        }
    @Test
    public void testTrueOrFalseEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Epic epicEmpty = new Epic(55, new String[]{});

        Assertions.assertTrue(epic.matches("Молоко")); // проверка поиска
        Assertions.assertFalse(epic.matches("молоко")); // проверка поиска регистр
        Assertions.assertFalse(epic.matches("Яица")); // проверка поиска й/и
        Assertions.assertFalse(epic.matches("Хлеба")); // проверка поиска окончание
        Assertions.assertFalse(epic.matches("Бублик")); // проверка поиска отсутствующего слова
        Assertions.assertFalse(epicEmpty.matches("Молоко")); // проверка пустого массива
    }
    }
//Assertions.assertTrue(simpleTask.matches(" ")); // проверка пробел



