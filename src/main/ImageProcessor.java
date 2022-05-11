package main;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.math.BigInteger;

public class ImageProcessor {
	
	public static BigInteger returnKValue(String bin) {
		BigInteger test = new BigInteger(bin, 2);
		final BigInteger panpaj = BigInteger.valueOf(17);
		test = test.multiply(panpaj);
		return test;

	}
	public static String processImage(String input) throws IOException{
		File image = new File(input);
		
		BufferedImage img = ImageIO.read(image).getSubimage(0, 0, 106, 17);
		String balls = "";
		System.out.println(img.getWidth());
		for(int i = 0; i < img.getWidth(); i++){
			for(int j=0; j < img.getHeight(); j++){
				int pixel = img.getRGB(i,j);
				Color pixelColor = new Color(pixel);
				int redValue = pixelColor.getRed();
				int greenValue = pixelColor.getGreen();
				int blueValue = pixelColor.getBlue();
				double grayscalePixel = (((0.21 * redValue) + (0.71 * greenValue) + (0.07 * blueValue)) / 255);		
				if(grayscalePixel <= 0.5){
					balls+= 1;
				} else {
					balls += 0;
				}
			}
		}
		image = new File("C:/Users/danie/OneDrive/Desktop/Untitled20.png");
		System.out.println("Writing...");
	    ImageIO.write(img, "jpg", image);
	    System.out.println("Done.");
	    return balls;
	}
	
	

}


