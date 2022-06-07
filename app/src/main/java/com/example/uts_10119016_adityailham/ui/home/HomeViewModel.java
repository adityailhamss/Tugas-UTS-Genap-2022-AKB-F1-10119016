package com.example.uts_10119016_adityailham.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//NIM     : 10119016
//NAMA    : ADITYA ILHAM SUBAGJA
//KELAS   : IF-1

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        String nim = ("NIM : 10119016\n\n");
        String nama = ("Nama : Aditya Ilham Subagja\n\n");
        String kelas = ("Kelas : IF-1\n\n");
        String email = ("Email : adityailham193@gmail.com");

        mText = new MutableLiveData<>();
        mText.setValue(nim+nama+kelas+email);
    }

    public LiveData<String> getText() {
        return mText;
    }
}