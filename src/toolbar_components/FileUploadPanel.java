package src.toolbar_components;

import src.common_components.*;
import src.models.*;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.util.ArrayList;
import java.util.Arrays;


public class FileUploadPanel extends JPanel {
  private JButton chooseButton;
  private ImageCollectionModel collectionModel;

  private void ChooseButtonActionPerformed(ActionEvent e) {
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
      "PNG & JPG & GIF Images", "jpg", "gif", "png"
    );
    chooser.setFileFilter(filter);
    chooser.setMultiSelectionEnabled(true);

    int returnVal = chooser.showOpenDialog(null);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      ArrayList<File> files = new ArrayList<File>(
        Arrays.asList(chooser.getSelectedFiles())
      );
      this.collectionModel.setLastBatchSize(files.size());
      this.collectionModel.addImageModels(files, false);
    }
  }

  public FileUploadPanel(ImageCollectionModel collectionModel) {
    this.collectionModel = collectionModel;
    String iconPath = "src/assets/icons/fileopener.png";

    ImageIcon img = FileIOService.loadAndScale(iconPath, Constants.ToolBarButtonSize);
    chooseButton = new JButton(img);
    chooseButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          ChooseButtonActionPerformed(e);
      }
    });
    add(chooseButton);
  }
}

