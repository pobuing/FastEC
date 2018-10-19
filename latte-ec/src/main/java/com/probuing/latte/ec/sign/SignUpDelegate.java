package com.probuing.latte.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.probuing.latte.ec.R;
import com.probuing.latte.ec.R2;
import com.probuing.latte_core.delegates.LatteDelegate;
import com.probuing.latte_core.net.RestClient;
import com.probuing.latte_core.net.callback.IFailure;
import com.probuing.latte_core.net.callback.ISuccess;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author wxblack-mac
 * @DATE 2018/10/19 18:40
 * @DESCRIBE: 注册页面
 * GOOD LUCK
 */
public class SignUpDelegate extends LatteDelegate {
    @BindView(R2.id.edit_sign_up_name)
    TextInputEditText editSignUpName;
    @BindView(R2.id.edit_sign_up_email)
    TextInputEditText editSignUpEmail;
    @BindView(R2.id.edit_sign_up_phone)
    TextInputEditText editSignUpPhone;
    @BindView(R2.id.edit_sign_up_password)
    TextInputEditText editSignUpPassword;
    @BindView(R2.id.edit_sign_up_re_password)
    TextInputEditText editSignUpRePassword;
    @BindView(R2.id.btn_sign_up)
    AppCompatButton btnSignUp;
    @BindView(R2.id.tv_link_sign_in)
    AppCompatTextView tvLinkSignIn;

    @OnClick(R2.id.btn_sign_up)
    public void onClickSignUp() {
        if (checkForm()) {
            Toast.makeText(getActivity(), "验证成功", Toast.LENGTH_SHORT).show();
//            RestClient.builder().url("")
//                    .success(new ISuccess() {
//                        @Override
//                        public void onSuccess(String response) {
//
//                        }
//                    }).params("", "")
//                    .failure(new IFailure() {
//                        @Override
//                        public void onFailure() {
//
//                        }
//                    }).build().post();
        }
    }

    /**
     * 校验用户输入数据是否合法
     */
    private boolean checkForm() {
        String name = editSignUpName.getText().toString();
        String email = editSignUpEmail.getText().toString();
        String phone = editSignUpPhone.getText().toString();
        String password = editSignUpPassword.getText().toString();
        String rePassword = editSignUpRePassword.getText().toString();
        //校验通过标识
        boolean isPass = true;
        if (name.isEmpty()) {
            editSignUpName.setError("请输入姓名");
            isPass = false;
        } else {
            editSignUpName.setError(null);
        }


        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editSignUpEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            editSignUpEmail.setError(null);
        }

        if (phone.isEmpty() || phone.length() != 11) {
            editSignUpPhone.setError("手机格式错误");
            isPass = false;
        } else {
            editSignUpPhone.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            editSignUpPassword.setError("请填写至少6位密码");
            isPass = false;
        } else {
            editSignUpPassword.setError(null);
        }

        if (rePassword.isEmpty() || rePassword.length() < 6 || !rePassword.equals(password)) {
            editSignUpRePassword.setError("密码验证错误");
            isPass = false;
        } else {
            editSignUpRePassword.setError(null);
        }
        return isPass;
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @Nullable View rootView) {

    }


}
