package com.example.uts_10119016_adityailham.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.uts_10119016_adityailham.MyDatabaseHelper;
import com.example.uts_10119016_adityailham.databinding.FragmentGalleryBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

//NIM     : 10119016
//NAMA    : ADITYA ILHAM SUBAGJA
//KELAS   : IF-1

public class GalleryFragment extends Fragment {

    /* Deklarasi variable */
    private FloatingActionButton addButton;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private ArrayList<ModelDiary> listTask = new ArrayList<>();
    private MyDatabaseHelper helper;

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}