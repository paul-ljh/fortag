package src.views;

import src.common_components.*;
import src.toolbar_components.*;
import src.models.*;

import java.awt.FlowLayout;
import javax.swing.*;

public class ToolBarView extends JPanel {

  public ToolBarView(ImageCollectionModel collectionModel, ImageCollectionView collectionView) {
    DisplayOptionPanel displayOption = new DisplayOptionPanel(collectionView);
    FileUploadPanel fileUpload = new FileUploadPanel(collectionModel);
    ClearPanel clear = new ClearPanel(collectionModel);
    FilterRatingPanel filterRating = new FilterRatingPanel(collectionView);

    JTextArea nameText = new JTextArea(Constants.AppTitle);
    nameText.setEditable(false);
    nameText.setFont(nameText.getFont().deriveFont(Constants.AppTitleFontSize));
    JPanel namePanel = new JPanel();
    namePanel.add(nameText);

    setLayout(new WrapLayout());
    add(displayOption);
    add(namePanel);
    add(clear);
    add(fileUpload);
    add(filterRating);
  }
}

