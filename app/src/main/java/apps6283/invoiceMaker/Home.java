package apps6283.invoiceMaker;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.os.Build.VERSION.SDK_INT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.Settings;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Home extends AppCompatActivity {

    EditText qty1,qty2,qty3,qty4,qty5,qty6,qty7,qty8;
    EditText rate1,rate2,rate3,rate4,rate5,rate6,rate7,rate8;
    TextView gross1,gross2,gross3,gross4,gross5,gross6,gross7,gross8,Total;
    String fName = String.valueOf(System.currentTimeMillis());

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_home);


if (!checkPermission()){

    requestPermission();
}
        qty1 = (EditText) findViewById(R.id.qty1);
        rate1 = (EditText) findViewById(R.id.rate1);
        gross1 = (TextView) findViewById(R.id.gross1);

        qty2 = (EditText) findViewById(R.id.qty2);
        rate2 = (EditText) findViewById(R.id.rate2);
        gross2 = (TextView) findViewById(R.id.gross2);

        qty3 = (EditText) findViewById(R.id.qty3);
        rate3 = (EditText) findViewById(R.id.rate3);
        gross3 = (TextView) findViewById(R.id.gross3);

        qty4 = (EditText) findViewById(R.id.qty4);
        rate4 = (EditText) findViewById(R.id.rate4);
        gross4 = (TextView) findViewById(R.id.gross4);

        qty5 = (EditText) findViewById(R.id.qty5);
        rate5 = (EditText) findViewById(R.id.rate5);
        gross5 = (TextView) findViewById(R.id.gross5);

        qty6 = (EditText) findViewById(R.id.qty6);
        rate6 = (EditText) findViewById(R.id.rate6);
        gross6 = (TextView) findViewById(R.id.gross6);

        qty7 = (EditText) findViewById(R.id.qty7);
        rate7 = (EditText) findViewById(R.id.rate7);
        gross7 = (TextView) findViewById(R.id.gross7);

        qty8 = (EditText) findViewById(R.id.qty8);
        rate8 = (EditText) findViewById(R.id.rate8);
        gross8 = (TextView) findViewById(R.id.gross8);

        Total = (TextView) findViewById(R.id.Total);



//Text change Listners;
        qty1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gross1.setText(addNumbers1());
                Total.setText(addTotal());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

        rate1.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                gross1.setText(addNumbers1());
                Total.setText(addTotal());

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });


        qty2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gross2.setText(addNumbers2());
                Total.setText(addTotal());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

        rate2.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                gross2.setText(addNumbers2());
                Total.setText(addTotal());

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });


        qty3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gross3.setText(addNumbers3());
                Total.setText(addTotal());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

        rate3.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                gross3.setText(addNumbers3());
                Total.setText(addTotal());

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });


        qty4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gross4.setText(addNumbers4());
                Total.setText(addTotal());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

        rate4.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                gross4.setText(addNumbers4());
                Total.setText(addTotal());

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });


        qty5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gross5.setText(addNumbers5());
                Total.setText(addTotal());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

        rate5.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                gross5.setText(addNumbers5());
                Total.setText(addTotal());

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });


        qty6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gross6.setText(addNumbers6());
                Total.setText(addTotal());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

        rate6.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                gross6.setText(addNumbers6());
                Total.setText(addTotal());

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });


        qty7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gross7.setText(addNumbers7());
                Total.setText(addTotal());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

        rate7.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                gross7.setText(addNumbers7());
                Total.setText(addTotal());

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });


        qty8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                gross8.setText(addNumbers8());
                Total.setText(addTotal());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        } );

        rate8.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                gross8.setText(addNumbers8());
                Total.setText(addTotal());

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });





