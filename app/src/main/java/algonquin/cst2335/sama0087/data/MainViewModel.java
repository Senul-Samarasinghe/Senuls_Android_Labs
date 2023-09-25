package algonquin.cst2335.sama0087.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {


    public MutableLiveData<String> userString = new MutableLiveData("");

    public MutableLiveData<Boolean> onOroff = new MutableLiveData<Boolean>(false);
}
