package cc.chengheng.opencv;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class A加载_修改_保存图像 {
    static {
        LibPathUtil.getDynamicLinkingLibrary();
    }

    public static void main(String[] args) {
        // 加载图像
        Mat image = Imgcodecs.imread("/Users/fengliulin/Documents/2021春节合影副本.jpg");
        if (image.empty()) {
            System.out.println("找不到图像");
        }

        // 把图像显示在窗口
        // HighGui.WINDOW_NORMAL 跟QT集成的时候会使用，允许修改窗口大小
        // HighGui.WINDOW_AUTOSIZE 根据图像大小，不能改变窗口
        HighGui.namedWindow("窗口1", HighGui.WINDOW_AUTOSIZE);
        HighGui.imshow("窗口1", image);

        Mat outputImage = new Mat();

        // 修改图像：颜色转换 支持的很多，具体查看api手册
        Imgproc.cvtColor(image, outputImage, Imgproc.COLOR_BGR2HLS);

        // 转换后的图片显示这个窗体上
        HighGui.namedWindow("窗口2", HighGui.WINDOW_AUTOSIZE);
        HighGui.imshow("窗口2", outputImage);

        // 保存图像, 这三个格式都可以，但是不支持gif
        Imgcodecs.imwrite("/Users/fengliulin/Documents/2021春节合影副本-转换后的颜色.jpg", outputImage);
        Imgcodecs.imwrite("/Users/fengliulin/Documents/2021春节合影副本-转换后的颜色.png", outputImage);
        Imgcodecs.imwrite("/Users/fengliulin/Documents/2021春节合影副本-转换后的颜色.tif", outputImage);


        HighGui.waitKey();
    }
}
