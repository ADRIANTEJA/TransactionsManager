package com.example.transactionsmanager.common.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/transactionsmanager/common/utils/ErrorNames;", "", "()V", "SMS_SIZE_CHANGED", "", "SMS_STRUCTURE_CHANGED", "app_debug"})
public final class ErrorNames {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.transactionsmanager.common.utils.ErrorNames INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SMS_STRUCTURE_CHANGED = "this can happen when the sms structure is changed by etecsa and it looses the range index of where to take the account number";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SMS_SIZE_CHANGED = "the size of the sms changed which could mean a change or error in the sms structure";
    
    private ErrorNames() {
        super();
    }
}