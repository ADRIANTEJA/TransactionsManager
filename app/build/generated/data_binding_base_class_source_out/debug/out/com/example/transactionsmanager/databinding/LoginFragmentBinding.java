// Generated by data binding compiler. Do not edit!
package com.example.transactionsmanager.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.transactionsmanager.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class LoginFragmentBinding extends ViewDataBinding {
  @NonNull
  public final TextInputEditText addressField;

  @NonNull
  public final TextInputLayout addressFieldTemplate;

  @NonNull
  public final TextView errorLabel;

  @NonNull
  public final ImageView fromvpnLogo;

  @NonNull
  public final MaterialButton loginButton;

  @NonNull
  public final LinearLayout loginDataFields;

  @NonNull
  public final ConstraintLayout loginFragment;

  @NonNull
  public final TextView loginLabel;

  @NonNull
  public final TextInputEditText passwordField;

  @NonNull
  public final TextInputLayout passwordFieldTemplate;

  @NonNull
  public final Button resetDBButton;

  @NonNull
  public final Button testButton;

  @NonNull
  public final TextInputEditText userField;

  @NonNull
  public final TextInputLayout userFieldTemplate;

  protected LoginFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextInputEditText addressField, TextInputLayout addressFieldTemplate, TextView errorLabel,
      ImageView fromvpnLogo, MaterialButton loginButton, LinearLayout loginDataFields,
      ConstraintLayout loginFragment, TextView loginLabel, TextInputEditText passwordField,
      TextInputLayout passwordFieldTemplate, Button resetDBButton, Button testButton,
      TextInputEditText userField, TextInputLayout userFieldTemplate) {
    super(_bindingComponent, _root, _localFieldCount);
    this.addressField = addressField;
    this.addressFieldTemplate = addressFieldTemplate;
    this.errorLabel = errorLabel;
    this.fromvpnLogo = fromvpnLogo;
    this.loginButton = loginButton;
    this.loginDataFields = loginDataFields;
    this.loginFragment = loginFragment;
    this.loginLabel = loginLabel;
    this.passwordField = passwordField;
    this.passwordFieldTemplate = passwordFieldTemplate;
    this.resetDBButton = resetDBButton;
    this.testButton = testButton;
    this.userField = userField;
    this.userFieldTemplate = userFieldTemplate;
  }

  @NonNull
  public static LoginFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.login_fragment, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LoginFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LoginFragmentBinding>inflateInternal(inflater, R.layout.login_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static LoginFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.login_fragment, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LoginFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LoginFragmentBinding>inflateInternal(inflater, R.layout.login_fragment, null, false, component);
  }

  public static LoginFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static LoginFragmentBinding bind(@NonNull View view, @Nullable Object component) {
    return (LoginFragmentBinding)bind(component, view, R.layout.login_fragment);
  }
}
