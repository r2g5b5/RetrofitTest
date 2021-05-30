package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView txtMain;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMain=findViewById(R.id.main_textView);


         retrofit=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        //getPosts();

        //getComments();

        //getPostsByUserId();

       // createPost();

        //updatePost();

        deletePost();



    }

    private void deletePost() {
        retrofit.create(JsonPlaceHolder.class).deletePost(2).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() ){

                    txtMain.append(response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });


    }

    private void updatePost() {
        Post post=new Post(2001,null,"Titttle");
        retrofit.create(JsonPlaceHolder.class).patchPost(5,post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful() && response.body()!=null){
                    Post postResponse=response.body();
                    txtMain.append(response.code()+"\n"+postResponse.getId()+"\n"+postResponse.getUserId()+"\n"+
                            postResponse.getTitle()+"\n"+postResponse.getText());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }

    private void createPost() {
        Post post=new Post(1001,"This is the text","Title of the text");
        retrofit.create(JsonPlaceHolder.class).createPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful() && response.body()!=null){
                    Post postResponse=response.body();
                    txtMain.append(response.code()+"\n"+postResponse.getId()+"\n"+postResponse.getUserId()+"\n"+
                            postResponse.getTitle()+"\n"+postResponse.getText());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }

    private void getPostsByUserId() {
        retrofit.create(JsonPlaceHolder.class).getPostsByUserId(3).enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    if (response.body()!=null) {
                        for (Post post : response.body()) {
                            txtMain.append("id: "+post.getId()+"\n"+"userId: "+post.getUserId() +
                                    "\n" + post.getTitle() + "\n" + post.getText() + "\n \n");
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });


    }

    private void getComments() {

        retrofit.create(JsonPlaceHolder.class).getComments(3).enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.isSuccessful() && response.body()!=null){
                    for (Comment comment :response.body()) {
                        txtMain.append("postId: "+comment.getPostId()+"\n"+
                                "Id: "+comment.getId() + "\n" +"Email: "+ comment.getEmail() + "\n"
                                + "body: "+comment.getText() + "\n \n");

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });

    }

    private void getPosts() {
        retrofit.create(JsonPlaceHolder.class).getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    if (response.body()!=null) {
                        for (Post post : response.body()) {
                            txtMain.append(post.getId() + "\n" + post.getTitle() + "\n" + post.getText() + "\n \n");
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

    }
}