package src.models;

import src.models.ImageModel;
import src.common_components.*;

import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


public class ImageCollectionModel extends Observable {
  private ArrayList<ImageModel> images;
  private String historyFilePath;

  // -1 meaning it's just been cleared
  private int lastBatchSize;

  public ImageCollectionModel() {
    this.images = new ArrayList<ImageModel>();

    // Load history file, create one if it doesn't exist
    File historyFile = FileIOService.loadFile(Constants.HistoryFilePath, false);
    if (!historyFile.exists()) FileIOService.createFile(historyFile);
    
    this.historyFilePath = historyFile.getAbsolutePath();

    this.populateImages();
    this.lastBatchSize = images.size();
    setChanged();
  }

  public void setLastBatchSize(int lastBatchSize) {
    this.lastBatchSize = lastBatchSize;
  }

  public int getLastBatchSize() {
    return this.lastBatchSize;
  }

  public String formatDate(long d) {
    Date date = new Date(d);
    DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    return formatter.format(date);
  }

  public void populateImages() {
    ArrayList<File> files = new ArrayList<File>();
    // history file is guarranteed to exist at this point
    String[] lines = FileIOService.readFile(this.historyFilePath);
    
    for (String line : lines) {      
      File image = FileIOService.loadFile(line, false);
      if (!image.exists()) continue;
      files.add(image);
    }
    this.addImageModels(files, true);
  }

  public void addImageModels(ArrayList<File> files, Boolean isHistory) {
    for (File imageFile : files) {
      ImageModel img = new ImageModel(
        imageFile.getPath(),
        formatDate(imageFile.lastModified()),
        imageFile.getName(),
        0
      );
      if (!isHistory) FileIOService.writeToFile(this.historyFilePath, imageFile.getAbsolutePath());
      images.add(img);
    }
    setChanged();
    notifyObservers();
  }

  public void clearImageModels() {
    this.images.clear();
    this.setLastBatchSize(-1);

    deleteHistoryFile();
    setChanged();
    notifyObservers();
  }
  
  public void deleteHistoryFile() {
    File image = FileIOService.loadFile(this.historyFilePath, false);
    if (!image.exists()) return;
    image.delete();
  }

  public ArrayList<ImageModel> getLastBatch() {
    return new ArrayList<ImageModel>(
      images.subList(images.size() - this.lastBatchSize, images.size())
    );
  }
}
