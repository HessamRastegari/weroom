package hessam.rastegari.weroom.di;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import hessam.rastegari.weroom.network.RetroServiceInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    String baseurl="http://192.168.1.5:8888/weroom_api/";

    @Singleton
    @Provides
    public RetroServiceInterface getRetrofitServiceInterface(Retrofit retrofit){
        return retrofit.create(RetroServiceInterface.class);
    }

    @Singleton
    @Provides
    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
