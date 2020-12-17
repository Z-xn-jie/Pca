package com.example.pca.model;

import com.example.pca.interfaces.IMain;
import com.example.pca.interfaces.net.INetCallBack;
import com.example.pca.presenter.MainPresenter;
import com.example.pca.utils.RetrofitUtils;

public class MainModel implements IMain.MainModel {
    private IMain.MainPresenter presenter;

    public MainModel(IMain.MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getBannerData(String url, INetCallBack<T> callBack) {
        RetrofitUtils.getInstant().get(url,callBack);
    }
}
