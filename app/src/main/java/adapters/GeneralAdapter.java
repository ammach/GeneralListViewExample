package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by ammach on 12/3/2016.
 */
public abstract class GeneralAdapter<T> extends BaseAdapter {

    Context context;
    List<T> data;
    int layout;
    LayoutInflater layoutInflater;

    public GeneralAdapter(Context context, List<T> data, int layout) {
        this.context = context;
        this.data = data;
        this.layout = layout;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        if(convertView==null){
            convertView=layoutInflater.inflate(layout,null);
        }
        T t=data.get(position);
        performView(convertView,t);
        return convertView;
    }

    public  abstract  void performView(View view,T t);
}
