package algonquin.cst2335.sama0087.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {


    public MutableLiveData<String> userString = new MutableLiveData("");

    public MutableLiveData<Boolean> onOroff = new MutableLiveData<Boolean>(false);

    public class ChatRoomViewModel extends ViewModel {
        public MutableLiveData<ArrayList<String>> messages = new MutableLiveData<>();
    }
}
