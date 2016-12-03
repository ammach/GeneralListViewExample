package adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by ammach on 12/3/2016.
 */
public abstract class GeneralAdapter<T> extends BaseAdapter implements AbsListView.OnScrollListener {

    //my variables
    Context context;
    List<T> data;
    int layout;
    LayoutInflater layoutInflater;
    private View bottomLayout;

    int layoutBottom;
    Activity activity;

    // Variables for scroll listener
    boolean userScrolled = false;

    public GeneralAdapter(Context context, List<T> data, int layoutRow, int layoutBottom, Activity activity) {
        this.context = context;
        this.data = data;
        this.layout = layoutRow;
        this.layoutBottom=layoutBottom;
        this.activity=activity;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, null);
        }
        T t = data.get(position);
        performView(convertView, t);
        return convertView;
    }

    public abstract void performView(View view, T t);

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
            userScrolled = true;

        }

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (userScrolled && firstVisibleItem + visibleItemCount == totalItemCount) {
            bottomLayout= activity.findViewById(layoutBottom);
            userScrolled = false;
            bottomLayout.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    updateListView();
                    notifyDataSetChanged();
                    bottomLayout.setVisibility(View.GONE);
                }
            }, 5000);
        }
    }

    protected abstract void updateListView();
}
