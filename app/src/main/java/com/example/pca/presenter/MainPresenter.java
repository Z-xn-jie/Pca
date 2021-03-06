package com.example.pca.presenter;

import com.example.pca.base.BaseActivity;
import com.example.pca.base.BasePresenter;
import com.example.pca.interfaces.IMain;
import com.example.pca.interfaces.net.INetCallBack;
import com.example.pca.interfaces.net.URLConstant;
import com.example.pca.model.MainModel;
import com.example.pca.model.data.BannerBean;
import com.example.pca.view.MainActivity;

import static com.example.pca.interfaces.net.URLConstant.BANNER;

public class MainPresenter extends BasePresenter<IMain.MainView> implements IMain.MainPresenter{
    private IMain.MainModel model;

    public MainPresenter() {
        this.model = new MainModel(this);
    }

    @Override
    public void transfer() {
        model.getBannerData(BANNER, new INetCallBack<BannerBean>() {
            @Override
            public void onSuccess(BannerBean bannerBean) {
                view.getBanner(bannerBean);
            }

            @Override
            public void onFail(String error) {

            }
        });
    }
}
