package com.example.android.myapplication3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private Button send;

    private EditText inputText;

    private MsgAdapter adapter;

    private List<Msg> msgList = new ArrayList<Msg>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initMsgs();
        adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);
        listView = (ListView) findViewById(R.id.msg_list_view);
        listView.setAdapter(adapter);

        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                if (!content.isEmpty()) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged(); // 当有消息更新的时候，刷新ListView中的显示
                    listView.setSelection(msgList.size()); // 把ListView定位到最后一行
                    inputText.setText(""); // 清空输入框的内容
                }
            }
        });
    }

    private void initMsgs() {
        Msg msg1 = new Msg("今天要回老家", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("这就是你不更博客的理由？", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("老家没网叫我怎么更...", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
