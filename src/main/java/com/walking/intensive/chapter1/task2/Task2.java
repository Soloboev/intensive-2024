package com.walking.intensive.chapter1.task2;

/**
 * Реализуйте метод getFlatLocation(), который будет принимать параметрами следующие данные:
 * <ul>
 * <li> Количество этажей в доме;
 * <li> Количество подъездов;
 * <li> Номер нужной квартиры.
 * </ul>
 *
 * <p>Необходимо определить подъезд, этаж и расположение нужной квартиры относительно лифта,
 * руководствуясь следующими правилами:
 * <ul>
 * <li> На этаже 4 квартиры;
 * <li> Нумерация квартир возрастает по часовой стрелке.
 * </ul>
 *
 * <p>Примеры строки, возвращаемой из метода:
 * <ul>
 * <li> 1 кв – 1 подъезд, 1 этаж, слева от лифта, влево
 * <li> 2 кв – 1 подъезд, 1 этаж, слева от лифта, вправо
 * <li> 3 кв – 1 подъезд, 1 этаж, справа от лифта, влево
 * <li> 4 кв – 1 подъезд, 1 этаж, справа от лифта, вправо
 * </ul>
 *
 * <p>Если для дома с указанной этажностью и количеством подъездов квартиры с заданным номером не существует,
 * метод должен вернуть строку "Такой квартиры не существует".
 *
 * <p>Если хотя бы один из указанных параметров некорректный - например, отрицательное число или 0,
 * метод должен вернуть строку "Некорректные входные данные".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task2 {
    public static void main(String[] args) {
    }

    static String getFlatLocation(int floorAmount, int entranceAmount, int flatNumber) {
        int totalFlats = floorAmount * entranceAmount * 4;
        if (flatNumber > totalFlats) {
            return "Такой квартиры не существует";
        } else if (flatNumber <= 0) {
            return "Некорректные входные данные";
        }
        if (flatNumber == 1) {
            return "1 кв – 1 подъезд, 1 этаж, слева от лифта, влево";
        }
        String result = flatNumber + " кв - ";
        int entrance = (flatNumber - 1) / floorAmount / 4 + 1;
        int floor = ((flatNumber - 1) - floorAmount * (entrance - 1) * 4) / 4 + 1;
        int lastEntranceFlat = (entrance - 1) * floorAmount * 4;
        int direction = (flatNumber - lastEntranceFlat) % 4;
        result += entrance + " подъезд, ";
        result += floor + " этаж, ";
        switch (direction) {
            case 0:
                result += "справа от лифта, вправо";
                break;
            case 1:
                result += "слева от лифта, влево";
                break;
            case 2:
                result += "слева от лифта, вправо";
                break;
            case 3:
                result += "справа от лифта, влево";
                break;
        }
        return result;
    }
}
