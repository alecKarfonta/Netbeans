package siggrabber3;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.ArrayList;

public class ImageTools {
        
    // histogram
    
    public static ArrayList<MyColor> getHistogramVertical(BufferedImage image, int x, int startY) {
        return getHistogramVertical(image, startY, x, 1);
    }
    public static ArrayList<MyColor> getHistogramVertical(BufferedImage image, int x, int startY, int skip) {
        ArrayList<MyColor> colorCounts = new ArrayList<MyColor>(); 

        // set the first color
        colorCounts.add(new MyColor(image.getRGB(x, startY)));
        for (int y = startY; y < image.getHeight(); y += skip) {
            for (int index = 0; index < colorCounts.size(); index++ ) {
                if (colorCounts.get(index).getColor() == image.getRGB(x, y)) {
                    colorCounts.get(index).increment();
                }
                else {
                    colorCounts.add(new MyColor(image.getRGB(x, y)));
                }
            }
        }
        return colorCounts;
    }
     
    // removes all white space
    public static BufferedImage getCroppedBorderImage(BufferedImage image) throws IOException{
        
        long borderColor = (image.getRGB(0, 0) 
                         + image.getRGB(0, image.getHeight() -1) 
                         + image.getRGB(image.getWidth()-1, 0) 
                         + image.getRGB(image.getWidth()-1, image.getHeight()-1))
                         / 4;
        
        boolean atEnd = false;
        int upperBorder = -1 , lowerBorder = -1, leftBorder = -1, rightBorder = -1; 
        int lowerOffset = -1, rightOffset = -1;
        
        // find the upper border
        do{
            upperBorder++ ;
            for (int x =0 ; x < image.getWidth() ; x++){
                if(!isColorMatch(image.getRGB(x, upperBorder), borderColor, 100000)){
                    atEnd = true;
                    break ;
                }
            }

            if (upperBorder >= image.getHeight())
                atEnd = true ;
        }while(!atEnd) ;
        
        // find the left border
        atEnd = false;
        do{
            leftBorder++ ;
            for (int y = 0; y < image.getHeight(); y++){
                if(!isColorMatch(image.getRGB(leftBorder, y), borderColor, 100000)){
                    atEnd = true;
                    break ;
                }
            }

            if (leftBorder >= image.getWidth())
                atEnd = true ;
        }while(!atEnd) ;
        
        // find the right border
        atEnd = false;
        rightBorder = image.getWidth();
        do{
            rightBorder--;
            rightOffset++;
            for (int y = 0; y < image.getHeight(); y++){
                if(!isColorMatch(image.getRGB(rightBorder, y), borderColor, 100000)){
                    atEnd = true;
                    break ;
                }
            }

            if (rightBorder >= image.getWidth())
                atEnd = true ;
        }while(!atEnd) ;
        
        // find the lower border
        lowerBorder = image.getHeight();
        atEnd = false;
        do{
            lowerBorder--;
            lowerOffset++;
            for (int x = 0; x < image.getWidth() ; x++){
                if(!isColorMatch(image.getRGB(x, lowerBorder), borderColor, 100000)){
                    atEnd = true;
                    break ;
                }
            }

            if (lowerBorder >= image.getHeight())
                atEnd = true ;
        }while(!atEnd) ;
        
        return getCroppedBorderImage( image, leftBorder, upperBorder
                , image.getWidth() - rightOffset - leftBorder
                , image.getHeight() - lowerOffset - upperBorder ) ;
    }
    
    // crops to the specifies dimensions
    public static BufferedImage getCroppedBorderImage(BufferedImage src, int x, int y, int w, int h) {
      BufferedImage dest = src.getSubimage(x, y, w, h);
      return dest; 
    }
   
    public static BufferedImage rotateImage(BufferedImage image, double rotation)    {
        rotation = Math.toRadians(rotation);
        double locationX = image.getWidth() / 2;
        double locationY = image.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotation, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        
        //apply filter to image
        image = ((AffineTransformOp)op).filter(image, null);
        return image;
    }
    
