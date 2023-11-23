package algonquin.cst2335.sama0087.data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import algonquin.cst2335.sama0087.databinding.DetailsLayoutBinding;

public class MessageDetailsFragment extends Fragment {

    ChatMessage selected;

    public MessageDetailsFragment(){

    }
    public MessageDetailsFragment (ChatMessage m) {
        this.selected = m;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        DetailsLayoutBinding binding = DetailsLayoutBinding.inflate(inflater);

        binding.textView2.setText(selected.message);
        binding.textView4.setText(selected.timeSent);
        binding.textView6.setText("Id = " + selected.id);

        return binding.getRoot();
    }

    public void displayMessage(ChatMessage newValue) {
    }
}
