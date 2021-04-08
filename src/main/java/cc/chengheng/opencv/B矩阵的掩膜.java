package cc.chengheng.opencv;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class B矩阵的掩膜 {
    static {
        LibPathUtil.getDynamicLinkingLibrary();
    }

    public static void main(String[] args) {
        Mat src = Imgcodecs.imread("/Users/fengliulin/Documents/2021春节合影副本.jpg");
        Mat dst = new Mat(src.size(), src.type());

        if (src.empty()) {
            System.out.println("找不到图像");
        }
        HighGui.namedWindow("窗口1", HighGui.WINDOW_AUTOSIZE);
        HighGui.imshow("窗口1", src);


        int channels = src.channels();
        double[] pixel = new double[3];
        float alpha = 1.2f;
        float bate = 30f;

        // 调整对比度
        /*for (int i = 0; i < src.rows(); i++) {
            for (int j = 0; j < src.cols(); j++) {
                if (channels == 3) {//1 图片为3通道即平常的(R,G,B)
                    pixel = src.get(i, j).clone();
                    pixel[0] = pixel[0] * alpha + bate;//R
                    pixel[1] = pixel[1] * alpha + bate;//G
                    pixel[2] = pixel[2] * alpha + bate;//B
                    dst.put(i, j, pixel);
                } else {//2 图片为单通道即灰度图
                    pixel = src.get(i, j).clone();
                    dst.put(i, j, pixel[0] * alpha + bate);
                }
            }
        }*/

        //内核
        Mat kernel = new Mat(new Size(3, 3), CvType.CV_16SC1, new Scalar(255));
        kernel.put(0, 0, 1);
        kernel.put(0, 1, 2);
        kernel.put(0, 2, 3);
        kernel.put(1, 0, 1);
        kernel.put(1, 1, 2);
        kernel.put(1, 2, 3);
        kernel.put(2, 0, 1);
        kernel.put(2, 1, 2);
        kernel.put(2, 2, 3);

        // src.depth()位图的深度，有32、24、8
        Imgproc.filter2D(src, dst, src.depth(), kernel);

        // 显示调整好的对比度图片
        HighGui.namedWindow("窗口2", HighGui.WINDOW_AUTOSIZE);
        HighGui.imshow("窗口2", dst);


        HighGui.waitKey();
    }
}
