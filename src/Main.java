import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

public class Main {


    public static void main(String[] args) {
        String foldersPath = "C:\\Users\\Natali\\Documents\\Java";
        File file = new File(foldersPath);
        Node root = new Node(file);
        // System.out.println(getFolderSize(file));
        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);
        System.out.println(root);


    }


}

