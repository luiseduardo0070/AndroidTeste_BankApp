package com.everis.androidteste_bankapp.model.user;

import com.everis.androidteste_bankapp.model.Error;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserReceive {

    @SerializedName("userAccount")
    @Expose
    private UserAccount userAccount;

    @SerializedName("error")
    @Expose
    private Error error;

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
