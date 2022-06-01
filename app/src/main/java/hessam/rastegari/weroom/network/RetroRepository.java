package hessam.rastegari.weroom.network;

import android.util.Log;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import hessam.rastegari.weroom.data.ActiveWeroomData;
import hessam.rastegari.weroom.data.CategoryData;
import hessam.rastegari.weroom.data.RegisterClass;
import hessam.rastegari.weroom.data.WelcomeClass;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroRepository {

   private RetroServiceInterface retroServiceInterface;

   public RetroRepository(RetroServiceInterface retroServiceInterface) {
      this.retroServiceInterface = retroServiceInterface;
   }

   public void makeAPICall(RegisterClass registerClass, MutableLiveData<List<CategoryData>> mutableLiveDataCategories,
                           MutableLiveData<List<ActiveWeroomData>> mutableLiveDataActiveWerooms){

      Call<WelcomeClass> call = retroServiceInterface.createPostField(registerClass.getFirstname(),
              registerClass.getSurename(),
              registerClass.getUsername(),
              registerClass.getPassword(),
              registerClass.getEmail(),
              registerClass.getToken(),
              registerClass.getAvatar(),
              registerClass.getMood());

      call.enqueue(new Callback<WelcomeClass>() {
         @Override
         public void onResponse(Call<WelcomeClass> call, Response<WelcomeClass> response) {
            if (response.isSuccessful()){
               mutableLiveDataActiveWerooms.postValue(response.body().getActiveWeroomClass().getItems());
               mutableLiveDataCategories.postValue(response.body().getCategoriesClass().getItems());
            }else{
               mutableLiveDataActiveWerooms.postValue(null);
               mutableLiveDataCategories.postValue(null);
            }
         }

         @Override
         public void onFailure(Call<WelcomeClass> call, Throwable t) {
            mutableLiveDataActiveWerooms.postValue(null);
            mutableLiveDataCategories.postValue(null);
         }
      });

   }



   public void makeAPICallResponseBody(RegisterClass registerClass, MutableLiveData<List<CategoryData>> mutableLiveDataCategories,
                           MutableLiveData<List<ActiveWeroomData>> mutableLiveDataActiveWerooms){

      Call<WelcomeClass> call = retroServiceInterface.createPostField(registerClass.getFirstname(),
              registerClass.getSurename(),
              registerClass.getUsername(),
              registerClass.getPassword(),
              registerClass.getEmail(),
              registerClass.getToken(),
              registerClass.getAvatar(),
              registerClass.getMood());

      call.equals(new Callback<ResponseBody>() {
         @Override
         public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            if (response.isSuccessful()){
               Log.d("ResponseBody", String.valueOf(response.code()));
               //mutableLiveDataActiveWerooms.postValue(response.body().getActiveWeroomClass().getItems());
               //mutableLiveDataCategories.postValue(response.body().getCategoriesClass().getItems());
            }else{
               //mutableLiveDataActiveWerooms.postValue(null);
               //mutableLiveDataCategories.postValue(null);
            }
         }

         @Override
         public void onFailure(Call<ResponseBody> call, Throwable t) {
//            mutableLiveDataActiveWerooms.postValue(null);
//            mutableLiveDataCategories.postValue(null);
            Log.d("ResponseBody", t.getStackTrace().toString());
         }
      });

   }
}
