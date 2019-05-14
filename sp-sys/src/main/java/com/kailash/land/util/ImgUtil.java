package com.kailash.land.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImgUtil {
	/**
	 * 给图片添加水印文字、可设置水印文字的旋转角度
	 * 
	 * @param logoText     要写入的文字
	 * @param srcImgPath   源图片路径
	 * @param newImagePath 新图片路径
	 * @param degree       旋转角度
	 * @param color        字体颜色
	 * @param formaName    图片后缀
	 */
	public static void markImageByText(String srcImgPath, String newImagePath, Integer degree, Color color,
			String formaName) {
		log.debug("--> ImgUtil: begin");
		log.info("--> ImgUtil: srcImgPath={}; newImagePath={}; degree={}; color={}; formaName={};", srcImgPath,
				newImagePath, degree, color, formaName);
		InputStream is = null;
		OutputStream os = null;
		try {
			// 1、源图片
			log.debug("--> ImgUtil: 1");
			java.awt.Image srcImg = ImageIO.read(new File(srcImgPath));
			BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
					BufferedImage.TYPE_INT_RGB);

			// 2、得到画笔对象
			log.debug("--> ImgUtil: 2");
			Graphics2D g = buffImg.createGraphics();

			// 3、设置对线段的锯齿状边缘处理
			log.debug("--> ImgUtil: 3");
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null),
					java.awt.Image.SCALE_SMOOTH), 0, 0, null);

			// 4、设置水印旋转
			log.debug("--> ImgUtil: 4");
			if (null != degree) {
				g.rotate(Math.toRadians(degree), buffImg.getWidth() / 2, buffImg.getHeight() / 2);
			}

			// 5、设置水印文字颜色
			log.debug("--> ImgUtil: 5");
			g.setColor(color);

			// 6、设置水印文字Font
			log.debug("--> ImgUtil: 6");
			g.setFont(new java.awt.Font("宋体", java.awt.Font.BOLD, buffImg.getHeight() / 10));

			// 7、设置水印文字透明度
			log.debug("--> ImgUtil: 7");
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.2f));

			// 8、第一参数->设置的内容，后面两个参数->文字在图片上的坐标位置(x,y)
			log.debug("--> ImgUtil: 8");
			g.drawString("四平铁西区农经局", buffImg.getWidth() / 4, buffImg.getHeight() / 4);
			g.drawString("土地流转交易平台专用", buffImg.getWidth() / 4, buffImg.getHeight() / 2);

			// 9、释放资源
			log.debug("--> ImgUtil: 9");
			g.dispose();

			// 10、生成图片
			log.debug("--> ImgUtil: 10");
			os = new FileOutputStream(newImagePath);
			ImageIO.write(buffImg, formaName, os);
			log.debug("--> ImgUtil: end");
		} catch (Exception e) {
			log.error(e.toString(), e);
			e.printStackTrace();
		} finally {
			try {
				if (null != is)
					is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (null != os)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
