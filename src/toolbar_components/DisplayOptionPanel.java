package src.toolbar_components;

import src.views.ImageCollectionView;
import src.common_components.*;
import src.models.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DisplayOptionPanel extends JPanel {
  private JButton listButton;
  private JButton gridButton;
  private ImageCollectionView collectionView;

  private void ListButtonActionPerformed(ActionEvent e) {
    System.out.println("list button clicked");
    this.collectionView.displayInList();
  }

  private void GridButtonActionPerformed(ActionEvent e) {
    System.out.println("Grid button clicked");
    this.collectionView.displayInGrid();
  }

  public DisplayOptionPanel(ImageCollectionView collectionView) {
    this.collectionView = collectionView;

    String listIconPath = "src/assets/icons/listlayout.png";
    ImageIcon listImg = FileIOService.loadAndScale(listIconPath, Constants.ToolBarButtonSize);
    listButton = new JButton(listImg);
    listButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ListButtonActionPerformed(e);
      }
    });

    String gridIconPath = "src/assets/icons/gridlayout.png";
    ImageIcon gridImg = FileIOService.loadAndScale(gridIconPath, Constants.ToolBarButtonSize);
    gridButton = new JButton(gridImg);
    gridButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GridButtonActionPerformed(e);
      }
    });

    add(gridButton);
    add(listButton);
  }
}

