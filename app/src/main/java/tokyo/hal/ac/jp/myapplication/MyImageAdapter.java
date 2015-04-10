package tokyo.hal.ac.jp.myapplication;

/**
 * Created by yoshimurasatoshi on 2015/04/10.
 */
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class MyImageAdapter extends RecyclerView.Adapter<MyImageAdapter.ViewHolder> {
    private int[] mDataset;

    // 使用しているビューの型への参照を渡す（カスタムViewHolder）
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView mImageView;
        public ViewHolder(ImageView v) {
            super(v);
            mImageView = v;
        }
    }

    // 適切なコンストラクタを提供する（データセットの種類によって異なる）
    public MyImageAdapter(int[] myDataset){
        mDataset = myDataset;
    }

    // 新しいViewを作成する（レイアウトマネージャーによって起動される）
    @Override
    public MyImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // 新しいViewを作成する
        ImageView v = (ImageView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_image_view, null);
        // Viewのサイズ、余白、パディングなどのレイアウトパラメータを設定する
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    // （レイアウトマネージャーによって起動される）Viewの内容を交換する
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 1.データセットから要素を取得する
        // 2.その要素とViewの内容を置き換える
        holder.mImageView.setImageResource(mDataset[position]);
    }

    // （レイアウトマネージャーによって起動される）データセットのサイズを返す
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

}