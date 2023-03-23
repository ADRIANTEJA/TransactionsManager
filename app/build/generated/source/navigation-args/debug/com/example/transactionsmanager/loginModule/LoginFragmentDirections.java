package com.example.transactionsmanager.loginModule;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.transactionsmanager.R;

public class LoginFragmentDirections {
  private LoginFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionLoginFragmentToAccountsManagerFragment() {
    return new ActionOnlyNavDirections(R.id.action_loginFragment_to_accountsManagerFragment);
  }
}
