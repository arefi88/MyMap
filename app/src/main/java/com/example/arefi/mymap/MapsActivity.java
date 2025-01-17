package com.example.arefi.mymap;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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
        LatLng mashhad = new LatLng(36.297817,59.4393717);
        LatLng tehran = new LatLng(35.6970118,51.209732);
        mMap.addMarker(new MarkerOptions().position(mashhad).title("Mashhad"));
        mMap.addMarker(new MarkerOptions().position(tehran).title("Tehran").draggable(true));
        //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(mashhad));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(tehran,4.5f));
        mMap.addCircle(new CircleOptions().radius(200000).fillColor(Color.parseColor("#220000ff")).center(tehran).strokeColor(Color.parseColor("#220000ff")));
       mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
           @Override
           public boolean onMarkerClick(Marker marker) {
               Toast.makeText(MapsActivity.this,marker.getTitle(),Toast.LENGTH_LONG).show();
               return false;
           }
       });

    }
}
