package src.image_components;

import src.common_components.*;
import src.models.ImageModel;
import src.views.ImageView;

import javax.swing.*;
import java.awt.Container;
import java.awt.event.*;

public class PicturePanel extends JPanel {
  private ImageModel image;
  private int size;
  private JButton picButton;

  public PicturePanel(ImageModel image, int size) {
    this.image = image;
    this.size = size;

    ImageIcon img = FileIOService.loadAndScale(this.image.getFilePath(), size);
    this.picButton = new JButton(img);

    // only add actionListener for normal picture panels, not already enlarged
    if (this.size != Constants.EnlargedPictureSize) {
      picButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          PicButtonActionPerformed(e);
        }
      });
    }
    add(picButton);
  }

  private void PicButtonActionPerformed(ActionEvent e) {
    JFrame frame = new JFrame(); 
    Container pane = frame.getContentPane();
    ImageView view = new ImageView(this.image, Constants.EnlargedPictureSize, Constants.EnlargedStarSize);
    pane.add(view);

    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame.setSize(Constants.EnlargedFrameWidth, Constants.EnlargedFrameHeight);
    frame.setVisible(true);
  }
}
