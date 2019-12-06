package com.example.youi_beta;

import android.app.AppComponentFactory;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Homepage extends AppCompatActivity {
    private GridView main_gridView;
    private boolean getService = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
//        testLocationProvider();		//檢查定位服務
        main_gridView = (GridView) findViewById(R.id.main_gridView);
        main_gridView.setAdapter(new HomepageAdapter(getApplicationContext()));
        main_gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(Homepage.this,News.class);
                        startActivity(intent);
                        break;

                    case 1:
                        Intent intent1 = new Intent(Homepage.this,MainActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(Homepage.this,Link.class);
                        intent2.putExtra("areas","桃園區");
                        intent2.putExtra("friendlys","友善類型");
                        intent2.putExtra("styles","餐廳菜單類型");
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(Homepage.this,Team.class);
                        startActivity(intent3);
                        break;
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login:
                Intent i = new Intent(this, Login.class);
                startActivity(i);

                break;
        }
        return super.onOptionsItemSelected(item);
    }


//    public void testLocationProvider() {
//        //取得系統定位服務
//        LocationManager status = (LocationManager) (this.getSystemService(Context.LOCATION_SERVICE));
//        if (status.isProviderEnabled(LocationManager.GPS_PROVIDER) || status.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
//            //如果GPS或網路定位開啟，呼叫locationServiceInitial()更新位置
//            getService = true;	//確認開啟定位服務
//            Log.d("getService=",String.valueOf(getService));
//
//        } else {
//            Toast.makeText(this, "請開啟定位服務", Toast.LENGTH_LONG).show();
//            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));	//開啟設定頁面
//        }
//    }


}
