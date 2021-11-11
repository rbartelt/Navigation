package de.xxlstrandkorbverleih.navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public class HomeFragment extends Fragment {

    //Layout per Constructor setzen
    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button buttonLogin = view.findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //actionHomeFragmentToLoginFragment() wird durch SafeArgs Plugin beim compilieren erzeugt
                NavDirections  action = HomeFragmentDirections.actionHomeFragmentToLoginFragment();
                Navigation.findNavController(view).navigate(action);

            }
        });
    }
}
