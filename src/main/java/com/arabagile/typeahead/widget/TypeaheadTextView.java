package com.arabagile.typeahead.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;

import com.arabagile.typeahead.AtTokenizer;
import com.arabagile.typeahead.MentionTextWatcher;
import com.arabagile.typeahead.R;

/**
 * Created by agile on 5/26/15.
 */
public final class TypeaheadTextView extends MultiAutoCompleteTextView {

    private static int THRESHOLD = 1;

    public TypeaheadTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TypeaheadTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TypeaheadTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    /**
     * Initializes paint objects and sets desired attributes.
     * @param context Context
     * @param attrs Attributes
     */
    private void init(Context context, AttributeSet attrs) {
        // Load the styled attributes and set their properties
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TypeaheadTextView);

        THRESHOLD = attributes.getInteger(R.styleable.TypeaheadTextView_ag_threshold, THRESHOLD);

        // We no longer need our attributes TypedArray, give it back to cache
        attributes.recycle();

        // Set tokenizer
        setTokenizer(new AtTokenizer());
        addTextChangedListener(new MentionTextWatcher(this));
        setThreshold(THRESHOLD);
    }

}
