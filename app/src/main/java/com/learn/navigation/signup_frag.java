package com.learn.navigation;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.navigation.databinding.FragmentSignupFragBinding;
import com.learn.navigation.models.Auth;

import java.util.ArrayList;
import java.util.List;


public class signup_frag extends Fragment {

    FragmentSignupFragBinding bind;
    List<Auth> auth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bind = DataBindingUtil.inflate(inflater,R.layout.fragment_signup_frag, container, false);
        final Bundle bundle = this.getArguments();
        auth = bundle.getParcelableArrayList("auth");
        bind.btnSigninClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bind.txtSigninUsername.setText("");
                bind.txtSigninPass.setText("");
                bind.txtSigninConfirmPass.setText("");
                bind.txtSigninEmail.setText("");
                bind.txtSigninPhone.setText("");
            }
        });
        bind.btnSigninSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bind.txtSigninUsername.getText() != null && bind.txtSigninPass.getText()!=null && bind.txtSigninConfirmPass!=null){
                    Auth newAuth = new Auth(bind.txtSigninUsername.getText().toString(), bind.txtSigninPass.getText().toString(),
                            bind.txtSigninEmail.getText().toString(), bind.txtSigninPhone.getText().toString());
                    auth.add(newAuth);
                    bundle.putParcelableArrayList("newAuth", (ArrayList<? extends Parcelable>) auth);
                    Navigation.findNavController(view).navigate(R.id.home_frag, bundle);
                }
            }
        });
        View view = bind.getRoot();
        return view;
    }
}