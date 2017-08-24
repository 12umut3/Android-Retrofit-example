package umut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umut.
 */
public class CustomAdapter extends ArrayAdapter<Items> {

    private Context context;
    private ViewHolder viewHolder;
    private List<Items> arrayList = new ArrayList<Items>();
    public CustomAdapter(Context context, List<Items> list_items) {

        super(context, R.layout.item_layout, list_items);
        this.context = context;
        this.arrayList = list_items;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if(view == null){

            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.item_layout, parent,false);

            viewHolder = new ViewHolder();
            viewHolder.txt_name = (TextView)view.findViewById(R.id.name);
            viewHolder.bookId = (TextView)view.findViewById(R.id.bookId);
            viewHolder.price = (TextView)view.findViewById(R.id.price);
            viewHolder.inStock= (TextView)view.findViewById(R.id.inStock);


            view.setTag(viewHolder);


        }else{

            viewHolder = (ViewHolder) view.getTag();

        }

        //Items items_info = getItem(position);

        viewHolder.txt_name.setText("Name: " + "" + arrayList.get(position).getName());  // name değerini textview e atıyoruz

        viewHolder.bookId.setText("BookId: " + "" + arrayList.get(position).getBookId()); // category değerini textview e atıyoruz

        viewHolder.price.setText("Price: " + "" + arrayList.get(position).getPrice()); // price değerini textview e atıyoruz

        viewHolder.inStock.setText("inStock: " + "" + arrayList.get(position).getInStock()); // price değerini textview e atıyoruz


        return view;

    }



    private static class ViewHolder{

        TextView txt_name;
        TextView bookId;
        TextView price;
        TextView inStock;
    }
}
