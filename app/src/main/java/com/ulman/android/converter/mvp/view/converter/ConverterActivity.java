package com.ulman.android.converter.mvp.view.converter;

import com.ulman.android.converter.HostActivity;
import com.ulman.android.converter.mvp.view.base.BaseFragment;

public class ConverterActivity extends HostActivity
{
    @Override
    public BaseFragment createFragment()
    {
        return new ConverterFragment();
    }
}
