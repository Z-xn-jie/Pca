package com.example.pca.base;

public abstract class BasePresenter<V extends BaseView> {
    public V view;
    public void attachView(V view){
        this.view = view;
    }
}
