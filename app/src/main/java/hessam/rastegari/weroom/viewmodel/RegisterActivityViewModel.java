package hessam.rastegari.weroom.viewmodel;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import hessam.rastegari.weroom.data.ActiveWeroomData;
import hessam.rastegari.weroom.data.CategoryData;
import hessam.rastegari.weroom.data.RegisterClass;
import hessam.rastegari.weroom.network.RetroRepository;
import hessam.rastegari.weroom.network.RetroServiceInterface;

@HiltViewModel
public class RegisterActivityViewModel extends ViewModel {

    MutableLiveData<List<CategoryData>> mutableLiveDataCategroryData;
    MutableLiveData<List<ActiveWeroomData>> mutableLiveDataActiveWeroomData;
    RegisterClass registerClass;

    @Inject
    RetroServiceInterface retroServiceInterface;

    @Inject
    public RegisterActivityViewModel() {

        mutableLiveDataCategroryData = new MutableLiveData();
        mutableLiveDataActiveWeroomData = new MutableLiveData();
    }

    public void setInputs(RegisterClass registerClass){
        this.registerClass = registerClass;
    }


    public MutableLiveData<List<CategoryData>> getMutableLiveDataCategroryData(){
        return mutableLiveDataCategroryData;
    }

    public MutableLiveData<List<ActiveWeroomData>> getMutableLiveDataActiveWeroomData(){
        return mutableLiveDataActiveWeroomData;
    }

    public void makeApiCall(){
        RetroRepository retroRepository = new RetroRepository(retroServiceInterface);
        retroRepository.makeAPICall(registerClass,mutableLiveDataCategroryData,mutableLiveDataActiveWeroomData);
    }

    public void makeApiCallResponseBody(){
        RetroRepository retroRepository = new RetroRepository(retroServiceInterface);
        retroRepository.makeAPICallResponseBody(registerClass,mutableLiveDataCategroryData,mutableLiveDataActiveWeroomData);
    }
}
