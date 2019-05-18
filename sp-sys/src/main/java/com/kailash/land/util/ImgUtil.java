package com.kailash.land.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImgUtil {

	public void createWaterMarkByIcon(String srcImagePath, double degree) {
		log.info("--> ImgUtil : createWaterMarkByIcon >>> begin");
		String logoImagePath = this.getClass().getResource("/").getPath() + "/static/images/pro_pic_mark.png";
		File srcImageFile = new File(srcImagePath);
		log.info("srcImageFile is {}", srcImageFile.exists());
		File logoImageFile = new File(logoImagePath);
		log.info("logoImageFile is {}", logoImageFile.exists());
		File outputImageFile = srcImageFile;
		OutputStream os = null;
		try {
			Image srcImg = ImageIO.read(srcImageFile);
			int width = srcImg.getWidth(null);
			int height = srcImg.getHeight(null);
			log.info("width={}; height={};", width, height);
			BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			Graphics2D graphics = buffImg.createGraphics();
			graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			graphics.drawImage(srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

			ImageIcon logoImgIcon = new ImageIcon(ImageIO.read(logoImageFile));
			Image logoImg = logoImgIcon.getImage();

			// 旋转
			if (degree > 0) {
				graphics.rotate(Math.toRadians(degree), (double) buffImg.getWidth() / 2,
						(double) buffImg.getWidth() / 2);
			}

			float alpha = 1.0f; // 透明度
			graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

			// 水印 的位置
			int middleWidth = width / 2 - width / 8;
			int middleHeight = height / 2 - height / 8;
			graphics.drawImage(logoImg.getScaledInstance(width / 4, height / 4, Image.SCALE_DEFAULT), middleWidth,
					middleHeight, null);
			graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
			graphics.dispose();

			os = new FileOutputStream(outputImageFile);
			// 生成图片
			ImageIO.write(buffImg, "JPG", os);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != os)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
