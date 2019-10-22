package src.image_components;

import src.models.ImageModel;
import java.awt.Component;
import javax.swing.*;

public class MetaDataPanel extends JPanel {

  public MetaDataPanel(ImageModel image, int starSize) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    JTextArea nameText = new JTextArea(image.getDisplayName());
    nameText.setEditable(false);
    JPanel namePanel = new JPanel();
    namePanel.add(nameText);
    
    JTextArea dateText = new JTextArea(image.getCreatedAt());
    dateText.setEditable(false);
    JPanel datePanel = new JPanel();
    datePanel.add(dateText);
    
    RatingPanel ratingPanel = new RatingPanel(null, image, starSize, false);

    // namePanel.setAlignmentX( Component.LEFT_ALIGNMENT );
    // datePanel.setAlignmentX( Component.LEFT_ALIGNMENT );
    // ratingPanel.setAlignmentX( Component.LEFT_ALIGNMENT );
    
    add(namePanel);
    add(datePanel);
    add(ratingPanel);
  }
}
