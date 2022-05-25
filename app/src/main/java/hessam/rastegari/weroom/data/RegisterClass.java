package hessam.rastegari.weroom.data;

public class RegisterClass {

   private String firstname;
   private String surename;
   private String username;
   private String password;
   private String email;
   private String token;
   private String avatar;
   private Integer mood;

   public RegisterClass(String firstname, String surename, String username, String password, String email, String token, String avatar, Integer mood) {
      this.firstname = firstname;
      this.surename = surename;
      this.username = username;
      this.password = password;
      this.email = email;
      this.token = token;
      this.avatar = avatar;
      this.mood = mood;
   }

   public String getFirstname() {
      return firstname;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public String getSurename() {
      return surename;
   }

   public void setSurename(String surename) {
      this.surename = surename;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
   }

   public String getAvatar() {
      return avatar;
   }

   public void setAvatar(String avatar) {
      this.avatar = avatar;
   }

   public Integer getMood() {
      return mood;
   }

   public void setMood(Integer mood) {
      this.mood = mood;
   }
}
