package com.example.schedger;

import android.content.Context;
import android.widget.TextView;

/**
 * This is the view used to display planner items.
 *
 * Created by mwwie on 2017-01-06.
 */

public abstract class ItemView extends TextView {
    private PlannerItem item;

    public ItemView(Context context) {
        super(context);
    }

    public ItemView(Context c, PlannerItem i)
    {
        super(c);
        item = i;
        format();
        setDisplay();
    }

    public PlannerItem getItem() {return item;}

    public abstract void format();
    public abstract void setDisplay();
}
