package src.toolbar_components;

import src.image_components.RatingPanel;
import src.common_components.Constants;
import src.views.ImageCollectionView;
import src.models.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class FilterRatingPanel extends JPanel {
  public FilterRatingPanel(ImageCollectionView collectionView) {
    // Filter by: text
    JTextArea filterText = new JTextArea(Constants.FilterTitle);
    filterText.setEditable(false);
    filterText.setFont(filterText.getFont().deriveFont(Constants.FilterTitleFontSize));

    JPanel filterTextPanel = new JPanel();
    filterTextPanel.add(filterText);

    // Actual Rating panel
    RatingPanel rating = new RatingPanel(collectionView, null, Constants.ToolBarButtonSize, true);

    add(filterTextPanel);
    add(rating);
  }
}

