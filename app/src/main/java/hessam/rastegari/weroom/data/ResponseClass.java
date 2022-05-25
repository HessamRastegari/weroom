package hessam.rastegari.weroom.data;

import com.google.gson.annotations.SerializedName;

public class ResponseClass {

   @SerializedName("success")
   private String success;
   @SerializedName("message")
   private String message;

   public String getSuccess() {
      return success;
   }

   public void setSuccess(String success) {
      this.success = success;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public ResponseClass(String success, String message) {
      this.success = success;
      this.message = message;
   }
}
