package cc.chengheng;

import org.opencv.core.CvType;
import org.opencv.core.Mat;

import java.io.*;
import java.net.URL;
import java.util.Objects;

public class Test打包成jar_命令行运行 {
    static {
        // 获取opencv本地动态连接库
        /*URL resource = Test打包成jar_命令行运行.class.getClassLoader().getResource("/libopencv_java452.dylib");
        URL urlPath = Objects.requireNonNull(resource);
        String libOpencvJava452PATH = urlPath.getPath();
        System.out.println(libOpencvJava452PATH);*/

        InputStream read = null;
        FileOutputStream write = null;
        try {
            read = Test打包成jar_命令行运行.class.getResourceAsStream("/libopencv_java452.dylib"); // 这样才可以加载jar里面的资源
            write = new FileOutputStream("/Users/fengliulin/Documents/libopencv_java452.dylib");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int len = 0;
            while (((len = read.read(buffer)) != -1)) {
                write.write(buffer, 0, len); // 从jar获取的流写入到磁盘别的目录，加载动态连接库可以用
                write.flush();
                byteArrayOutputStream.write(buffer, 0, len); // 采用内存流，是无法加载动态连接库的
            }

            byte[] bytes = byteArrayOutputStream.toByteArray();
            for (byte aByte : bytes) {
                System.out.println(aByte);
            }

            // 只支持这种绝对路径的， 内存流的方式无法使用
            System.load("/Users/fengliulin/Documents/libopencv_java452.dylib");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(write).close();
                read.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 加载动态连接库
//        System.load(libOpencvJava452PATH);
//        System.loadLibrary("libopencv_java452.dylib");

//        String property = System.getProperty("user.dir");
//        System.out.println(property);
//        System.load("/Users/fengliulin/Documents/opencv-4.5.2/build/lib/libopencv_java452.dylib");
    }
    public static void main(String[] args) {
        // 执行通过代表动态连接库ok
        Mat m = Mat.eye(3, 3, CvType.CV_8UC1);
        System.out.println("m = " + m.dump());
    }
}
