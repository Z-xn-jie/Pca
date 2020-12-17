package com.example.pca.interfaces;

import com.example.pca.interfaces.net.INetCallBack;

public interface IMain {
    interface MainView{

    }
    interface MainPresenter{
        void transfer();
    }
    interface MainModel{
        <T>void getBannerData(String url, INetCallBack<T> callBack);
    }

}
