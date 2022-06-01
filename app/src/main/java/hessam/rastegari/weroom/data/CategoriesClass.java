package hessam.rastegari.weroom.data;

import java.util.List;

public class CategoriesClass {


   private List<CategoryData> items;

   public CategoriesClass(List<CategoryData> items) {
      this.items = items;
   }

   public List<CategoryData> getItems() {
      return items;
   }

   public void setItems(List<CategoryData> items) {
      this.items = items;
   }
}
