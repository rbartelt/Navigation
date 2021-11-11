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

public class LoginFragment extends Fragment {
    public LoginFragment(){
        super(R.layout.fragment_login);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView username = view.findViewById(R.id.edit_text_username);
        TextView password = view.findViewById(R.id.edit_text_password);
        Button buttonConfirm = view.findViewById(R.id.button_confirm);
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                NavDirections action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(strUsername, strPassword);
                Navigation.findNavController(view).navigate(action);

            }
        });
    }

}
