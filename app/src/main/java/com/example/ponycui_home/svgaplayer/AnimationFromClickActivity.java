package com.example.ponycui_home.svgaplayer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.gamesdk.svgaplayer.SVGAClickAreaListener;
import com.gamesdk.svgaplayer.SVGADrawable;
import com.gamesdk.svgaplayer.SVGADynamicEntity;
import com.gamesdk.svgaplayer.SVGAImageView;
import com.gamesdk.svgaplayer.SVGAParser;
import com.gamesdk.svgaplayer.SVGAVideoEntity;

import org.jetbrains.annotations.NotNull;


/**
 * Created by miaojun on 2019/6/21.
 * mail:1290846731@qq.com
 */
public class AnimationFromClickActivity extends Activity {

    SVGAImageView animationView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animationView = new SVGAImageView(this);
        animationView.setOnAnimKeyClickListener(new SVGAClickAreaListener() {
            @Override
            public void onClick(@NotNull String clickKey) {
                Toast.makeText(AnimationFromClickActivity.this,clickKey,Toast.LENGTH_SHORT).show();
            }
        });
        animationView.setBackgroundColor(Color.WHITE);
        loadAnimation();
        setContentView(animationView);
    }

    private void loadAnimation() {
        SVGAParser parser = new SVGAParser(this);
        parser.decodeFromAssets("test2.svga",new SVGAParser.ParseCompletion() {
            @Override
            public void onComplete(@NotNull SVGAVideoEntity videoItem) {
                SVGADynamicEntity dynamicEntity = new SVGADynamicEntity();
                dynamicEntity.setClickArea("img_10");
                SVGADrawable drawable = new SVGADrawable(videoItem, dynamicEntity);
                animationView.setImageDrawable(drawable);
                animationView.startAnimation();
            }
            @Override
            public void onError() {

            }
        });
    }

}

