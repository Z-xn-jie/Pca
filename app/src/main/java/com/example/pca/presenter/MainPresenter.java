package com.example.pca.presenter;

import com.example.pca.base.BaseActivity;
import com.example.pca.base.BasePresenter;
import com.example.pca.interfaces.IMain;
import com.example.pca.model.MainModel;
import com.example.pca.view.MainActivity;

public class MainPresenter extends BasePresenter<IMain.MainView> implements IMain.MainPresenter{
    private IMain.MainModel model;

    public MainPresenter() {
        this.model = new MainModel(this);
    }

    @Override
    public void transfer() {

    }
}
