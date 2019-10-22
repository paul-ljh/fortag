package src;

import src.views.*;
import src.models.*;
import src.common_components.Constants;

import javax.swing.*;
import java.awt.*;

class Main {
  public static void main(String[] args) {
    JFrame frame = new JFrame(Constants.AppTitle); 
    Container pane = frame.getContentPane();
    pane.setLayout(new BorderLayout());
    
    ImageCollectionModel collectionModel = new ImageCollectionModel();
    
    ImageCollectionView collectionView = new ImageCollectionView(collectionModel);
    collectionView.setSize(new Dimension(1200, 700));
    
    JScrollPane scrollBar = new JScrollPane(collectionView, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    pane.add(scrollBar, BorderLayout.CENTER);
    
    ToolBarView toolbarView = new ToolBarView(collectionModel, collectionView);
    pane.add(toolbarView, BorderLayout.PAGE_START); 
    
    collectionModel.addObserver(collectionView);
    collectionModel.notifyObservers();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setMinimumSize(new Dimension(500, 400));
    frame.setSize(1200, 800);
    frame.setVisible(true);
  }
}
