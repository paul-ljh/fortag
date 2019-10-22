package src.common_components;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileIOService {  
  public static File loadFile(String filePath, Boolean exitOnError) {
    File f = null;
    try {
      f = new File(filePath);
      if (!f.exists()) throw new IOException();
    } catch(Exception e) {
      e.printStackTrace();
      System.out.println("FAILED to load " + filePath);
      if (exitOnError) System.exit(0);
    }
    return f;
  }

  public static void createFile(File file) {
    try {
      file.createNewFile();
    } catch(IOException ioe) {
      ioe.printStackTrace();
      System.out.println("FAILED to create" + file.getAbsolutePath());
      System.exit(0);
    }
  }

  public static void writeToFile(String filePath, String content) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
      writer.write(content, 0, content.length());
      writer.newLine();
      writer.close();
    } catch(IOException ioe) {
      ioe.printStackTrace();
      System.exit(0);
    }
  }

  public static String[] readFile(String filePath) {
    String[] lines = null;
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath));
      Object[] objects = reader.lines().toArray();
      lines = Arrays.asList(objects).toArray(new String[objects.length]);
      reader.close();
    } catch(IOException ioe) {
      ioe.printStackTrace();
      System.exit(0);
    }
    return lines;
  }

  public static ImageIcon loadAndScale(String filePath, int size) {
    loadFile(filePath, true);
    ImageIcon icon = new ImageIcon(filePath);
    // transform to Image class then resize
    Image newImg = icon.getImage().getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH);
    return new ImageIcon(newImg);
  }
}
