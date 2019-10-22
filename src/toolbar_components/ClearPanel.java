package src.toolbar_components;

import src.common_components.*;
import src.models.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ClearPanel extends JPanel {
  private JButton clearButton;
  private ImageCollectionModel collectionModel;

  private void ClearButtonActionPerformed(ActionEvent e) {
    this.collectionModel.clearImageModels();
  }

  public ClearPanel(ImageCollectionModel collectionModel) {
    this.collectionModel = collectionModel;

    ImageIcon gridImg = FileIOService.loadAndScale(Constants.ClearIconPath, Constants.ToolBarButtonSize);
    clearButton = new JButton(gridImg);
    clearButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ClearButtonActionPerformed(e);
      }
    });
    add(clearButton);
  }
}

