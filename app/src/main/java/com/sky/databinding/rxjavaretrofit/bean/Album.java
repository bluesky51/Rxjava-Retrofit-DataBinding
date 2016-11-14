package com.sky.databinding.rxjavaretrofit.bean;

import android.view.View;
import android.widget.Toast;

import java.util.List;

/**
 * Created by BlueSky on 16/11/14.
 */

public class Album {

    /**
     * msg : OK
     * data : [{"album_id":15,"pic_url":"http://7xiuft.com1.z0.glb.clouddn.com/20151106/53cbe255779587547e34ccc0cc1cda5e.jpg","title":"萌系易容术"},{"album_id":14,"pic_url":"http://7xiuft.com1.z0.glb.clouddn.com/20151106/c624a3a2a81cca587d798ddd07422b74.jpg","title":"猫咪物语"},{"album_id":13,"pic_url":"http://7xiuft.com1.z0.glb.clouddn.com/20151106/177879df9484d726fa6d2ba5bb5848e3.jpg","title":"12星座礼物"},{"album_id":12,"pic_url":"http://7xiuft.com1.z0.glb.clouddn.com/20151106/8d4b3ff39b38d71559de6bebf70c2aed.jpg","title":"水果萌萌哒"},{"album_id":11,"pic_url":"http://7xiuft.com1.z0.glb.clouddn.com/20151106/9e43d5b2dbded15098b5ef63cfa2310c.jpg","title":"阿萌收纳课堂"},{"album_id":10,"pic_url":"http://7xiuft.com1.z0.glb.clouddn.com/20151106/bdd08e39ca01f5117dbc842a4259938d.jpg","title":"家要暖暖的"},{"album_id":9,"pic_url":"http://7xiuft.com1.z0.glb.clouddn.com/20151106/64aa0a76a233ec25615ecdb4661bf688.jpg","title":"关爱学生协会"},{"album_id":6,"pic_url":"http://7xiuft.com1.z0.glb.clouddn.com/20151106/1ae87f7d315e04f513d1b4b56749f76d.jpg","title":"黄色联萌"},{"album_id":7,"pic_url":"http://7xiuft.com1.z0.glb.clouddn.com/20151106/2cfb5274a98f1c9fa6048b88e9ca420a.jpg","title":"吃货联萌"},{"album_id":8,"pic_url":"http://7xiuft.com1.z0.glb.clouddn.com/20151106/6b9487631ca42aec023a932bd218cdaa.jpg","title":"萌萌小饰界"}]
     * code : 0
     */

    private String msg;
    private int code;
    /**
     * album_id : 15
     * pic_url : http://7xiuft.com1.z0.glb.clouddn.com/20151106/53cbe255779587547e34ccc0cc1cda5e.jpg
     * title : 萌系易容术
     */

    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int album_id;
        private String pic_url;
        private String title;

        public int getAlbum_id() {
            return album_id;
        }

        public void setAlbum_id(int album_id) {
            this.album_id = album_id;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public void onItemClick(View view){
            Toast.makeText(view.getContext(),"点击了"+title,Toast.LENGTH_LONG).show();

        }
    }



}
