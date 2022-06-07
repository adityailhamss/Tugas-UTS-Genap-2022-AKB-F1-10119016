package com.example.uts_10119016_adityailham.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//NIM     : 10119016
//NAMA    : ADITYA ILHAM SUBAGJA
//KELAS   : IF-1

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aplikasi pencatat kegiatan harian");
    }

    public LiveData<String> getText() {
        return mText;
    }
}