package view;

import java.util.List;

import model.Hero;

public interface MainContentView {
    public void OnResponseSuccess(List<Hero> heroesList);
    public void OnResponseFails();
}
