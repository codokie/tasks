package org.tasks.preferences;

import android.app.Activity;
import android.util.TypedValue;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ResourceResolver {

    private final Activity activity;

    @Inject
    public ResourceResolver(Activity activity) {
        this.activity = activity;
    }

    public int getResource(int attr) {
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(attr, typedValue, true);
        return typedValue.resourceId;
    }
}
