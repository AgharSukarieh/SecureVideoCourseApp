package com.example.myproject.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myproject.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;
import java.util.HashMap;

public class Video_Activity extends AppCompatActivity {
    private TextView likeCount, dislikeCount;
    private ImageView likeButton, dislikeButton ;
    private int like = 0;
    private int dislike = 0;
    private int position, positionVideo;
    private boolean isLiked = false;
    private boolean isDisliked = false;
    private HashMap<Integer, ArrayList<String>> courseVideos;
    List_Lesson_Couers list_lesson_couers = new List_Lesson_Couers();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        initializeUI();
        loadPreferences();
        setupLikeDislikeListeners();
        initializeCourseVideos();
        setupYoutubePlayer();

    }

    private void initializeUI() {
        Intent intent = getIntent();
        position = intent.getIntExtra("p", 0);
        positionVideo = intent.getIntExtra("pl", 0);

        likeCount = findViewById(R.id.like_count);
        dislikeCount = findViewById(R.id.dislike_count);
        likeButton = findViewById(R.id.like_button);
        dislikeButton = findViewById(R.id.dislike_button);

        likeCount.setText(String.valueOf(like));
        dislikeCount.setText(String.valueOf(dislike));
    }


    private void setupLikeDislikeListeners() {
        likeButton.setOnClickListener(v -> {
            likeVideo();
            likeCount.setText(String.valueOf(like));
            savePreferences();
        });

        dislikeButton.setOnClickListener(v -> {
            dislikeVideo();
            dislikeCount.setText(String.valueOf(dislike));
            savePreferences();
        });
    }

    private void initializeCourseVideos() {
        courseVideos = new HashMap<>();

        courseVideos.put(0, addLesson0Videos());
        courseVideos.put(1, addLesson1Videos());
        courseVideos.put(2, addLesson2Videos());
        courseVideos.put(3, addLesson3Videos());
        courseVideos.put(4, addLesson4Videos());
        courseVideos.put(5, addLesson5Videos());
    }

    private void setupYoutubePlayer() {
        YouTubePlayerView youTubePlayerView = findViewById(R.id.video_card_play_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new YouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                ArrayList<String> videos = courseVideos.get(positionVideo);
                if (videos != null && position < videos.size()) {
                    String videoId = videos.get(position);
                    youTubePlayer.loadVideo(videoId, 0);
                }
            }

            @Override
            public void onStateChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerState playerState) {
            }

            @Override
            public void onPlaybackQualityChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlaybackQuality playbackQuality) {
            }

            @Override
            public void onPlaybackRateChange(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlaybackRate playbackRate) {
            }

            @Override
            public void onError(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerError playerError) {
            }

            @Override
            public void onCurrentSecond(@NonNull YouTubePlayer youTubePlayer, float v) {
            }

            @Override
            public void onVideoDuration(@NonNull YouTubePlayer youTubePlayer, float v) {
            }

            @Override
            public void onVideoLoadedFraction(@NonNull YouTubePlayer youTubePlayer, float v) {
            }

            @Override
            public void onVideoId(@NonNull YouTubePlayer youTubePlayer, @NonNull String s) {
            }

            @Override
            public void onApiChange(@NonNull YouTubePlayer youTubePlayer) {
            }
        });
    }

    private ArrayList<String> addLesson0Videos() {
        ArrayList<String> videos = new ArrayList<>();
        videos.add("z1FdInL8sjg");
        videos.add("xo1R1nYM4aw");
        videos.add("pw7rTydaSYs");
        return videos;
    }

    private ArrayList<String> addLesson1Videos() {
        ArrayList<String> videos = new ArrayList<>();
        videos.add("VHbSopMyc4M");
        videos.add("-C88r0niLQQ");
        videos.add("mG4NLNZ37y4");
        return videos;
    }

    private ArrayList<String> addLesson2Videos() {
        ArrayList<String> videos = new ArrayList<>();
        videos.add("4EaYeZyzIB0");
        videos.add("wJI5RsdX26E");
        videos.add("zIjI8H945T");
        return videos;
    }
    private ArrayList<String> addLesson3Videos() {
        ArrayList<String> videos = new ArrayList<>();
        videos.add("yyMXxVUgOvU");
        videos.add("HiwEvRAidR8");
        videos.add("03OOW_R1s");
        return videos;
    }

    private ArrayList<String> addLesson4Videos() {
        ArrayList<String> videos = new ArrayList<>();
        videos.add("q_JsgpiuY98");
        videos.add("-WEpWH1NHGU");
        videos.add("BPHAr4QGGVE");
        return videos;
    }

    private ArrayList<String> addLesson5Videos() {
        ArrayList<String> videos = new ArrayList<>();
        videos.add("B_PvduWozPg");
        videos.add("t3p2NCth-pQ");
        videos.add("Y_44pWwR9g0");
        return videos;
    }

    private void likeVideo() {
        if (!isLiked) {
            isLiked = true;
            like++;
        }
    }

    private void dislikeVideo() {
        if (!isDisliked) {
            isDisliked = true;
            dislike++;
        }
    }

    private void savePreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("VideoPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("like", like);
        editor.putInt("dislike", dislike);
        editor.apply();
    }

    private void loadPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("VideoPrefs", MODE_PRIVATE);
        like = sharedPreferences.getInt("like", 0);
        dislike = sharedPreferences.getInt("dislike", 0);
    }


}
