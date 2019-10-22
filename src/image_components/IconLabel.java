package src.image_components;

import src.common_components.FileIOService;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class IconLabel extends JLabel {
  public void setIconLabel(String filePath, int size) {
    ImageIcon icon = FileIOService.loadAndScale(filePath, size);
    setIcon(icon);
  }
}
