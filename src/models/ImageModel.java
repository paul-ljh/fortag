package src.models;

import java.util.Observable;
import java.util.Observer;

public class ImageModel extends Observable {
   // the path to the image, its creation date, display name and user rating
   private String filePath;
   private String createdAt;
   private String displayName;
   private Integer rating;

   public ImageModel(String filePath, String createdAt, String displayName, Integer rating) {
      this.filePath = filePath;
      this.createdAt = createdAt;
      this.displayName = displayName;
      this.rating = rating;
   }
  
   public String getFilePath() {
     return this.filePath;
   }
  
   public void setFilePath(String filePath) {
      this.filePath = filePath;
   }

   public String getDisplayName() {
      return this.displayName;
   }

   public void setDisplayName(String displayName) {
      this.displayName = displayName;
   }
  
   public String getCreatedAt() {
      return this.createdAt;
   }
   
   public void setCreatedAt(String createdAt) {
      this.createdAt = createdAt;
   }

   public Integer getRating() {
      return this.rating;
   }
   
   public void setRating(Integer rating) {
      System.out.println("set to rating on model from " + this.rating + " to " + rating);
      this.rating = rating;
      setChanged();
      notifyObservers();
   }
}
