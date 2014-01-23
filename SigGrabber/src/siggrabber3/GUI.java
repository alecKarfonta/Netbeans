
package siggrabber3;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GUI extends javax.swing.JFrame {

    // vision settings
    int colorRange = 250000;
    
    private BufferedImage sourceImage, targetImage;
    private ArrayList<MyColor> sourceHist, travHist, stanHist;
    
    public GUI() {
        System.out.println("Start");
        initComponents();
        try {
            // load images
            targetImage = ImageIO.read(new File("images/stock/trav.jpg"));
            displayImage(targetImage, jlTargetImage);
            sourceImage = ImageIO.read(new File("images/trav0_rotated.jpg"));
            displayImage(sourceImage, jlSourceImage);
            
            loadTravHistogram();
            loadStanHistogram();            
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private ArrayList<MyColor> getHistogram(String filePath) {
        BufferedReader buffReader = null;
        String line = "";
        String[] data;
        String delimiter = ",";
        ArrayList list = new ArrayList<MyColor>();
        MyColor color;
        try {
            buffReader = new BufferedReader(new FileReader(filePath));
            while ((line = buffReader.readLine()) != null) {
                data = line.split(delimiter);
                color = new MyColor(Integer.parseInt(data[0]));
                color.setCount(Integer.parseInt(data[1]));
                list.add(color);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return list;
    }
    
    public void getVertHistogram(BufferedImage image, int x, int y1, int y2) {
        
        sourceHist = new ArrayList<MyColor>();
        sourceHist.add(new MyColor(image.getRGB(x, y1)));
        int newColor;
        boolean isNewColor = true;
        
        // analyse a vertical bar of the image
        for (int y = y1 + 1; y < y2 - 5; y++) {
            newColor = image.getRGB(x, y);
            
            // for each current color
            for (MyColor currColor : sourceHist) {
                // check if the color already exists
                if (newColor == currColor.getColor()) {
                    // if it does then increment its value and set the new color flag to false
                    currColor.increment();
                    isNewColor = false;
                    break;
                }
            }
            
            // if the color was new
            if (isNewColor = true) {
                // add the color to the list
                sourceHist.add(new MyColor(newColor));
            }
        }
        
        // sort the list in descending order
        Collections.sort(sourceHist);
        Collections.reverse(sourceHist);
        
        // display the results
        jtaSourceInfo.setText(null);
        int colorLabels = 5;
        for (MyColor myColor : sourceHist) {
            if (myColor.getCount() > 10) {
                jtaSourceInfo.append("Color: " + myColor.getColor() + " \t Frequency: " + myColor.getCount() + "\n");
                if (colorLabels > 0) {
                    switch (colorLabels) {
                        case 5: 
                            jlSourceColor1.setBackground(new Color(myColor.getColor(), true));
                            jlSourceColor1.setOpaque(true);
                            break;
                        case 4: 
                            jlSourceColor2.setBackground(new Color(myColor.getColor(), true));
                            jlSourceColor2.setOpaque(true);
                            break;
                        case 3: 
                            jlSourceColor3.setBackground(new Color(myColor.getColor(), true));
                            jlSourceColor3.setOpaque(true);
                            break;
                        case 2: 
                            jlSourceColor4.setBackground(new Color(myColor.getColor(), true));
                            jlSourceColor4.setOpaque(true);
                            break;
                        case 1: 
                            jlSourceColor5.setBackground(new Color(myColor.getColor(), true));
                            jlSourceColor5.setOpaque(true);
                            break;
                    }
                colorLabels--;
                }
            }
        }
    }
    
    public void getHorizHistogram(BufferedImage image, int x1, int x2, int y) {
        
        sourceHist = new ArrayList<MyColor>();
        sourceHist.add(new MyColor(image.getRGB(x1, y)));
        int newColor;
        boolean isNewColor = true;
        
        // analyse a vertical bar of the image
        for (int x = x1 + 1; x < x2 - 5; x++) {
            newColor = image.getRGB(x, y);
            
            // for each current color
            for (MyColor currColor : sourceHist) {
                // check if the color already exists
                if (newColor == currColor.getColor()) {
                    // if it does then increment its value and set the new color flag to false
                    currColor.increment();
                    isNewColor = false;
                    break;
                }
            }
            
            // if the color was new
            if (isNewColor = true) {
                // add the color to the list
                sourceHist.add(new MyColor(newColor));
            }
        }
        
        // sort the list in descending order
        Collections.sort(sourceHist);
        Collections.reverse(sourceHist);
        
        // display the results
        jtaSourceInfo.setText(null);
        int colorLabels = 5;
        for (MyColor myColor : sourceHist) {
            if (myColor.getCount() > 10) {
                jtaSourceInfo.append("Color: " + myColor.getColor() + " \t Frequency: " + myColor.getCount() + "\n");
                if (colorLabels > 0) {
                    switch (colorLabels) {
                        case 5: 
                            jlSourceColor1.setBackground(new Color(myColor.getColor(), true));
                            jlSourceColor1.setOpaque(true);
                            break;
                        case 4: 
                            jlSourceColor2.setBackground(new Color(myColor.getColor(), true));
                            jlSourceColor2.setOpaque(true);
                            break;
                        case 3: 
                            jlSourceColor3.setBackground(new Color(myColor.getColor(), true));
                            jlSourceColor3.setOpaque(true);
                            break;
                        case 2: 
                            jlSourceColor4.setBackground(new Color(myColor.getColor(), true));
                            jlSourceColor4.setOpaque(true);
                            break;
                        case 1: 
                            jlSourceColor5.setBackground(new Color(myColor.getColor(), true));
                            jlSourceColor5.setOpaque(true);
                            break;
                    }
                colorLabels--;
                }
            }
        }
    }
    
    
    public void openCheck(JLabel label) { 
        try {
            // open a new file chooser dialog and store it's return value
            int rv = sourceImageChooser.showOpenDialog(this);
            File file;
            // if the user clicked open in the file chooser dialog
            if (rv == JFileChooser.APPROVE_OPTION) {
                file = sourceImageChooser.getSelectedFile();
             
                // check if the file was a jpg
                if (file.getName().contains(".jpg") 
                        || file.getName().contains(".jpeg")
                        || file.getName().contains(".png")) {
                    // assign it to the source image
                    sourceImage = ImageIO.read(file);
                    // put the image in the label
                    displayImage(sourceImage, label);
                } else {
                    System.out.println("openCheck() : file was not a jpg");
                }
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void displayImage(BufferedImage image, JLabel label) {
        if (image.getWidth() > label.getWidth() 
                || image.getHeight() > label.getHeight()) {
            label.setText(null);
            label.setIcon(new ImageIcon(ImageTools.resizeImage(image, label.getWidth(), label.getHeight(), true)));
        }
    }
    
    private void saveHistogram(ArrayList<MyColor> colors, String type) {
        // open file
        File file = new File(type + "Histogram.csv");
        
        // if the file does not exist create it
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        // write 
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (MyColor myColor : colors) {
                bufferedWriter.write(myColor.getColor() + "," + myColor.getCount() + "\n");
            }
        } catch (Exception ex) {
            
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    }
    
    private void compareHistogram(ArrayList<MyColor> hist) {
        // clear results text area
        jtaResults.setText(null);
        
        // boolean array for color matches
        boolean[] travColorMatches = new boolean[5];
        boolean[] stanColorMatches = new boolean[5];
        
        // find the smallest size so we dont compare out of index
        int minSize = hist.size();
        
        for (int x = 0; (x < minSize) && (x < travColorMatches.length); x++) {
            for (int y = 0; y < 5; y++ ) {
                
                if (ImageTools.isColorMatch(hist.get(x).getColor(), travHist.get(y).getColor(), colorRange)) {
                    travColorMatches[x] = true;
                } 
                if (ImageTools.isColorMatch(hist.get(x).getColor(), stanHist.get(y).getColor(), colorRange)) {
                    stanColorMatches[x] = true;
                } 
        
            }
        }
        
        for (int index = 0; index < travColorMatches.length; index++) {
            jtaResults.append("Trav color " + (index+1) + " match : " + travColorMatches[index] + "\n");
        } 
        jtaResults.append("\n\n");
        for (int index = 0; index < stanColorMatches.length; index++) {
            jtaResults.append("Stan color " + (index+1) + " match : " + stanColorMatches[index] + "\n");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sourceImageChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlSourceImage = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jlTargetImage = new javax.swing.JLabel();
        jlStockImage = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaSourceInfo = new javax.swing.JTextArea();
        jlSourceColor1 = new javax.swing.JLabel();
        jlSourceColor2 = new javax.swing.JLabel();
        jlSourceColor3 = new javax.swing.JLabel();
        jlSourceColor4 = new javax.swing.JLabel();
        jlSourceColor5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaResults = new javax.swing.JTextArea();
        jlTravColor1 = new javax.swing.JLabel();
        jlTravColor2 = new javax.swing.JLabel();
        jlTravColor3 = new javax.swing.JLabel();
        jlTravColor4 = new javax.swing.JLabel();
        jlTravColor5 = new javax.swing.JLabel();
        jlStanColor1 = new javax.swing.JLabel();
        jlStanColor2 = new javax.swing.JLabel();
        jlStanColor3 = new javax.swing.JLabel();
        jlStanColor4 = new javax.swing.JLabel();
        jlStanColor5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jbSaveStandardHistogram1 = new javax.swing.JButton();
        jbGetHistogram = new javax.swing.JButton();
        jbOpenSourceImage1 = new javax.swing.JButton();
        jbCompareHistograms1 = new javax.swing.JButton();
        jbSaveTravellersHistogram1 = new javax.swing.JButton();
        jbShowStockTravellersImage1 = new javax.swing.JButton();
        jbShowStockStandardImage1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jbLoadTravHistogram = new javax.swing.JButton();
        jbLoadStandardHistogram = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        sourceImageChooser.setMinimumSize(new java.awt.Dimension(550, 400));
        sourceImageChooser.setPreferredSize(new java.awt.Dimension(1258, 776));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Source Image");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlSourceImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSourceImage.setText("source image not loaded yet");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(232, 232, 232))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jlSourceImage, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jlSourceImage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 271, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(626, 301));

        jlTargetImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTargetImage.setText("target image not loaded yet");

        jlStockImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlStockImage.setText("Stock Image: Travellers Check");
        jlStockImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(214, 214, 214)
                .add(jlStockImage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 244, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jlTargetImage, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .add(jlStockImage)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jlTargetImage, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtaSourceInfo.setColumns(20);
        jtaSourceInfo.setRows(5);
        jScrollPane1.setViewportView(jtaSourceInfo);

        jlSourceColor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSourceColor1.setText("Color 1");
        jlSourceColor1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlSourceColor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSourceColor2.setText("Color 2");
        jlSourceColor2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlSourceColor3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSourceColor3.setText("Color 3");
        jlSourceColor3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlSourceColor4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSourceColor4.setText("Color 4");
        jlSourceColor4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlSourceColor5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSourceColor5.setText("Color 5");
        jlSourceColor5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtaResults.setColumns(20);
        jtaResults.setRows(5);
        jScrollPane2.setViewportView(jtaResults);

        jlTravColor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTravColor1.setText("Color 1");
        jlTravColor1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlTravColor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTravColor2.setText("Color 2");
        jlTravColor2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlTravColor3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTravColor3.setText("Color 3");
        jlTravColor3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlTravColor4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTravColor4.setText("Color 4");
        jlTravColor4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlTravColor5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTravColor5.setText("Color 5");
        jlTravColor5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlStanColor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlStanColor1.setText("Color 1");
        jlStanColor1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlStanColor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlStanColor2.setText("Color 2");
        jlStanColor2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlStanColor3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlStanColor3.setText("Color 3");
        jlStanColor3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlStanColor4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlStanColor4.setText("Color 4");
        jlStanColor4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlStanColor5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlStanColor5.setText("Color 5");
        jlStanColor5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Current Histogram Peaks");

        jLabel5.setText("Travellers Check Histogram Peaks");

        jLabel6.setText("Standard Check Histogram Peaks");

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 309, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jlSourceColor1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 205, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(27, 27, 27)
                                .add(jLabel3))))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(321, 321, 321)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jlSourceColor3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 205, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jlSourceColor2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 205, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jlSourceColor4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 205, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jlSourceColor5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 205, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jlStanColor1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jlStanColor4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jlStanColor3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jlStanColor2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jlStanColor5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                        .add(jlTravColor1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel5))
                    .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jlTravColor3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 212, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jlTravColor2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 212, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jlTravColor4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 212, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jlTravColor5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 212, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1)
                    .add(jScrollPane2)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(jlSourceColor1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlSourceColor2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlSourceColor3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlSourceColor4)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlSourceColor5))
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel6)
                                    .add(jLabel3))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlStanColor1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlStanColor2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlStanColor3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlStanColor4)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlStanColor5))
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(jLabel5)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlTravColor1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlTravColor2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlTravColor3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlTravColor4)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jlTravColor5)))
                        .add(0, 100, Short.MAX_VALUE))))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbSaveStandardHistogram1.setText("Save As Standard Histogram");
        jbSaveStandardHistogram1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveStandardHistogramActionPerformed(evt);
            }
        });

        jbGetHistogram.setText("Get Histogram");
        jbGetHistogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHistogramActionPerformed(evt);
            }
        });

        jbOpenSourceImage1.setText("Open Source Image");
        jbOpenSourceImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOpenSourceImageActionPerformed(evt);
            }
        });

        jbCompareHistograms1.setText("Compare Histograms");
        jbCompareHistograms1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCompareHistogramsActionPerformed(evt);
            }
        });

        jbSaveTravellersHistogram1.setText("Save As Travellers Histogram");
        jbSaveTravellersHistogram1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveTravellersHistogramActionPerformed(evt);
            }
        });

        jbShowStockTravellersImage1.setText("Show Stock Travellers Check");
        jbShowStockTravellersImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbShowStockTravellersImageActionPerformed(evt);
            }
        });

        jbShowStockStandardImage1.setText("Show Stock Standard Check");
        jbShowStockStandardImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbShowStockStandardImageActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Control Panel");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jbLoadTravHistogram.setText("Load Travellers Histogram");
        jbLoadTravHistogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoadTravHistogramActionPerformed(evt);
            }
        });

        jbLoadStandardHistogram.setText("Load Standard Histogram");
        jbLoadStandardHistogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoadStandardHistogramActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jbGetHistogram)
                    .add(jbOpenSourceImage1))
                .add(18, 18, 18)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jbSaveStandardHistogram1)
                    .add(jbSaveTravellersHistogram1))
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbCompareHistograms1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 207, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(30, 30, 30)
                        .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 154, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jbShowStockTravellersImage1)
                    .add(jbLoadTravHistogram))
                .add(18, 18, 18)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jbLoadStandardHistogram)
                    .add(jbShowStockStandardImage1))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(new java.awt.Component[] {jbCompareHistograms1, jbGetHistogram, jbLoadStandardHistogram, jbLoadTravHistogram, jbOpenSourceImage1, jbSaveStandardHistogram1, jbSaveTravellersHistogram1, jbShowStockTravellersImage1}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbOpenSourceImage1)
                    .add(jbShowStockTravellersImage1)
                    .add(jbSaveTravellersHistogram1)
                    .add(jbShowStockStandardImage1)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jbGetHistogram)
                    .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jbSaveStandardHistogram1)
                        .add(jbCompareHistograms1)
                        .add(jbLoadTravHistogram)
                        .add(jbLoadStandardHistogram)))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(new java.awt.Component[] {jbCompareHistograms1, jbGetHistogram, jbOpenSourceImage1, jbSaveTravellersHistogram1, jbShowStockTravellersImage1}, org.jdesktop.layout.GroupLayout.VERTICAL);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                            .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbShowStockStandardImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbShowStockStandardImageActionPerformed
        try {
            targetImage = ImageIO.read(new File("images/stock/stan.jpg"));
            displayImage(targetImage, jlTargetImage);
            jlStockImage.setText("Stock Image: Standard Check");
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbShowStockStandardImageActionPerformed

    private void jbShowStockTravellersImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbShowStockTravellersImageActionPerformed
        try {
            targetImage = ImageIO.read(new File("images/stock/trav.jpg"));
            displayImage(targetImage, jlTargetImage);
            jlStockImage.setText("Stock Image: Travellers Check");
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbShowStockTravellersImageActionPerformed

    private void jbSaveTravellersHistogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveTravellersHistogramActionPerformed
        if (sourceHist != null && !sourceHist.isEmpty()) {
            saveHistogram(sourceHist, "trav");
        } else {
            JOptionPane.showMessageDialog(this, "Source Histogram is empty.", "Error", 0);
        }
    }//GEN-LAST:event_jbSaveTravellersHistogramActionPerformed

    private void jbCompareHistogramsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCompareHistogramsActionPerformed
        if (sourceHist != null && !sourceHist.isEmpty()) {
            compareHistogram(sourceHist);
        } else {
            JOptionPane.showMessageDialog(this, "Source Histogram is empty.", "Error", 0);
        }
    }//GEN-LAST:event_jbCompareHistogramsActionPerformed

    private void jbOpenSourceImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOpenSourceImageActionPerformed
        openCheck(jlSourceImage);
    }//GEN-LAST:event_jbOpenSourceImageActionPerformed

    // get histogram button
    private void jbHistogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHistogramActionPerformed
        displayImage(ImageTools.getGrayscale(sourceImage), jlSourceImage);
        getVertHistogram(ImageTools.getGrayscale(sourceImage), sourceImage.getWidth() / 2, 0 , sourceImage.getHeight());
        //getHorizHistogram(ImageTools.getGrayscale(sourceImage), 0, sourceImage.getWidth(), 5);
    }//GEN-LAST:event_jbHistogramActionPerformed

    private void jbSaveStandardHistogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveStandardHistogramActionPerformed
        if (sourceHist != null && !sourceHist.isEmpty()) {
            saveHistogram(sourceHist, "stan");
        } else {
            JOptionPane.showMessageDialog(this, "Source Histogram is empty.", "Error", 0);
        }
    }//GEN-LAST:event_jbSaveStandardHistogramActionPerformed

    private void jbLoadTravHistogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoadTravHistogramActionPerformed
            loadTravHistogram();
    }//GEN-LAST:event_jbLoadTravHistogramActionPerformed

    private void jbLoadStandardHistogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoadStandardHistogramActionPerformed
        loadStanHistogram();
    }//GEN-LAST:event_jbLoadStandardHistogramActionPerformed

    private void loadTravHistogram() {
        // initialize the stock histograms
            travHist = getHistogram("travHistogram.csv");
            
            // initialize the stock color info
            // trav check colors
            jlTravColor1.setBackground(new Color(travHist.get(0).getColor(), true));
            jlTravColor1.setOpaque(true);
            jlTravColor2.setBackground(new Color(travHist.get(1).getColor(), true));
            jlTravColor2.setOpaque(true);
            jlTravColor3.setBackground(new Color(travHist.get(2).getColor(), true));
            jlTravColor3.setOpaque(true);
            jlTravColor4.setBackground(new Color(travHist.get(3).getColor(), true));
            jlTravColor4.setOpaque(true);
            jlTravColor5.setBackground(new Color(travHist.get(4).getColor(), true));
            jlTravColor5.setOpaque(true);
    }

    private void loadStanHistogram() {
            // initialize the stock histograms
            stanHist = getHistogram("stanHistogram.csv");
            
            // stan check colors
            jlStanColor1.setBackground(new Color(stanHist.get(0).getColor(), true));
            jlStanColor1.setOpaque(true);
            jlStanColor2.setBackground(new Color(stanHist.get(1).getColor(), true));
            jlStanColor2.setOpaque(true);
            jlStanColor3.setBackground(new Color(stanHist.get(2).getColor(), true));
            jlStanColor3.setOpaque(true);
            jlStanColor4.setBackground(new Color(stanHist.get(3).getColor(), true));
            jlStanColor4.setOpaque(true);
            jlStanColor5.setBackground(new Color(stanHist.get(4).getColor(), true));
            jlStanColor5.setOpaque(true);

    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbCompareHistograms1;
    private javax.swing.JButton jbGetHistogram;
    private javax.swing.JButton jbLoadStandardHistogram;
    private javax.swing.JButton jbLoadTravHistogram;
    private javax.swing.JButton jbOpenSourceImage1;
    private javax.swing.JButton jbSaveStandardHistogram1;
    private javax.swing.JButton jbSaveTravellersHistogram1;
    private javax.swing.JButton jbShowStockStandardImage1;
    private javax.swing.JButton jbShowStockTravellersImage1;
    private javax.swing.JLabel jlSourceColor1;
    private javax.swing.JLabel jlSourceColor2;
    private javax.swing.JLabel jlSourceColor3;
    private javax.swing.JLabel jlSourceColor4;
    private javax.swing.JLabel jlSourceColor5;
    private javax.swing.JLabel jlSourceImage;
    private javax.swing.JLabel jlStanColor1;
    private javax.swing.JLabel jlStanColor2;
    private javax.swing.JLabel jlStanColor3;
    private javax.swing.JLabel jlStanColor4;
    private javax.swing.JLabel jlStanColor5;
    private javax.swing.JLabel jlStockImage;
    private javax.swing.JLabel jlTargetImage;
    private javax.swing.JLabel jlTravColor1;
    private javax.swing.JLabel jlTravColor2;
    private javax.swing.JLabel jlTravColor3;
    private javax.swing.JLabel jlTravColor4;
    private javax.swing.JLabel jlTravColor5;
    private javax.swing.JTextArea jtaResults;
    private javax.swing.JTextArea jtaSourceInfo;
    private javax.swing.JFileChooser sourceImageChooser;
    // End of variables declaration//GEN-END:variables
}
