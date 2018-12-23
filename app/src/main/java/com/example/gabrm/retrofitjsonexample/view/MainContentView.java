package com.example.gabrm.retrofitjsonexample.view;

import java.util.List;

import com.example.gabrm.retrofitjsonexample.model.Hero;

public interface MainContentView {
    public void OnResponseSuccess(List<Hero> heroesList);
    public void OnResponseFails();
}