    // uses ColorConvertOp to convert image to grayscale 
    // ColorConvertOp link: http://docs.oracle.com/javase/6/docs/api/java/awt/image/ColorConvertOp.html#ColorConvertOp%28java.awt.color.ColorSpace%2C%20java.awt.RenderingHints%29
    // ColorSpace link: http://docs.oracle.com/javase/6/docs/api/java/awt/color/ColorSpace.html
    public static BufferedImage getGrayscale(BufferedImage origImage) {
        BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        return op.filter(origImage, null);
    }
    
    public static int getColorDifference(int color1, int color2) {
        if (-color1 > -color2) {
            //System.out.println(-color1 - -color2);
            return -color1 - -color2;
        }
        else
        {
            //System.out.println(-color2 - -color1);
            return -color2 - -color1;
        }
    }
    
    public static long getColorDifference(long color1, long color2) {
        if (-color1 > -color2) {
            //System.out.println(-color1 - -color2);
            return -color1 - -color2;
        }
        else
        {
            //System.out.println(-color2 - -color1);
            return -color2 - -color1;
        }
    }
    
    public static String getAspectRatio(BufferedImage image) {
        return image.getWidth() + ":" + image.getHeight();
    }
    
    public static boolean isColorMatch(int color1, int color2, int range) {
        if (getColorDifference(color1, color2) < range) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean isColorMatch(long color1, long color2, int range) {
        if (getColorDifference(color1, color2) < range) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static byte[] getByteArray (BufferedImage image) throws IOException {
        
        // get DataBufferBytes from Raster
        WritableRaster raster = image.getRaster();
        DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
        return ( data.getData() );
    }
   
    public static int compareImages(BufferedImage image1, BufferedImage image2) {
        // make the images the same size
        BufferedImage resizedImage2 = resizeImage(image2, image1.getWidth(), image1.getHeight(), true);
        int matches = 0;
        // for each pixel compare the colors
        for (int x = 0; x < image1.getWidth(); x++) {
            for (int y = 0; y < image1.getHeight(); y++) {
                if (isColorMatch(image1.getRGB(x, y), image2.getRGB(x, y), 10000)) {
                    matches++;
                }
            }
        }
        
        return (image1.getHeight() * image1.getWidth()) / matches;
    }
    
    public static BufferedImage resizeImage(BufferedImage originalImage, int scaledWidth, int scaledHeight, boolean preserveAlpha)    {
    	System.out.println("resizing...");
    	int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
    	BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
    	Graphics2D g = scaledBI.createGraphics();
    	if (preserveAlpha) {
    		g.setComposite(AlphaComposite.Src);
    	}
    	g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
    	g.dispose();
    	return scaledBI;
    }
        
    public static BufferedImage Threshold(BufferedImage img) {
        // initial theshold of 100
        int threshold = 100;
        
        
        return Threshold(img,100);
    }
    
    public static BufferedImage Threshold(BufferedImage img,int requiredThresholdValue) {
        int height = img.getHeight();
        int width = img.getWidth();
        BufferedImage finalThresholdImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB) ;

        int red = 0;
        int green = 0;
        int blue = 0;

        for (int x = 0; x < width; x++) {
            try {
                for (int y = 0; y < height; y++) {
                    int color = img.getRGB(x, y);

                    red = getRed(color);
                    green = getGreen(color);
                    blue = getBlue(color);

                    if((red+green+green)/3 < (int)(requiredThresholdValue)) {
                        finalThresholdImage.setRGB(x, y, mixColor(0, 0, 0));
                    }
                    else {
                        finalThresholdImage.setRGB(x, y, mixColor(255, 255, 255));
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }

        return finalThresholdImage;
    }
    
    private static int mixColor(int red, int green, int blue) {
            return red<<16|green<<8|blue;
    }

    public static int getRed(int color) {
            return (color & 0x00ff0000)  >> 16;
    }

    public static int getGreen(int color) {
            return	(color & 0x0000ff00)  >> 8;
    }

    public static int getBlue(int color) {
            return (color & 0x000000ff)  >> 0;

    }
}
