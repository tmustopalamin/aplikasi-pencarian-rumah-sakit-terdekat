package com.example.admientoto.cobacoba;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admientoto.cobacoba.R;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class CariCepat extends AppCompatActivity {

    private static final String TAG = CariCepat.class.getSimpleName();

    @BindView(R.id.tvRS)
    TextView txtLocationResult;

    @BindView(R.id.tv3)
    TextView txtJarak;


    // location last updated time
    private String mLastUpdateTime;

    // location updates interval - 10sec
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;

    // fastest updates interval - 5 sec
    // location updates will be received if another app is requesting the locations
    // than your app can handle
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 5000;

    private static final int REQUEST_CHECK_SETTINGS = 100;

    //woke
    ArrayList<Double> hasilhitung = new ArrayList<Double>();
    ArrayList<String> namaRS = new ArrayList<String>();
    rumahSakit rs = new rumahSakit();
    public Double asalLat;
    public Double asalLon;
    Double tujuanLat;
    Double tujuanLon;
    ArrayList<rsList> RSnya = new ArrayList<rsList>();
    String KEY_NAME = "idRS";
    String kirim;
    String kunci_lat = "lat";
    String kunci_lon = "Lon";
    Double lat;
    Double lon;


    // bunch of location related apis
    private FusedLocationProviderClient mFusedLocationClient;
    private SettingsClient mSettingsClient;
    private LocationRequest mLocationRequest;
    private LocationSettingsRequest mLocationSettingsRequest;
    private LocationCallback mLocationCallback;
    private Location mCurrentLocation;

    // boolean flag to toggle the ui
    private Boolean mRequestingLocationUpdates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_cepat);
        setTitle("Pencarian Terdekat");
        ButterKnife.bind(this);



        // initialize the necessary libraries
        init();

        // restore the values from saved instance state


        restoreValuesFromBundle(savedInstanceState);
        startLocationButtonClick();
    }

    private void init() {
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mSettingsClient = LocationServices.getSettingsClient(this);

        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                // location is received
                mCurrentLocation = locationResult.getLastLocation();

                updateLocationUI();
            }
        };

        mRequestingLocationUpdates = false;

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        mLocationSettingsRequest = builder.build();
    }

    /**
     * Restoring values from saved instance state
     */
    private void restoreValuesFromBundle(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("is_requesting_updates")) {
                mRequestingLocationUpdates = savedInstanceState.getBoolean("is_requesting_updates");
            }

            if (savedInstanceState.containsKey("last_known_location")) {
                mCurrentLocation = savedInstanceState.getParcelable("last_known_location");
            }

            if (savedInstanceState.containsKey("last_updated_on")) {
                mLastUpdateTime = savedInstanceState.getString("last_updated_on");
            }
        }

        updateLocationUI();
    }


    /**
     * Update the UI displaying the location data
     * and toggling the buttons
     */
    private void updateLocationUI() {

        if (mCurrentLocation != null) {
            asalLat = mCurrentLocation.getLatitude();
            asalLon = mCurrentLocation.getLongitude();

            lat = asalLat;
            lon = asalLon;


            for (int i=0;i<16; i++){
                rs.setDataRs(i+1);
                namaRS.add(rs.getNamaRs());
                tujuanLat = (rs.getlatTujuan()*(3.14/180));
                tujuanLon = (rs.getlonTujuan()*(3.14/180));
                hasilhitung.add(2*6371*Math.asin(Math.sqrt((Math.pow(Math.sin((asalLat*(3.14/180)-tujuanLat)/2),2))+Math.cos(asalLat*(3.14/180))*Math.cos(tujuanLat)*(Math.pow(Math.sin((tujuanLon-asalLon*(3.14/180))/2),2)))));
            }

            if(hasilhitung.size() == 16){
                for (int i=0;i<hasilhitung.size(); i++) {
                    Double a = hasilhitung.get(i);
                    RSnya.add(new rsList(namaRS.get(i), a ));
                }

                Collections.sort(RSnya, new Comparator<rsList>() {
                    @Override
                    public int compare(rsList o1, rsList o2) {
                        return o1.getJarakRS().compareTo(o2.getJarakRS());
                    }
                });



                txtLocationResult.setText(
                        RSnya.get(0).getnamaRS().toString() + " "
                );

                txtJarak.setText(
                        "diperkirakan " + new DecimalFormat("##.##").format(RSnya.get(0).getJarakRS()) + " KM dari posisi kamu."
                );

                rs.setAmbilLagi(RSnya.get(0).getnamaRS().toString());
                Button detailBtn = findViewById(R.id.detailButton);
                detailBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        kirim = rs.getNamaRs();

                        if (kirim.equals("RS. BAYUKARTA")){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. CITRA SARI INTAN BAROKAH"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. DELIMA ASIH"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. DEWI SRI"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. FIKRI MEDIKA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. ISLAM"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. IZZA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. KARYA HUSADA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. LIRA MEDIKA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. MANDAYA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. PROKLAMASI"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. PURI ASIH"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. ROSELA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. SARASWATI"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. PERSADA MEDIKA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RSUD. KARAWANG"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }
                    }
                });

                rs.setAmbilLagi(RSnya.get(0).getnamaRS().toString());
                Button arahinBtn = findViewById(R.id.arahkanButton);
                arahinBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        kirim = rs.getNamaRs();
                        if (kirim == "RS. BAYUKARTA"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }

                        if (kirim == "RS. CITRA SARI INTAN BAROKAH"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }

                        if (kirim == "RS. DELIMA ASIH"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }

                        if (kirim == "RS. DEWI SRI"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }

                        if (kirim == "RS. FIKRI MEDIKA"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }

                        if (kirim == "RS. ISLAM"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }

                        if (kirim == "RS. IZZA"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }

                        if (kirim == "RS. KARYA HUSADA"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }

                        if (kirim == "RS. LIRA MEDIKA"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }

                        if (kirim == "RS. MANDAYA"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. PROKLAMASI"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. PURI ASIH"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. ROSELA"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. SARASWATI"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. PERSADA MEDIKA"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
//
                        if (kirim == "RSUD. KARAWANG"){
                            String url = "https://www.google.com/maps/dir/?api=1&destination=" + rs.getlatTujuan() + "," + rs.getlonTujuan() + "&travelmode=driving";
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                            startActivity(intent);
                        }
                    }
                });

                rs.setAmbilLagi(RSnya.get(0).getnamaRS().toString());
                Button hubungiBtn = findViewById(R.id.hubungiBtn);
                hubungiBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        kirim = rs.getNamaRs();
                        if (kirim == "RS. BAYUKARTA"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }

                        if (kirim == "RS. CITRA SARI INTAN BAROKAH"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }

                        if (kirim == "RS. DELIMA ASIH"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }

                        if (kirim == "RS. DEWI SRI"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }

                        if (kirim == "RS. FIKRI MEDIKA"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }

                        if (kirim == "RS. ISLAM"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }

                        if (kirim == "RS. IZZA"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }

                        if (kirim == "RS. KARYA HUSADA"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }

                        if (kirim == "RS. LIRA MEDIKA"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }

                        if (kirim == "RS. MANDAYA"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }
