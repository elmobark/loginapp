package com.apine.socr.loginapp.were_the_magic_happens;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemDecoration extends RecyclerView.ItemDecoration {

    /**
     *
     * {@link #startPadding} and {@link #endPadding} are final and required on initialization
     * because  {@link android.support.v7.widget.RecyclerView.ItemDecoration} are drawn
     * before the adapter's child views so you cannot rely on the child view measurements
     * to determine padding as the two are connascent
     *
     * see {@see <a href="https://en.wikipedia.org/wiki/Connascence_(computer_programming)"}
     */

    /**
     * @param startPadding
     * @param endPadding
     */
    private final int startPadding;
    private final int endPadding;

    public ItemDecoration(int startPadding, int endPadding) {
        this.startPadding = startPadding;
        this.endPadding = endPadding;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
            RecyclerView.State state) {

        int totalWidth = parent.getWidth();

        //first element
        if (parent.getChildAdapterPosition(view) == 0) {
            int firstPadding = (totalWidth -400) / 2;
            firstPadding = Math.max(0, firstPadding);
            outRect.set(0, 0, firstPadding, 0);

        }

        //last element
        if (parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() - 1 &&
                parent.getAdapter().getItemCount() > 1) {
            int lastPadding = (totalWidth -400)/2;
            lastPadding = Math.max(0, lastPadding);
            outRect.set(lastPadding, 0, 0, 0);
        }
    }

}
