package com.example.pca.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pca.interfaces.IMain;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {
protected T presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (presenter == null){
            presenter = getPresenter();
            presenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract T getPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getLayoutId();
}
