package com.learn.navigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.navigation.databinding.FragmentHomeFragBinding;
import com.learn.navigation.models.Auth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class home_frag extends Fragment {
    List<Auth> auth = new ArrayList<>();
    FragmentHomeFragBinding bind;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if(bundle.getParcelableArrayList("newAuth") != null){
            auth = bundle.getParcelableArrayList("newAuth");
        }
        // Inflate the layout for this fragment
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_home_frag, container, false);
        View view =  bind.getRoot();
        bind.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = bind.txtUsername.getText().toString();
                String pass = bind.txtPassword.getText().toString();
                Iterator iterator = auth.iterator();
                for (Iterator it = iterator; it.hasNext(); ) {
                    Auth i = (Auth) it.next();
                    if(i.getUname().equals(uname) && i.getPass().equals(pass)){
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("auth", i);
                        Navigation.findNavController(view).navigate(R.id.detail_frag, bundle);
                    }
                }
            }
        });
        bind.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("auth", (ArrayList<? extends Parcelable>) auth);
                Navigation.findNavController(view).navigate(R.id.signup_frag, bundle);
            }
        });
        return view;
    }


}