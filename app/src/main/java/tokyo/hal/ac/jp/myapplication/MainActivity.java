package tokyo.hal.ac.jp.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.marvinlabs.widget.slideshow.SlideShowView;
import com.marvinlabs.widget.slideshow.adapter.ResourceBitmapAdapter;


public class MainActivity extends Activity {
    /***
     * recyclerVivewで必要なセット
     */
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
//
//        // コンテンツの変化でRecyclerViewのサイズが変わらない場合は、
//        // パフォーマンスを向上させることができる
//        mRecyclerView.setHasFixedSize(true);
//
//        // LinearLayoutManagerを使用する
//        mLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//        // テストデータを作成する
//        String[] myDataset = {"北海道",
//                "青森県", "岩手県", "宮城県", "秋田県", "山形県", "福島県",
//                "茨城県", "栃木県", "群馬県", "埼玉県", "千葉県", "東京都", "神奈川県",
//                "新潟県", "富山県", "石川県", "福井県", "山梨県", "長野県", "岐阜県", "静岡県", "愛知県",
//                "三重県", "滋賀県", "京都府", "大阪府", "兵庫県", "奈良県", "和歌山県",
//                "鳥取県", "島根県", "岡山県", "広島県", "山口県",
//                "徳島県", "香川県", "愛媛県", "高知県",
//                "福岡県", "佐賀県", "長崎県", "熊本県", "大分県", "宮崎県", "鹿児島県",
//                "沖縄県"};
//        // アダプタを指定する
//        mAdapter = new MyAdapter(myDataset);
//        mRecyclerView.setAdapter(mAdapter);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // MotionEventしかわからない
        mRecyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    // ここで処理
                    TextView test = (TextView)findViewById(R.id.textView);
                    test.setText("aaa");
                }
            })
        );

        // コンテンツの変化でRecyclerViewのサイズが変わらない場合は、
        // パフォーマンスを向上させることができる
        mRecyclerView.setHasFixedSize(true);

        // LinearLayoutManagerを使用する
        mLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        mRecyclerView.setHorizontalScrollBarEnabled(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // テストデータを作成する
        int[] myDataset = {R.drawable.neko,R.drawable.shenron,R.drawable.neko};
        // アダプタを指定する
        mAdapter = new MyImageAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
