package com.example.pca.interfaces;

import com.example.pca.base.BaseView;
import com.example.pca.interfaces.net.INetCallBack;
import com.example.pca.model.data.BannerBean;

public interface IMain {
    interface MainView extends BaseView {
        void getBanner(BannerBean bannerBean);
    }
    interface MainPresenter{
        void transfer();
    }
    interface MainModel{
        <T>void getBannerData(String url, INetCallBack<T> callBack);
    }

}
