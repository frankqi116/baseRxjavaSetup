package com.qi.frank.baserxjavasetup.module.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.TextView;

import com.qi.frank.baserxjavasetup.R;
import com.qi.frank.baserxjavasetup.base.BaseFragment;
import com.qi.frank.baserxjavasetup.network.APIsCallbackWrapper;

import java.util.Objects;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class StepResetPasswordFragment extends BaseFragment {

    private ResetPasswordActivity resetPasswordActivity;

    @BindView(R.id.form_errors)
    TextView formErrors;

    @BindView(R.id.new_password)
    EditText newPasswordTxt;

    @BindView(R.id.verify_password)
    EditText verifyPasswordTxt;

    @BindView(R.id.reset_btn)
    TextView resetBtn;

    @Override
    public int getContentViewLayoutResId() {
        return R.layout.fragment_step_reset_password;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        resetPasswordActivity = (ResetPasswordActivity) Objects.requireNonNull(getActivity());

        resetBtn.setOnClickListener(v -> {
            resetPasswordActivity.showLoading();
            resetPasswordActivity.getCompositeDisposable().add(resetPasswordActivity.createAPIs()
                    .changePassword(newPasswordTxt.getText().toString(), verifyPasswordTxt.getText().toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(new APIsCallbackWrapper<Boolean>(resetPasswordActivity) {
                        @Override
                        protected void onSuccess(Boolean check) {
                            // todo add business logic here
                        }

                        @Override
                        public void onShowError(String message) {
                            // todo choose your specific way of show message
                        }
                    }));
        });
    }
}
