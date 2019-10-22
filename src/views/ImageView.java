package src.views;

import src.models.ImageModel;
import src.common_components.Constants;
import src.image_components.PicturePanel;
import src.image_components.MetaDataPanel;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class ImageView extends JPanel implements Observer {
  private ImageModel image;
  private MetaDataPanel metaDataPanel;
  private int starSize;

  public ImageView(ImageModel image, int picSize, int starSize) {
    this.image = image;
    this.starSize = starSize;

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    PicturePanel picPanel = new PicturePanel(image, picSize);
    this.metaDataPanel = new MetaDataPanel(image, starSize);
    add(picPanel);
    add(metaDataPanel);
  }

  public int getRating() {
    return this.image.getRating();
  }

  // TODO: with enlarged JFrame present, clicking on the original JFrame doesn't syncronize with the enlarged one. However it does vice versa.
  @Override
	public void update(Observable o, Object arg) {
    System.out.println("update received!");
    this.remove(this.metaDataPanel);
    this.metaDataPanel = new MetaDataPanel(image, this.starSize);  
    this.add(metaDataPanel);
    revalidate();
    repaint();
  }
}
