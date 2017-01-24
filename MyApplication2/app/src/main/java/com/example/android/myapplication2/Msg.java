package com.example.android.myapplication2;

/**
 * Created by Jeff on 2017/1/22.
 */

public class Msg {
        public static final int TYPE_RECEVIED = 0;
        public static final int TYPE_SENT = 1;
        private String content;
        private int type;
        public Msg(String content,int type){
            this.content = content;
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public String getContent() {
            return content;
        }

}
