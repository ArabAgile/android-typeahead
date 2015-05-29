package com.arabagile.typeahead;

import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.widget.MultiAutoCompleteTextView;

/**
 * Created by agile on 5/26/15.
 */
public class MentionTextWatcher implements TextWatcher {

    MultiAutoCompleteTextView tvAutoComplete;

    public MentionTextWatcher(MultiAutoCompleteTextView tvAutoComplete) {
        this.tvAutoComplete = tvAutoComplete;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Layout layout = tvAutoComplete.getLayout();
        if (layout != null) {
            int pos      = tvAutoComplete.getSelectionStart();
            int line     = layout.getLineForOffset(pos);
            int baseline = layout.getLineBaseline(line);
            int bottom   = tvAutoComplete.getHeight();

            // Set menu below text
            tvAutoComplete.setDropDownVerticalOffset(baseline - bottom + 10);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {}
}
