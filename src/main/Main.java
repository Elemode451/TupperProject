package main;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		System.out.println("Begining Execution...");
		String bin = ImageProcessor.processImage("C:/Users/danie/OneDrive/Desktop/NMICK.png");
		System.out.println("Image Processed");
		System.out.println(ImageProcessor.returnKValue(bin));
		System.out.println("Balls Secured!");
	}
}
