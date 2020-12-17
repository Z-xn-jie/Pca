package com.example.pca.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pca.R;
import com.example.pca.base.BaseActivity;
import com.example.pca.base.BasePresenter;
import com.example.pca.interfaces.IMain;
import com.example.pca.interfaces.net.INetCallBack;
import com.example.pca.model.data.BannerBean;
import com.example.pca.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements IMain.MainView {


    private TextView text;

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        presenter.transfer();
    }

    @Override
    protected void initView() {
        text = findViewById(R.id.text);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void getBanner(BannerBean bannerBean) {
        String code = bannerBean.getCode();
        text.setText(code);

    }


}