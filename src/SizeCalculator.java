import java.io.File;
import java.util.HashMap;

public class SizeCalculator {
    private static char[] sizeMultipliers = {'B', 'K', 'M', 'G', 'T'};
    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for (File file : files
        ) {
            sum += getFolderSize(file);
        }
//        Stream<File> files = Arrays.stream(folder.listFiles());
//        sum = files.
        return sum;
    }

    // 24B, 234Kb, 236Mb, 435 Gb, 2Tb
    public static String getHumanReadableSize(long size) {
        if (size <= 0) {
            return "Недопустимое значение  переменной size - меньше 0";
        }
        for (int i = 0; i < sizeMultipliers.length; i++) {
            double value = size / Math.pow(1024, i);

            if (value < 1024) {
                return Math.round(value) + "" + sizeMultipliers[i] + (i > 0 ? "b" : "");
            }
        }
        return "";
    }

    public static long getSizeFromHumanReadable(String size) {
//        int sizeInByte = 0;
//        String stringToNumber = "";
//               if(size.contains("M") || size.contains("Mb")){
//           stringToNumber = size.replaceAll("\\D", "");
//           sizeInByte = Integer.parseInt(stringToNumber);
//           return sizeInByte*1024;
//       }
//        return 0;
        HashMap<Character, Integer> charToMultiplier = getMultipiers();
        char sizeFactor = size.replaceAll("[0-9\\s+]", "").charAt(0);
        int multiplier = charToMultiplier.get(sizeFactor);
        long length = multiplier * Long.valueOf(size.replaceAll("[^0-9]", ""));

        return length;
    }

    private static HashMap<Character, Integer> getMultipiers() {

        HashMap<Character, Integer> charToMultiplier = new HashMap<>();
        for (int i = 0; i < sizeMultipliers.length; i++) {
            charToMultiplier.put(sizeMultipliers[i], (int) Math.pow(2, i * 10));
        }
        return charToMultiplier;
    }
}
