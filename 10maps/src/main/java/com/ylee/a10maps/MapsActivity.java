package com.ylee.a10maps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    float zoomlevel = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Button btnplus = findViewById(R.id.btnplus);
        Button btnminus = findViewById(R.id.btnminus);
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mMap != null){
                    ++zoomlevel;
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(zoomlevel));
                }
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mMap != null){
                    --zoomlevel;
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(zoomlevel));
                }
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng seoul = new LatLng(37.56, 126.97);
        LatLng shingu = new LatLng(37.448092, 127.169127);
        LatLng shingucross = new LatLng(37.446678, 127.167292);
        LatLng bus1 = new LatLng(37.475588, 127.127192);
        LatLng bus2 = new LatLng(37.475532, 127.12719) ;
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.addMarker(new MarkerOptions().position(seoul).title("서울 한국의수도"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12));
        mMap.addMarker(new MarkerOptions().position(shingu).title("신구 우리학교"));
        mMap.addMarker(new MarkerOptions().position(shingucross).title("신구대사거리"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(shingu));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
        mMap.addMarker(new MarkerOptions().position(bus1).title("서울71사1886"));
        mMap.addMarker(new MarkerOptions().position(bus2).title("두번째서울71사1886"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bus1));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(zoomlevel));
    }
}
