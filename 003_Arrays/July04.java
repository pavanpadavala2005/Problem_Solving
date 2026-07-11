import java.util.*;

public class July04 {

    public static int[][] mergeOverlappingIntervalsV4(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (res.isEmpty() || intervals[i][0] > res.get(res.size() - 1)[1]) {
                res.add(new int[] { intervals[i][0], intervals[i][1] });
            } else {
                if (res.get(res.size() - 1)[1] <= intervals[i][1]) {
                    int[] pair = res.get(res.size() - 1);
                    pair[1] = intervals[i][1];
                    res.set(res.size() - 1, pair);
                }
            }
        }
        // Conversion from ArrayList to Matrix
        return res.toArray(new int[res.size()][]);
    }

    public static int[][] mergeOverlappingIntervalsV3(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> res = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (res.isEmpty() || intervals[i][0] > res.get(res.size() - 1).get(1)) {
                res.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            } else {
                if (res.get(res.size() - 1).get(1) <= intervals[i][1]) {
                    List<Integer> pair = res.get(res.size() - 1);
                    pair.set(1, intervals[i][1]);
                    res.set(res.size() - 1, pair);
                }
            }
        }
        // Conversion from ArrayList to Matrix
        int[][] mat = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            int[] pair = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                pair[j] = res.get(i).get(j);
            }
            mat[i] = pair;
        }
        return mat;

    }

    public static int[][] mergeOverlappingIntervalsV2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> res = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (res.isEmpty()) {
                res.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
                continue;
            }
            int l = intervals[i][0];
            int r = intervals[i][1];
            // Getting last Element's Last element res[last][1]
            int resR = res.get(res.size() - 1).get(1);
            if (l <= resR) {
                if (r > resR) {
                    List<Integer> prev = res.get(res.size() - 1);
                    prev.set(1, r);
                    res.set(res.size() - 1, prev);
                }
            } else {
                res.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            }
        }
        // Conversion from ArrayList to Matrix
        int[][] mat = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            int[] pair = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                pair[j] = res.get(i).get(j);
            }
            mat[i] = pair;
        }
        return mat;
    }

    public static int[][] mergeOverlappingIntervalsV1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(intervals));
        List<List<Integer>> res = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            if (res.isEmpty()) {
                res.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
                continue;
            }
            List<Integer> prev = res.get(res.size() - 1);
            for (int j = i; j < n; j++) {
                int f = intervals[i][0];
                int l = intervals[i][1];
                if (prev.get(prev.size() - 1) > f)
                    prev.set(1, l);
                else {
                    break;
                }
            }
        }
        int[][] mat = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            int[] pair = new int[res.get(i).size()];
            for (int j = 0; j < res.get(i).size(); j++) {
                pair[j] = res.get(i).get(j);
            }
            mat[i] = pair;
        }
        return mat;
    }
}