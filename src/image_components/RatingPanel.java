package src.image_components;

import src.common_components.*;
import src.models.ImageModel;
import src.views.ImageCollectionView;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RatingPanel extends JPanel implements MouseListener {
  private ImageCollectionView collectionView;
  private Boolean isFilter;
  private ImageModel image;
  private int clicked;
  private int starSize;

  protected final ArrayList<IconLabel> labelList = new ArrayList<IconLabel>(
    Arrays.asList(
      new IconLabel(),
      new IconLabel(),
      new IconLabel(),
      new IconLabel(),
      new IconLabel())
  );

  // for filter rating panel, we will pass parameter image as null
  public RatingPanel(ImageCollectionView collectionView, ImageModel image, int starSize, Boolean isFilter) {
    this.collectionView = collectionView;
    this.image = image;
    this.clicked = image == null ? -1 : image.getRating();
    this.isFilter = isFilter;
    this.starSize = starSize;

    ImageIcon clearImg = FileIOService.loadAndScale(Constants.ClearStarsIconPath, this.starSize);
    JButton clearButton = new JButton(clearImg);
    clearButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        clear();
      }
    });
    add(clearButton);

    String starPath;
    for (IconLabel l : labelList) {
      starPath = labelList.indexOf(l) < this.clicked ? Constants.FullStar : Constants.EmptyStar;
      l.setIconLabel(starPath, this.starSize);
      add(l);
    }
    addMouseListener(this);
  }

  public void clear() {
    clicked = -1;
    repaintIcon(clicked);
  }

  public void mouseClicked(MouseEvent e) {
    clicked = getSelectedIconIndex(e.getPoint());
    System.out.println(e.getPoint() + "Clicked on index " + clicked);
    repaintIcon(clicked);
  }

  private int getSelectedIconIndex(Point p) {
    Rectangle r;
    for (int i = 0; i < labelList.size(); ++i) {
      r = labelList.get(i).getBounds();
      if (r.contains(p)) return i;
    }
    return -1;
  }

  protected void repaintIcon(int index) {
    // No need to set model ratings for rating filter panel
    if (this.isFilter) {
      this.collectionView.filterViews(index + 1);
    } else {
      this.image.setRating(index + 1);
    }

    for (int i = 0; i < labelList.size(); ++i) {
      labelList.get(i).setIconLabel(i <= index ? Constants.FullStar : Constants.EmptyStar, this.starSize);
    }
  }

  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}
  public void mouseMoved(MouseEvent e) {}
  public void mouseDragged(MouseEvent e) {}
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
}
