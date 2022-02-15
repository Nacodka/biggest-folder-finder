import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        String foldersPath = "C:\\Users\\Natali\\Documents\\Java";
        long sizeLimit = 10 * 1024 * 1024;

        File file = new File(foldersPath);
        Node root = new Node(file, sizeLimit);
        // System.out.println(getFolderSize(file));
        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        long size = pool.invoke(calculator);

//        List<Node> foldersUpperSizeLimit = root.getChildren().stream().
//                filter(i -> i.getSize() >= sizeLimit).collect(Collectors.toList());
//        System.out.println(foldersUpperSizeLimit.toString());
        System.out.println(root);

    }


}

