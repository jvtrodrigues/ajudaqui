package br.edu.ifrs.ajudaqui.view.ui.encontrar;

import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import br.edu.ifrs.ajudaqui.R;

public class EncontrarOngsFragment extends Fragment implements OnMapReadyCallback {


    public EncontrarOngsFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_encontrar_ongs, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return root;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(map.getCameraPosition().target, 11));

       // LatLng latLon = map.getCameraPosition().target;
       // map.addMarker(new MarkerOptions().position(new LatLng(map.getCameraPosition().target.latitude+0.3, map.getCameraPosition().target.longitude+0.3)).title("Ong do Joaozinho"));
       // map.addMarker(new MarkerOptions().position(new LatLng(latLon.latitude+0.1, latLon.longitude+0.17)).title("Ong do Bruno"));
       // map.addMarker(new MarkerOptions().position(new LatLng(latLon.latitude-0.114, latLon.longitude+0.46)).title("Ong do Mariano"));
        //map.addMarker(new MarkerOptions().position(new LatLng(-25.443150, -49.238243)).title("Jardim Botânico"));
    }

}
