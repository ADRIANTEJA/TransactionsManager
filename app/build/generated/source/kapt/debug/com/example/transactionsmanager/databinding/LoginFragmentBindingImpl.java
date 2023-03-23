package com.example.transactionsmanager.databinding;
import com.example.transactionsmanager.R;
import com.example.transactionsmanager.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LoginFragmentBindingImpl extends LoginFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.login_label, 1);
        sViewsWithIds.put(R.id.fromvpn_logo, 2);
        sViewsWithIds.put(R.id.login_data_fields, 3);
        sViewsWithIds.put(R.id.user_field_template, 4);
        sViewsWithIds.put(R.id.user_field, 5);
        sViewsWithIds.put(R.id.address_field_template, 6);
        sViewsWithIds.put(R.id.address_field, 7);
        sViewsWithIds.put(R.id.password_field_template, 8);
        sViewsWithIds.put(R.id.password_field, 9);
        sViewsWithIds.put(R.id.login_button, 10);
        sViewsWithIds.put(R.id.error_label, 11);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public LoginFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private LoginFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.textfield.TextInputEditText) bindings[7]
            , (com.google.android.material.textfield.TextInputLayout) bindings[6]
            , (android.widget.TextView) bindings[11]
            , (android.widget.ImageView) bindings[2]
            , (com.google.android.material.button.MaterialButton) bindings[10]
            , (android.widget.LinearLayout) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.TextView) bindings[1]
            , (com.google.android.material.textfield.TextInputEditText) bindings[9]
            , (com.google.android.material.textfield.TextInputLayout) bindings[8]
            , (com.google.android.material.textfield.TextInputEditText) bindings[5]
            , (com.google.android.material.textfield.TextInputLayout) bindings[4]
            );
        this.loginFragment.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}