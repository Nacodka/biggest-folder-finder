import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String foldersPath = "C:\\Users\\Natali\\Desktop\\Кузьмич\\Модуль 4";
        File file = new File(foldersPath);
       // System.out.println(getFolderSize(file));
        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);
        System.out.println(size);

    }

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
}

