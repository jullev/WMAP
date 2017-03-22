package Desain;

/**
 * Created by setiyawan on 3/22/17.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.setiyawan.mobileapps.R;

public class ListView1Inflater extends ArrayAdapter<String> {
    private String[] id;
    Integer[] gambar;
    private Activity context;
    private String[] jenis;
    private String[] status;

    public ListView1Inflater(Activity context,Integer[] gambar, String[] names, String[] desc, String[] status) {
        super(context, R.layout.detail_list, names);
        this.context = context;
        this.id = names;
        this.jenis = desc;
        this.status = status;
        this.gambar = gambar;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.detail_list, null, true);
        ImageView img = (ImageView) listViewItem.findViewById(R.id.imageView2);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.txtnama);
        TextView textViewDesc = (TextView) listViewItem.findViewById(R.id.txtalamat);
        TextView textViewDesc2 = (TextView) listViewItem.findViewById(R.id.txtnohp);

        img.setImageResource(gambar[position]);
        textViewName.setText(id[position]);
        textViewDesc.setText(jenis[position]);
        textViewDesc2.setText(status[position]);
        return  listViewItem;
    }
}
