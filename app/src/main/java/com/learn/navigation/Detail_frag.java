package com.learn.navigation;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.navigation.databinding.FragmentDetailFragBinding;
import com.learn.navigation.models.Auth;

import java.util.List;


public class Detail_frag extends Fragment {
    Auth auth;
    FragmentDetailFragBinding bind;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_frag, container, false);
        View view =  bind.getRoot();
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            auth = bundle.getParcelable("auth");
        }
        bind.setAuth(auth);
        return view;
    }
}