package de.xxlstrandkorbverleih.navigation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class WelcomeFragment extends Fragment {
    private WelcomeFragmentArgs args;
    private TextView tvUsername;
    private TextView tvPassword;
    private Button buttonOk;
    public WelcomeFragment(){
        super(R.layout.fragment_welcome);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        args = WelcomeFragmentArgs.fromBundle(getArguments());
        tvUsername = view.findViewById(R.id.text_view_username);
        tvPassword = view.findViewById(R.id.text_view_password);
        tvUsername.setText(args.getUsername());
        tvPassword.setText(args.getPassword());
        buttonOk = view.findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment();
                Navigation.findNavController(view).navigate(action);
            }
        });


    }
}
