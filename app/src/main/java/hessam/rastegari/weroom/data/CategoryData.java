package hessam.rastegari.weroom.data;

public class CategoryData {

   public String catName;
   public Integer catID;

   public CategoryData(String catName, Integer catID) {
      this.catName = catName;
      this.catID = catID;
   }

   public String getCatName() {
      return catName;
   }

   public void setCatName(String catName) {
      this.catName = catName;
   }

   public Integer getCatID() {
      return catID;
   }

   public void setCatID(Integer catID) {
      this.catID = catID;
   }
}
