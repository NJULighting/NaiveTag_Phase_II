package top.minecode.domain.statistic;

import top.minecode.utils.Pair;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2018/4/21.
 * Description:
 * @author Liao
 */
public class TimeNumberGraph {
    private Map<LocalDate, Integer> dots;

    public TimeNumberGraph() {
        dots = new HashMap<>();
    }

    public List<GraphPoint> getDots() {
        return dots.entrySet().stream().map(GraphPoint::new)
                .sorted(Comparator.comparing(GraphPoint::getDate)).collect(Collectors.toList());
    }


    public void addDot(LocalDate date) {
        dots.merge(date, 1, (a, b) -> a + b);
    }

    public TimeNumberGraph accumulateGraph() {
        List<Map.Entry<LocalDate, Integer>> entryList = new ArrayList<>(dots.entrySet());
        entryList.sort(Comparator.comparing(Map.Entry::getKey));

        dots = new HashMap<>(entryList.size());
        for (int i = 0, prev = 0; i < entryList.size(); i++) {
            Map.Entry<LocalDate, Integer> entry = entryList.get(i);
            dots.put(entry.getKey(), entry.getValue() + prev);
            prev += entry.getValue();
        }

        return this;
    }

    public static class GraphPoint {
        private LocalDate date;

        private int number;

        private GraphPoint(Map.Entry<LocalDate, Integer> entry) {
            this.date = entry.getKey();
            this.number = entry.getValue();
        }

        public LocalDate getDate() {
            return date;
        }

        public int getNumber() {
            return number;
        }
    }
}
