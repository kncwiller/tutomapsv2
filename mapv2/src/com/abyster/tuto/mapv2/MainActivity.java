package com.abyster.tuto.mapv2;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainActivity extends FragmentActivity {
	
	private GoogleMap GMap;
	private LatLng yaounde=new LatLng(3.881501,11.50818);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        GMap= ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        
		if(GMap!=null){
			GMap.setTrafficEnabled(true);
			GMap.setMyLocationEnabled(true);
			MarkerOptions markerOptions = new MarkerOptions();
	        markerOptions.title("YAOUNDE");
	        markerOptions.visible(true);
	        markerOptions.position(yaounde);
	        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
	        
	        GMap.addMarker(markerOptions);
			GMap.moveCamera(CameraUpdateFactory.newLatLngZoom(yaounde, 16));
			GMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
		}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
