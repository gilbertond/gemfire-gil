package algorithms;

import java.util.*;

public class Alg implements Comparator<String> {
    public static void main(String[] a) {

        System.out.println(reorderLines(
                                    5,
                                    Arrays.asList(new String[]{
                                                                "[a1 9 2 3 1]",
                                                                "[g1 Act car]",
                                                                "[zo4 4 7]",
                                                                "[ab1 off KEY dog]",
                                                                "[a8 act zoo]"
                                                            }
                                    )
                                )
                            );
                        }

    static List<String> reorderLines(int logSize, List<String> logLines) {
        List<String> result = new ArrayList<>();
        if (logLines == null) return result;

        if (logLines.size() != logSize) return result;

        List<String> numericsList = new ArrayList<>();
        List<String> nonNumericList = new ArrayList<>();

        for (int i = 0; i < logSize; i++) {
            String line = logLines.get(i);

            String[] lineArr = line.split(" ");

            String identifier = lineArr[0].substring(1);
            String log = line.substring(identifier.length()+1, line.length() - 1);

            String bkp = log;

            System.out.println(":LOG:"+log.replace(" ", ""));

            if (log.replace(" ", "").matches("^[0-9]+$")) {

                System.out.println("Log with #:"+log);

                //Add numerics to its list
                numericsList.add(String.join(identifier, log.trim()));

            }   else {
                nonNumericList.add(String.join(identifier, log.toLowerCase().trim()));
            }
        }

        Collections.sort(nonNumericList);
        result.addAll(sortLogs(nonNumericList));
        result.addAll(numericsList);
        return result;
    }

    public int compareIdentifiers(String identifier1,String identifier2) {
//        if(identifier1.compareToIgnoreCase(identifier2) ==)

        return 0;
    }

    static List<String> sortLogs(List<String> list) {
        if(list.isEmpty()) return list;

        return list;
    }

    @Override
    public int compare(String o1, String o2) {
        if (o1.compareToIgnoreCase(o2) == 1) return 1;
        if (o1.compareToIgnoreCase(o2) == 0) return 0;
        if (o1.compareToIgnoreCase(o2) == -1) return -1;
        return 0;
    }
}