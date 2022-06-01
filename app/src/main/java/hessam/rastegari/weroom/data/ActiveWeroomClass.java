package hessam.rastegari.weroom.data;

import java.util.List;

public class ActiveWeroomClass {

   private List<ActiveWeroomData> items;

   public ActiveWeroomClass(List<ActiveWeroomData> items) {
      this.items = items;
   }

   public List<ActiveWeroomData> getItems() {
      return items;
   }

   public void setItems(List<ActiveWeroomData> items) {
      this.items = items;
   }
}