//
                        if (kirim == "RS. PROKLAMASI"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }
//
                        if (kirim == "RS. PURI ASIH"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }
//
                        if (kirim == "RS. ROSELA"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }
//
                        if (kirim == "RS. SARASWATI"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }
//
                        if (kirim == "RS. PERSADA MEDIKA"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }
////
                        if (kirim == "RSUD. KARAWANG"){
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:"+rs.getNoTelp().toString()));
                            startActivity(callIntent);
                        }
                    }
                });

                RSnya.remove(0);

            }
                rsListAdapter adapter = new rsListAdapter(this,RSnya);
                ListView listView = findViewById(R.id.listviewCari);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String kirim  = RSnya.get(position).getnamaRS();
                        if (kirim.equals("RS. BAYUKARTA")){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. CITRA SARI INTAN BAROKAH"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. DELIMA ASIH"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. DEWI SRI"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. FIKRI MEDIKA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. ISLAM"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. IZZA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. KARYA HUSADA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. LIRA MEDIKA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RS. MANDAYA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. PROKLAMASI"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. PURI ASIH"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. ROSELA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. SARASWATI"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }
//
                        if (kirim == "RS. PERSADA MEDIKA"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }

                        if (kirim == "RSUD. KARAWANG"){
                            Intent intent = new Intent(CariCepat.this, tampilRS.class);
                            intent.putExtra(KEY_NAME, kirim);
                            intent.putExtra(kunci_lat, lat);
                            intent.putExtra(kunci_lon, lon);
                            startActivity(intent);
                        }
                    }
                });

            stopLocationUpdates();

        }



    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("is_requesting_updates", mRequestingLocationUpdates);
        outState.putParcelable("last_known_location", mCurrentLocation);

    }



    /**
     * Starting location updates
     * Check whether location settings are satisfied and then
     * location updates will be requested
     */
    private void startLocationUpdates() {
        mSettingsClient
                .checkLocationSettings(mLocationSettingsRequest)
                .addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                        Log.i(TAG, "All location settings are satisfied.");

                        //Toast.makeText(getApplicationContext(), "Started location updates!", Toast.LENGTH_SHORT).show();
                        //lokasi start

                        //noinspection MissingPermission
                        mFusedLocationClient.requestLocationUpdates(mLocationRequest,
                                mLocationCallback, Looper.myLooper());

                        updateLocationUI();
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        int statusCode = ((ApiException) e).getStatusCode();
                        switch (statusCode) {
                            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                Log.i(TAG, "Location settings are not satisfied. Attempting to upgrade " +
                                        "location settings ");
                                try {
                                    // Show the dialog by calling startResolutionForResult(), and check the
                                    // result in onActivityResult().
                                    ResolvableApiException rae = (ResolvableApiException) e;
                                    rae.startResolutionForResult(CariCepat.this, REQUEST_CHECK_SETTINGS);
                                } catch (IntentSender.SendIntentException sie) {
                                    Log.i(TAG, "PendingIntent unable to execute request.");
                                }
                                break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                String errorMessage = "Location settings are inadequate, and cannot be " +
                                        "fixed here. Fix in Settings.";
                                Log.e(TAG, errorMessage);

                                Toast.makeText(CariCepat.this, errorMessage, Toast.LENGTH_LONG).show();
                        }

                        updateLocationUI();
                    }
                });
    }

    public void startLocationButtonClick() {
        // Requesting ACCESS_FINE_LOCATION using Dexter library
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        mRequestingLocationUpdates = true;
                        startLocationUpdates();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        if (response.isPermanentlyDenied()) {
                            // open device settings when the permission is
                            // denied permanently
                            openSettings();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }


    public void stopLocationUpdates() {
        // Removing location updates
        mFusedLocationClient
                .removeLocationUpdates(mLocationCallback)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // lokasi stop
                    }
                });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // Check for the integer request code originally supplied to startResolutionForResult().
            case REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        Log.e(TAG, "User agreed to make required location settings changes.");
                        // Nothing to do. startLocationupdates() gets called in onResume again.
                        break;
                    case Activity.RESULT_CANCELED:
                        Log.e(TAG, "User chose not to make required location settings changes.");
                        mRequestingLocationUpdates = false;
                        break;
                }
                break;
        }
    }

    private void openSettings() {
        Intent intent = new Intent();
        intent.setAction(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package",
                BuildConfig.APPLICATION_ID, null);
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Resuming location updates depending on button state and
        // allowed permissions
        if (mRequestingLocationUpdates && checkPermissions()) {
            startLocationUpdates();
        }

        updateLocationUI();
    }

    private boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }


    @Override
    protected void onPause() {
        super.onPause();

        if (mRequestingLocationUpdates) {
            // pausing location updates
            stopLocationUpdates();
        }
    }
}