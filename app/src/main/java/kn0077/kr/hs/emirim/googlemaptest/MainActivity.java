package kn0077.kr.hs.emirim.googlemaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap googleMap;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) { // 구글 맵 서비스가 제공되었을 때
        this.googleMap=googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.869130,128.579860),17));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public static final int ITEM_SATELLITE=1;
    public static final int ITEM_NORMAL=2;
    public static final int PYUNGYANG=3;
    public static final int HONGDAE=4;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, ITEM_SATELLITE, 0, "위성 지도");
        menu.add(0, ITEM_NORMAL, 0, "일반 지도");
        SubMenu hotMenu=menu.addSubMenu("핫플레이스");
        hotMenu.add(0, PYUNGYANG, 0, "평양");
        hotMenu.add(0, HONGDAE, 0, "홍대");
//        menu.add(0, PYUNGYANG, 0, "평양");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case ITEM_SATELLITE : googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); return true; // 제대로 실행 되었을 때
            case ITEM_NORMAL : googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL); return true;
            case PYUNGYANG : googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(39.004845,125.736442),17)); return true;
            case HONGDAE : googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.556034,126.922945),17)); return true;
        }

        return false; // 제대로 실행이 잘 안되었을 때
    }
}
