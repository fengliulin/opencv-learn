package cc.chengheng.opencv;

import java.net.URL;
import java.util.Objects;

public class LibPathUtil {

    /**
     * 获取动态连接库 libopencv_java452.dylib
     */
    public static void getDynamicLinkingLibrary() {
        // 获取opencv本地动态连接库
        URL resource = LibPathUtil.class.getClassLoader().getResource("libopencv_java452.dylib");
        URL urlPath = Objects.requireNonNull(resource);
        String libOpencvJava452PATH = urlPath.getPath();
//        System.out.println(libOpencvJava452PATH);

        System.load(libOpencvJava452PATH);
    }

}
