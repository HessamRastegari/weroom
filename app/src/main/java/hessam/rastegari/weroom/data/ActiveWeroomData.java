package hessam.rastegari.weroom.data;

public class ActiveWeroomData {

   public Integer activeWeroomId;
   public Integer catId;
   public Integer catAvatar;

   public ActiveWeroomData(Integer activeWeroomId, Integer catId, Integer catAvatar) {
      this.activeWeroomId = activeWeroomId;
      this.catId = catId;
      this.catAvatar = catAvatar;
   }

   public Integer getActiveWeroomId() {
      return activeWeroomId;
   }

   public void setActiveWeroomId(Integer activeWeroomId) {
      this.activeWeroomId = activeWeroomId;
   }

   public Integer getCatId() {
      return catId;
   }

   public void setCatId(Integer catId) {
      this.catId = catId;
   }

   public Integer getCatAvatar() {
      return catAvatar;
   }

   public void setCatAvatar(Integer catAvatar) {
      this.catAvatar = catAvatar;
   }
}
