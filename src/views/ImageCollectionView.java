package src.views;

import src.common_components.*;
import src.models.*;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

public class ImageCollectionView extends JPanel implements Observer {
  private ArrayList<ImageView> views;
  private ImageCollectionModel collectionModel;

  public ImageCollectionView(ImageCollectionModel collectionModel) {
    this.collectionModel = collectionModel;
    this.views = new ArrayList<ImageView>();
    this.setLayout(new WrapLayout());
  }

  public void filterViews(int rating) {
    this.removeAll();
    for (ImageView view : views) {
      if (view.getRating() >= rating) {
        this.add(view);
      }
    } 
    this.revalidate();
    this.repaint();
  }

  public void displayInList() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.revalidate();
    this.repaint();
  }

  public void displayInGrid() {
    this.setLayout(new WrapLayout());
    this.revalidate();
    this.repaint();
  }

  public void addToViews() {
    ArrayList<ImageModel> lastBatch = this.collectionModel.getLastBatch();
    for (ImageModel img : lastBatch) {
      ImageView view = new ImageView(img, Constants.PictureSize, Constants.StarSize);
      img.addObserver(view);
      this.views.add(view);
      this.add(view);
    }
    this.revalidate();
    System.out.println("we have " + this.views.size() + " views in the collectionView");
  }

  public void clearViews() {
    System.out.println("Clearing " + this.views.size() + " views");
    this.views.clear();
    System.out.println(this.views.size() + " views left");
    this.removeAll();
    this.revalidate();
    this.repaint();
  }

  public void updateViews() {
    if (this.collectionModel.getLastBatchSize() == -1) {
      clearViews();
    } else {
      addToViews();
    }
  }

	@Override
	public void update(Observable o, Object arg) {
    updateViews();
  }
}

