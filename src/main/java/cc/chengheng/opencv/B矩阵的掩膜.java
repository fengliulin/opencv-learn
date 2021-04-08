package cc.chengheng.opencv;

import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class B矩阵的掩膜 {
    static {
        LibPathUtil.getDynamicLinkingLibrary();
    }

    public static void main(String[] args) {
        Mat src, dst;
        src = Imgcodecs.imread("/Users/fengliulin/Documents/2021春节合影副本.jpg");
        if (src.empty()) {
            System.out.println("找不到图像");
        }

        HighGui.namedWindow("窗口1", HighGui.WINDOW_AUTOSIZE);
        HighGui.imshow("窗口1", src);

        int cols = (src.cols()-1) * src.channels(); // 行-- 高度
        int rows = src.rows(); // 列 --- 宽度

        int offsetX = src.channels(); // 获取图像通道数

        for (int row = 1; row < rows - 1; row++) {
//            final char current = src.
            for (int col = offsetX; col < cols; col++) {

            }
        }



        HighGui.waitKey();
    }
}
