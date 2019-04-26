package com.example.engahmed.camera;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button;
  ImageView imageView;

    private static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       button=(Button)findViewById(R.id.button2);
      imageView=(ImageView)findViewById(R.id.imageView2);
        if(!hascamera())
            button.setEnabled(false);


    }

    public boolean hascamera(){

        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);

    }





public void but(View view){

    Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);




}






    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap  photo= (Bitmap) extras.get("data");
          imageView.setImageBitmap(photo);
        }
    }



}
