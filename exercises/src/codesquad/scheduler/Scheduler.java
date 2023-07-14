package exercises.src.codesquad.scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2023.7.14(금) 0h35
public class Scheduler {
    public static Map<String, List<String>> datesAndSchedulesMap = new HashMap<>();

    public static Map<String, List<String>> getDatesAndSchedulesMap() {
        return datesAndSchedulesMap;
    }

    public static void setDatesAndSchedulesMap(Map<String, List<String>> datesAndSchedulesMap) {
        Scheduler.datesAndSchedulesMap = datesAndSchedulesMap;
    }

    public boolean createSchedule(String inputDate, String inputSchedule) {
        try {
            if (!datesAndSchedulesMap.containsKey(inputDate)) {
                List<String> schedulesList = new ArrayList<>();
                schedulesList.add(inputSchedule);
                datesAndSchedulesMap.put(inputDate, schedulesList);
            } else {
                datesAndSchedulesMap.get(inputDate).add(inputSchedule);

                // todo
//                for (int i = 0; i < datesAndSchedulesMap.get(inputDate).size(); i++) {
//                    System.out.println(datesAndSchedulesMap.get(inputDate).get(i));
//                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<String> searchSchedule(String inputDate) {
        if (datesAndSchedulesMap.containsKey(inputDate)) {
            return datesAndSchedulesMap.get(inputDate);
        } else {
            return new ArrayList<>();
        }
    }

    // 2023.7.14(금) 13h10
    public boolean updateSchedule(String inputDate, int inputNum, String updatedSchedule) {
        try {
            datesAndSchedulesMap.get(inputDate).set(inputNum - 1, updatedSchedule);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteSchedule(String inputDate, int inputNum) {
        try {
            datesAndSchedulesMap.get(inputDate).remove(inputNum - 1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 2023.7.14(금) 13h25
    public boolean hasSchedule(int year, int month, int date) {
        String key = String.format("%d-%02d-%d", year, month, date);

        if (datesAndSchedulesMap.containsKey(key)) {
            if (!datesAndSchedulesMap.get(key).isEmpty()) {
                return true;
            }
        }

        return false;
    }
}
