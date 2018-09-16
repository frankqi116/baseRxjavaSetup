package com.qi.frank.baserxjavasetup.module.profile;

import android.os.Bundle;

import com.qi.frank.baserxjavasetup.R;
import com.qi.frank.baserxjavasetup.base.BaseActivity;

public class ResetPasswordActivity extends BaseActivity {

    @Override
    public int getContentViewLayoutResId() {
        return R.layout.activity_reset_pwd;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StepResetPasswordFragment stepResetPasswordFragment = new StepResetPasswordFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.steps_container, stepResetPasswordFragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
