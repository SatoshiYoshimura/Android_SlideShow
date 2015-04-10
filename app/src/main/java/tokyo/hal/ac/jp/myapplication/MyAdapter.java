package tokyo.hal.ac.jp.myapplication;

/**
 * Created by yoshimurasatoshi on 2015/04/10.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;

    // 使用しているビューの型への参照を渡す（カスタムViewHolder）
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }
    // 適切なコンストラクタを提供する（データセットの種類によって異なる）
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // 新しいViewを作成する（レイアウトマネージャーによって起動される）
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // 新しいViewを作成する
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, null);
        // Viewのサイズ、余白、パディングなどのレイアウトパラメータを設定する
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    // （レイアウトマネージャーによって起動される）Viewの内容を交換する
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 1.データセットから要素を取得する
        // 2.その要素とViewの内容を置き換える
        holder.mTextView.setText(mDataset[position]);
    }

    // （レイアウトマネージャーによって起動される）データセットのサイズを返す
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}