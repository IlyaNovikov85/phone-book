//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами.
// Вывод должен быть отсортирован по убыванию числа телефонов.


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Map<String, Set<Long>> map = new HashMap<>();
        map.put("Ivanov", Set.of(83838538279L, 22092090298092L, 22525275827252L));
        map.put("Petrov", Set.of(83838538249L));
        map.put("Sidorov", Set.of(53838538279L, 22092094298092L));
        map.put("Skvorcov", Set.of(53838538279L, 22092094298092L, 30926209602960L, 49348630683L, 7062780967206L));

        System.out.println(sorting(map));
    }

    public static Map<String, Set<Long>> sorting(Map<String, Set<Long>> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((Set<Long> v1, Set<Long> v2) ->
                        Integer.compare(v2.size(), v1.size())))
                .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);
    }
}