//add strict mode code on app intialize

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        //start

        //end

        findViewById(R.id.createBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                layoutToImage();

                layoutTOimageConverter();
            }
        });


    }

    private void layoutTOimageConverter() {


        Dexter.withContext(this).withPermissions(WRITE_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        if (report.areAllPermissionsGranted()) {

//                            ConstraintLayout layout = findViewById(R.id.lay);

//                            ScrollView layout = findViewById(R.id.sView);
                            LinearLayout layout  = findViewById(R.id.sllayout);


                            File file = saveBitMap(Home.this, layout);    //which view you want to pass that view as parameter
                            if (file != null) {
                                Log.i("TAG", "Drawing saved to the gallery!");
                                Toast.makeText(Home.this, "Processing", Toast.LENGTH_SHORT).show();


                                try {
                                    imageToPDF();
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }


                            } else {
                                Log.i("TAG", "Oops! Image could not be saved.");
                                Toast.makeText(Home.this, "Click Again !", Toast.LENGTH_SHORT).show();

                            }


                        } else {
                            Toast.makeText(Home.this, "Permissions are not granted!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();


    }


    public void imageToPDF() throws FileNotFoundException {
        try {
            Document document = new Document();
            String dirpath = android.os.Environment.getExternalStorageDirectory().toString();
            PdfWriter.getInstance(document, new FileOutputStream(dirpath + "/"+fName+".pdf")); //  Change pdf's name.
            document.open();
            Image img = Image.getInstance(Environment.getExternalStorageDirectory() + File.separator +"/Pictures/Download/"+ fName+".jpg");
            float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin() - 0) / img.getWidth()) * 100;
            img.scalePercent(scaler);
            img.setAlignment(Image.ALIGN_CENTER | Image.ALIGN_TOP);
            document.add(img);
            document.close();
            Toast.makeText(this, "PDF Generated successfully!..", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

        }
    }






    private File saveBitMap(Context context, View drawView) {
        File pictureFileDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Download"); // enter folder name to save image
        if (!pictureFileDir.exists()) {
            boolean isDirectoryCreated = pictureFileDir.mkdirs();
            if (!isDirectoryCreated)
                Log.i("ATG", "Can't create directory to save the image");
            return null;
        }
        String filename = pictureFileDir.getPath() + File.separator +fName + ".jpg";
        File pictureFile = new File(filename);
        Bitmap bitmap = getBitmapFromView(drawView);
        try {
            pictureFile.createNewFile();
            FileOutputStream oStream = new FileOutputStream(pictureFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, oStream);
            oStream.flush();
            oStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("TAG", "There was an issue saving the image.");
        }
        scanGallery(context, pictureFile.getAbsolutePath());
        return pictureFile;
    }










    //create bitmap from view and returns it
    private Bitmap getBitmapFromView(View view) {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable = view.getBackground();
        if (bgDrawable != null) {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        } else {
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }










    private void scanGallery(Context cntx, String path) {
        try {
            MediaScannerConnection.scanFile(cntx, new String[]{path}, null, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String path, Uri uri) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private boolean checkPermission() {
        if (SDK_INT >= Build.VERSION_CODES.R) {
            return Environment.isExternalStorageManager();
        } else {
            int result = ContextCompat.checkSelfPermission(Home.this, READ_EXTERNAL_STORAGE);
            int result1 = ContextCompat.checkSelfPermission(Home.this, WRITE_EXTERNAL_STORAGE);
            return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
        }
    }


    private void requestPermission() {
        if (SDK_INT >= Build.VERSION_CODES.R) {
            try {
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse(String.format("package:%s",getApplicationContext().getPackageName())));
                startActivityForResult(intent, 2296);
            } catch (Exception e) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                startActivityForResult(intent, 2296);
            }
        } else {
            //below android 11
            ActivityCompat.requestPermissions(Home.this, new String[]{WRITE_EXTERNAL_STORAGE}, 1100);
        }
    }

    private String addNumbers1() {
        int number1;
        int number2;
        if(qty1.getText().toString() != "" && qty1.getText().length() > 0) {
            number1 = Integer.parseInt(qty1.getText().toString());
        } else {
            number1 = 0;
        }
        if(rate1.getText().toString() != "" && rate1.getText().length() > 0) {
            number2 = Integer.parseInt(rate1.getText().toString());
        } else {
            number2 = 0;
        }
        int number3;
        number3 = number1 * number2;

        if(number3!=0){
            return Integer.toString(number3);
        }else{
            return " ";
        }
    }

    private String addNumbers2() {
        int number1;
        int number2;

        if(qty2.getText().toString() != "" && qty2.getText().length() > 0) {
            number1 = Integer.parseInt(qty2.getText().toString());
        } else {
            number1 = 0;
        }
        if(rate2.getText().toString() != "" && rate2.getText().length() > 0) {
            number2 = Integer.parseInt(rate2.getText().toString());
        } else {
            number2 = 0;
        }
        int number3;
        number3 = number1 * number2;

        if(number3!=0){
            return Integer.toString(number3);
        }else{
            return " ";
        }


    }
    private String addNumbers3() {
        int number1;
        int number2;
        if(qty3.getText().toString() != "" && qty3.getText().length() > 0) {
            number1 = Integer.parseInt(qty3.getText().toString());
        } else {
            number1 = 0;
        }
        if(rate3.getText().toString() != "" && rate3.getText().length() > 0) {
            number2 = Integer.parseInt(rate3.getText().toString());
        } else {
            number2 = 0;
        }
        int number3;
        number3 = number1 * number2;

        if(number3!=0){
            return Integer.toString(number3);
        }else{
            return " ";
        }

    }
    private String addNumbers4() {
        int number1;
        int number2;
        if(qty4.getText().toString() != "" && qty4.getText().length() > 0) {
            number1 = Integer.parseInt(qty4.getText().toString());
        } else {
            number1 = 0;
        }
        if(rate4.getText().toString() != "" && rate4.getText().length() > 0) {
            number2 = Integer.parseInt(rate4.getText().toString());
        } else {
            number2 = 0;
        }
        int number3;
        number3 = number1 * number2;

        if(number3!=0){
            return Integer.toString(number3);
        }else{
            return " ";
        }
    }

    private String addNumbers5() {
        int number1;
        int number2;
        if(qty5.getText().toString() != "" && qty5.getText().length() > 0) {
            number1 = Integer.parseInt(qty5.getText().toString());
        } else {
            number1 = 0;
        }
        if(rate5.getText().toString() != "" && rate5.getText().length() > 0) {
            number2 = Integer.parseInt(rate5.getText().toString());
        } else {
            number2 = 0;
        }
        int number3;
        number3 = number1 * number2;

        if(number3!=0){
            return Integer.toString(number3);
        }else{
            return " ";
        }
    }

    private String addNumbers6() {
        int number1;
        int number2;
        if(qty6.getText().toString() != "" && qty6.getText().length() > 0) {
            number1 = Integer.parseInt(qty6.getText().toString());
        } else {
            number1 = 0;
        }
        if(rate6.getText().toString() != "" && rate6.getText().length() > 0) {
            number2 = Integer.parseInt(rate6.getText().toString());
        } else {
            number2 = 0;
        }
        int number3;
        number3 = number1 * number2;

        if(number3!=0){
            return Integer.toString(number3);
        }else{
            return " ";
        }
    }

    private String addNumbers7() {
        int number1;
        int number2;
        if(qty7.getText().toString() != "" && qty7.getText().length() > 0) {
            number1 = Integer.parseInt(qty7.getText().toString());
        } else {
            number1 = 0;
        }
        if(rate7.getText().toString() != "" && rate7.getText().length() > 0) {
            number2 = Integer.parseInt(rate7.getText().toString());
        } else {
            number2 = 0;
        }
        int number3;
        number3 = number1 * number2;

        if(number3!=0){
            return Integer.toString(number3);
        }else{
            return " ";
        }
    }

    private String addNumbers8() {
        int number1;
        int number2;
        if(qty8.getText().toString() != "" && qty8.getText().length() > 0) {
            number1 = Integer.parseInt(qty8.getText().toString());
        } else {
            number1 = 0;
        }
        if(rate8.getText().toString() != "" && rate8.getText().length() > 0) {
            number2 = Integer.parseInt(rate8.getText().toString());
        } else {
            number2 = 0;
        }
        int number3;
        number3 = number1 * number2;

        if(number3!=0){
            return Integer.toString(number3);
        }else{
            return " ";
        }
    }


    private String addTotal() {
        int q1,q2,q3,q4,q5,q6,q7,q8,r1,r2,r3,r4,r5,r6,r7,r8,t1,t2,t3,t4,t5,t6,t7,t8,Total;

        if(qty1.getText().toString() != "" && qty1.getText().length() > 0) {
            q1 = Integer.parseInt(qty1.getText().toString());
        } else {
            q1 = 0;
        }
        if(rate1.getText().toString() != "" && rate1.getText().length() > 0) {
            r1 = Integer.parseInt(rate1.getText().toString());
        } else {
            r1 = 0;
        }

        t1 = q1 * r1;
//1

        if(qty2.getText().toString() != "" && qty2.getText().length() > 0) {
            q2 = Integer.parseInt(qty2.getText().toString());
        } else {
            q2 = 0;
        }
        if(rate2.getText().toString() != "" && rate2.getText().length() > 0) {
            r2 = Integer.parseInt(rate2.getText().toString());
        } else {
            r2 = 0;
        }

        t2 = q2 * r2;

//2
        if(qty3.getText().toString() != "" && qty3.getText().length() > 0) {
            q3 = Integer.parseInt(qty3.getText().toString());
        } else {
            q3 = 0;
        }
        if(rate3.getText().toString() != "" && rate3.getText().length() > 0) {
            r3 = Integer.parseInt(rate3.getText().toString());
        } else {
            r3 = 0;
        }

        t3 = q3 * r3;

//3
        if(qty4.getText().toString() != "" && qty4.getText().length() > 0) {
            q4 = Integer.parseInt(qty4.getText().toString());
        } else {
            q4 = 0;
        }
        if(rate4.getText().toString() != "" && rate4.getText().length() > 0) {
            r4 = Integer.parseInt(rate4.getText().toString());
        } else {
            r4 = 0;
        }

        t4 = q4 * r4;

//4
        if(qty5.getText().toString() != "" && qty5.getText().length() > 0) {
            q5 = Integer.parseInt(qty5.getText().toString());
        } else {
            q5 = 0;
        }
        if(rate5.getText().toString() != "" && rate5.getText().length() > 0) {
            r5 = Integer.parseInt(rate5.getText().toString());
        } else {
            r5 = 0;
        }

        t5 = q5 * r5;
//5

        if(qty6.getText().toString() != "" && qty6.getText().length() > 0) {
            q6 = Integer.parseInt(qty6.getText().toString());
        } else {
            q6 = 0;
        }
        if(rate6.getText().toString() != "" && rate6.getText().length() > 0) {
            r6 = Integer.parseInt(rate6.getText().toString());
        } else {
            r6 = 0;
        }

        t6 = q6 * r6;

//6
        if(qty7.getText().toString() != "" && qty7.getText().length() > 0) {
            q7 = Integer.parseInt(qty7.getText().toString());
        } else {
            q7 = 0;
        }
        if(rate7.getText().toString() != "" && rate7.getText().length() > 0) {
            r7 = Integer.parseInt(rate7.getText().toString());
        } else {
            r7 = 0;
        }

        t7 = q7 * r7;
//7

        if(qty8.getText().toString() != "" && qty8.getText().length() > 0) {
            q8 = Integer.parseInt(qty8.getText().toString());
        } else {
            q8 = 0;
        }
        if(rate8.getText().toString() != "" && rate8.getText().length() > 0) {
            r8 = Integer.parseInt(rate8.getText().toString());
        } else {
            r8 = 0;
        }

        t8 = q8 * r8;
//8

        Total = t1+t2+t3+t4+t5+t6+t7+t8;

        if(Total!=0){
            return Integer.toString(Total);
        }else{
            return " ";
        }

    }

}